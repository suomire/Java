package task1;

import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args){
        List new_list=new ArrayList();
        int[] indexes={-8, 1, -6, 3, 7};
        for (int indexe : indexes) new_list.add(indexe);

        System.out.print(new_list.get(0));
    }
}
