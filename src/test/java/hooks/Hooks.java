package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Hooks {

    @Before
    public void before() {
        PageFactory.initElements(driver, this);
        DriverManager.getWebDriver();
    }

    protected static WebDriver driver = DriverManager.getWebDriver();

    @After
    public void tearDown(Scenario scenario) {
        String screenshotName = scenario.getName().replace(" ", "_");
        try {
            if (scenario.isFailed()) {
                scenario.log("Alarm!");
                TakesScreenshot ts = (TakesScreenshot) DriverManager.getWebDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void exit() {
        DriverManager.quitDriver();
    }
}