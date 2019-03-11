package cn.umisoft.admin;

import cn.umisoft.admin.util.interceptor.JWTInterceptor;
import cn.umisoft.admin.util.mybatisplus.UmiQueryConditionTypeEnum;
import cn.umisoft.admin.util.property.UmiApplicationProperties;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Properties;

@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({UmiApplicationProperties.class})
public class ApplicationStarter implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStarter.class, args);
	}

	/**
	 * @description: <p>FastJson整合</p>
	 * @author: hujie@umisoft.cn
	 * @date: 2019/1/12 9:44 PM
	 * @return: org.springframework.boot.autoconfigure.http.HttpMessageConverters
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();

		config.setSerializerFeatures(SerializerFeature.WriteEnumUsingToString, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty);

		// 便于动态SQL 枚举映射
		SerializeConfig serializeConfig = new SerializeConfig();
		for (UmiQueryConditionTypeEnum item : UmiQueryConditionTypeEnum.values()) {
			serializeConfig.configEnumAsJavaBean(item.getClass());
		}
		config.setSerializeConfig(serializeConfig);

		fastConverter.setFastJsonConfig(config);
		return new HttpMessageConverters(fastConverter);
	}
	/**
	 * @description: <p></p>
	 * @author: hujie@umisoft.cn
	 * @date: 2019/2/20 12:58 AM
	 * @param:
	 * @return:
	 */
	@Bean
	public Producer producer() {
		Properties props = new Properties();
		props.put("kaptcha.border", "no");
		props.put("kaptcha.textproducer.char.length","6");
		props.put("kaptcha.image.height","40");
		props.put("kaptcha.image.width","200");
		props.put("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");
		props.put("kaptcha.textproducer.font.color","black");
		props.put("kaptcha.textproducer.font.size","30");
//		props.put("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");
		props.put("kaptcha.noise.impl","com.google.code.kaptcha.impl.DefaultNoise");
		props.put("kaptcha.textproducer.char.string","acdefhkmnprtwxy2345678");
		Config config = new Config(props);
		return config.getProducerImpl();
	}
	/**
	 * @description: <p>JWT拦截器，便于组件注入</p>
	 * @author: hujie@umisoft.cn
	 * @date: 2019/2/19 10:29 PM
	 */
	@Bean
	public JWTInterceptor jwtInterceptor() {
		return new JWTInterceptor();
	}
	/**
	 * @description: <p>拦截器注册</p>
	 * @author: hujie@umisoft.cn
	 * @date: 2019/2/15 9:07 AM
	 * @param: registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration registration = registry.addInterceptor(jwtInterceptor());
		registration.addPathPatterns("/**");

		// /admin/auth/logout 拦截器必须拦截token，确保分布式环境下，能够正常退出
		registration.excludePathPatterns("/admin/auth/captcha", "/admin/auth/login");
	}
}

