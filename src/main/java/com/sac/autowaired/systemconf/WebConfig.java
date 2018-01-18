package com.sac.autowaired.systemconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author:eason
 * @Description
 * @Date: 19:41,2018/1/17
 * @ModifiedBy
 */

@Configuration
@EnableWebMvc
@Component("configWeb")
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置视图解析器
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        //region 配置文件代码
      /*  <bean
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
          <property name="viewClass"
        value="org.springframework.web.servlet.view.JstlView"/>
          <property name="prefix" value="/WEB-INF/jsp/"/>
          <property name="suffix" value=".jsp"/>
      </bean>*/
        //endregion
        InternalResourceViewResolver resourceViewResolver =
                new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("WEB-INF/jsp/");
        resourceViewResolver.setSuffix(".jsp");
        resourceViewResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        return resourceViewResolver;
    }

    /**
     * 配置静态资源处理
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //region xml配置代码
       /*  <!-- 通过mvc:resources设置静态资源，这样servlet就会处理这些静态资源，而不通过控制器 -->
    <!-- 设置不过滤内容，比如:css,jquery,img 等资源文件 -->
    <!--  <mvc:resources location="*//*.html" mapping="*//**.html"/>
      <mvc:resources location="/css*//*" mapping="/css*//**"/>
      <mvc:resources location="/js*//*" mapping="/js*//**"/>
      <mvc:resources location="/images*//*" mapping="/images*//**"/>-->

    <!--或则-->
   <!-- <mvc:resources mapping="/resources*//**" location="/resources/"/>-->*/
        //endregion
    registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    /**
     *  配置静态资源的处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}
