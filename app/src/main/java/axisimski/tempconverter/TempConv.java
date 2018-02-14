package axisimski.tempconverter;

/**
 * Created by Alex on 2/1/2018.
 */

public class TempConv {

    public static long c2f(long cdegrees){

        double deg=  (cdegrees*1.8)+32;
        long r = (long) Math.round(deg);
        return  r;
    }

    public static long f2c(long fdegrees){

        double deg=(fdegrees-32)/1.8;

        long r = (long) Math.round(deg);
        return  r;
    }
}
