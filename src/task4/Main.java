package task4;

import com.sun.org.apache.xpath.internal.SourceTree;
import criterion.RivnCriterion;
import task4.LewisPayneRandomizer;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

/**
 * Created by alexander on 19.03.16.
 */
public class Main {
    public static void main (String[] args) {
        System.out.println("Task #3. Lewis Payne Algorithm");

        int[] initialArray = new int[] {34, 22, 55, 65, 24, 32, 53, 43, 35, 54,
                                        45, 16, 90, 71, 63, 55, 44, 89, 99, 77,
                                        35, 11, 7, 93, 101, 342, 22, 17, 19, 1,
                                        2, 4, 81, 80, 87, 9, 62, 8, 5, 12,
                                        14, 1, 5, 78, 24, 54, 28, 32, 11, 234,
                                        49, 23, 35, 45, 99};

        LewisPayneRandomizer lpr = new LewisPayneRandomizer(initialArray);
        ArrayList<Integer> elements = new ArrayList<Integer>();
        int count = 0;
        int x = 55;
        while (count < x) {
            elements.add(initialArray[count]);
            count++;
        }

        boolean play = true;

        while (count < 20) {
            int el = lpr.Next();
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

        RivnCriterion rc = new RivnCriterion();
        System.out.println("V = "  + rc.calc(elements));

    }
}
