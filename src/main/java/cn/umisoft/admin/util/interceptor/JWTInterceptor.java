package cn.umisoft.admin.util.interceptor;

import cn.umisoft.admin.exception.ControllerFieldCheckException;
import cn.umisoft.admin.util.UmiJWT;
import cn.umisoft.admin.util.UmiUserContextHolder;
import cn.umisoft.admin.util.property.UmiApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: <p>JWT 拦截器，双重验证</p>
 * @author: hujie@umisoft.cn
 * @date: 2019/2/19 10:41 PM
 */
public class JWTInterceptor implements HandlerInterceptor {
    @Autowired
    protected UmiApplicationProperties props;
    @Autowired
    protected StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = UmiJWT.getToken(request);
        if (authorization == null) {
            throw new ControllerFieldCheckException("缺失token信息");
        }
        // 验证JWT，并为线程绑定当前登录人信息ID
        UmiUserContextHolder.setContext(UmiJWT.verify(authorization, props.getJwt().getSecret(), redisTemplate));
        return true;
    }
}
