import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
    final String[] actualArray = new String[]{"one","two","three","four","five","six"};

    @Test
    public void TestOne(){
        Assert.assertEquals(actualArray.length,6,"Array size is wrong");

    }

}
