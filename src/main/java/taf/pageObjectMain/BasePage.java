package taf.pageObjectMain;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    protected String pageUrl;

    public BasePage() {
        Configuration.browser = "Chrome";
        // Configuration.browserSize = true;
        //Configuration.headless = true;
    }

    public void goToPage(String url) {
        Selenide.open(pageUrl);
    }

    public SelenideElement findById(String id) {
        return $(By.id(id));
    }

    public SelenideElement findByClassName(String className) {
        return $(By.className(className));
    }

    public SelenideElement findByCss(String css) {
        return $(By.cssSelector(css));
    }

    public SelenideElement findByXpath(String xpath) {
        return $(By.cssSelector(xpath));
    }

    public void clickElement(SelenideElement element) {
        element.click();
    }

    public void sendKeyboardKey(SelenideElement element) {
        element.sendKeys();
    }

    public void setText(SelenideElement element, String text) {
        element.sendKeys(text);
    }

    public String getText(SelenideElement element) {
        return element.getText();
    }

    public void hoverElement(SelenideElement element) {
        element.hover();
    }


}
