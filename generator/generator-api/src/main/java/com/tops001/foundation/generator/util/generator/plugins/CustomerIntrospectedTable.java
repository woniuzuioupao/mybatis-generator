package com.tops001.foundation.generator.util.generator.plugins;

import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;
import org.mybatis.generator.codegen.mybatis3.model.RecordWithBLOBsGenerator;

import java.util.List;

/**
 * @author liuxy
 * @Date 2017/4/21
 */
public class CustomerIntrospectedTable extends IntrospectedTableMyBatis3Impl {


    @Override
    public void setMyBatis3JavaMapperType(String mybatis3JavaMapperType) {

        String newFileName = mybatis3JavaMapperType.replace("Mapper", "Dao");
        internalAttributes.put(
                InternalAttribute.ATTR_MYBATIS3_JAVA_MAPPER_TYPE,
                newFileName);
    }

    protected void calculateJavaModelGenerators(List<String> warnings,
                                                ProgressCallback progressCallback) {


        if (getRules().generateBaseRecordClass()) {
            AbstractJavaGenerator javaGenerator = new CustomerRecordGenerator();
            initializeAbstractGenerator(javaGenerator, warnings,
                    progressCallback);
            javaModelGenerators.add(javaGenerator);
        }

        if (getRules().generateRecordWithBLOBsClass()) {
            AbstractJavaGenerator javaGenerator = new RecordWithBLOBsGenerator();
            initializeAbstractGenerator(javaGenerator, warnings,
                    progressCallback);
            javaModelGenerators.add(javaGenerator);
        }
    }

    @Override
    public void initialize() {
        super.initialize();
        setRules(new CostomerConditionalModelRules(this));
    }
}
