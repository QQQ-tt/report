ALTER TABLE `sys_url`
    ADD COLUMN `url_id` varchar(32) NULL COMMENT '请求地址id' AFTER `id`;