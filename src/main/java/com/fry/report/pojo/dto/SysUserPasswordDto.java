package com.fry.report.pojo.dto;

import com.fry.report.common.CommonPage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
@Data
public class SysUserPasswordDto  {
    private String oldPassword;
    private String newPassword;
}
