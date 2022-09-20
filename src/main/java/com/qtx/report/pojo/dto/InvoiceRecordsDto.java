package com.qtx.report.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qtx.report.common.CommonPage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author: QTX
 * @Since: 2022/8/31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InvoiceRecordsDto extends CommonPage {

    /**
     * 票据代码
     */
    private String ticketCode;

    /**
     * 票据号码
     */
    private String ticketNumber;

    /**
     * 流程号
     */
    private String processNumber;

    /**
     * 开票日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * 开票日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * 报销人
     */
    private String reimbursementPerson;


}
