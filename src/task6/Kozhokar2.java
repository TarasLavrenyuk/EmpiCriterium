package task6;

/**
 * Created by alexander on 29.03.16.
 */

public class Kozhokar2 {
    int m;
    int seed = 19;
    int x_prev;
    int c = 28;
    int a = 120;

    public Kozhokar2 (int module) {
        this.m = module;
        x_prev = seed;
    }


    private int Middle(long number) {
        String str = String.valueOf(number);
        int left = (str.length()-str.length()/2)/2;
        return Integer.parseInt(str.substring(left, left + str.length()/2));
    }

    public int next() {
        double result;
        result = (x_prev * a ^ c) % m;
        x_prev = (int) result;
        return  (int) result;
    }
}