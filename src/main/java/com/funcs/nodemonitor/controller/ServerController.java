package com.funcs.nodemonitor.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.funcs.nodemonitor.lang.Result;
import com.funcs.nodemonitor.mapper.ServerMapper;
import com.funcs.nodemonitor.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.funcs.nodemonitor.entity.Server;
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
@RequestMapping("/server")
public class ServerController {
    @Autowired
    ServerService serverService;
    ServerMapper serverMapper;
    @RequestMapping("/getall")
    public Result getAll(){
//        List serverList = serverService.list();
//        return Result.succ(serverList);
        QueryWrapper<Server> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "servername", "serverlocation", "serverdescribe");
        List serverList = serverService.listMaps(queryWrapper);
        return  Result.succ(serverList);
    }
}
