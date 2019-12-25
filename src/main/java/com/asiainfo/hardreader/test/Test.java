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
        String str="232321";
        String sss[]=str.split(",");
        System.out.println(sss.length);
        System.out.println(sss[0]);
    }
}
