package apptest.apptest;

/**
 * Hello world!
 *
 */
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

public class App {
	AndroidDriver driver;

	@BeforeClass
	public void before(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		File file = new File(System.getProperty("user.dir").concat("/ContactManager.apk"));
		capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "androidPhone");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, ".ContactManager");
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.example.android.contactmanager");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600");
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}