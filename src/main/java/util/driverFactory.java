package util;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class driverFactory {

    public static ThreadLocal<RemoteWebDriver>  driverThreadLocal =  new ThreadLocal<>();;
    propertiesFactory propertiesFactory = new propertiesFactory();

    public void initDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driverThreadLocal.set(new ChromeDriver());
                getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                getDriver().manage().window().maximize();
                getDriver().get(propertiesFactory.getUrl());

                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driverThreadLocal.set(new FirefoxDriver());
                getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                getDriver().manage().window().maximize();
                getDriver().get(propertiesFactory.getUrl());

                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driverThreadLocal.set(new InternetExplorerDriver());
                getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                getDriver().manage().window().maximize();
                getDriver().get(propertiesFactory.getUrl());

                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driverThreadLocal.set(new EdgeDriver());
                getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                getDriver().manage().window().maximize();
                getDriver().get(propertiesFactory.getUrl());

                break;
            case "android":
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "R68T701AZ3N");
                capabilities.setCapability("platformVersion", "12");
                capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
                capabilities.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");

                try {
                   driverThreadLocal.set(new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                Assert.assertTrue(false, "İstenilen browser seçeneeklerimizde yok");
                break;
        }
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        //getDriver().quit();
    }

    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }


}
