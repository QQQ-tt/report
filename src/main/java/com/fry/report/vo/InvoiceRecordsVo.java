package com.fry.report.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
@Data
public class InvoiceRecordsVo {

    private Integer id;
    /**
     * 票据代码
     */
    private Integer ticketCode;

    /**
     * 票据号码
     */
    private Integer ticketNumber;

    /**
     * 检验码
     */
    private String checkCode;

    /**
     * 开票日期
     */
    private LocalDateTime billingDate;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 报销人
     */
    private String reimbursementPerson;

    /**
     * 流程号
     */
    private Integer processNumber;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据创建人
     */
    private String createBy;
}
