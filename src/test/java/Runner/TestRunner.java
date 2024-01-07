package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/OrderCheckout.feature",
        glue = {"StepDefinition"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-html-report", "json:cucumber.json"}
)
public class TestRunner {
}
