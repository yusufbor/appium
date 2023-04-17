package appiumtests;

import org.junit.jupiter.api.Test;
import pages.CalcPage;

import static org.junit.jupiter.api.Assertions.*;

public class CalcPOMTest {

    CalcPage calcPage = new CalcPage();

    @Test
    public void multiplyTest(){

        calcPage.clickSingleDigit(5);
        calcPage.multiply.click();
        calcPage.clickSingleDigit(8);
        calcPage.equals.click();
        String actResult = calcPage.results.getText();

        String expResult = "40";

        assertEquals(expResult,actResult);

    }
}
