package com.funcs.nodemonitor.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.funcs.nodemonitor.comon.dto.UpdateDto;
import com.funcs.nodemonitor.entity.Info;
import com.funcs.nodemonitor.lang.Result;
import jdk.nashorn.internal.ir.RuntimeNode;
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
    @GetMapping("/get/{serverId}")
    public Result test(@PathVariable("serverId") Long serverId) {
        List serverStatus = infoService.list( new QueryWrapper<Info>().orderByAsc("time").eq("serverid", serverId));

        return Result.succ(serverStatus);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    /*
    Post format: json, in body
    url:http://127.0.0.1:8080/info/updete
    {
      "serverId": 1,
      "cpu": 34.44,
      "memory": 334,
      "netUp": 56.5,
      "netDown": 54.3,
      "ping": 23
     }
     */
    public Result update(@RequestBody UpdateDto updateDto){
        Info info = new Info();
        System.out.println(updateDto.getCpu());

        info.setServerid(updateDto.getServerId());
        info.setCpu(updateDto.getCpu());
        info.setMemory(updateDto.getMemory());
        info.setNetout(updateDto.getNetOut());
        info.setNetin(updateDto.getNetIn());
        info.setPing(updateDto.getPing());
        boolean indexId = infoService.saveOrUpdate(info);
        return Result.succ("Updated success"+indexId);
    }
}
