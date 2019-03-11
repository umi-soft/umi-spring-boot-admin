package cn.umisoft.admin.util.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: <p>JWT token相关</p>
 * @author: hujie@umisoft.cn
 * @date: 2019/2/19 3:13 PM
 */
@ConfigurationProperties(prefix = "umisoft.jwt")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JwtToken {

    private String secret;

    private Integer minutes;


}
