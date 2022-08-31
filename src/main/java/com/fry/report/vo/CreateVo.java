package com.fry.report.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVo {
    private String name;
    private Integer card;
    private String password;
}
