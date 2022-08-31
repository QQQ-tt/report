ALTER TABLE `sys_user`
    ADD COLUMN `create_by` varchar(50) NULL COMMENT '创建数据的用户' AFTER `password`,
ADD COLUMN `create_time` datetime NULL COMMENT '创建时间' AFTER `create_by`,
ADD COLUMN `update_by` varchar(50) NULL COMMENT '修改数据的用户' AFTER `create_time`,
ADD COLUMN `update_time` datetime NULL COMMENT '修改时间' AFTER `update_by`;