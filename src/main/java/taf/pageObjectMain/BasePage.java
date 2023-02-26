package taf.pageObjectMain;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public abstract class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void goToPage(String url){
        Selenide.open(pageUrl);
   }

    public void click(SelenideElement element){
        element.click();
    }
}
