package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class TelevisionsPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("Выбрать производителя телевизора в фильтрах")
    public void televisionsFilter() {
        pageManager.getTelevisionsPage().televisionsFilter();
    }

    @И("Проверка количества результатов поиска телевизора")
    public void numberOfSearchResultsTelly() {
        pageManager.getTelevisionsPage().numberOfSearchResultsTelly();
    }

    @И("Сравнение наименований телевизоров")
    public void comparisonTVNames() {
        pageManager.getTelevisionsPage().comparisonTVNames();
    }
}
