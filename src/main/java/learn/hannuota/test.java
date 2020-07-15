package learn.hannuota;

import java.util.Date;

/**
 * Created by 13577 on 2019/3/8.
 */
public class test {
    public static void main(String[] args) throws Exception{
        Date begin = new Date();
        Thread.sleep(1800000);
        Date end = new Date();
        System.out.print((end.getTime()-begin.getTime())/1000);
    }
}
