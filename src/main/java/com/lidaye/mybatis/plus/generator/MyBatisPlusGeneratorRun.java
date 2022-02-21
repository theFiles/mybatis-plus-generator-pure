package com.lidaye.mybatis.plus.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lidaye
 * @date 2022/2/21
 */
public class MyBatisPlusGeneratorRun {
    /**
     * 当前项目的路径
     */
    private final static String PROJECT_PATH = System.getProperty("user.dir");

    /**
     * mapper.xml文件存放目录
     */
    private final static String MAPPER_XML_PATH = PROJECT_PATH + "/src/main/resources/mapper/";

    /**
     * 数据库类型
     */
    private final static DbType DB_TYPE = DbType.MYSQL;

    /**
     * 数据库链接信息
     */
    private final static String DB_URL = "jdbc:mysql://localhost:3306/zfposp-backup?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2b8";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "123456";

    /**
     * 项目包名
     */
    private final static String PACKAGE_NAME = "com.lidaye.mybatis.plus.generator";

    /**
     * 生成的表名
     */
    private final static String[] TABLE_NAMES = new String[]{"pos_user"};


    public static void main(String[] args) {
        MyBatisPlusGeneratorRun myBatisPlusGeneratorRun = new MyBatisPlusGeneratorRun();
        myBatisPlusGeneratorRun.generateByTables(false, TABLE_NAMES);
    }

    /**
     * 根据表自动生成
     * @param serviceNameStartWithI 默认为false
     * @param tableNames      表名
     * @author Terry
     */
    private void generateByTables(boolean serviceNameStartWithI, String... tableNames) {
        //配置数据源
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);
        //全局变量配置
        GlobalConfig globalConfig = getGlobalConfig(serviceNameStartWithI);
        //包名配置
        PackageConfig packageConfig = getPackageConfig(PACKAGE_NAME);
        //自动生成
        atuoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig);
    }

    /**
     * 集成
     * @param dataSourceConfig 配置数据源
     * @param strategyConfig  策略配置
     * @param config      全局变量配置
     * @param packageConfig  包名配置
     * @author Terry
     */
    private void atuoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig config, PackageConfig packageConfig) {

        TemplateConfig templateConfig = new TemplateConfig();
        // 不生成controller类
        templateConfig.setController("");
        // 不生成xml文件
        templateConfig.setXml("");

        // 自定义配置，重新定义xml文件生成路径
        InjectionConfig injectionConfig = getInjectionConfig();

        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplate(templateConfig)
                .setCfg(injectionConfig)
                .execute();
    }

    /**
     * 自定义配置
     * @return              自定义配置
     */
    private InjectionConfig getInjectionConfig() {
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MAPPER_XML_PATH + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {}
        };

        cfg.setFileOutConfigList(focList);

        return cfg;
    }

    /**
     * 设置包名
     * @param packageName 父路径包名
     * @return PackageConfig 包名配置
     * @author Terry
     */
    private PackageConfig getPackageConfig(String packageName) {
        return new PackageConfig()
                .setParent(packageName)
                .setMapper("mapper")
                .setEntity("entity");
    }

    /**
     * 全局配置
     * @param serviceNameStartWithI false
     * @return GlobalConfig
     * @author Terry
     */
    private GlobalConfig getGlobalConfig(boolean serviceNameStartWithI) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                .setActiveRecord(false)
                //设置输出路径
                .setOutputDir("./src/main/java/")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            //设置service名
            globalConfig.setServiceName("%sService");
        }
        return globalConfig;
    }

    /**
     * 策略配置
     * @param tableNames 表名
     * @return StrategyConfig
     * @author Terry
     */
    private StrategyConfig getStrategyConfig(String... tableNames) {
        return new StrategyConfig()
                // 全局大写命名 ORACLE 注意
                .setCapitalMode(true)
                //从数据库表到文件的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                // 是否使用lombok
//                .setEntityLombokModel(true)
                //需要生成的的表名，多个表名传数组
                .setInclude(tableNames);
    }

    /**
     * 配置数据源
     * @return 数据源配置 DataSourceConfig
     * @author Terry
     */
    private DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig().setDbType(DB_TYPE)
                .setUrl(DB_URL)
                .setUsername(USERNAME)
                .setPassword(PASSWORD)
                .setDriverName(DRIVER);
    }

    /**
     * 根据表自动生成
     * @param tableNames 表名
     * @author Terry
     */
    @SuppressWarnings("unused")
    private void generateByTables(String... tableNames) {
        generateByTables(true, tableNames);
    }
}
