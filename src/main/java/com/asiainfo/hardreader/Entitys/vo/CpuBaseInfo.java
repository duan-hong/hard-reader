package com.asiainfo.hardreader.Entitys.vo;

/**
 * @author duanhong
 * @description 硬件基本信息
 * @date 2019/11/23
 */
public class CpuBaseInfo {
    private int mhz;

    private String vendor;

    private String model;

    private long cacheSize;

    private int cpuCoreNum;

    public int getCpuCoreNum() {
        return cpuCoreNum;
    }

    public void setCpuCoreNum(int cpuCoreNum) {
        this.cpuCoreNum = cpuCoreNum;
    }

    public int getMhz() {
        return mhz;
    }

    public void setMhz(int mhz) {
        this.mhz = mhz;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(long cacheSize) {
        this.cacheSize = cacheSize;
    }
}
