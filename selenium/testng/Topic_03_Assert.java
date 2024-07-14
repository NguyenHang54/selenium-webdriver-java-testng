package testng;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_03_Assert {
    @Test
    public void test01(){
        //System.out.println("Test 01");
        // equals = kiểm tra 2 dữ liệu bằng nhau (expected / actual)
        //String, boolean, int, float
        String fullName = "Automation FC";
        Assert.assertEquals(fullName,"Automation CF");

        // True- false...
        //Điều kiện nhận vào là boolean (isDíslayed/ Enabled/ isSelected/ isMultipled..)

    }
}
