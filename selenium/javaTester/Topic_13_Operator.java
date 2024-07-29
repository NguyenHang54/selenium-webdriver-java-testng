package javaTester;

public class Topic_13_Operator {
    public static void main(String[] args) {

        int number = 10;
        number += 5;
//        System.out.println(number);
//        // chia lấy phần nguyên
//        System.out.println(number /5);
//        // chia lấy phần dư 15/6 = 2 dư 3
//        System.out.println(number % 6);
//
//        System.out.println(number++);
        // in number ra trước là = 15 sau đó tăng ++ là 16, nhưng in trc rồi nên lấy = 15

        System.out.println(++number);
        // cộng tr sau đó mới in. cộng lên = 17 nên in ra là 17

        for (int i = 0; i < 3; i++) {
            System.out.println(i);

        }

        String address =" Ho Chi Minh";
        if (address != "Ha Noi") {
            System.out.println("Address is not  the same");
        }

        boolean status = (address == "Ha Noi") ? true: false;
        System.out.println(status);

    }
}
