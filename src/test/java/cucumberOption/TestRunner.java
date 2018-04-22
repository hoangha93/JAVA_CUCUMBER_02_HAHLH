package cucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = { "pretty","html:target/site/cucumber-reporting","json:target/site/cucumber.json", "junit:target/cucumber/cucumber.xml"},
        snippets = SnippetType.CAMELCASE,
        tags = { "@payment" })

public class TestRunner {

}
