package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Priority {

    @BeforeClass
    public void init(){
        System.out.println("Pre-conditions for bellow test cases");
    }

    // khi run sẽ chạy theo A-Z, chạy TC 02 trước
    @Test
    public void Priority_01_SearchWithDate(){
    }
    @Test
    public void Priority_02_SearchWithBilling(){

    }

    @Test ( priority = 3 )
    public void Priority_03_SearchWithProduct(){
    }

    @AfterClass
    public void after(){
        System.out.println("Post-condition for above test cases");
    }
}
