package task1;

import criterion.ConflictCriterion;
import criterion.RivnCriterion;

import java.util.ArrayList;

/**
 * Created by alexander on 19.03.16.
 */

public class Main {
    public static  void main (String[] args) {
        System.out.println("Task #1. John Mauchli Algorithm");
        int[] arr = new int[] {231, 5232, 3524, 2411, 4310, 2524};
        MauchliRandomizer mr = new MauchliRandomizer(arr);
        ArrayList<Integer> elements = new ArrayList<Integer>();
        int count = 0;
        int x = 6;

        for(int i = 0; i < arr.length; i++) {
            elements.add(arr[i]);
            ++count;
        }

        boolean play = true;

        int elements_cout =  32768;

        while (count < elements_cout) {
            int el = mr.Next();
            elements.add(el);
            ++count;
            if (count > x) {
                int x_sample[] = new int[x];
                int cnt = 0;
                for (int i = count - x; i < count; i++) {
                    x_sample[cnt] = elements.get(i);
                    cnt++;
                }
                for (int i = 0; i < count - x; i++) {
                    int _cnt = 0;
                    for (int j = i; j < i + x; j++) {
                        if ((x_sample[_cnt] == elements.get(j))) {
                            ++_cnt;
                        } else {
                            break;
                        }
                    }
                    if (_cnt == x) {
                        play = false;
                        System.out.println("PERIOD: " + count);
                        break;
                    }
                }
            }
        }

//        RivnCriterion rc = new RivnCriterion();
//        System.out.println("\nV = " + rc.calc(elements));
//

        ConflictCriterion cc = new ConflictCriterion();
        System.out.println((int)Math.log10(elements_cout));
        System.out.println("vector length: "  + (int)Math.log10(elements_cout));
        cc.calc(elements, mr.getModule() , 17);
    }
}
