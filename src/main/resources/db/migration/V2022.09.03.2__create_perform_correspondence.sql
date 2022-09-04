CREATE TABLE `perform_correspondence`
(
    `id`                  int                                                          NOT NULL AUTO_INCREMENT,
    `data_info_id_select` int                                                          NULL COMMENT '查询数据源id',
    `data_info_id_insert` int                                                          NULL COMMENT '目标数据源id',
    `select_sql`          tinytext                                                     NULL COMMENT '查询sql',
    `insert_sql`          tinytext                                                     NULL COMMENT '插入sql',
    `create_by`           varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建数据的用户',
    `create_time`         datetime(0)                                                  NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`           varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改数据的用户',
    `update_time`         datetime(0)                                                  NULL DEFAULT NULL COMMENT '修改时间',
    `delete_flag`         int                                                          NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
) COMMENT = '数据执行对应关系';