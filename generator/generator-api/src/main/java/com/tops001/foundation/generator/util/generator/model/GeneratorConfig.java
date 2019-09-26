package com.tops001.foundation.generator.util.generator.model;

/**
 * @author liuxy
 * @Date 2017/4/21
 */
public class GeneratorConfig {

    // mysql-connection-jar
    private String connectorJarPath;

    // 项目目录
    private String projectFolder;

    // src/main/java
    private String modelPackage;

    // com.tops001.bops
    private String modelPackageTargetFolder;

    private String daoPackage;

    private String daoTargetFolder;

    private String mappingXMLPackage;

    private String mappingXMLTargetFolder;


    public GeneratorConfig() {
    }

    public GeneratorConfig(String projectFolder, String modelPackage,
                           String modelPackageTargetFolder, String daoPackage,
                           String daoTargetFolder, String mappingXMLPackage,
                           String mappingXMLTargetFolder) {
        String all = System.getProperty("java.class.path");
        String connector = all.substring(all.lastIndexOf(";", all.indexOf("mysql-connector-java")) + 1, all.indexOf(";", all.indexOf("mysql-connector-java")));
        this.connectorJarPath = connector;
        this.projectFolder = projectFolder;
        this.modelPackage = modelPackage;
        this.modelPackageTargetFolder = modelPackageTargetFolder;
        this.daoPackage = daoPackage;
        this.daoTargetFolder = daoTargetFolder;
        this.mappingXMLPackage = mappingXMLPackage;
        this.mappingXMLTargetFolder = mappingXMLTargetFolder;
    }


    public String getConnectorJarPath() {
        return connectorJarPath;
    }

    public void setConnectorJarPath(String connectorJarPath) {
        this.connectorJarPath = connectorJarPath;
    }

    public String getProjectFolder() {
        return projectFolder;
    }

    public void setProjectFolder(String projectFolder) {
        this.projectFolder = projectFolder;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getModelPackageTargetFolder() {
        return modelPackageTargetFolder;
    }

    public void setModelPackageTargetFolder(String modelPackageTargetFolder) {
        this.modelPackageTargetFolder = modelPackageTargetFolder;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getDaoTargetFolder() {
        return daoTargetFolder;
    }

    public void setDaoTargetFolder(String daoTargetFolder) {
        this.daoTargetFolder = daoTargetFolder;
    }

    public String getMappingXMLPackage() {
        return mappingXMLPackage;
    }

    public void setMappingXMLPackage(String mappingXMLPackage) {
        this.mappingXMLPackage = mappingXMLPackage;
    }

    public String getMappingXMLTargetFolder() {
        return mappingXMLTargetFolder;
    }

    public void setMappingXMLTargetFolder(String mappingXMLTargetFolder) {
        this.mappingXMLTargetFolder = mappingXMLTargetFolder;
    }

}
