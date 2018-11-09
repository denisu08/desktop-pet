package com.erithstudio.exercise;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class JNATest {

    public interface CLibrary extends Library {
        CLibrary clib = (CLibrary) Native.loadLibrary("msvcrt", CLibrary.class);

        void printf(String format, Object... args);
        int sprintf(byte[] speicher, String format, Object...args);
        int scanf (String format, Object... args1);
    }


    public static void main(String[] args) {
        CLibrary.clib.printf("Hello World");
        String test= "";
        args = new String[2];
        args[0]="This is a test";
        args[1]="and another one";
        for ( int i = 0; i < args.length; i++ ){
            CLibrary.clib.printf( "\nArgument %d : %s",i, args[ i ] );
        }

        CLibrary.clib.printf("\nBitte Namen eingeben");
        CLibrary.clib.scanf("%s", test);
        CLibrary.clib.printf("\nyour name is %s",test);
    }
}