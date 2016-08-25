package com.example.sony.jesquiz;

/**
 * Created by SONY on 8/13/2016.
 */
import java.util.*;
public class Rand {


    public  int rRand(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max<min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }




}
