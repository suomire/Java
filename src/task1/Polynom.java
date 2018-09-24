package task1;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Polynom {
    private List<Integer> listArray;

    public Polynom(ArrayList<Integer> list) {
        this.listArray=list;
    }

    public List<Integer> getListArray() {
        return listArray;
    }

    public int polynomValue(int x) {
        int polVal = 0;
        for (int i = 0; i < listArray.size(); i++)
            polVal += pow(x, i) + listArray.get(i);
        return polVal;
    }
    public ArrayList<Integer> plus(ArrayList<Integer> plusList){
        ArrayList<Integer> plusResult=new ArrayList<>();
        for(int i=0; i<this.listArray.size(); i++)
            plusResult.add(this.listArray.get(i)+plusList.get(i));
        return plusResult;
    }
    public ArrayList minus(ArrayList<Integer> plusList){
        ArrayList<Integer> plusResult=new ArrayList<>();
        for(int i=0; i<this.listArray.size(); i++)
            plusResult.add(this.listArray.get(i)-plusList.get(i));
        return plusResult;
    }
    public ArrayList multiplication(ArrayList<Integer> plusList){
        ArrayList<Integer> plusResult=new ArrayList<>();
        for(int i=0; i<this.listArray.size(); i++)
            plusResult.add(i*2, this.listArray.get(i)*plusList.get(i));
        return plusResult;
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
    public String toString(){
        return String.valueOf(listArray);
    }
}
