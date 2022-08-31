package pages;

import managers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testProperties.TestProperties;

public class StartPage extends BasePage {

    @FindBy(xpath = "//a[@data-id='market']")
    private WebElement clickButtonYandexMarket;

    public StartPage getURL() {
        driver.get(TestProperties.getInstance().getProperties().getProperty("HOSTNAME"));
        String originalHandle = DriverManager.getWebDriver().getWindowHandle();
        for(String handle : DriverManager.getWebDriver().getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                DriverManager.getWebDriver().switchTo().window(handle);
                DriverManager.getWebDriver().close();
            }
        }
        DriverManager.getWebDriver().switchTo().window(originalHandle);
        return pageManager.getStartPage();
    }

    public ChooseProductPage openYandexMarket() {
        clickButtonYandexMarket.click();
        switchTab();
        return pageManager.getChooseProductPage();
    }
}
