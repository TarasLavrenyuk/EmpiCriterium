package task1;

import java.util.ArrayList;

/**
 * Created by alexander on 19.03.16.
 */

public class MauchliRandomizer {
    int m = 7; //максимальна довжина згенерованого числа послідовності

    int module = 104729;

    int[] elements;

    ArrayList<Integer> arr = new ArrayList<Integer>();

    public MauchliRandomizer(int[] elements) {
        this.elements = elements;
    }

    private int Middle(long number) {
        String str = String.valueOf(number);

        if (str.length() <= m) {
            return  (int) number;
        }

        int left = (str.length()-m)/2;
        return Integer.parseInt(str.substring(left, left + m));
    }

    //Метод зсуву масиву. Необхідний для правильної роботи з масивом

    public void shiftLeft() {
        for (int i = 0; i < 5; i++) {
            elements[i] = elements[i+1];
        }
    }

    public int Next() {
        int next = Middle(elements[0] * elements[5])%module;
        if (next < 0) {
            next *= -1;
        }
        shiftLeft();
        elements[5] = next;
        return  next;
    }

    public int getModule() {
        return module;
    }

}
