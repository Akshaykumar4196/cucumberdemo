package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/appfeatures",
        glue = {"stepdefs","apphooks"},
        tags = "@Smoke",
        plugin = {"pretty", "html:target/cucumber"}
)
public class TestRunner {
}
