package com.sac.controller;

import com.sac.annotation.ApiVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: TecDemo
 * @Package: com.sac.controller
 * @Title:
 * @Description:
 * @Author: EAISON
 * @CreateDate: 2018-04-20 13:46
 * @ModifyUser:
 * @ModifyDate: 2018-04-20 13:46
 * @ModifyRemark:
 * @Version: 1.0.0
 * @Copyright: Copyright (c) 南京华盾电力信息安全测评有限公司 2018
 **/
@Controller
@RequestMapping("/{version}/")
public class VersionController {

    @RequestMapping("hello/")
    @ApiVersion(1)
    @ResponseBody
    private Map<String, String> index() {
        Map<String, String> maps = new HashMap<>();
        maps.put("sac", "wwg");
        return maps;
    }
}
