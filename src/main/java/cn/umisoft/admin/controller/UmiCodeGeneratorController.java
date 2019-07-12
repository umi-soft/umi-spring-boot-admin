package cn.umisoft.admin.controller;

import cn.umisoft.admin.util.ApiResult;
import cn.umisoft.admin.util.ApiResultWrapper;
import cn.umisoft.admin.util.property.UmiApplicationProperties;
import cn.umisoft.admin.util.property.UmiMPCodeGeneratorConfig;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * @description: <p>代码生成器</p>
 * @author: hujie@umisoft.cn
 * @date: 2019/3/17 10:48 PM
 */
@RestController
@RequestMapping("/admin/code-generator")
public class UmiCodeGeneratorController {
    @Autowired
    private UmiApplicationProperties properties;

    @Value("${spring.datasource.druid.url}")
    private String url;
    @Value("${spring.datasource.druid.username}")
    private String username;
    @Value("${spring.datasource.druid.password}")
    private String password;
    @Value("${spring.datasource.druid.driver-class-name}")
    private String driverClassName;
    
    @PostMapping(value = "execute")
    public ApiResult generator(UmiMPCodeGeneratorConfig config) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        if (config.getGlobalConfig().getOutputDir() == null) {
            // System.getProperty("user.dir") 即为当前工程根路径
            config.getGlobalConfig().setOutputDir(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java");
        }
        mpg.setGlobalConfig(config.getGlobalConfig());

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setDriverName(driverClassName);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        mpg.setDataSource(dataSourceConfig);

        // 包配置
        mpg.setPackageInfo(config.getPackageConfig());

        // 策略配置
        mpg.setStrategy(config.getStrategyConfig());

        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
        return ApiResultWrapper.success();
    }
}
