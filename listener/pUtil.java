package com.company;

public class pUtil{

    protected static void Print( Object ... Values ){
        String toPrint = "";
        for ( Object CurrentObject : Values ){
            toPrint += CurrentObject.toString() + "\t";
        }
        System.out.println( toPrint );
    }

    protected static int Clamp( int n, int min, int max ){
        return Math.max( Math.min( max, n ), min );
    }

    protected static float CurTime(){
        return ( float ) System.nanoTime() / 1000000000;
    }
}
