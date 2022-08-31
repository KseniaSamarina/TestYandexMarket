package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChooseProductPage extends BasePage {

    @FindBy(xpath = "//button[@id='catalogPopupButton']")
    private WebElement buttonCatalogIsDisplayed;

    @FindBy(xpath = "//button[@id='catalogPopupButton']")
    private WebElement CatalogButton;

    @FindBy(xpath = "//div[@id='catalogPopup']")
    private WebElement catalogPopupIsDisplayed;

    @FindBy(xpath = "//a[contains (@class, '_191Hm')]/span[text() = 'Электроника']")
    private WebElement pointElectronicsSection;

    @FindBy(xpath = "//a[contains (@class, 'egKyN _1mqvV _3kgUl') and text() = 'Телевизоры']")
    private WebElement sectionTelevisions;

    @FindBy(xpath = "//a[@class='egKyN _2jA_3 _1B0pX' and text() = 'Наушники  и аудиотехника']")
    private WebElement sectionHeadphones;

    public ChooseProductPage openCatalog() {
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
        wait.until(ExpectedConditions.visibilityOf(buttonCatalogIsDisplayed));
        CatalogButton.click();
        wait.until(ExpectedConditions.visibilityOf(catalogPopupIsDisplayed));
        return pageManager.getChooseProductPage();
    }

    public ChooseProductPage openElectronics() {
        Actions builder = new Actions(driver);
        builder.moveToElement(pointElectronicsSection).build().perform();
        return pageManager.getChooseProductPage();
    }

    public TelevisionsPage openTelevisions() {
        sectionTelevisions.click();
        return pageManager.getTelevisionsPage();
    }

    public HeadphonesAndAudioPage openHeadphonesAndAudio() {
        sectionHeadphones.click();
        return pageManager.getHeadphonesAndAudioPage();
    }
}
