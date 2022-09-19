package com.qtx.report.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qtx.report.common.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 发票记录表
 * </p>
 *
 * @author qtx
 * @since 2022-08-31
 */
@Getter
@Setter
@TableName("invoice_records")
@ContentFontStyle(fontHeightInPoints = 12)
public class InvoiceRecords extends BaseEntity {

    /**
     * 票据代码
     */
    @TableField("ticket_code")
    @ExcelProperty("票据代码")
    private Integer ticketCode;

    /**
     * 票据号码
     */
    @TableField("ticket_number")
    @ExcelProperty("票据号码")
    private Integer ticketNumber;

    /**
     * 检验码
     */
    @TableField("check_code")
    @ExcelProperty("检验码")
    private Integer checkCode;

    /**
     * 开票日期
     */
    @TableField("billing_date")
    @ExcelProperty("开票日期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime billingDate;

    /**
     * 金额
     */
    @TableField("money")
    @ExcelProperty("金额")
    private BigDecimal money;

    /**
     * 报销人
     */
    @TableField("reimbursement_person")
    @ExcelProperty("报销人")
    private String reimbursementPerson;

    /**
     * 流程号
     */
    @TableField("process_number")
    @ExcelProperty("流程号")
    private Integer processNumber;

    /**
     * 备注
     */
    @TableField("remark")
    @ExcelProperty("备注")
    private String remark;
}
