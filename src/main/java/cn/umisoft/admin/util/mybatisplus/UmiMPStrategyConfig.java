package cn.umisoft.admin.util.mybatisplus;

import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @description: <p></p>
 * @author: hujie@umisoft.cn
 * @date: 2019/3/17 11:04 PM
 */
@ConfigurationProperties(prefix = "umisoft.mybatis-plus.generator.strategy")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UmiMPStrategyConfig extends StrategyConfig {

}
