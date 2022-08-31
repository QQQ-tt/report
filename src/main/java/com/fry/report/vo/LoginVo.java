package com.fry.report.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
@Data
@Accessors(chain = true)
public class LoginVo {
    private String card;
    private String token;
}
