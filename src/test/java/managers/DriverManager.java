package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testProperties.TestProperties;

import java.util.Properties;

import static java.lang.System.setProperty;
import static java.time.Duration.ofSeconds;

public class DriverManager {
    protected static WebDriver driver;
    private static final Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getWebDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(ofSeconds(20));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        PageManager.nullInstance();
    }
}
