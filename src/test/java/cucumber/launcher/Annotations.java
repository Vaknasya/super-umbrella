package cucumber.launcher;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Annotations {

    @Before
    public void setUpSelenide(){
        Configuration.timeout = 35000;
    }

    @After
    public void closeSelenide(){
        WebDriverRunner.getWebDriver().close();
    }
}
