package criterion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexander on 15.05.16.
 */
public class RivnCriterion {
    public RivnCriterion() {

    }

    public ArrayList<Integer> getObservedArray(ArrayList<Integer> array, int m) {
        Integer[] tmp = new Integer[m];
        for (int i = 0; i < tmp.length;i++) {
            tmp[i] = 0;
        }
        System.out.println();
        for (Integer i : array) {
            tmp[i]++;
        }
        return  new ArrayList<Integer>(Arrays.asList(tmp));
    }

    public double calc(ArrayList<Integer> array) {
        double answer = 0;
        int m = 13;
        ArrayList<Double> probability = new ArrayList<Double>();
        for (int i = 0; i < array.size(); i++) {
            array.set(i,array.get(i) % m);
        }
        ArrayList<Integer> observed = getObservedArray(array, m);
        int d = m - 1;
        System.out.println("\nv = " + d);
        for (int i = 0; i < m; i++) {
            probability.add(1.0/m);
        }
        ChiSquare ch = new ChiSquare(observed, probability, array.size(), m);
        answer = ch.calc();
        return answer;
    }
}
