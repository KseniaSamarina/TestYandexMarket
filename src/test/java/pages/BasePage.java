package pages;

import managers.DriverManager;
import managers.PageManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver = DriverManager.getWebDriver();
    protected final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    protected PageManager pageManager = PageManager.getInstance();

    @FindBy(xpath = "//span[@class='_36HP6 _3ZjYC' and text() = 'Показать ещё']")
    private WebElement scrollToButtonShowMore;

    @FindBy(css = "body")
    private WebElement vopros;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public void switchTab() {
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
    }

    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToButtonShowMore);
        vopros.sendKeys(Keys.CONTROL, Keys.END);
    }

    public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 10) {
            try {
                driver.findElement(by);
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Элемент не найден");
            }
            attempts++;
        }
        return result;
    }
}
