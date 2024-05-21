package javaTester;

public class Topic_06_Array {
    static int[] studentAge ={10,25,28,30};
    static String[] studentName ={"Nguyen Hang"," Tran Linh"};
    String[] studentAddress = new String[5];

    public static void main (String [] args){
        String [] studentAddress = new String[5];
        // gan phan tu: co 5 phan tu, bat dau = 0
        studentAddress[0]= "165 Bach Dang";
        studentAddress[1]= "167 Bach Dang";
        studentAddress[2]= "168 Bach Dang";
        studentAddress[3]= "169 Bach Dang";
        studentAddress[4]= "170 Bach Dang";

        System.out.println(studentName[0]);
        System.out.println(studentName[1]);

        for (int i = 0; i <studentAddress.length ; i++) {
            System.out.println(studentAddress[i]);
        }


    }
    }