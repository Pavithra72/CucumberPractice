package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/features/Honda.feature"}, glue = {"steps","hooks"},
monochrome = true)

public class RunTest_Honda extends AbstractTestNGCucumberTests {

}


//, dryRun = true, snippets = SnippetType.CAMELCASE