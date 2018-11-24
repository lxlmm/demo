package com.lxl;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyBatisPlusCodeGenerator {
    private static String projectPath = System.getProperty("user.dir");

    private static String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/liaoxl_db";


    @Test
    public void codeGen() {
        String[] include = {"t_student"};

        main(include, null);
    }


    private static void main(String[] include, String[] exclude) {


        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir(projectPath + "/src/main/java")
                .setFileOverride(true)
                .setActiveRecord(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setAuthor("liaoxl")
                .setOpen(false)
                .setIdType(IdType.AUTO)
                .setDateType(DateType.ONLY_DATE)
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");

        mpg.setGlobalConfig(gc);

        DataSourceConfig desc = new DataSourceConfig();

        desc.setUrl(jdbcUrl);
        desc.setDriverName("com.mysql.cj.jdbc.Driver");
        desc.setUsername("root");
        desc.setPassword("123456");

        mpg.setDataSource(desc);
        PackageConfig pc = new PackageConfig();

        pc
                .setParent("com.lxl")
                .setEntity("entity")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl")
                .setController("controller");

        mpg.setPackageInfo(pc);


        StrategyConfig sc = new StrategyConfig();
        sc.setInclude(include);
        sc.setExclude(exclude);
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(sc);

        /**
         * 注入自定义配置
         */
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig abc = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String,Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //自定义文件输出位置（非必须）
        List<FileOutConfig> fileOutList = new ArrayList<FileOutConfig>();
        fileOutList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/templates/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        abc.setFileOutConfigList(fileOutList);
        mpg.setCfg(abc);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        mpg.setTemplate(tc);


        mpg.execute();

    }

}
