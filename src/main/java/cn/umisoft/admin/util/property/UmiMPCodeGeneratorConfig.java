package cn.umisoft.admin.util.property;

import cn.umisoft.admin.util.mybatisplus.UmiMPGlobalConfig;
import cn.umisoft.admin.util.mybatisplus.UmiMPPackageConfig;
import cn.umisoft.admin.util.mybatisplus.UmiMPStrategyConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: <p></p>
 * @author: hujie@umisoft.cn
 * @date: 2019/3/17 11:17 PM
 */
@ConfigurationProperties(prefix = "umisoft.mybatis-plus.generator")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmiMPCodeGeneratorConfig {
    private UmiMPGlobalConfig globalConfig;
    private UmiMPPackageConfig packageConfig;
    private UmiMPStrategyConfig strategyConfig;

}
