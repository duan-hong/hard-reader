package com.asiainfo.hardreader.Entitys.vo;

import java.math.BigDecimal;

/**
 * @author duanhong
 * @description 文件系统信息
 * @date 2019/12/23
 */
public class FileSysInfo {
    private String name;
    private String desc;
    private String type;
    private String usable;
    private String totalSpace;
    private BigDecimal usedPercent;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String desc) {
        this.desc = desc;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getUsable() {
        return this.usable;
    }

    public void setUsable(final String usable) {
        this.usable = usable;
    }

    public String getTotalSpace() {
        return this.totalSpace;
    }

    public void setTotalSpace(final String totalSpace) {
        this.totalSpace = totalSpace;
    }

    public BigDecimal getUsedPercent() {
        return this.usedPercent;
    }

    public void setUsedPercent(final BigDecimal usedPercent) {
        this.usedPercent = usedPercent;
    }
}
