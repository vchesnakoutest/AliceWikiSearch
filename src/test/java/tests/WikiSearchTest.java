package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = "steps",
        plugin = { "pretty", "html:target/cucumber-reports",
                "json:target/cucumber-reports"}
)
public class WikiSearchTest extends AbstractTestNGCucumberTests {
}
