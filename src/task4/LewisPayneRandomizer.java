package task4;

/**
 * Created by alexander on 19.03.16.
 */

public class LewisPayneRandomizer {
    int[] elements;

    public LewisPayneRandomizer(int[] elements) {
        this.elements = elements;
    }

    public void shiftLeft() {
        for (int i = 0; i < 54; i++) {
            elements[i] = elements[i+1];
        }
    }

    public int Next() {
        int next = (elements[31] ^ elements[0])%121; // еквівалентно формулі x = (x[n-24] ^ x[n - 55])mod m, m - парне
        shiftLeft();
        elements[54] = next;
        return  next;
    }
}
