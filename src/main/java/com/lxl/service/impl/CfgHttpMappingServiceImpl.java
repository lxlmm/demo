package com.lxl.service.impl;

import com.lxl.entity.CfgHttpMapping;
import com.lxl.mapper.CfgHttpMappingMapper;
import com.lxl.service.CfgHttpMappingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liaoxl
 * @since 2021-02-26
 */
@Service
@CacheConfig(cacheNames = "caffeineCacheManager")
@Slf4j
public class CfgHttpMappingServiceImpl extends ServiceImpl<CfgHttpMappingMapper, CfgHttpMapping> implements CfgHttpMappingService {

    @Override
    @Cacheable(key = "#mappingId")
    public CfgHttpMapping queryById(Long mappingId) {
        log.info("query");
        return getById(mappingId);
    }
}
