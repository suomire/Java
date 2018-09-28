package task1;

import static java.lang.Math.pow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> new_list = new ArrayList<>();
        ArrayList<Integer> test_arrayList = new ArrayList<>();
        ArrayList<Integer> a;
        int[] indexes = {-8, 1, -6, 3, 7};
        int[] testV = {-3, -5, -1};
        for (int indexe : indexes) new_list.add(indexe);
        for (int indexe : testV) test_arrayList.add(indexe);
        Polynom testP = new Polynom(new_list);
        a = testP.division(test_arrayList);
        System.out.println(a);
    }
}
