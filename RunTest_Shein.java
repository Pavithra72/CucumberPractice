package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/features/Shein.feature"}, glue = "steps",
monochrome = true)

public class RunTest_Shein extends AbstractTestNGCucumberTests {

}


//, dryRun = true, snippets = SnippetType.CAMELCASE