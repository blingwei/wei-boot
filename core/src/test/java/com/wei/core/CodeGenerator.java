package com.wei.core;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

public class CodeGenerator {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "\\core\\src\\test\\resources\\";

        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/chat", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("blingweiwei") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(path); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.wei.core.domain") // 设置父包名
                            .moduleName("session") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, path)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("session_message"); // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

}
