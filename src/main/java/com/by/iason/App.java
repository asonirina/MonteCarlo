package com.by.iason;

import com.by.iason.integral.Integral;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Integral integral = new Integral();
        System.out.println(integral.doF1());
        System.out.println(integral.doF2());
    }
}
