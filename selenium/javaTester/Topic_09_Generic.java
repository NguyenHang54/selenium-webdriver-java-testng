package javaTester;

import java.util.ArrayList;
import java.util.List;

public class Topic_09_Generic {

    public static void main (String[] args){
        List<String> Students = new ArrayList<String>();
        // list chi chuwa du lieu kieu String
        // E V T K L: type of element in list
        Students.add("Jenny");
        Students.add("Hanna");
        Students.add("Tomm");

        List adress = new ArrayList<>();
        adress.add("123 St.");// sting
        adress.add(15);// integer
        adress.add(true);// boolean
        adress.add(15.78);// float
    }
}
