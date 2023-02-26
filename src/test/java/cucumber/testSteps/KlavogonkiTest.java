package cucumber.testSteps;

import cucumber.pages.KlavogonkiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class KlavogonkiTest {

    KlavogonkiPage klavogonkiPage = new KlavogonkiPage();

    @Given("Open the desired page {string}")
    public void openPage(String url) {
        klavogonkiPage.goToPage(url);
    }

    @And("Pressing the quickstart button")
    public void clickStartBtn() {
        klavogonkiPage.clickQuickStartIcon();
    }

    @And("Closing the context menu")
    public void closeContextMenu() {
        klavogonkiPage.clickContextStartWindow();
    }

    @When("Starting the game")
    public void startGame() {
        if (klavogonkiPage.isStartGameButtonVisible()) {
            klavogonkiPage.clickStartGameButton();
        }
    }

    @And("Waiting for the game to start")
    public void waitingForStart() {
        klavogonkiPage.clickFocusedElement();
    }

    @And("Enter the highlighted word in the loop")
    public void enterHighlightedWord() {
        while (true) {
            String focusedWord = klavogonkiPage.getFocusedWord();
            String afterFocusedWordSymbol = klavogonkiPage.getAfterFocusedElementText();
            klavogonkiPage.sendTextToInputField(focusedWord);
            if (afterFocusedWordSymbol.equals(".")) {
                klavogonkiPage.sendTextToInputField(".");
                break;
            }
            klavogonkiPage.sendKeysToInputField(Keys.SPACE);
        }

    }

    @Then("Fix that the game is over")
    public void FixIsGameFinished() {
        Assert.assertTrue(klavogonkiPage.isAfterBookIsVisible());
    }

    @And("Fix there are more characters per minute than {int}")
    public void FixCharacters(Integer charactersCount) {
        Assert.assertTrue("Relevant count is: " + charactersCount,
                klavogonkiPage.getCountInt() > charactersCount);
    }
}
