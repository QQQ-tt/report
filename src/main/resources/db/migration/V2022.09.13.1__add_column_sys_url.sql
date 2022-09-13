ALTER TABLE `sys_url`
    ADD COLUMN `request_type` varchar(50) NULL COMMENT '请求类型' AFTER `bean`;