package com.asiainfo.hardreader.utils;

/**
 * @author duanhong
 * @description 字节处理
 * @date 2019/11/23
 */
public class Bytes {
    public static String substring(String src, int start_idx, int end_idx){
        byte[] b = src.getBytes();
        String tgt = "";
        for(int i=start_idx; i<=end_idx; i++){
            tgt +=(char)b[i];
        }
        return tgt;
    }
}
