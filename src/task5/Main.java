package task5;

import criterion.ConflictCriterion;
import criterion.RivnCriterion;

/**
 * Created by alexander on 29.03.16.
 */
public class Main {
    public static  void main (String[] str) {
        int elements_count =  32768;
        Darkham d = new Darkham(elements_count);
        d.shuffle();
//        RivnCriterion rc = new RivnCriterion();
//        System.out.println("V = " + rc.calc(d.getArray()));

        System.out.println("Darkham");
        ConflictCriterion cc = new ConflictCriterion();
        System.out.println((int)Math.log10(elements_count));
        System.out.println("vector length: "  + (int)Math.log10(elements_count));
        cc.calc(d.getArray(), d.getModule(), 17);
    }
}
