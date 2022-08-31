package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TelevisionsPage extends BasePage {

    @FindBy(xpath = "//h1[text() = 'Телевизоры']")
    private WebElement titleTelevisionsIsDisplayed;

    @FindBy(xpath = "//label[@data-auto='filter-list-item-153061']//span[@class='_2XaWK']")
    private WebElement checkboxSamsung;

    @FindBy(xpath = "//label[@data-auto='filter-list-item-153074']//span[@class='_2XaWK']")
    private WebElement checkboxLG;

    @FindBy(xpath = "//button[@class='_2AMPZ _1N_0H _1ghok']")
    private WebElement allFiltersButton;

    @FindBy(xpath = "//div[@data-index and @data-known-size and @data-item-index]")
    private List<WebElement> countTelly;

    @FindBy(xpath = "//a[@title='43\" Телевизор LG 43UP75006LF 2021 LED, HDR']")
    private WebElement rememberNameFirstTelly;

    @FindBy(xpath = "//input[@id='header-search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-r='search-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@data-index='1']//a[@class='_2f75n _24Q6d cia-cs']")
    private WebElement nameOfSecondTelevision;

    public FiltersPage televisionsFilter() {
        wait.until(ExpectedConditions.visibilityOf(titleTelevisionsIsDisplayed));
        checkboxSamsung.click();
        checkboxLG.click();
        allFiltersButton.click();
        return pageManager.getFiltersPage();
    }

    public TelevisionsPage numberOfSearchResultsTelly() {
        scrollDown();
        Assertions.assertEquals(49, countTelly.size(), "Количество элементов не равно 48");
        return pageManager.getTelevisionsPage();
    }

    public TelevisionsPage comparisonTVNames() {
        String nameOfFirstTelevision = rememberNameFirstTelly.getAttribute("title");
        searchField.sendKeys(nameOfFirstTelevision);
        searchButton.click();
        boolean isClickable = retryingFindClick(By.xpath("//div[@data-index='1']//a[@class='_2f75n _24Q6d cia-cs']"));
        if (isClickable) {
            Assertions.assertEquals(nameOfFirstTelevision, nameOfSecondTelevision.getAttribute("title"), "Значения не равны");
        }
        return pageManager.getTelevisionsPage();
    }
}