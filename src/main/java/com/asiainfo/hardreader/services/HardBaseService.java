package com.asiainfo.hardreader.services;

import com.asiainfo.hardreader.Entitys.vo.*;
import org.hyperic.sigar.*;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duanhong
 * @description 系统基本信息服务类
 * @date 2019/11/24
 */
@Service
public class HardBaseService {

    public CpuBaseInfo getCpuBaseInfo() {
        Sigar sigar = new Sigar();
        CpuBaseInfo cpuBaseInfo=new CpuBaseInfo();
        try {
            CpuInfo infos[] = sigar.getCpuInfoList();
            cpuBaseInfo.setMhz(infos[0].getMhz());
            cpuBaseInfo.setCpuCoreNum(infos[0].getTotalCores());
            cpuBaseInfo.setCacheSize(infos[0].getCacheSize());
            cpuBaseInfo.setModel(infos[0].getModel());
            cpuBaseInfo.setVendor(infos[0].getVendor());
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return cpuBaseInfo;
    }

    public MemBaseInfo getMemBaseInfo() {
        Sigar sigar = new Sigar();
        MemBaseInfo memBaseInfo=new MemBaseInfo();
        try {
            Mem mem = sigar.getMem();
            Swap swap = sigar.getSwap();
            memBaseInfo.setTotal(mem.getTotal() / 1024L );
            memBaseInfo.setFree(mem.getFree() / 1024L );
            memBaseInfo.setUsed(mem.getUsed() / 1024L );
            memBaseInfo.setSwapTotal(swap.getTotal() / 1024L );
            memBaseInfo.setSwapFree(swap.getFree() / 1024L );
            memBaseInfo.setSwapUsed(swap.getUsed() / 1024L );
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return memBaseInfo;
    }

    public SystemBaseInfo getSysBaseInfo() {
        OperatingSystem os = OperatingSystem.getInstance();
        SystemBaseInfo systemBaseInfo=new SystemBaseInfo();
        systemBaseInfo.setArch(os.getArch());
        systemBaseInfo.setCpuEndian(os.getCpuEndian());
        systemBaseInfo.setDataModel(os.getDataModel());
        systemBaseInfo.setDesc(os.getDescription());
        systemBaseInfo.setName(os.getName());
        systemBaseInfo.setPatchLevel(os.getPatchLevel());
        systemBaseInfo.setVendor(os.getVendor());
        systemBaseInfo.setVendorCodeName(os.getVendorCodeName());
        systemBaseInfo.setVendorName(os.getVendorName());
        systemBaseInfo.setVendorVersion(os.getVendorVersion());
        systemBaseInfo.setVersion(os.getVersion());
        return systemBaseInfo;
    }

    public UserBaseInfo getUserBaseInfo() {
        Sigar sigar = new Sigar();
        UserBaseInfo userBaseInfo=new UserBaseInfo();
        try {
            Who who[] = sigar.getWhoList();
            userBaseInfo.setDevice(who[0].getDevice());
            userBaseInfo.setHost(who[0].getHost());
            userBaseInfo.setUser(who[0].getUser());
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return userBaseInfo;
    }

    public NetBaseInfo getNetBaseInfo() {
        Sigar sigar = new Sigar();
        NetBaseInfo netBaseInfo=new NetBaseInfo();
        try {
            String ifNames[] = sigar.getNetInterfaceList();
            String name = ifNames[0];
            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
            netBaseInfo.setName(name);
            netBaseInfo.setAddress(ifconfig.getAddress());
            netBaseInfo.setMask(ifconfig.getNetmask());
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return netBaseInfo;
    }

    public YitaiNetBaseInfo getYiTaiNetBaseInfo() {
        Sigar sigar = new Sigar();
        YitaiNetBaseInfo yitaiNetBaseInfo=new YitaiNetBaseInfo();
        try {
            String[] ifaces = sigar.getNetInterfaceList();
            NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[0]);
            if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress())
                    || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
                    || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
                return yitaiNetBaseInfo;
            }else {
                yitaiNetBaseInfo.setAddress(cfg.getAddress());
                yitaiNetBaseInfo.setBroadCast(cfg.getBroadcast());
                yitaiNetBaseInfo.setDesc(cfg.getDescription());
                yitaiNetBaseInfo.setHwAddress(cfg.getHwaddr());
                yitaiNetBaseInfo.setMask(cfg.getNetmask());
                yitaiNetBaseInfo.setType(cfg.getType());

            }
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return yitaiNetBaseInfo;
    }

    public List<FileSystemBaseInfo> getFileSystemBaseInfo() {
        Sigar sigar = new Sigar();
        List<FileSystemBaseInfo> list=new ArrayList<>();
        try {
            FileSystem fslist[] = sigar.getFileSystemList();
            for (FileSystem fileSystem:fslist) {
                FileSystemBaseInfo fileSystemBaseInfo=new FileSystemBaseInfo();
                fileSystemBaseInfo.setDevName(fileSystem.getDevName());
                fileSystemBaseInfo.setDirName(fileSystem.getDirName());
                fileSystemBaseInfo.setFlags(fileSystem.getFlags()+"");
                fileSystemBaseInfo.setType(fileSystem.getType()+"");
                fileSystemBaseInfo.setSysTypeName(fileSystem.getSysTypeName());
                switch (fileSystem.getType()){
                    case 2:
                        fileSystemBaseInfo.setTypeName("本地文件");
                        break;
                    case 3:
                        fileSystemBaseInfo.setTypeName("网络文件");
                        break;
                    case 4:
                        fileSystemBaseInfo.setTypeName("闪存");
                        break;
                    case 5:
                        fileSystemBaseInfo.setTypeName("光驱");
                        break;
                    case 6:
                        fileSystemBaseInfo.setTypeName("页面交换");
                        break;
                    default:
                        break;
                }
                list.add(fileSystemBaseInfo);
            }
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<FileSysInfo> getFileSysInfo() {
        SystemInfo si = new SystemInfo();
        oshi.software.os.OperatingSystem os = si.getOperatingSystem();
        List<FileSysInfo> list=new ArrayList<>();
        OSFileStore[] fsArray = os.getFileSystem().getFileStores();
        for (OSFileStore fs : fsArray) {
            long usable = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            FileSysInfo fileSysInfo=new FileSysInfo();
            fileSysInfo.setName(fs.getName());
            fileSysInfo.setDesc(fs.getDescription().isEmpty() ? "file system" : fs.getDescription());
            fileSysInfo.setType(fs.getType());
            fileSysInfo.setUsable(FormatUtil.formatBytes(usable));
            fileSysInfo.setTotalSpace(FormatUtil.formatBytes(fs.getTotalSpace()));
            double percent=100d * usable / total;
            BigDecimal a = BigDecimal.valueOf(percent);
            BigDecimal b =a.setScale(2, RoundingMode.HALF_UP);//保留两位小数
            fileSysInfo.setUsedPercent(b);
            list.add(fileSysInfo);
        }
        return list;
    }
}
