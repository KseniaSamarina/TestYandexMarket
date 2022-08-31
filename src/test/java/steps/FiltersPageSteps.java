package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class FiltersPageSteps {
    PageManager pageManager = PageManager.getInstance();

    @И("В фильтрах выбрать минимальную цену телевизора")
    public void selectFiltersTelevision() {
        pageManager.getFiltersPage().selectFiltersTelevision();
    }

    @И("В фильтрах выбрать минимальную цену наушников")
    public void selectFiltresHeadphones() {
        pageManager.getFiltersPage().selectFiltresHeadphones();
    }
}
