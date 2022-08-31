CREATE TABLE `sys_user`
(
    `id`          int NOT NULL,
    `name`        varchar(50) NULL COMMENT '用户名',
    `card`        int NULL COMMENT '账号',
    `password`    varchar(100) NULL COMMENT '密码',
    `delete_flag` int NULL DEFAULT 0 COMMENT '逻辑删除',
    PRIMARY KEY (`id`)
);