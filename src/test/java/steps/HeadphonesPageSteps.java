package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class HeadphonesPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("Выбрать производителя наушников в фильтрах")
    public void headphonesFilter() {
        pageManager.getHeadphonesPage().headphonesFilter();
    }

    @И("Проверка количества результатов поиска наушников")
    public void numberOfSearchResultsHeadphones() {
        pageManager.getHeadphonesPage().numberOfSearchResultsHeadphones();
    }

    @И("Сравнение наименований наушников")
    public void comparisonHeadphonesNames() {
        pageManager.getHeadphonesPage().comparisonHeadphonesNames();
    }
}
