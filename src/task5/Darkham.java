package task5;

import task1.MauchliRandomizer;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexander on 29.03.16.
 */
public class Darkham {

    Integer a[];
    int length = 0;
    int x;
    int module = 104729;
    MauchliRandomizer mr;

    public Darkham(int length) {
        this.length = length;
        a = new Integer[length];
        mr = new MauchliRandomizer(new int[] {2231, 5133, 3522, 223, 4242, 424});
        for (int i = 0; i < length; i++) {
            a[i] = mr.Next();
        }
        x = mr.Next();
    }

    public void showArray() {
        for (int i = 0; i < length; i++) {
            System.out.println(a[i]);
        }
    }

    public void shuffle() {
        int j;
        for (int i = 0; i < 1000000; i++) {
           j = Math.abs(length * x/module);
           x = a[j];
           a[j] = mr.Next();
        }
    }

    public ArrayList<Integer> getArray() {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(a));
        return array;
    }

    public int getModule() {
        return module;
    }
}
