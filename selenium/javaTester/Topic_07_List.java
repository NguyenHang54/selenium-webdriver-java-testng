package javaTester;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_07_List {

    @Test
    public void testList(){
        List <String> studentName = new ArrayList<String>();
        studentName.add(" Nguyễn Thu Thảo");
        studentName.add(" Nguyễn Thu HƯơng");
        studentName.add(" Dương Văn Linh");
        studentName.add(" Cao Thu Uyên");
// 3 element trong List
        System.out.println(studentName.size());

        System.out.println(studentName.get(0));
        // lấy ra phần tử cuối cùng: bằng size -1

        System.out.println(studentName.get(studentName.size()-1));



    }

}
