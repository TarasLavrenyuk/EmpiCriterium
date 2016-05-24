package task2;

import criterion.ConflictCriterion;
import criterion.RivnCriterion;

import java.util.ArrayList;

/**
 * Created by alexander on 15.03.16.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Task #2");

        ArrayList<Integer> elements = new ArrayList<>();
        ArrayList<Integer> parA = new ArrayList<>();
        ArrayList<Integer> parC = new ArrayList<>();

        int c = 571; //приріст 571
        int m = 104729; //модуль 104729
        int a = 29; //множник 29
        int seed = 0;
        int current = seed;
        int count = 0;

        int x = 4;
        int y = 3;

        int elements_cout = 32768;

        while (count < elements_cout) {
            elements.add(current);
            parA.add(a);
            parC.add(c);
            count++;
            if (count >= x) {
                a = ((parA.get(count - x) + parC.get(count - y))/2)%m;
                c = ((parC.get(count - x) + parA.get(count - y))/2)%m;
            }
            current = (a * current + c)%m;

            if (count > x) {
                int x_sample[] = new int[x];
                int a_sample[] = new int[x];
                int c_sample[] = new int[x];

                int cnt = 0;
                for (int i = count - x; i < count; i++) {
                    x_sample[cnt] = elements.get(i);
                    a_sample[cnt] = parA.get(i);
                    c_sample[cnt] = parC.get(i);
                    cnt++;
                }

                for (int i = 0; i < count - x; i++) {
                    int _cnt = 0;
                    for (int j = i; j < i + x; j++) {
                        if ((x_sample[_cnt] == elements.get(j)) && (a_sample[_cnt] == parA.get(j)) && (c_sample[_cnt] == parC.get(j))) {
                            ++_cnt;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

//        RivnCriterion r = new RivnCriterion();
//        System.out.println("\nV = " + r.calc(elements));

        ConflictCriterion cc = new ConflictCriterion();
        System.out.println((int)Math.log10(elements_cout));
        System.out.println("vector length: "  + (int)Math.log10(elements_cout));
        cc.calc(elements, m, 17);
    }
}
