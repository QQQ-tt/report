package com.qtx.report.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qtx.report.common.pojo.BaseEntity;
import lombok.*;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author qtx
 * @since 2022-09-07
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

    /**
     * 用户账号
     */
    @TableField("user_card")
    private Integer userCard;

    /**
     * 角色id
     */
    @TableField("role_id")
    private String roleId;
}


