import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest {
    @BeforeClass
    public void before(){
        System.out.println("Start testing BeforeClass");
    }

    @AfterMethod
    public void afterTest(){
        System.out.println("after Test Method finish");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Finish testing AfterClass");
    }

    @DataProvider(name = "DP",parallel = true)
    public Object[][] dp(){
        return new Object[][]{{"one"},{"two"},{"four"}};
    }

    @Test(dataProvider = "DP")
    public void testNameExistDataProvider(String expectedName){
        Assert.assertTrue(arrayContainsName(actualArray,expectedName),"Array do not contain expected name");
    }

    final String[] actualArray = new String[]{"one","two","three","four","five","six"};

    @Test(enabled = false)
    public void TestLengthFirst(){
        int expected =6;
        Assert.assertEquals(actualArray.length,expected,"Array size is wrong");

    }

    public void TestLengthSecond(){
        int expected =5;
        Assert.assertNotEquals(actualArray.length,expected,"Array size is the same");

    }

    @Test(invocationCount = 5)
    public void TestNameExist(){
        String expectedName ="five";
        Assert.assertTrue(arrayContainsName(actualArray,expectedName),"Array do not contain expected name");
    }

    private boolean arrayContainsName(String[] array, String expectedName){
        boolean nameExist = false;
        for (int i=0;i<array.length;i++){
            if(array[i].equals(expectedName)){
                nameExist=true;
                break;
            }
        }
        return  nameExist;
    }

}
