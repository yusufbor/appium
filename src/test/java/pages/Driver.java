package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigurationReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {

   private static AppiumDriver <MobileElement> driver;
   private static URL url;

   private Driver(){

   }


    public static AppiumDriver<MobileElement> getDriver(){
        String platform = ConfigurationReader.getProperty("platform");
        if (Objects.isNull(driver))
            switch (platform){
                case "android" :
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("deviceName","Pixel_3a");
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
                    capabilities.setCapability(MobileCapabilityType.VERSION,"13");
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
                    capabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/calculator.apk");
                  try{
                      url = new URL("http://localhost:4723/wd/hub");
                  } catch (MalformedURLException e) {
                      e.printStackTrace();
                  }
                  driver = new AndroidDriver<>(url,capabilities);
                  break;
                case "android-remote":
                    DesiredCapabilities caps = new DesiredCapabilities();
            }
        return driver;
    }
}
