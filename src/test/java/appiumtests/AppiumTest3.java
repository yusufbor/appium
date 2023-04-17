package appiumtests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest3 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Pixel_3a");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.VERSION,"13");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url,capabilities);

        System.out.println(driver.getDeviceTime());

        Thread.sleep(3000);

        MobileElement clearElem = driver.findElement(MobileBy.AccessibilityId("clear"));
        System.out.println(clearElem.getText());


        driver.closeApp();



    }
}
