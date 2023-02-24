package cucumber.launcher;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = {"src\\test\\resources\\cucumberFeatures"},
        glue = {"cucumber.testSteps", "cucumber.launcher"})
public class CucumberRunner {
}
