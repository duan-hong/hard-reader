package com.asiainfo.hardreader.services;

import com.asiainfo.hardreader.Entitys.vo.CpuRealData;
import com.asiainfo.hardreader.Entitys.vo.HardRuntimeInfo;
import com.asiainfo.hardreader.utils.HardInfoRegistryData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanhong
 * @description 实时数据服务
 * @date 2019/11/23
 */
@Service
public class RealDataService {

    private List<HardRuntimeInfo> list=new ArrayList<>();

    public List<HardRuntimeInfo> getRealData(int size) {
        HardInfoRegistryData hardInfoRegistryData=HardInfoRegistryData.getHardInfoRegistry();
        List<HardRuntimeInfo> hardRuntimeInfoList=hardInfoRegistryData.getList();
        return hardRuntimeInfoList;
    }

    public List<CpuRealData> getCpuRealData() {
        HardInfoRegistryData hardInfoRegistryData=HardInfoRegistryData.getHardInfoRegistry();
        List<CpuRealData> cpuRealDataList=hardInfoRegistryData.getCpuRealDataList();
        return cpuRealDataList;
    }
}
