package com.qtx.report.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String ticketCode;

    /**
     * 票据号码
     */
    private String ticketNumber;

    /**
     * 检验码
     */
    private String checkCode;

    /**
     * 开票日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
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
    private String processNumber;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据创建人
     */
    private String createBy;

    /**
     * 录入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime;
}
