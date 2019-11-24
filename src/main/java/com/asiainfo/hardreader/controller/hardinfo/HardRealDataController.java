package com.asiainfo.hardreader.controller.hardinfo;

import com.asiainfo.hardreader.Entitys.response.BaseResponse;
import com.asiainfo.hardreader.Entitys.vo.CpuRealData;
import com.asiainfo.hardreader.Entitys.vo.HardRuntimeInfo;
import com.asiainfo.hardreader.services.RealDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanhong
 * @description 硬件信息实时数据
 * @date 2019/11/23
 */
@Controller
@RequestMapping("/hardReal")
public class HardRealDataController {

    @Autowired
    RealDataService realDataService;

    /**
     * 获取内存实时数据
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/memData")
    @ResponseBody
    public BaseResponse<List<HardRuntimeInfo>> getRealData(int page,int size){
        List<HardRuntimeInfo> hardRuntimeInfoList= realDataService.getRealData(size);
        return new BaseResponse<List<HardRuntimeInfo>>(hardRuntimeInfoList);
    }

    /**
     * 获取cpu实时数据
     * @return
     */
    @GetMapping("/cpuData")
    @ResponseBody
    public BaseResponse<List<CpuRealData>> getCpuRealData(){
        List<CpuRealData> list=realDataService.getCpuRealData();
        return new BaseResponse<List<CpuRealData>>(list);
    }
}
