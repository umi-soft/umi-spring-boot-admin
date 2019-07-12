package cn.umisoft.admin.util.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: <p>配置项</p>
 * @author: hujie@umisoft.cn
 * @date: 2019/1/27 9:55 PM
 * @param:
 * @return:
 */
@ConfigurationProperties(prefix = "umisoft")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmiApplicationProperties {
    private String avatarDiskPrefixPath;
    private JwtToken jwt;

    private UmiMPCodeGeneratorConfig mybatisPlusGeneratorConfig;
}
