package com.fry.report.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fry.report.common.pojo.BaseEntity;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author qtx
 * @since 2022-08-30
 */
@Getter
@Setter
@Builder
@TableName("sys_user")
@AllArgsConstructor
@NoArgsConstructor
public class SysUser extends BaseEntity {


    /**
     * 用户名
     */
    @TableField("name")
    private String name;

    /**
     * 账号
     */
    @TableField("card")
    private Integer card;

    /**
     * 密码
     */
    @TableField("password")
    private String password;
}
