package com.lxl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liaoxl
 * @since 2021-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CfgHttpMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mapping_id", type = IdType.AUTO)
    private Long mappingId;

    private String cfgHttpCode;

    private String mappingName;

    private String mappingValue;

    private String state;

    private String remarks;


}
