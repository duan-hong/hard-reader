package com.asiainfo.hardreader.utils;

import com.asiainfo.hardreader.Entitys.vo.CpuUseCalResult;
import org.hyperic.sigar.CpuPerc;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author duanhong
 * @description 计算cpu使用率
 * @date 2019/11/24
 */
public class CalCpuUseValue {
    /*CPU的即时利用率的计算公式：
    CPU在t1到t2时间段总的使用时间 = ( user2+ nice2+ system2+ idle2+ iowait2+ irq2+ softirq2) - ( user1+ nice1+ system1+ idle1+ iowait1+ irq1+ softirq1)
    CPU在t1到t2时间段空闲使用时间 = (idle2 - idle1)
    CPU在t1到t2时间段即时利用率 =  1 - CPU空闲使用时间 / CPU总的使用时间*/
    public static CpuUseCalResult getCpuUseValue(CpuPerc[] cpuPercs){
        CpuUseCalResult cpuUseCalResult=new CpuUseCalResult();
        Double naN=Double.NaN;
        double user=0;
        double sys=0;
        double nice=0;
        double idle=0;
        double wait=0;
        double irq=0;
        double softIrq=0;
        double stolen=0;
        double combined=0;
        /*System.out.println(cpuPercs.length);
        System.out.println(cpuPercs.toString());*/
        for (CpuPerc cpuPerc:cpuPercs) {
            /*System.out.println("开始计算");
            System.out.println(cpuPerc.getUser());
            System.out.println(cpuPerc.getSys());
            System.out.println(cpuPerc.getNice());
            System.out.println(cpuPerc.getIdle());
            System.out.println(cpuPerc.getWait());
            System.out.println(cpuPerc.getCombined());*/
            user+=cpuPerc.getUser()*100.0D;
            sys+=cpuPerc.getSys()*100.0D;
            nice+=cpuPerc.getNice()*100.0D;
            idle+=cpuPerc.getIdle()*100.0D;
            wait+=cpuPerc.getWait()*100.0D;
            irq+=cpuPerc.getIrq()*100.0D;
            softIrq+=cpuPerc.getSoftIrq()*100.0D;
            stolen+=cpuPerc.getStolen()*100.0D;
            combined+=cpuPerc.getCombined()*100.0D;
        }
        double len=cpuPercs.length;
        if (len>0){
            /*System.out.println(user);
            System.out.println(sys);
            System.out.println(nice);
            System.out.println(idle);
            System.out.println(wait);
            System.out.println(combined);*/
            BigDecimal userBig;
            BigDecimal sysBig;
            BigDecimal niceBig;
            BigDecimal idleBig;
            BigDecimal waitBig;
            BigDecimal combinedBig;
            if (!naN.equals(user)){
                userBig = new BigDecimal(user/len);
            }else {
                userBig = new BigDecimal(0);
            }

            if (!naN.equals(sys)){
                sysBig= new BigDecimal(sys/len);
            }else {
                sysBig= new BigDecimal(0);
            }

            if (!naN.equals(nice)){
                niceBig= new BigDecimal(nice/len);
            }else {
                niceBig= new BigDecimal(0);
            }

            if (!naN.equals(idle)){
                idleBig = new BigDecimal(idle/len);
            }else {
                idleBig = new BigDecimal(0);
            }

            if (!naN.equals(wait)){
                 waitBig= new BigDecimal(wait/len);
            }else {
                waitBig= new BigDecimal(0);
            }

            if (!naN.equals(combined)){
                 combinedBig= new BigDecimal(combined/len);
            }else {
                combinedBig= new BigDecimal(0);
            }
            double  userVal= userBig.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            double  sysVal= sysBig.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            double  niceVal= niceBig.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            double  idleVal= idleBig.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            double  waitVal= waitBig.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            double  combinedVal= combinedBig.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            cpuUseCalResult.setUserValue(userVal);
            cpuUseCalResult.setSysValue(sysVal);
            cpuUseCalResult.setCurrentErrorValue(niceVal);
            cpuUseCalResult.setCurrentFreeValue(idleVal);
            cpuUseCalResult.setCurrentWaitValue(waitVal);
            cpuUseCalResult.setTotalValue(combinedVal);
        }
        return cpuUseCalResult;
    }
}
