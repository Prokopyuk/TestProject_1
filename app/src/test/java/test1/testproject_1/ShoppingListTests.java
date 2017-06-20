package test1.testproject_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Natalia on 5/27/2017.
 */

public class ShoppingListTests {
    WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "7.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.capigami.outofmilk");
        capabilities.setCapability("appActivity", "com.capigami.outofmilk.MainActivity");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void AddingNewItemToShoppingListWithSpecialCharacters() {

         /* Clicking Skip button. */
        driver.findElement(By.id("com.capigami.outofmilk:id/action_skip")).click();
          /* Closing What`s new */
        driver.findElement(By.id("android:id/button1")).click();
           /* Entering new item name*/
        driver.findElement(By.id("com.capigami.outofmilk:id/input_field")).click();
        driver.findElement(By.id("com.capigami.outofmilk:id/input_field")).sendKeys("_!#`_New1t`em/");
          /* Submiting adding new item*/
        driver.findElement(By.id("com.capigami.outofmilk:id/submit")).click();

        //Verifying new item with correct name was added by clicking on it
        driver.findElement(By.name("_!#`_New1t`em/")).click();

        driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
    }

    @After
    public void End() {
        driver.quit();
    }
}