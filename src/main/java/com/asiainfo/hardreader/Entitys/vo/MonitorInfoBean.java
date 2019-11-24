package com.asiainfo.hardreader.Entitys.vo;

import java.math.BigDecimal;

/**
 * @author duanhong
 * @description 监控信息
 * @date 2019/11/23
 */
public class MonitorInfoBean {
    /** *//** 可使用内存. */
    private long totalMemory;

    /** *//** 剩余内存. */
    private long freeMemory;

    /** *//** 最大可使用内存. */
    private long maxMemory;

    /** *//** 操作系统. */
    private String osName;

    /** *//** 总的物理内存. */
    private BigDecimal totalMemorySize;

    /** *//** 剩余的物理内存. */
    private BigDecimal freePhysicalMemorySize;

    /** *//** 已使用的物理内存. */
    private BigDecimal usedMemory;

    /** *//** 线程总数. */
    private int totalThread;


    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public BigDecimal getTotalMemorySize() {
        return totalMemorySize;
    }

    public void setTotalMemorySize(BigDecimal totalMemorySize) {
        this.totalMemorySize = totalMemorySize;
    }

    public BigDecimal getFreePhysicalMemorySize() {
        return freePhysicalMemorySize;
    }

    public void setFreePhysicalMemorySize(BigDecimal freePhysicalMemorySize) {
        this.freePhysicalMemorySize = freePhysicalMemorySize;
    }

    public BigDecimal getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(BigDecimal usedMemory) {
        this.usedMemory = usedMemory;
    }

    public int getTotalThread() {
        return totalThread;
    }

    public void setTotalThread(int totalThread) {
        this.totalThread = totalThread;
    }


    @Override
    public String toString() {
        return "MonitorInfoBean{" +
                "totalMemory=" + totalMemory +
                ", freeMemory=" + freeMemory +
                ", maxMemory=" + maxMemory +
                ", osName='" + osName + '\'' +
                ", totalMemorySize=" + totalMemorySize +
                ", freePhysicalMemorySize=" + freePhysicalMemorySize +
                ", usedMemory=" + usedMemory +
                ", totalThread=" + totalThread +
                '}';
    }
}
