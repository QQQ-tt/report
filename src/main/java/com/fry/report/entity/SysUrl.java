package com.fry.report.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fry.report.common.pojo.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 请求地址信息表
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@Getter
@Setter
@TableName("sys_url")
@Builder
public class SysUrl extends BaseEntity {

    /**
     * 请求名称
     */
    @TableField("name")
    private String name;

    /**
     * 请求地址
     */
    @TableField("url")
    private String url;
}
