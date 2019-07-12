package cn.umisoft.admin.util.mybatisplus;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: <p></p>
 * @author: hujie@umisoft.cn
 * @date: 2019/3/17 10:59 PM
 */
@ConfigurationProperties(prefix = "umisoft.mybatis-plus.generator.package")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmiMPPackageConfig extends PackageConfig {

}
