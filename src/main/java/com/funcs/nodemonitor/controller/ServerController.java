package com.funcs.nodemonitor.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.funcs.nodemonitor.comon.dto.ServerUpdateDto;
import com.funcs.nodemonitor.comon.lang.Result;
import com.funcs.nodemonitor.mapper.ServerMapper;
import com.funcs.nodemonitor.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.funcs.nodemonitor.entity.Server;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Function
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/server")
public class ServerController {
    @Autowired
    ServerService serverService;
    ServerMapper serverMapper;

    @RequestMapping("/getall")
    public Result getAll() {
        QueryWrapper<Server> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "servername", "serverlocation", "serverdescribe");
        List serverList = serverService.listMaps(queryWrapper);
        return Result.succ(serverList);
    }

    @GetMapping("/getone/{id}")
    public Result getOne(@PathVariable(name = "id") Long id) {
        QueryWrapper<Server> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "servername", "serverlocation", "serverdescribe").eq("id", id);
        List serverList = serverService.listMaps(queryWrapper);
        return Result.succ(serverList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody ServerUpdateDto serverUpdateDto) {
        if ("".equals(serverUpdateDto.getPassword())) {
            return Result.fail(400, "Password not found", null);
        } else if ("".equals(serverUpdateDto.getServerName())) {
            return Result.fail(400, "ServerName not found", null);
        } else {
            Server server = new Server();
            server.setServername(serverUpdateDto.getServerName());
            server.setServerlocation(serverUpdateDto.getServerLocation());
            server.setServerdescribe(serverUpdateDto.getServerDescribe());
            server.setPasswd(serverUpdateDto.getPassword());
            System.out.println("a"+ serverUpdateDto.getServerDescribe() + "b");
            try {
                boolean updateStatus = serverService.save(server);
                // check params not null and return warning.
                if (serverUpdateDto.CheckNull().size() != 0) {
                    return Result.fail(402, "Update was successful but Lost some params", serverUpdateDto.CheckNull());
                }
                if (updateStatus == true) {
                    return Result.succ("Updated success");
                } else {
                    return Result.fail(500, "Database Error", null);
                }
            } catch (Exception e) {
                return Result.fail(500, "Server Error", null);
            }

        }

    }
}

