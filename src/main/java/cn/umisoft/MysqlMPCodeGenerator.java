package cn.umisoft;

import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MysqlMPCodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
//        String projectName = scanner("工程名称(如：umi-sprint-boot-template)");
        String projectName = "umi-sprint-boot-template";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("hujie@umisoft.cn");
//        gc.setAuthor(scanner("作者邮箱"));
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.144.128.53:3306/umi-soft-admin?useUnicode=true&useSSL=false&characterEncoding=utf8");
//        dsc.setUrl(scanner("url(如:jdbc:mysql://localhost:3306/ant?useUnicode=true&useSSL=false&characterEncoding=utf8)"));
//        dsc.setSchemaName(scanner("SchemaName"));
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
//        dsc.setUsername(scanner("db username"));
        dsc.setPassword("umisoft.cn");
//        dsc.setPassword(scanner("db password"));
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("admin");

//        pc.setModuleName(scanner("模块工程名称"));
        pc.setParent("cn.umisoft");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("cn.umisoft.admin.entity.UmiREntity");
        strategy.setSuperEntityColumns("id", "deleted", "createdBy", "createdDate", "modifiedBy", "modifiedDate");
        strategy.setSuperServiceClass("cn.umisoft.admin.service.UmiService");
        strategy.setSuperServiceImplClass("cn.umisoft.admin.service.impl.UmiServiceImpl");
        strategy.setEntityLombokModel(true);
//        strategy.setSuperControllerClass("com.baomidou.mybatisplus.samples.generator.common.BaseController");
//        strategy.setInclude("T_TEST");
//        strategy.setInclude(scanner("表名"));
//        strategy.setSuperEntityColumns("id");
//        strategy.setTablePrefix("T_","R_");
        strategy.setLogicDeleteFieldName("DELETED");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
