package com.sac.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @ProjectName: TecDemo
 * @Package: com.sac.framework
 * @Title:
 * @Description:
 * @Author: EAISON
 * @CreateDate: 2018-04-20 14:24
 * @ModifyUser:
 * @ModifyDate: 2018-04-20 14:24
 * @ModifyRemark:
 * @Version: 1.0.0
 * @Copyright: Copyright (c) 南京华盾电力信息安全测评有限公司 2018
 **/
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }
}
