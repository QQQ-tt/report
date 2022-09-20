package com.qtx.report.pojo.dto;

import com.qtx.report.common.CommonPage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserDto extends CommonPage {
    private String name;
    private String card;
}
