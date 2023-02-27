package cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import taf.pageObjectMain.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class KlavogonkiPage extends BasePage {

    public KlavogonkiPage() {
        super();
    }

    private final SelenideElement quickStartIcon = $(".quickstart");

    public void clickQuickStartIcon() {
        clickElement(quickStartIcon);
    }

    private final SelenideElement contextStartWindow = $("input[onclick*=\"howtoplay\"]");

    public void clickContextStartWindow() {
        clickElement(contextStartWindow);
    }

    private final SelenideElement startGameButton = $("a[id*=\"host_start\"]");

    public void clickStartGameButton() {
        clickElement(startGameButton);
    }

    public Boolean isStartGameButtonVisible() {
        return startGameButton.isDisplayed();
    }

    private final SelenideElement focusedElement = $("#typefocus");

    public void clickFocusedElement() {
        clickElement(focusedElement);
    }

    /**
     * Site has anti-bot protection and replaces Russian characters with English when typing
     */
    public String getFocusedWord() {
        return getText(focusedElement).replaceAll("c", "с").replaceAll("o", "о");
    }

    private final SelenideElement inputTextField = $("#inputtext");

    public void sendTextToInputField(String str) {
        setText(inputTextField, str);
    }

    public void sendKeysToInputField(Keys str) {
        setText(inputTextField, String.valueOf(str));
    }

    private final SelenideElement afterFocusedElement = $("#afterfocus");

    public String getAfterFocusedElementText() {
       return getText(afterFocusedElement);
    }

    private final SelenideElement afterGameAuthorBook = $(".imobilco-cover");

    public Boolean isAfterBookIsVisible() {
        return afterGameAuthorBook.isDisplayed();
    }

    private final SelenideElement countResult =
            $x("//div[contains((@class), \"you\")]//div[@id=\"stats0\"]//div[2]/span/span");

    public int getCountInt() {
        return Integer.parseInt(getText(countResult));
    }


}
