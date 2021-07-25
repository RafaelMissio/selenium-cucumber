package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//features",
                plugin = {"pretty"},
                snippets = CucumberOptions.SnippetType.CAMELCASE,
                glue = {"steps"},
                tags = "not @ignore",
                dryRun = false)

public class Runner {
}
