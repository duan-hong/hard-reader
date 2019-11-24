package com.asiainfo.hardreader.utils;

import com.asiainfo.hardreader.Entitys.vo.MonitorInfoBean;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;

/**
 * @author duanhong
 * @description 实现类
 * @date 2019/11/23
 */
@Component
public class MonitorUtils{
    //可以设置长些，防止读到运行此次系统检查时的cpu占用率，就不准了
    private static final int CPUTIME = 5000;

    private static final int PERCENT = 100;

    private static final int FAULTLENGTH = 10;
    /** *//**
     * 获得当前的监控对象.
     * @return 返回构造好的监控对象
     * @throws Exception
     * @author amg     * Creation date: 2008-4-25 - 上午10:45:08
     */
    public MonitorInfoBean getMonitorInfoBean() throws Exception {
        int kb = 1024;
        BigDecimal mbBig = new BigDecimal(1073741824);
        // 可使用内存
        long totalMemory = Runtime.getRuntime().totalMemory() / kb/kb;
        // 剩余内存
        long freeMemory = Runtime.getRuntime().freeMemory() / kb/kb;
        // 最大可使用内存
        long maxMemory = Runtime.getRuntime().maxMemory() / kb/kb;

        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        // 操作系统
        String osName = System.getProperty("os.name");
        // 总的物理内存
        long totalMemorySizeByte = osmxb.getTotalPhysicalMemorySize();
        BigDecimal totalMemorySizeByteBig = new BigDecimal(totalMemorySizeByte);
        BigDecimal totalMemorySizeMb = totalMemorySizeByteBig.divide(mbBig,2,2);//小数点2位

        // 剩余的物理内存
        long freePhysicalMemorySizeByte = osmxb.getFreePhysicalMemorySize();
        BigDecimal freePhysicalMemorySizeByteBig=new BigDecimal(freePhysicalMemorySizeByte);
        BigDecimal freePhysicalMemorySizeMb=freePhysicalMemorySizeByteBig.divide(mbBig,2,2);
        // 已使用的物理内存
        long usedMemoryByte = (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize());
        BigDecimal usedMemoryByteBig=new BigDecimal(usedMemoryByte);
        BigDecimal usedMemoryMb=usedMemoryByteBig.divide(mbBig,2,2);

        // 获得线程总数
        ThreadGroup parentThread;
        for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
                .getParent() != null; parentThread = parentThread.getParent())
            ;
        int totalThread = parentThread.activeCount();

        // 构造返回对象
        MonitorInfoBean infoBean = new MonitorInfoBean();
        infoBean.setFreeMemory(freeMemory);
        infoBean.setFreePhysicalMemorySize(freePhysicalMemorySizeMb);
        infoBean.setMaxMemory(maxMemory);
        infoBean.setOsName(osName);
        infoBean.setTotalMemory(totalMemory);
        infoBean.setTotalMemorySize(totalMemorySizeMb);
        infoBean.setTotalThread(totalThread);
        infoBean.setUsedMemory(usedMemoryMb);
        return infoBean;
    }
}
