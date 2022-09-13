package com.fry.report.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fry.report.common.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 角色地址关系表
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@Getter
@Setter
@TableName("sys_role_url")
public class SysRoleUrl extends BaseEntity {

    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 地址id
     */
    @TableField("url_id")
    private Integer urlId;
}
