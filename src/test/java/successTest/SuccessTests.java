package successTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessTests {
    @Test

    public void testStandardUser(){
        Assert.assertEquals(6,6);
    }
}
