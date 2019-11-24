package com.asiainfo.hardreader.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author duanhong
 * @description 页面控制器
 * @date 2019/11/23
 */
@Controller
public class PageController {

    @RequestMapping("/page/{pageName}")
    public String pageByName(@PathVariable String pageName){
        if (StringUtils.isEmpty(pageName)){
            System.out.println("页面不能为空");
            return "404";
        }
        return pageName;
    }
}
