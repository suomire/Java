package task1;

import org.junit.Test;

import java.util.ArrayList;

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
    public void addition() {
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
        Polynom polyPlus = new Polynom(plusList);
        Polynom polyPlus1 = new Polynom(plusList1);
        Polynom polyPlus2= new Polynom(plusList2);
        Polynom polyPlus3 = new Polynom(plusList3);

        assertEquals(list_k, poly.addition(polyPlus).getListArray());
        assertEquals(plusRes1, poly.addition(polyPlus1).getListArray());
        assertEquals(plusRes2, poly.addition(polyPlus2).getListArray());
        assertEquals(plusRes3, poly.addition(polyPlus3).getListArray());
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
        Polynom polyPlus = new Polynom(plusList);
        Polynom polyPlus1 = new Polynom(plusList1);
        Polynom polyPlus2= new Polynom(plusList2);
        Polynom polyPlus3 = new Polynom(plusList3);


        assertEquals(list_k, poly.substraction(polyPlus).getListArray());
        assertEquals(plusRes1, poly.substraction(polyPlus1).getListArray());
        assertEquals(plusRes2, poly.substraction(polyPlus2).getListArray());
        assertEquals(plusRes3, poly.substraction(polyPlus3).getListArray());
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
        Polynom polyPlus = new Polynom(plusList);
        Polynom polyPlus1 = new Polynom(plusList1);
        Polynom polyPlus2= new Polynom(plusList2);
        Polynom polyPlus3 = new Polynom(plusList3);
        Polynom polyPlus4= new Polynom(plusList4);
        Polynom polyPlus5 = new Polynom(plusList5);

        assertEquals(plusRes, poly.multiplication(polyPlus).getListArray());
        assertEquals(plusRes1, poly.multiplication(polyPlus1).getListArray());
        assertEquals(plusRes2, poly.multiplication(polyPlus2).getListArray());
        assertEquals(plusRes3, poly.multiplication(polyPlus3).getListArray());
        assertEquals(plusRes4, poly.multiplication(polyPlus4).getListArray());
        assertEquals(plusRes5, poly.multiplication(polyPlus5).getListArray());
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
        Polynom polyPlus1 = new Polynom(plusList1);
        Polynom polyPlus2= new Polynom(plusList2);
        Polynom polyPlus3 = new Polynom(plusList3);
        Polynom polyPlus4= new Polynom(plusList4);
        Polynom polyPlus5 = new Polynom(plusList5);

        assertEquals(plusRes1, poly.division(polyPlus1).getListArray());
        assertEquals(plusRes2, poly.division(polyPlus2).getListArray());
        assertEquals(plusRes3, poly.division(polyPlus3).getListArray());
        assertEquals(plusRes4, poly.division(polyPlus4).getListArray());
        assertEquals(plusRes5, poly.division(polyPlus5).getListArray());

    }

    @Test
    public void remaindedD() {
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

        int[] plusArrayRes1 = {-15, -6, -13, -4, 0};
        int[] plusArrayRes2 = {-407, -568, 0, 0, 0};
        int[] plusArrayRes3 = {-11,  0, 0, 0, 0};
        int[] plusArrayRes4 = {-17, -6, 0, 0, 0};
        int[] plusArrayRes5 = {589,  0, 0, 0, 0};

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
        Polynom polyPlus1 = new Polynom(plusList1);
        Polynom polyPlus2= new Polynom(plusList2);
        Polynom polyPlus3 = new Polynom(plusList3);
        Polynom polyPlus4= new Polynom(plusList4);
        Polynom polyPlus5 = new Polynom(plusList5);

        assertEquals(plusRes1, poly.remaindedD(polyPlus1).getListArray());
        assertEquals(plusRes2, poly.remaindedD(polyPlus2).getListArray());
        assertEquals(plusRes3, poly.remaindedD(polyPlus3).getListArray());
        assertEquals(plusRes4, poly.remaindedD(polyPlus4).getListArray());
        assertEquals(plusRes5, poly.remaindedD(polyPlus5).getListArray());


    }

    @Test
    public void equals() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        int[] listA = {-8, 1, -6, 3, 7};
        int[] listA1 = {0, 0, 0, 0, 0};
        int[] listA2 = {1, 1, 1, 1, 1};
        int[] listA3 = {-8, -1, -23, -89, -9};

        for (int ex : listA) list.add(ex);
        for (int ex : listA1) list1.add(ex);
        for (int ex : listA2) list2.add(ex);
        for (int ex : listA3) list3.add(ex);

        Polynom poly = new Polynom(list);
        Polynom poly2 = new Polynom(list);
        assertTrue(poly.equals(poly2));

        poly = new Polynom(list1);
        poly2 = new Polynom(list1);
        assertTrue(poly.equals(poly2));

        poly = new Polynom(list2);
        poly2 = new Polynom(list2);
        assertTrue(poly.equals(poly2));

        poly = new Polynom(list3);
        poly2 = new Polynom(list3);
        assertTrue(poly.equals(poly2));

        poly = new Polynom(list1);
        poly2 = new Polynom(list2);
        assertFalse(poly.equals(poly2));

        poly = new Polynom(list2);
        poly2 = new Polynom(list3);
        assertFalse(poly.equals(poly2));

        poly = new Polynom(list3);
        poly2 = new Polynom(list);
        assertFalse(poly.equals(poly2));


    }


}