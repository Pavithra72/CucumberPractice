package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/features/BigBasket.feature"}, glue = "steps",
monochrome = true)

public class RunTest_BigBasket extends AbstractTestNGCucumberTests {

}


//, dryRun = true, snippets = SnippetType.CAMELCASE