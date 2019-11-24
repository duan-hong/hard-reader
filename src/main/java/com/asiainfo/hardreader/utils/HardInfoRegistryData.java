package com.asiainfo.hardreader.utils;

import com.asiainfo.hardreader.Entitys.vo.CpuRealData;
import com.asiainfo.hardreader.Entitys.vo.HardRuntimeInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanhong
 * @description 实时数据寄存器
 * @date 2019/11/23
 */
public class HardInfoRegistryData {
    private List<HardRuntimeInfo> list=new ArrayList<>();
    private List<CpuRealData> cpuRealDataList=new ArrayList<>();
    private static HardInfoRegistryData hardInfoRegistryData;
    private HardInfoRegistryData(){}
    synchronized public static HardInfoRegistryData getHardInfoRegistry(){
        if(hardInfoRegistryData==null){
            hardInfoRegistryData=new HardInfoRegistryData();
        }
        return hardInfoRegistryData;
    }

    public List<HardRuntimeInfo> getList() {
        return list;
    }

    public void setList(List<HardRuntimeInfo> list) {
        this.list = list;
    }

    public List<CpuRealData> getCpuRealDataList() {
        return cpuRealDataList;
    }

    public void setCpuRealDataList(List<CpuRealData> cpuRealDataList) {
        this.cpuRealDataList = cpuRealDataList;
    }
}
