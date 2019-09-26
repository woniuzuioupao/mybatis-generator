package com.tops001.foundation.generator.util.generator;


import com.tops001.foundation.generator.util.MybatisGeneratorUtils;
import com.tops001.foundation.generator.util.generator.model.DatabaseConfig;
import com.tops001.foundation.generator.util.generator.model.GeneratorConfig;
import com.tops001.foundation.generator.util.generator.model.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:
 *
 * @createdtime 2019/9/25
 */
public class Main {

    public static void main(String[] args) throws Exception{

        GeneratorConfig generatorConfig = new GeneratorConfig("E:\\web\\generate",
                "temp", "src\\java",
                "temp", "src\\java",
                "temp", "src\\java");
        DatabaseConfig databaseConfig = new DatabaseConfig("jdbc:mysql://dev.mysql.apitops.com:4308/tops_okr?allowMultiQueries=true&useSSL=false&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&connectTimeout=2000&autoReconnect=true",
                "tops_okr_dev", "J6wfkJTX5TAnZax6nO74XFE48eRSTT");
        List<Table> list = new ArrayList<>();
        list.add(new Table("to_comment", "Comment"));
        MybatisGeneratorUtils.generator(generatorConfig, databaseConfig, list);

    }
}
