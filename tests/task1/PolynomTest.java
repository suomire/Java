package task1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public final class PolynomTest {

    @Test
    public void polynomValue() {
        ArrayList<Integer> list_k = new ArrayList<>();
        list_k.add(0);
        list_k.add(4);
        list_k.add(6);
        list_k.add(8);
        Polynom poly = new Polynom(list_k);
        assertEquals(0, poly.polynomValue(0));
        assertEquals(-48, poly.polynomValue(-2));
        assertEquals(18, poly.polynomValue(1));
        assertEquals(447792, poly.polynomValue(38));
    }

    @Test
    public void plus() {
        ArrayList<Integer> list_k = new ArrayList<>();
        ArrayList<Integer> plusList = new ArrayList<>();
        ArrayList<Integer> plusList1 = new ArrayList<>();
        ArrayList<Integer> plusList2 = new ArrayList<>();
        ArrayList<Integer> plusList3 = new ArrayList<>();

        ArrayList<Integer> plusRes1 = new ArrayList<>();
        ArrayList<Integer> plusRes2 = new ArrayList<>();
        ArrayList<Integer> plusRes3 = new ArrayList<>();

        int[] indexes = {-8, 1, -6, 3, 7};
        int[] plusArray = {0, 0, 0, 0, 0};
        int[] plusArray1 = {1, 1, 1, 1, 1};
        int[] plusArray2 = {-8, -1, -23, -89, -9};
        int[] plusArray3 = {11, 134, 573, 30, 990};

        int[] plusArrayRes1 = {-7, 2, -5, 4, 8};
        int[] plusArrayRes2 = {-16, 0, -29, -86, -2};
        int[] plusArrayRes3 = {3, 135, 567, 33, 997};

        for (int ind : indexes) list_k.add(ind);
        for (int k : plusArray) plusList.add(k);
        for (int k : plusArray1) plusList1.add(k);
        for (int k : plusArray2) plusList2.add(k);
        for (int k : plusArray3) plusList3.add(k);

        for (int k : plusArrayRes1) plusRes1.add(k);
        for (int k : plusArrayRes2) plusRes2.add(k);
        for (int k : plusArrayRes3) plusRes3.add(k);

        Polynom poly = new Polynom(list_k);

        assertEquals(list_k, poly.plus(plusList));
        assertEquals(plusRes1, poly.plus(plusList1));
        assertEquals(plusRes2, poly.plus(plusList2));
        assertEquals(plusRes3, poly.plus(plusList3));
    }

    @Test
    public void minus() {
        ArrayList<Integer> list_k = new ArrayList<>();
        ArrayList<Integer> plusList = new ArrayList<>();
        ArrayList<Integer> plusList1 = new ArrayList<>();
        ArrayList<Integer> plusList2 = new ArrayList<>();
        ArrayList<Integer> plusList3 = new ArrayList<>();

        ArrayList<Integer> plusRes1 = new ArrayList<>();
        ArrayList<Integer> plusRes2 = new ArrayList<>();
        ArrayList<Integer> plusRes3 = new ArrayList<>();

        int[] indexes = {-8, 1, -6, 3, 7};
        int[] plusArray = {0, 0, 0, 0, 0};
        int[] plusArray1 = {1, 1, 1, 1, 1};
        int[] plusArray2 = {-8, -1, -23, -89, -9};
        int[] plusArray3 = {11, 134, 573, 30, 990};

        int[] plusArrayRes1 = {-9, 0, -7, 2, 6};
        int[] plusArrayRes2 = {0, 2, 17, 92, 16};
        int[] plusArrayRes3 = {-19, -133, -579, -27, -983};

        for (int ind : indexes) list_k.add(ind);
        for (int k : plusArray) plusList.add(k);
        for (int k : plusArray1) plusList1.add(k);
        for (int k : plusArray2) plusList2.add(k);
        for (int k : plusArray3) plusList3.add(k);

        for (int k : plusArrayRes1) plusRes1.add(k);
        for (int k : plusArrayRes2) plusRes2.add(k);
        for (int k : plusArrayRes3) plusRes3.add(k);

        Polynom poly = new Polynom(list_k);

        assertEquals(list_k, poly.minus(plusList));
        assertEquals(plusRes1, poly.minus(plusList1));
        assertEquals(plusRes2, poly.minus(plusList2));
        assertEquals(plusRes3, poly.minus(plusList3));
    }

    @Test
    public void multiplication() {
        ArrayList<Integer> list_k = new ArrayList<>();
        ArrayList<Integer> plusList = new ArrayList<>();
        ArrayList<Integer> plusList1 = new ArrayList<>();
        ArrayList<Integer> plusList2 = new ArrayList<>();
        ArrayList<Integer> plusList3 = new ArrayList<>();
        ArrayList<Integer> plusList4 = new ArrayList<>();
        ArrayList<Integer> plusList5 = new ArrayList<>();

        ArrayList<Integer> plusRes = new ArrayList<>();
        ArrayList<Integer> plusRes1 = new ArrayList<>();
        ArrayList<Integer> plusRes2 = new ArrayList<>();
        ArrayList<Integer> plusRes3 = new ArrayList<>();
        ArrayList<Integer> plusRes4 = new ArrayList<>();
        ArrayList<Integer> plusRes5 = new ArrayList<>();

        int[] indexes = {-8, 1, -6, 3, 7};
        int[] plusArray = {0, 0, 0, 0, 0};
        int[] plusArray1 = {1, 1, 1, 1, 1};
        int[] plusArray2 = {-2, -1, -3, -5, -6};
        int[] plusArray3 = {2, 4, 9, 11, 9};
        int[] plusArray4 = {1, 2, 1};
        int[] plusArray5 = {-3, 1, 0};

        int[] plusArrayRes = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] plusArrayRes1 = {-8, -7, -13, -10, -3, 5, 4, 10, 7};
        int[] plusArrayRes2 = {16, 6, 35, 37, 44, 8, 0, -53, -42};
        int[] plusArrayRes3 = {-16, -30, -80, -97, -89, -2, 42, 104, 63};
        int[] plusArrayRes4 = {-8, -15, -12, -8, 7, 17, 7};
        int[] plusArrayRes5 = {24, -11, 19, -15, -18, 7, 0};

        for (int ind : indexes) list_k.add(ind);
        for (int k : plusArray) plusList.add(k);
        for (int k : plusArray1) plusList1.add(k);
        for (int k : plusArray2) plusList2.add(k);
        for (int k : plusArray3) plusList3.add(k);
        for (int k : plusArray4) plusList4.add(k);
        for (int k : plusArray5) plusList5.add(k);

        for (int k : plusArrayRes) plusRes.add(k);
        for (int k : plusArrayRes1) plusRes1.add(k);
        for (int k : plusArrayRes2) plusRes2.add(k);
        for (int k : plusArrayRes3) plusRes3.add(k);
        for (int k : plusArrayRes4) plusRes4.add(k);
        for (int k : plusArrayRes5) plusRes5.add(k);

        Polynom poly = new Polynom(list_k);

        assertEquals(plusRes, poly.multiplication(plusList));
        assertEquals(plusRes1, poly.multiplication(plusList1));
        assertEquals(plusRes2, poly.multiplication(plusList2));
        assertEquals(plusRes3, poly.multiplication(plusList3));
        assertEquals(plusRes4, poly.multiplication(plusList4));
        assertEquals(plusRes5, poly.multiplication(plusList5));
    }

    @Test
    public void division() {
        ArrayList<Integer> list_k = new ArrayList<>();
        ArrayList<Integer> plusList1 = new ArrayList<>();
        ArrayList<Integer> plusList2 = new ArrayList<>();
        ArrayList<Integer> plusList3 = new ArrayList<>();
        ArrayList<Integer> plusList4 = new ArrayList<>();
        ArrayList<Integer> plusList5 = new ArrayList<>();

        ArrayList<Integer> plusRes1 = new ArrayList<>();
        ArrayList<Integer> plusRes2 = new ArrayList<>();
        ArrayList<Integer> plusRes3 = new ArrayList<>();
        ArrayList<Integer> plusRes4 = new ArrayList<>();
        ArrayList<Integer> plusRes5 = new ArrayList<>();

        int[] indexes = {-8, 1, -6, 3, 7};
        int[] plusArray1 = {1, 1, 1, 1, 1};
        int[] plusArray2 = {-3, -5, -1};
        int[] plusArray3 = {1, 1};
        int[] plusArray4 = {1, 2, 1};
        int[] plusArray5 = {-3, 1};

        int[] plusArrayRes1 = {7};
        int[] plusArrayRes2 = {-133, 32, -7};
        int[] plusArrayRes3 = {3, -2, -4, 7};
        int[] plusArrayRes4 = {9, -11, 7};
        int[] plusArrayRes5 = {199, 66, 24, 7};

        for (int ind : indexes) list_k.add(ind);
        for (int k : plusArray1) plusList1.add(k);
        for (int k : plusArray2) plusList2.add(k);
        for (int k : plusArray3) plusList3.add(k);
        for (int k : plusArray4) plusList4.add(k);
        for (int k : plusArray5) plusList5.add(k);

        for (int k : plusArrayRes1) plusRes1.add(k);
        for (int k : plusArrayRes2) plusRes2.add(k);
        for (int k : plusArrayRes3) plusRes3.add(k);
        for (int k : plusArrayRes4) plusRes4.add(k);
        for (int k : plusArrayRes5) plusRes5.add(k);

        Polynom poly = new Polynom(list_k);

        assertEquals(plusRes1, poly.division(plusList1));
        assertEquals(plusRes2, poly.division(plusList2));
        assertEquals(plusRes3, poly.division(plusList3));
        assertEquals(plusRes4, poly.division(plusList4));
        assertEquals(plusRes5, poly.division(plusList5));

    }

    @Test
    public void equals() {
    }
}