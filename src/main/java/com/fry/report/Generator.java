package com.fry.report;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.fry.report.common.BaseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 代码生成器
 *
 * @author: QTX
 * @Since: 2022/8/30
 */
public class Generator {

    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(
            "jdbc:mysql://127.0.0.1:3307/report", "root", "123456");

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author("qtx").outputDir(projectPath + "/src/main/java")
                        .disableOpenDir())
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent("com.fry").moduleName("report").entity("entity")
                        .service("service").serviceImpl("service.impl").mapper("mapper").xml("mapper")
                        .controller("controller")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(
                                getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all"))).controllerBuilder()
                        .enableRestStyle().entityBuilder().disableSerialVersionUID().enableLombok().superClass(BaseEntity.class)
                        .enableTableFieldAnnotation()
                        .addSuperEntityColumns("id", "delete_flag", "create_by", "create_time", "update_by",
                                "update_time").mapperBuilder().mapperAnnotation(Mapper.class).build()).execute();
    }

    /** 处理 all 情况 */
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
