CREATE TABLE `sys_user_role`
(
    `id`          int                                                          NOT NULL AUTO_INCREMENT,
    `user_card`   int                                                          NULL COMMENT '用户账号',
    `role_id`     int                                                          NULL COMMENT '角色id',
    `create_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建数据的用户',
    `create_time` datetime(0)                                                  NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改数据的用户',
    `update_time` datetime(0)                                                  NULL DEFAULT NULL COMMENT '修改时间',
    `delete_flag` int                                                          NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) COMMENT = '用户角色关系表';