import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args){
        List new_list=new ArrayList();
        int[] indexes={-8, 1, -6, 3, 7};
        for(int i=0; i<indexes.length; i++)
            new_list.add(indexes[i]);

        System.out.print(new_list.get(0));
    }
}
