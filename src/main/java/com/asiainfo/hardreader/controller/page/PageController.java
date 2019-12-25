package com.asiainfo.hardreader.controller.page;

import com.asiainfo.hardreader.Entitys.constant.MenuConstant;
import org.apache.commons.lang.StringUtils;import org.springframework.stereotype.Controller;
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
        if (MenuConstant.MENU_LIST.contains(pageName)){
            return "page/"+pageName;
        }else{
            return "page/404";
        }
    }
}
