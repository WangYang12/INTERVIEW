package com.wy.interview;

/**
 * @Author WangYang
 * @Description: ip地址与int的转换
 * @Date Created in 9:29 2019/3/15
 */
public class Ip2Int {
    public static void main(String[] args) {
        System.out.println(ipString("255.255.255.255"));
        System.out.println(Integer.toBinaryString(ipString("255.255.255.255")));
        System.out.println(ipInt(ipString("255.255.255.255")));
    }

    public static int ipString(String ipString){
        String[] ipstrs = ipString.split("\\.");
        int retval = 0;
        for(int i=0;i<ipstrs.length;i++){
            int temp = Integer.parseInt(ipstrs[i])<<8*i;
            retval = retval|temp;
        }
        return retval;
    }

    public static String ipInt(int ip){
        String[] retval = new String[4];
        for(int i=0;i<4;i++){
            int pos = 8*i;
            int temp = ip&(255<<pos);
            retval[i] = String.valueOf(temp>>>8*i);
        }
        return String.join(".",retval);
    }
}
