package com.fry.report.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fry.report.common.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 数据库信息表
 * </p>
 *
 * @author qtx
 * @since 2022-09-03
 */
@Getter
@Setter
@TableName("data_info")
public class DataInfo extends BaseEntity {

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 数据类型
     */
    @TableField("data_type")
    private String dataType;

    /**
     * 数据库jdbc:url地址
     */
    @TableField("url")
    private String url;

    /**
     * 用户名
     */
    @TableField("user")
    private String user;

    /**
     * 密码
     */
    @TableField("password")
    private String password;
}
