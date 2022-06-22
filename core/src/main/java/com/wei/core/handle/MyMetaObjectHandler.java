package com.wei.core.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Value;

/**
 * mybatis自动填充数值
 */
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Value("${env:dev}")
    private String env;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "ownSign", String.class, env);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
