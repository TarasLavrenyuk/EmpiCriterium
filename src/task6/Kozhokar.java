package task6;

import task1.MauchliRandomizer;

/**
 * Created by alexander on 29.03.16.
 */

public class Kozhokar {
    int x_prev;
    int module = 104729;
    private MauchliRandomizer mr;
    public Kozhokar () {
        mr = new MauchliRandomizer(new int[] {223114, 5131413, 3524232, 22423, 43242, 31424});
        x_prev = mr.Next();
    }

    public int next() {
        int result;
        result = Math.abs((x_prev + mr.Next())%module);
        x_prev = result;
        return  result;
    }

    public int getModule() {
        return module;
    }
}


