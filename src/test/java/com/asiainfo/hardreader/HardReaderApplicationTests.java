package com.asiainfo.hardreader;

import com.asiainfo.hardreader.Entitys.vo.MonitorInfoBean;
import com.asiainfo.hardreader.utils.MonitorUtils;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HardReaderApplicationTests {

    @Test
    void contextLoads() {
        MonitorUtils monitorUtils=new MonitorUtils();
        try {
            MonitorInfoBean monitorInfoBean=monitorUtils.getMonitorInfoBean();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    private void cpu() throws SigarException {
        Sigar sigar = new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] = null;
        cpuList = sigar.getCpuPercList();
        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
            CpuInfo info = infos[i];
            System.out.println("第" + (i + 1) + "块CPU信息");
            System.out.println("CPU的总量MHz:    " + info.getMhz());
            System.out.println("CPU生产商:    " + info.getVendor());
            System.out.println("CPU类别:    " + info.getModel());
            System.out.println("CPU缓存数量:    " + info.getCacheSize());
        }
    }

}
