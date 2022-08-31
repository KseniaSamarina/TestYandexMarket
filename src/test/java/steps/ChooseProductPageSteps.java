package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class ChooseProductPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("Открыть {string}")
    public void openCatalog(String catalog) {
        pageManager.getChooseProductPage().openCatalog();
    }
    @И("Выбрать пункт {string}")
    public void openElectronics(String elect) {
        pageManager.getChooseProductPage().openElectronics();
    }
    @И("Выбрать {string}")
    public void openTelevisions(String telly) {
        pageManager.getChooseProductPage().openTelevisions();
    }
    @И("Выбрать раздел {string}")
    public void openHeadphonesAndAudio(String headph) {
        pageManager.getChooseProductPage().openHeadphonesAndAudio();
    }
}
