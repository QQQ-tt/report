ALTER TABLE `sys_user`
    ADD COLUMN `status` int NULL DEFAULT 0 COMMENT '状态' AFTER `card`;