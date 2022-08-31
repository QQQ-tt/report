ALTER TABLE `invoice_records`
    MODIFY COLUMN `ticket_code` int NOT NULL COMMENT '票据代码' AFTER `id`,
    MODIFY COLUMN `ticket_number` int NOT NULL COMMENT '票据号码' AFTER `ticket_code`,
    MODIFY COLUMN `check_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '检验码' AFTER `ticket_number`,
    MODIFY COLUMN `billing_date` datetime NOT NULL COMMENT '开票日期' AFTER `check_code`,
    MODIFY COLUMN `money` decimal(10, 2) NOT NULL COMMENT '金额' AFTER `billing_date`,
    MODIFY COLUMN `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建数据的用户' AFTER `remark`,
    MODIFY COLUMN `create_time` datetime NOT NULL COMMENT '创建时间' AFTER `create_by`,
    MODIFY COLUMN `delete_flag` int NOT NULL DEFAULT 0 COMMENT '逻辑删除' AFTER `update_time`;