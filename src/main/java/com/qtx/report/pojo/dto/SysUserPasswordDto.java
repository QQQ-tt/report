package com.qtx.report.pojo.dto;

import lombok.Data;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
@Data
public class SysUserPasswordDto  {
    private String oldPassword;
    private String newPassword;
}
