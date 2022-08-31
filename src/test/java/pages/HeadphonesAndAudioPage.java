package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeadphonesAndAudioPage extends BasePage {

    @FindBy(xpath = "//a[@class='egKyN _2jA_3 _9qbcy' and text() = 'Наушники и Bluetooth-гарнитуры']")
    private WebElement sectionHeadphonesAndBluetooth;

    public HeadphonesPage openHeadphonesAndBluetooth() {
        sectionHeadphonesAndBluetooth.click();
        return pageManager.getHeadphonesPage();
    }
}
