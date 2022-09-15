CREATE TABLE `sys_role_url`
(
    `id`          int                                                          NOT NULL AUTO_INCREMENT,
    `role_id`     varchar(32)                                                  NULL COMMENT '角色id',
    `url_id`      varchar(32)                                                  NULL COMMENT '地址id',
    `create_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建数据的用户',
    `create_time` datetime(0)                                                  NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改数据的用户',
    `update_time` datetime(0)                                                  NULL DEFAULT NULL COMMENT '修改时间',
    `delete_flag` int                                                          NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) COMMENT = '角色地址关系表';



ALTER TABLE `sys_url`
    ADD COLUMN `bean` varchar(50) NULL COMMENT 'bean名字' AFTER `name`;