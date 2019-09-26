package com.tops001.foundation.generator.util.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.sql.Types;
import java.util.List;

/**
 * @author liuxy
 * @Date 2017/4/21
 */
public class ModelGeneratePlugin extends PluginAdapter {

    @Override
    public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

        List<IntrospectedColumn> pks = introspectedTable.getPrimaryKeyColumns();
        if(pks != null && pks.size() > 1) {
            return true;
        }
        IntrospectedColumn introspectedColumn = pks.get(0);
        int jdbcType = introspectedColumn.getJdbcType();
        if(jdbcType != Types.BIGINT && jdbcType != Types.INTEGER) {
            return true;
        }
        element.addAttribute(new Attribute("useGeneratedKeys", "true"));
        element.addAttribute(new Attribute("keyProperty", introspectedColumn.getJavaProperty()));
        element.addAttribute(new Attribute("keyColumn", introspectedColumn.getActualColumnName()));

        return super.sqlMapInsertElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {

        List<IntrospectedColumn> pks = introspectedTable.getPrimaryKeyColumns();
        if(pks != null && pks.size() > 1) {
            return true;
        }
        IntrospectedColumn introspectedColumn = pks.get(0);
        int jdbcType = introspectedColumn.getJdbcType();
        if(jdbcType != Types.BIGINT && jdbcType != Types.INTEGER) {
            return true;
        }
        element.addAttribute(new Attribute("useGeneratedKeys", "true"));
        element.addAttribute(new Attribute("keyProperty", introspectedColumn.getJavaProperty()));
        element.addAttribute(new Attribute("keyColumn", introspectedColumn.getActualColumnName()));

        return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);
    }

    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        System.out.println(field.getType().toString() + ":" + field.getName());
        if(field.getType().toString().equals("java.lang.Byte")){
            field.setType(new FullyQualifiedJavaType(Integer.class.getName()));
        }


        System.out.println("      ");
        System.out.println("注释:" + introspectedColumn.getRemarks());
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {

        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addAnnotation("@Data");
        return true;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {


        return false;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {


        return false;
    }

    private void addPK(XmlElement element, IntrospectedTable introspectedTable) {

    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
}
