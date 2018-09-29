package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.pow;

public class Polynom {

    private ArrayList<Integer> listArray = new ArrayList<>();

    Polynom() {
        this.listArray.add(0);
    }

    Polynom(ArrayList<Integer> list) {
        this.listArray = list;
    }

    public List<Integer> getListArray() {
        return listArray;
    }

    public int polynomValue(int x) {
        int polVal = 0;
        for (int i = 0; i < this.listArray.size(); i++) {
            polVal += pow(x, i) * this.listArray.get(i);
        }
        return polVal;
    }

    public ArrayList<Integer> plus(ArrayList<Integer> plusList) {
        ArrayList<Integer> plusResult = new ArrayList<>();
        try {
            if (this.listArray.size() != plusList.size()) throw new IllegalArgumentException("");

            for (int i = 0; i < this.listArray.size(); i++)
                plusResult.add(this.listArray.get(i) + plusList.get(i));
        } catch (IllegalArgumentException e) {
            System.out.println("addition cannot be done");
        }
        return plusResult;
    }

    public ArrayList<Integer> minus(ArrayList<Integer> plusList) {
        ArrayList<Integer> plusResult = new ArrayList<>();
        for (int i = 0; i < this.listArray.size(); i++)
            plusResult.add(this.listArray.get(i) - plusList.get(i));
        return plusResult;
    }

    public ArrayList<Integer> multiplication(ArrayList<Integer> plusList) {
        ArrayList<Integer> plusResult = new ArrayList<>();

        for (int i = 0; i < (plusList.size() + this.listArray.size() - 1); i++)
            plusResult.add(i, 0);
        for (int i = 0; i < this.listArray.size(); i++)
            for (int j = 0; j < plusList.size(); j++)
                plusResult.set(i + j, plusResult.get(i + j) + plusList.get(j) * this.listArray.get(i));

        return plusResult;
    }

    public ArrayList<Integer> division(ArrayList<Integer> dList) {

        ArrayList<Integer> dResult = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        try {
            if (this.listArray.size() < dList.size() || dList.size() == 1)
                throw new IllegalArgumentException("");

            for (int i = 0; i < (this.listArray.size() - dList.size() + 1); i++) {
                dResult.add(i, 0);
            }
            for (int i = 0; i < dList.size(); i++) {
                tempList.add(i, 0);
            }
            int addIndex;
            int elemValue;


            //цикл по делимому
            for (int i = (this.listArray.size() - 1); i >= 0; i--) {
                if (i - dList.size() + 1 >= 0) {
                    // цикл для определения области деления, размерность области равна размерности делителя
                    if (i == this.listArray.size() - 1) {
                        //задаю вспомогательный лист для нахождения остатка от деления
                        int j = tempList.size() - 1;
                        while (j >= 0) {
                            for (int k = i; k > i - tempList.size(); k--) {
                                tempList.set(j, this.listArray.get(k));
                                j--;
                            }
                        }
                    }

                    addIndex = i - dList.size() + 1;
                    elemValue = tempList.get(tempList.size() - 1) / dList.get(dList.size() - 1);
                    dResult.set(addIndex, elemValue);
                    // переопределение области деления, вычитание + сдвиг
                    for (int j = 0; j < dList.size(); j++) {
                        tempList.set(j, tempList.get(j) - dResult.get(addIndex) * dList.get(j));
                        if (tempList.get(j) == 0 && (i - tempList.size() >= 0)) {
                            tempList.set(j, null);
                            tempList.add(0, this.listArray.get(i - tempList.size()));
                        }
                    }
                    tempList.removeAll(Collections.singleton(null));
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("HUI");
        }
        return dResult;
    }

    public ArrayList remaindedD(ArrayList<Integer> dList) {
        ArrayList<Integer> listResult;
        ArrayList<Integer> tempList;

        Polynom temp1 = new Polynom(this.listArray);
        Polynom temp2 = new Polynom(dList);
        tempList = temp1.division(dList);
        listResult = temp1.minus(temp2.multiplication(tempList));
        listResult.removeAll(Collections.singleton(null));

        return listResult;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Polynom) {
            Polynom other = (Polynom) obj;
            return listArray.equals(other.listArray);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return listArray.hashCode() * 2 + 12;
    }

    @Override
    public String toString() {
        return this.listArray.toString();
    }
}
