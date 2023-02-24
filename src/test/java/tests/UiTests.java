package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Tag("UI")
public class UiTests {

    ArrayList<String> divideExpressionsList = new ArrayList<String>() {
        {
            add("16/1");
            add("64/4");
        }
    };

    private final String url = "https://www.google.com/";
    private final String expectedResult = "16";
    private final SelenideElement inputField = $x("//input[@name='q']");
    private final SelenideElement resultField = $("#cwos");


    @BeforeClass
    public void setUpDriver() {
        Configuration.headless = true;
    }

    @BeforeMethod
    public void openPage() {
        Selenide.open(url);
    }

    private void assertAnswer(String value) {
        inputField.sendKeys(value + "=" + Keys.ENTER);
       // Selenide.screenshot(String.valueOf(System.currentTimeMillis()));
        Assert.assertEquals(expectedResult, resultField.getText());
    }

    @DataProvider(name = "calcPlusTestDataProvider")
    public Object[][] positiveCalcMatchingChecks() {
        return new Object[][]{
                {new String("8+8")},
                {new String("0+16")},
                {new String("4+12")},
                {new String("7+9")}
        };
    }

    @Test(dataProvider = "calcPlusTestDataProvider")
    public void calcPlusTest(String matchingValue) {
        assertAnswer(matchingValue);
    }


    @DataProvider(name = "calcMinusTestDataProvider")
    public Object[][] positiveCalcSubtractChecks() {
        return new Object[][]{
                {new String("16-0")},
                {new String("32-16")},
                {new String("100-84")},
                {new String("21-5")}
        };
    }

    @Test(dataProvider = "calcMinusTestDataProvider")
    public void calcMinusTest(String subtractValue) {
        assertAnswer(subtractValue);
    }


    @Test
    public void calcMultipyTest() {
        assertAnswer("4*4");
    }

    @Test
    public void calcDivideTest() {
        assertAnswer("64/4");
    }

}


