package com.lxl.controller;

import com.lxl.common.tool.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    @ResponseBody
    @GetMapping("/get")
    public String get(@RequestParam String key) {
        log.info("key:{}", key);
        redisUtil.set(key,"value...");
        String value=redisUtil.get(key);
        log.info("value:{}",value);
        return value;

    }
}
