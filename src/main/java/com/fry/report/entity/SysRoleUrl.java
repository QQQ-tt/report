package com.fry.report.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fry.report.common.pojo.BaseEntity;
import lombok.*;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role_url")
public class SysRoleUrl extends BaseEntity {

    /**
     * 角色id
     */
    @TableField("role_id")
    private String roleId;

    /**
     * 地址id
     */
    @TableField("url_id")
    private String urlId;
}
