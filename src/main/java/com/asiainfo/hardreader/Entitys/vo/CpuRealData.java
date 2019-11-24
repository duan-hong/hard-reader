package com.asiainfo.hardreader.Entitys.vo;

/**
 * @author duanhong
 * @description cpu使用实时数据
 * @date 2019/11/24
 */
public class CpuRealData {
    //CPU用户使用率
    private double userValue;
    //CPU系统使用率
    private double sysValue;
    //CPU当前等待率
    private double currentWaitValue;
    //CPU当前错误率
    private double currentErrorValue;
    //CPU当前空闲率
    private double currentFreeValue;
    //CPU总的使用率
    private double totalValue;
    //采集时间
    private String collectTime;

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime;
    }

    public double getUserValue() {
        return userValue;
    }

    public void setUserValue(double userValue) {
        this.userValue = userValue;
    }

    public double getSysValue() {
        return sysValue;
    }

    public void setSysValue(double sysValue) {
        this.sysValue = sysValue;
    }

    public double getCurrentWaitValue() {
        return currentWaitValue;
    }

    public void setCurrentWaitValue(double currentWaitValue) {
        this.currentWaitValue = currentWaitValue;
    }

    public double getCurrentErrorValue() {
        return currentErrorValue;
    }

    public void setCurrentErrorValue(double currentErrorValue) {
        this.currentErrorValue = currentErrorValue;
    }

    public double getCurrentFreeValue() {
        return currentFreeValue;
    }

    public void setCurrentFreeValue(double currentFreeValue) {
        this.currentFreeValue = currentFreeValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
