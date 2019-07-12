package cn.umisoft.admin.util.mybatisplus;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: <p></p>
 * @author: hujie@umisoft.cn
 * @date: 2019/3/17 11:12 PM
 */
@ConfigurationProperties(prefix = "umisoft.mybatis-plus.generator.global")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmiMPGlobalConfig extends GlobalConfig {

}
