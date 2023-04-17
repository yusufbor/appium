package appiumtests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.http.impl.cookie.IgnoreSpec;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class Calculator {

    AppiumDriver <MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Pixel_3a");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.VERSION,"13");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url,capabilities);
    }

    @Test
    public void addTest(){


        MobileElement four = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_4"));
        four.click();
        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus"));
        plus.click();
        MobileElement five = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_5"));
        five.click();
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        equals.click();
        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));
        String actResult = result.getText();
        int expResult = 9;

        assertEquals(expResult,Integer.parseInt(actResult));

    }


    @Test
    public void divideTest(){

        MobileElement one = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_1"));
        one.click();
        MobileElement five = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_5"));
        five.click();
        MobileElement divide = driver.findElement(MobileBy.AccessibilityId("divide"));
        divide.click();
        MobileElement three = driver.findElement(MobileBy.id("com.google.android.calculator:id/digit_3"));
        three.click();
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        equals.click();
        MobileElement result = driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));
        String actResult = result.getText();
        int expResult = 5;

        assertEquals(expResult,Integer.parseInt(actResult));


    }

    @AfterEach
    public void tearDown(){

    }
}
