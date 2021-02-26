package com.lxl.controller;


import com.lxl.entity.CfgHttpMapping;
import com.lxl.entity.UserInfo;
import com.lxl.service.CfgHttpMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liaoxl
 * @since 2021-02-26
 */
@RestController
@RequestMapping("/cfg-http-mapping")
public class CfgHttpMappingController {
    @Autowired
    private CfgHttpMappingService cfgHttpMappingService;

    @GetMapping("/{id}")
    public Object getCfgMapping(@PathVariable Long id) {
        CfgHttpMapping cfgHttpMapping = cfgHttpMappingService.queryById(id);
        if (cfgHttpMapping == null) {
            return "没用查询到数据";
        }
        return cfgHttpMapping;
    }

    @GetMapping("get/{id}")
    public Object get(@PathVariable Long id) {
        CfgHttpMapping cfgHttpMapping = cfgHttpMappingService.getById(id);
        if (cfgHttpMapping == null) {
            return "没用查询到数据";
        }
        return cfgHttpMapping;
    }
}
