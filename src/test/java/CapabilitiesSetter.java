import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilitiesSetter {
    public static AndroidDriver<MobileElement> DriverCreator () throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //setDeviceCapabilitiesEmulator(desiredCapabilities);
        setDeviceCapabilities(desiredCapabilities);

        desiredCapabilities.setCapability("appPackage", "com.zenaclean");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");
        desiredCapabilities.setCapability("skipUnlock", "true");
        desiredCapabilities.setCapability("noReset", "false");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        return new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    private static void setDeviceCapabilities(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("udid", "988678454846324951");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "8.0");
        desiredCapabilities.setCapability("deviceName", "Samsung_Galaxy_S7");
    }

    private static void setDeviceCapabilitiesEmulator(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "8.0");
        desiredCapabilities.setCapability("deviceName", "Pixel_2_API_26");
    }
}