package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class CalcPage {

    public CalcPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }

    @AndroidFindBy(accessibility = "multiply")
    public MobileElement multiply;

    @AndroidFindBy(accessibility = "equals")
    public MobileElement equals;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public MobileElement results;

    public void clickSingleDigit(int digit){
        String id = "com.google.android.calculator:id/digit_" + digit;
        MobileElement number = Driver.getDriver().findElement(MobileBy.id(id));
        number.click();
    }
}
