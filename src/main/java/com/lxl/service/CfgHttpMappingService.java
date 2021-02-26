package com.lxl.service;

import com.lxl.entity.CfgHttpMapping;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liaoxl
 * @since 2021-02-26
 */
public interface CfgHttpMappingService extends IService<CfgHttpMapping> {

    /**
     * 查询
     * @param mappingId
     * @return
     */
    CfgHttpMapping queryById(Long mappingId);

}
