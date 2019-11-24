package com.asiainfo.hardreader.task;

import com.asiainfo.hardreader.Entitys.vo.CpuRealData;
import com.asiainfo.hardreader.Entitys.vo.CpuUseCalResult;
import com.asiainfo.hardreader.Entitys.vo.HardRuntimeInfo;
import com.asiainfo.hardreader.Entitys.vo.MonitorInfoBean;
import com.asiainfo.hardreader.utils.CalCpuUseValue;
import com.asiainfo.hardreader.utils.HardInfoRegistryData;
import com.asiainfo.hardreader.utils.MonitorUtils;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author duanhong
 * @description 读取硬件信息定时任务
 * @date 2019/11/23
 */
@Component
@Configuration //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class HardInfoTask {
    @Autowired
    private MonitorUtils monitorUtils;

    @Scheduled(fixedRate=2000)
    public void refreshHardWareInfo(){
        HardInfoRegistryData hardInfoRegistryData=HardInfoRegistryData.getHardInfoRegistry();
        Sigar sigar = new Sigar();
        SimpleDateFormat sfm=new SimpleDateFormat("HH:mm:ss");
        HardRuntimeInfo hardRuntimeInfo=new HardRuntimeInfo();
        CpuRealData cpuRealData=new CpuRealData();
        //计算cpu使用数据
        try {
            CpuPerc[] cpuPercs=sigar.getCpuPercList();
            CpuUseCalResult cpuUseCalResult=CalCpuUseValue.getCpuUseValue(cpuPercs);
            BeanUtils.copyProperties(cpuUseCalResult,cpuRealData);
            cpuRealData.setCollectTime(sfm.format(new Date()));
        } catch (SigarException e) {
            e.printStackTrace();
        }

        //获取内存使用情况
        try {
            MonitorInfoBean monitorInfoBean= monitorUtils.getMonitorInfoBean();
            BeanUtils.copyProperties(monitorInfoBean,hardRuntimeInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        hardRuntimeInfo.setCollectTime(sfm.format(new Date()));
        hardRuntimeInfo.setDataId(new Date().getTime()+"");
        List<HardRuntimeInfo> list=hardInfoRegistryData.getList();
        List<CpuRealData> cpuRealDataList=hardInfoRegistryData.getCpuRealDataList();
        list.add(hardRuntimeInfo);
        cpuRealDataList.add(cpuRealData);
        if (list.size()>20){
            list=list.subList(list.size()-20,list.size()-1);
        }
        if (cpuRealDataList.size()>20){
            cpuRealDataList=cpuRealDataList.subList(cpuRealDataList.size()-20,cpuRealDataList.size()-1);
        }
        hardInfoRegistryData.setList(list);
        hardInfoRegistryData.setCpuRealDataList(cpuRealDataList);
    }
}
