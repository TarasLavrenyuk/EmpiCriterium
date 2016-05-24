package task3;

/**
 * Created by alexander on 19.03.16.
 */

public class MitchelMooreRandomizer {
    int[] elements;

    int module = 104729;

    public MitchelMooreRandomizer(int[] elements) {
        this.elements = elements;
    }

    public void shiftLeft() {
        for (int i = 0; i < 54; i++) {
            elements[i] = elements[i+1];
        }
    }

    public int Next() {
        int next = (elements[31] + elements[0])%module; // еквівалентно формулі x = (x[n-24] + x[n - 55])mod m
        if (next < 0) {
            next*=-1;
        }
        shiftLeft();
        elements[54] = next;
        return  next;
    }

    public int getModule() {
        return module;
    }
}
