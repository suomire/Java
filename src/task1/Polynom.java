package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.pow;

/**
 * Задача 1. Написать класс на языке Java, реализующий указанную ниже функциональность.
 * Написать для этого класса автоматические тесты, покрывающие весь его исходный код.
 * Написанный код держать в отдельном проекте или модуле в репозитории на GitHub.
 * <p>
 * Объект класса хранит полином вида 7x4+3x3-6x2+x-8. Все коэффициенты -- целые числа.
 * <p>
 * Методы: сравнить два полинома на равенство,
 * рассчитать значение при данном (целом) x, сложить / вычесть / умножить / поделить два полинома,
 * найти остаток от деления одного полинома на другой.
 */
public class Polynom {

    private List<Integer> listArray = new ArrayList<>();

    Polynom() {

        this.listArray.add(0);

    }

    Polynom(List<Integer> list) {
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

    public Polynom addition(Polynom polynom) {
        List<Integer> list = new ArrayList<>();
        if (this.listArray.size() != polynom.getListArray().size()) {
            throw new IllegalArgumentException("the sizes of the polynomials are different");
        }
        for (int i = 0; i < this.listArray.size(); i++)
            list.add(this.listArray.get(i) + polynom.getListArray().get(i));
        return new Polynom(list);
    }

    public Polynom substraction(Polynom polynom) {
        List<Integer> list = new ArrayList<>();
        if (this.listArray.size() != polynom.getListArray().size()) {
            throw new IllegalArgumentException("the sizes of the polynomials are different");
        }
        for (int i = 0; i < this.listArray.size(); i++)
            list.add(this.listArray.get(i) - polynom.getListArray().get(i));
        return new Polynom(list);
    }

    public Polynom multiplication(Polynom polynom) {
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = polynom.getListArray();
        for (int i = 0; i < (temp.size() + this.listArray.size() - 1); i++)
            list.add(i, 0);
        for (int i = 0; i < this.listArray.size(); i++)
            for (int j = 0; j < temp.size(); j++)
                list.set(i + j, list.get(i + j) + temp.get(j) * this.listArray.get(i));

        return new Polynom(list);
    }

    public Polynom division(Polynom dList) {
        ArrayList<Integer> dResult = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        if (this.listArray.size() < dList.getListArray().size() || dList.getListArray().size() == 1)
            throw new IllegalArgumentException("the sizes of the polynomials are different");

        for (int i = 0; i < (this.listArray.size() - dList.getListArray().size() + 1); i++) {
            dResult.add(i, 0);
        }
        for (int i = 0; i < dList.getListArray().size(); i++) {
            tempList.add(i, 0);
        }
        int addIndex;
        int elemValue;
        //цикл по делимому
        for (int i = (this.listArray.size() - 1); i >= 0; i--) {
            if (i - dList.getListArray().size() + 1 >= 0) {
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

                addIndex = i - dList.getListArray().size() + 1;
                elemValue = tempList.get(tempList.size() - 1) /
                        dList.getListArray().get(dList.getListArray().size() - 1);
                dResult.set(addIndex, elemValue);
                // переопределение области деления, вычитание + сдвиг
                for (int j = 0; j < dList.getListArray().size(); j++) {
                    tempList.set(j, tempList.get(j) - dResult.get(addIndex) * dList.getListArray().get(j));
                    if (tempList.get(j) == 0 && (i - tempList.size() >= 0)) {
                        tempList.set(j, null);
                        tempList.add(0, this.listArray.get(i - tempList.size()));
                    }
                }
                tempList.removeAll(Collections.singleton(null));
            }
        }
        return new Polynom(dResult);
    }

    public Polynom remaindedD(Polynom polynom) {
        List<Integer> list = new ArrayList<>();
        Polynom temp2 = this.division(polynom);
        Polynom polResult = this.substraction(polynom.multiplication(temp2));
        return polResult;
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
