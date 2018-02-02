package axisimski.tempconverter;

/**
 * Created by Alex on 2/1/2018.
 */

public class TempConv {

    public static double c2f(double cdegrees){

        return  (cdegrees*1.8)+32;
    }

    public static double f2c(double fdegrees){

        return  (fdegrees-32)/1.8;
    }
}
