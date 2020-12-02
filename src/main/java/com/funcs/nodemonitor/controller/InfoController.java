package com.funcs.nodemonitor.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.funcs.nodemonitor.comon.dto.InfoUpdateDto;
import com.funcs.nodemonitor.entity.Info;
import com.funcs.nodemonitor.entity.Server;
import com.funcs.nodemonitor.lang.Result;
import com.funcs.nodemonitor.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.funcs.nodemonitor.service.InfoService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Function
 * @since 2020-11-24
 */

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    InfoService infoService;
    @Autowired
    ServerService serverService;
    @GetMapping("/get/{serverId}")
    public Result test(@PathVariable("serverId") Long serverId) {
        List serverStatus = infoService.list( new QueryWrapper<Info>().orderByAsc("time").eq("serverid", serverId));

        return Result.succ(serverStatus);
    }


    /*
    Post format: json, in body
    url:http://127.0.0.1:8080/info/updete
    {
      "serverId": 1,
      "cpu": 92.44,
      "memory": 124,
      "netOut": 56.5,
      "netIn": 53.3,
      "ping": 223,
      "pwd": 123
    }
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody InfoUpdateDto infoUpdateDto){
        Server checkInfo = serverService.getOne(new QueryWrapper<Server>().eq("id", infoUpdateDto.getServerId()));
        if(checkInfo == null){
            return Result.fail(404,"ServerId not found", null);
        }

        if(!checkInfo.getPasswd().equals(infoUpdateDto.getPwd())){
            return Result.fail(401, "Wrong Password.", null);
        }else {
            Info info = new Info();
            info.setServerid(infoUpdateDto.getServerId());
            info.setCpu(infoUpdateDto.getCpu());
            info.setMemory(infoUpdateDto.getMemory());
            info.setNetout(infoUpdateDto.getNetOut());
            info.setNetin(infoUpdateDto.getNetIn());
            info.setPing(infoUpdateDto.getPing());
            try {
                boolean updateStatus = infoService.save(info);
                if(updateStatus == true){
                    return Result.succ("Updated success");
                } else {
                    return Result.fail(500, "Database Error", null);
                }
            } catch (Exception e){
                return Result.fail(400, "Missing Parameters", null);
            }
        }
    }
}
