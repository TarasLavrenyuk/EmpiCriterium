package criterion;

import java.util.ArrayList;

/**
 * Created by alexander on 15.05.16.
 */
public class ChiSquare {
    private ArrayList<Integer> observed;
    private ArrayList<Double> probability;
    private int number;
    private int kvalue;

    public ChiSquare (ArrayList<Integer> obs,
                      ArrayList<Double> prob,
                      int n, int k) {
        this.observed = obs;
        this.probability = prob;
        this.number = n;
        this.kvalue = k;
    }

    public double calc() {
        double sum = 0;
        for (int i = 0; i < kvalue; i++) {
            sum += observed.get(i) * observed.get(i) * 1.0 / probability.get(i);
        }
        return 1.0/number * sum - number;
    }
}
