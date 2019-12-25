package com.asiainfo.hardreader.Entitys.vo;

/**
 * @author duanhong
 * @description 文件系统信息
 * @date 2019/12/13
 */
public class FileSystemBaseInfo {
    private String devName;
    private String dirName;
    private String flags;
    private String sysTypeName;
    private String typeName;
    private String type;

    public String getDevName() {
        return this.devName;
    }

    public void setDevName(final String devName) {
        this.devName = devName;
    }

    public String getDirName() {
        return this.dirName;
    }

    public void setDirName(final String dirName) {
        this.dirName = dirName;
    }

    public String getFlags() {
        return this.flags;
    }

    public void setFlags(final String flags) {
        this.flags = flags;
    }

    public String getSysTypeName() {
        return this.sysTypeName;
    }

    public void setSysTypeName(final String sysTypeName) {
        this.sysTypeName = sysTypeName;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(final String typeName) {
        this.typeName = typeName;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }
}
