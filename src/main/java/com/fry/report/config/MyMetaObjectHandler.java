package com.fry.report.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.fry.report.common.CommonMethod;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: QTX
 * @Since: 2022/8/30
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        String s = CommonMethod.getName();
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createBy", String.class, s);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        String s = CommonMethod.getName();
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateBy", String.class, s);
    }

}

