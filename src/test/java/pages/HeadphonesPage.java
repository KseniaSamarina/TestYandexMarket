package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeadphonesPage extends BasePage {

    @FindBy(xpath = "//h1[text() = 'Наушники и Bluetooth-гарнитуры']")
    private WebElement titleHeadphonesAndBluetoothIsDisplayed;

    @FindBy(xpath = "//span[@class='_2Pukk' and text() = 'Показать всё']")
    private WebElement showAllLink;

    @FindBy(xpath = "//div[@data-tid='cf0256cc 8bcbee67 1092628']//input[@class='_3qxDp']")
    private WebElement enterHeadphoneManufacturer;

    @FindBy(xpath = "//span[@class='_1ZDAA' and text() = 'JBL']")
    private WebElement checkboxJBL;

    @FindBy(xpath = "//button[@class='_2AMPZ _1N_0H _1ghok']")
    private WebElement allFiltersButton2;

    @FindBy(xpath = "//div[@data-index and @data-known-size and @data-item-index]")
    private List<WebElement> countHeadphones;

    @FindBy(xpath = "//a[@title='Беспроводные наушники JBL Tune 510BT']")
    private WebElement rememberNameFirstHeadphones;

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-r='search-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@data-index='1']//a[@class='_2f75n _24Q6d cia-cs']")
    private WebElement nameOfSecondHeadphones;

    public FiltersPage headphonesFilter() {
        wait.until(ExpectedConditions.visibilityOf(titleHeadphonesAndBluetoothIsDisplayed));
        showAllLink.click();
        enterHeadphoneManufacturer.sendKeys("JBL");
        checkboxJBL.click();
        allFiltersButton2.click();
        return pageManager.getFiltersPage();
    }

    public HeadphonesPage numberOfSearchResultsHeadphones() {
        scrollDown();
        Assertions.assertEquals(50, countHeadphones.size(), "Количество элементов не равно 48");
        return pageManager.getHeadphonesPage();
    }

    public HeadphonesPage comparisonHeadphonesNames() {
        String nameOfFirstHeadphones = rememberNameFirstHeadphones.getAttribute("title");
        searchField.sendKeys(nameOfFirstHeadphones);
        searchButton.click();
        boolean isClickable = retryingFindClick(By.xpath("//div[@data-index='1']//a[@class='_2f75n _24Q6d cia-cs']"));
        if (isClickable) {
            Assertions.assertEquals(nameOfFirstHeadphones, nameOfSecondHeadphones.getAttribute("title"), "Значения не равны");
        }
        return pageManager.getHeadphonesPage();
    }
}
