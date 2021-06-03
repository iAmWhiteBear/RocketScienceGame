package math;

import java.util.Random;

public class Rnd {



    public static float nextFloat(float min, float max){
        return (float) Math.random()*(max-min)+min;
    }
}
