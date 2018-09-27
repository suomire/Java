package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.pow;

public class Polynom {

    private ArrayList<Integer> listArray;

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
        for (int i = 0; i < this.listArray.size(); i++)
            plusResult.add(this.listArray.get(i) + plusList.get(i));
        return plusResult;
    }

    public ArrayList minus(ArrayList<Integer> plusList) {
        ArrayList<Integer> plusResult = new ArrayList<>();
        for (int i = 0; i < this.listArray.size(); i++)
            plusResult.add(this.listArray.get(i) - plusList.get(i));
        return plusResult;
    }

    public ArrayList multiplication(ArrayList<Integer> plusList) {
        ArrayList<Integer> plusResult = new ArrayList<>();

        for (int i = 0; i < (plusList.size() + this.listArray.size() - 1); i++)
            plusResult.add(i, 0);
        for (int i = 0; i < this.listArray.size(); i++)
            for (int j = 0; j < plusList.size(); j++)
                plusResult.set(i + j, plusResult.get(i+j) + plusList.get(j) * this.listArray.get(i));

        return plusResult;
    }

    /*public ArrayList division(ArrayList<Integer> dList) {

        ArrayList<Integer> dResult = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();

        for (int i = 0; i < dList.size(); i++) {
            tempList.add(i, 0);
        }
        int addIndex;
        int elemValue;

        if (this.listArray.size() < dList.size()) throw new ArithmeticException("");
        //цикл по делимому
        for (int i = (this.listArray.size() - 1); i >= 0; i--) {
            // цикл для определения области деления, размерность области равна размерности делителя
            if (i == this.listArray.size() - 1) {
                for (int j = tempList.size(); j >= 0; j--) {
                    tempList.set(j, this.listArray.get(i));
                }
            }

            addIndex = i - dList.size() - 1;
            elemValue = tempList.get(i) / dList.get(dList.size() - 1);
            dResult.add(addIndex, elemValue);
            // переопределение области деления, вычитание + сдвиг
            for (int j = 0; j < dList.size(); j++) {
                tempList.set(i, tempList.get(i) - dResult.get(addIndex) * dList.get(i));
                if (tempList.get(i) == 0) tempList.set(i, null);
                tempList.add(0, this.listArray.get(j - tempList.size() - 1));
            }
            tempList.removeAll(Collections.singleton(null));
        }
        return dResult;
    }*/

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
        return String.valueOf(listArray);
    }
}
