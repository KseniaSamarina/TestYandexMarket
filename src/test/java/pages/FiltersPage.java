package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FiltersPage extends BasePage {

    @FindBy(xpath = "//div[@data-filter-id='glprice']//div[@data-prefix='от']/input[@class='_2xtC2']")
    private WebElement enterPrice;

    @FindBy(xpath = "//a[@class='_2qvOO _3qN-v _1Rc6L']")
    private WebElement showAllResultsButton;

    public TelevisionsPage selectFiltersTelevision() {
        enterPrice.sendKeys("20000");
        showAllResultsButton.click();
        return pageManager.getTelevisionsPage();
    }

    public HeadphonesPage selectFiltresHeadphones() {
        enterPrice.sendKeys("5000");
        showAllResultsButton.click();
        return pageManager.getHeadphonesPage();
    }
}
