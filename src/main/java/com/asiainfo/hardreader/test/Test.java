package com.asiainfo.hardreader.test;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

/**
 * @author duanhong
 * @description sdd
 * @date 2019/11/24
 */
public class Test {
    public static void main(String[] args) {
        try {

//            cpu();


            // 内存信息
            memory();


            // 操作系统信息
//            os();


            // 用户信息
//            who();


            // 文件系统信息
//            file();


            // 网络信息
//            net();
            // 以太网信息
//            ethernet();

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    private static void memory() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        // 内存总量
//        log.info("内存总量:    " + mem.getTotal() / 1024L + "K av");
        // 当前内存使用量
//        log.info("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
        // 当前内存剩余量
//        log.info("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
        Swap swap = sigar.getSwap();
        // 交换区总量
//        log.info("交换区总量:    " + swap.getTotal() / 1024L + "K av");
        // 当前交换区使用量
//        log.info("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
        // 当前交换区剩余量
//        log.info("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
    }
}
