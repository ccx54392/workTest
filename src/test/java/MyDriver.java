import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyDriver {
    private AppiumDriver<MobileElement> driver;

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public MyDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", "Mi A1");
        cap.setCapability("udid", "350632679805");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.1.0");

        cap.setCapability("appPackage", "com.greengoblintechnology.sat");
        cap.setCapability("appActivity", "com.greengoblintechnology.sat.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(url, cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
