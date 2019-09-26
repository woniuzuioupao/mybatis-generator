package com.tops001.foundation.generator.util;

import com.tops001.foundation.generator.util.generator.bridge.MybatisGeneratorBridge;
import com.tops001.foundation.generator.util.generator.model.DatabaseConfig;
import com.tops001.foundation.generator.util.generator.model.GeneratorConfig;
import com.tops001.foundation.generator.util.generator.model.Table;

import java.util.List;

/**
 * 类描述:
 *
 * @createdtime 2019/9/26
 */
public class MybatisGeneratorUtils {

    public static void generator(GeneratorConfig generatorConfig, DatabaseConfig databaseConfig, List<Table> list) throws Exception{
        MybatisGeneratorBridge mybatisGeneratorBridge = new MybatisGeneratorBridge(generatorConfig, databaseConfig, list);
        mybatisGeneratorBridge.generator();
    }

}
