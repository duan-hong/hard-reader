package com.asiainfo.hardreader.Entitys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author duanhong
 * @description 运行时信息
 * @date 2019/11/23
 */
public class HardRuntimeInfo implements Serializable {
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

    /** *//** cpu使用率. */
    private double cpuRatio;

    //采集时间
    private String collectTime;

    //数据Id
    private String dataId;

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

    public double getCpuRatio() {
        return cpuRatio;
    }

    public void setCpuRatio(double cpuRatio) {
        this.cpuRatio = cpuRatio;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }
}
