package com.fry.report.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fry.report.common.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author qtx
 * @since 2022-09-13
 */
@Getter
@Setter
@TableName("sys_role")
public class SysRole extends BaseEntity {

    /**
     * 角色id
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 角色名字
     */
    @TableField("role_name")
    private String roleName;
}
