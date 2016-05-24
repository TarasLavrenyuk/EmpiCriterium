package criterion;

import org.omg.PortableInterceptor.INACTIVE;
import sun.security.util.BigInt;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexander on 16.05.16.
 */
public class ConflictCriterion {
    public ConflictCriterion () {};

    public double [] getTheoreticalProbability(int n, int m) {
        double[] result = new double[n + 1];
        result[1] = 1;
        int j0 = 1;
        int j1 = 1;
        for (int i = 0; i < n - 1; i++) {
            j1 += 1;
            for (int j = j1; j >= j0; j--) {
                result[j] = (double) j / m * result[j] + ((1 + 1.0 / m) - ((double) j / m)) * result[j - 1];
                if (result[j] < (double) 1e-20) {
                    result[j] = 0;
                    if (j == j1) {
                        j1--;
                    }
                    if (j == j0) {
                        j0++;
                    }
                }
            }
        }

        double T[] = {0.01, 0.05, 0.25, 0.5, 0.75, 0.95, 0.99, 1};

        double p = 0;
        int t = 1;
        int j = j0 -1;
        double ans[] = new double[2];

        while (t != 7) {
            j += 1;
            p += result[j];
            ans[0] = n - j - 1;
            ans[1] = 1 - p;
            if (p > T[t]) {
                System.out.println(ans[0] + " " +  ans[1]);
            }
            while (p > T[t] && t < 7) {
                t++;
            }

        }

        return result;
    }

    public double getVectorElement(double element, int d) {
        return Math.floor(element * d);
    }

    public int conflicts_count(ArrayList<Integer> ar, int max) {
        int sum = 0;
        int[] conf = new int[max + 1];
        System.out.println("LENGTH " + max + " ARRAY " + conf.length);
        int cnt = 0;
        for (int el : ar) {
            conf[el]++;
        }
        for (int i = 0; i < conf.length; i++) {
            System.out.println(conf[i]);
            if (conf[i] > 0) {
                sum += conf[i] - 1;
            }
        }
        return sum;
    }

    public void calc (ArrayList<Integer> array, int module, int vector_length) {
        Double[] tmp = new Double[array.size()];
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int index = 0;
        for (Integer el : array) {
           tmp[index] = getVectorElement((double)el/module, 2);
           index++;
        }
        int j = 0;
        while(vector_length * (j + 1) <= array.size()) {
            ar.add(0);
            for (int i = j * vector_length ; i < vector_length * (j + 1) ; i++) {
                ar.set(j, new Double(ar.get(j) + tmp[i] * Math.pow(2, i - j * vector_length)).intValue());
            }
            j++;
        }
        int max = 0;
        for (int i = 0; i < vector_length; i++) {
            max += Math.pow(2, i);
        }
        getTheoreticalProbability(ar.size(), module);
        System.out.println("N: " + ar.size());
        System.out.println("Conflicts: " + conflicts_count(ar, max));
    }
}
