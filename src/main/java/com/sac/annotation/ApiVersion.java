package com.sac.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @ProjectName: TecDemo
 * @Package: com.sac.annotation
 * @Title:
 * @Description:
 * @Author: EAISON
 * @CreateDate: 2018-04-20 13:56
 * @ModifyUser:
 * @ModifyDate: 2018-04-20 13:56
 * @ModifyRemark:
 * @Version: 1.0.0
 * @Copyright: Copyright (c) 南京华盾电力信息安全测评有限公司 2018
 **/

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    int value();
}
