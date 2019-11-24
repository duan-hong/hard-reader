package com.asiainfo.hardreader.controller.hardinfo;

import com.asiainfo.hardreader.Entitys.vo.*;
import com.asiainfo.hardreader.Entitys.response.BaseResponse;
import com.asiainfo.hardreader.services.HardBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author duanhong
 * @description 硬件基本信息
 * @date 2019/11/23
 */
@Controller
@RequestMapping("/hardBase")
public class HardBaseController {

    @Autowired
    private HardBaseService hardBaseService;

    /**
     * 获取cpu信息
     * @return
     */
    @GetMapping("/cpuInfo")
    @ResponseBody
    public BaseResponse<CpuBaseInfo> getCpuBaseInfo(){
        CpuBaseInfo cpuBaseInfo=hardBaseService.getCpuBaseInfo();
        return new BaseResponse<CpuBaseInfo>(cpuBaseInfo);
    }

    /**
     * 获取内存信息
     * @return
     */
    @GetMapping("/memInfo")
    @ResponseBody
    public BaseResponse<MemBaseInfo> getMemBaseInfo(){
        MemBaseInfo memBaseInfo=hardBaseService.getMemBaseInfo();
        return new BaseResponse<MemBaseInfo>(memBaseInfo);
    }

    /**
     * 获取系统信息
     * @return
     */
    @GetMapping("/sysInfo")
    @ResponseBody
    public BaseResponse<SystemBaseInfo> getSysBaseInfo(){
        SystemBaseInfo systemBaseInfo=hardBaseService.getSysBaseInfo();
        return new BaseResponse<SystemBaseInfo>(systemBaseInfo);
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/userInfo")
    @ResponseBody
    public BaseResponse<UserBaseInfo> getUserBaseInfo(){
        UserBaseInfo userBaseInfo=hardBaseService.getUserBaseInfo();
        return new BaseResponse<UserBaseInfo>(userBaseInfo);
    }

    /**
     * 获取网络信息
     * @return
     */
    @GetMapping("/netInfo")
    @ResponseBody
    public BaseResponse<NetBaseInfo> getNetBaseInfo(){
        NetBaseInfo netBaseInfo=hardBaseService.getNetBaseInfo();
        return new BaseResponse<NetBaseInfo>(netBaseInfo);
    }

    /**
     * 获取以太网信息
     * @return
     */
    @GetMapping("/yiTaiNetInfo")
    @ResponseBody
    public BaseResponse<YitaiNetBaseInfo> getYiTaiNetBaseInfo(){
        YitaiNetBaseInfo yiTaiNetBaseInfo=hardBaseService.getYiTaiNetBaseInfo();
        return new BaseResponse<YitaiNetBaseInfo>(yiTaiNetBaseInfo);
    }

}
