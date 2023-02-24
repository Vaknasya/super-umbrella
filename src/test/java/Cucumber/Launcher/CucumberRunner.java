package Cucumber.Launcher;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = {"src/test/resources/cucumberScenarious"})
public class CucumberRunner {
}
