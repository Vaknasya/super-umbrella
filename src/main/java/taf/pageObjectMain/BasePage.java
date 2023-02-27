package taf.pageObjectMain;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    protected String pageUrl;

    public BasePage() {
        Configuration.browser = "Chrome";
        //  Configuration.browserSize = siz
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
        element.sendKeys(Keys.valueOf(String.valueOf(element)));
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
