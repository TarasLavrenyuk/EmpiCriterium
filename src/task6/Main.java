package task6;

import criterion.ConflictCriterion;
import criterion.RivnCriterion;

import java.util.ArrayList;

/**
 * Created by alexander on 19.03.16.
 */

public class Main {
    public static void main (String[] args) {
        int elements_count =  32768;
        Kozhokar rand = new Kozhokar();
        int period = 0;
        ArrayList<Integer> array = new ArrayList<>();
        boolean play = true;
        int count = 0;
        while (count < elements_count) {
            array.add(rand.next());
            ++count;
        }

        ConflictCriterion cc = new ConflictCriterion();
        System.out.println((int)Math.log10(elements_count));
        System.out.println("vector length: "  + (int)Math.log10(elements_count));
        cc.calc(array, rand.getModule(), 17);
    }
}
