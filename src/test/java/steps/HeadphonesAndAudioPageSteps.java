package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class HeadphonesAndAudioPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("Открыть страницу {string}")
    public void openHeadphonesAndBluetooth(String blue) {
        pageManager.getHeadphonesAndAudioPage().openHeadphonesAndBluetooth();
    }
}
