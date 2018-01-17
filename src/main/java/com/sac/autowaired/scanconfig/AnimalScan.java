package com.sac.autowaired.scanconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author:eason
 * @Description：配置扫描的配置类 混合连接，自动装配和xml配置结合
 * @Date: 13:55,2018/1/17
 * @ModifiedBy
 */

@Configuration
@ComponentScan(basePackages = {"com.sac.autowaired.bean1"})
@ImportResource("classpath:applicationContext-service.xml")
public class AnimalScan {
}

/**
 * 配置扫描的配置类 纯自动配置
 */
/*@Configuration
@ComponentScan(basePackages = {"com.sac.autowaired.bean1","com.sac.autowaired.bean2"})
@ImportResource("classpath:applicationContext-service.xml")
public class AnimalScan {
}*/
