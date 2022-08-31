package managers;

import pages.*;

public class PageManager {

    private static PageManager instance = null;

    private BasePage basePage;
    private StartPage startPage;
    private ChooseProductPage chooseProductPage;
    private HeadphonesAndAudioPage headphonesAndAudioPage;
    private FiltersPage filtersPage;
    private TelevisionsPage televisionsPage;
    private HeadphonesPage headphonesPage;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
        }
        return instance;
    }

    public BasePage getBasePage() {
        if (basePage == null) {
            basePage = new BasePage();
        }
        return basePage;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public ChooseProductPage getChooseProductPage() {
        if (chooseProductPage == null) {
            chooseProductPage = new ChooseProductPage();
        }
        return chooseProductPage;
    }

    public HeadphonesAndAudioPage getHeadphonesAndAudioPage() {
        if (headphonesAndAudioPage == null) {
            headphonesAndAudioPage = new HeadphonesAndAudioPage();
        }
        return headphonesAndAudioPage;
    }

    public FiltersPage getFiltersPage() {
        if (filtersPage == null) {
            filtersPage = new FiltersPage();
        }
        return filtersPage;
    }

    public TelevisionsPage getTelevisionsPage() {
        if (televisionsPage == null) {
            televisionsPage = new TelevisionsPage();
        }
        return televisionsPage;
    }

    public HeadphonesPage getHeadphonesPage() {
        if (headphonesPage == null) {
            headphonesPage = new HeadphonesPage();
        }
        return headphonesPage;
    }

    public static PageManager nullInstance() {
        instance = null;
        return instance;
    }
}


