package cucumber.testSteps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class KlavogonkiTest {
    private final SelenideElement quickStartIcon = $(".quickstart");
    private final SelenideElement closeStartWindow = $("input[onclick*=\"howtoplay\"]");
    private final SelenideElement startGameButton = $("a[id*=\"host_start\"]");
    private final SelenideElement focusedElement = $("#typefocus");
    private final SelenideElement inputTextField = $("#inputtext");
    private final SelenideElement afterFocusedElement = $("#afterfocus");
    private final SelenideElement countResult =
            $x("//div[contains((@class), \"you\")]//div[@id=\"stats0\"]//div[2]/span/span");

    /**
     * Site has anti-bot protection and replaces Russian characters with English when typing
     */
    private String getFocusedWord() {
        return focusedElement.getText().replaceAll("c", "с").replaceAll("o", "о");
    }

    @Given("Open the desired page {string}")
    public void openTheDesiredPage(String url) {
        Selenide.open(url);
    }

    @And("Pressing the quickstart button")
    public void pressingTheButton() {
        quickStartIcon.click();
    }

    @When("Starting the game")
    public void starting_the_game() {
        closeStartWindow.click();
        if (startGameButton.isDisplayed()) {
            startGameButton.click();
        }

    }

    @And("Waiting for the game to start")
    public void waiting_for_the_game_to_start() {
        focusedElement.click();
    }

    @And("Enter the highlighted word in the loop")
    public void enter_the_highlighted_word_in_the_loop() {
        while (true) {
            String focusedWord = getFocusedWord();
            String afterFocusedWordSymbol = afterFocusedElement.getText();
            inputTextField.sendKeys(focusedWord);
            if (afterFocusedWordSymbol.equals(".")) {
                inputTextField.sendKeys(".");
                break;
            }
            inputTextField.sendKeys(Keys.SPACE);
        }

    }

    @Then("Fix that the game is over and there are more characters per minute than {int}")
    public void fix_that_the_game_is_over_and_there_are_more_characters_per_minute_than(Integer valueCount) {
        String raceResult = countResult.getText();
        int resultCount = Integer.parseInt(raceResult);
        Assert.assertTrue("Relevant count is: " + valueCount, resultCount > valueCount);
    }
}
