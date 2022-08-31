package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class StartPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("Открыть Яндекс")
    public void getURL() {
        pageManager.getStartPage().getURL();
    }

    @И("Открыть раздел {string}")
    public void openYandexMarket(String str) {
        pageManager.getStartPage().openYandexMarket();
    }
}
