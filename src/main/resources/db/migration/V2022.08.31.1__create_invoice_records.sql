CREATE TABLE `invoice_records`
(
    `id`                   int NOT NULL AUTO_INCREMENT,
    `ticket_code`          int NULL COMMENT '票据代码',
    `ticket_number`        int NULL COMMENT '票据号码',
    `check_code`           int NULL COMMENT '检验码',
    `billing_date`         datetime NULL COMMENT '开票日期',
    `money`                decimal(10, 2) NULL COMMENT '金额',
    `reimbursement_person` varchar(100) NULL COMMENT '报销人',
    `process_number`       int NULL COMMENT '流程号',
    `remark`               varchar(255) NULL COMMENT '备注',
    `create_by`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建数据的用户',
    `create_time`          datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`            varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改数据的用户',
    `update_time`          datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
    `delete_flag`          int NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) COMMENT = '发票记录表';