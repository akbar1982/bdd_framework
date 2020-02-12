package base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Sam");
        list.add("Manny");
        list.add("Mansur");
        list.add("Jurabek");
        list.add("Sam");
//        list.remove(3);
        System.out.println(  "This is the size of the list: "+list.size());
        System.out.println("this is my list "+list);


        Set<String> myset = new HashSet<>();
        myset.add("Sam");
        myset.add("Manny");
        myset.add("Mansur");
        myset.add("Jurabek");
        myset.add("Sam");

//        System.out.println("this is my set " + myset);

        for(String item: myset){
            System.out.println(item);
        }

    }
}
