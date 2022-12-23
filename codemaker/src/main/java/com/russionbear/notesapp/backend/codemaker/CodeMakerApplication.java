package com.russionbear.notesapp.backend.codemaker;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.config.StrategyConfig.Builder;
import java.util.Collections;


public  class CodeMakerApplication {
    static String jdbcUrl = "jdbc:mysql://localhost:3306/test";
    static String username = "root";
    static String password = "tedu";
    static String authorName = "russionbear";

    public static void make(String[] args, String[] tables, boolean isFirst){
        FastAutoGenerator.create(jdbcUrl, username, password)
                .globalConfig(builder -> {
                    builder.author(authorName) // 设置作者
                            .enableSwagger()
                            .enableSpringdoc()
                            .disableOpenDir()
                            .outputDir(args[0]+"/src/main/java");

                })
                .packageConfig(builder -> {
                    builder.parent(args[1]) // 设置父包名
                            .moduleName(args[2])
                            .pathInfo(Collections.singletonMap(OutputFile.xml, args[0]+"/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    Builder builder1 = builder.addInclude(tables); // 设置需要生成的表名
                    if(isFirst){
                        builder1.entityBuilder().enableFileOverride()
                                .mapperBuilder().enableFileOverride()
                                .controllerBuilder().enableFileOverride()
                        //.serviceBuilder().enableFileOverride()
                        ;
                    }else{
                        builder1.entityBuilder();
                    }
                })
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    public static void main(String[] args) {
        String projectRoot = "E:\\workspace\\notes-app\\notesapp-backend";
        make(new String[]{projectRoot+"/userinfo","com.russionbear.notesapp.backend","userinfo"},
                new String[]{"user_info", "chat_info", "collection", "edit_model", "watch", "token_info"},
                false);
//        make(new String[]{projectRoot+"/article","com.russionbear.notesapp.backend","article"},
//                new String[]{"note_info", "storage_info", "discuss", "good"},
//                true);
//        make(new String[]{projectRoot+"/resource","com.russionbear.notesapp.backend","resource"},
//                new String[]{"resource_info"},
//                true);

    }
}

