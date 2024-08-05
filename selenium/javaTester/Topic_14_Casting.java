package javaTester;

public class Topic_14_Casting {
    public static void main (String[] args){
        // ngầm định = ko mất dữ liệu
        byte bNumber = 126;
        short sNumber = bNumber;

        int iNumber = sNumber;

        long lNumber = iNumber;

       // float fNumber = lNumber;

       // double dNumer = fNumber;

        // tường minh
        double dNumber = 156783;
        System.out.println(dNumber);

        float fNumber = (float) dNumber;
        System.out.println(fNumber);


    }
}
