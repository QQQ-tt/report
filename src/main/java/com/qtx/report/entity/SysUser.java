package com.qtx.report.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qtx.report.common.pojo.BaseEntity;
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
    @ExcelProperty("名字")
    private String name;

    /**
     * 账号
     */
    @TableField("card")
    @ExcelProperty("卡号")
    private Integer card;

    /**
     * 密码
     */
    @TableField("password")
    @ExcelProperty("密码")
    private String password;

    /**
     * 状态
     */
    @TableField("status")
    @ExcelProperty("状态")
    private Integer status;
}
