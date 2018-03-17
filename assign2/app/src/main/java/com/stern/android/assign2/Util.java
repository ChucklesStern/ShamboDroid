package com.stern.android.assign2;

import java.util.Random;

/**
 * Created by adamstern on 2/28/18.
 *
 * /*
 Adam C Stern
 adamstern@my.smccd.edu
 CIS135POL
 Util.java
 Util file that holds my Computer roll calculation method as a case switch statement called AIDecides
 Assignment#2
 28 February 2018

 */


public class Util {

    public static final Integer PAPER_ID = 1;
    public static final Integer ROCK_ID = 2;
    public static final Integer SCISSOR_ID = 3;

    public static Integer AIDecides() {
        int AIDecides = 1;
        Integer roshambo;
        Random rng = new Random();
        roshambo = rng.nextInt(3) + 1;

        switch (roshambo) {
            case 1:
                AIDecides = PAPER_ID;
                break;

            case 2:
                AIDecides = ROCK_ID;
                break;

            case 3:
                AIDecides = SCISSOR_ID;
                break;
        }
        return AIDecides;
    }

}
