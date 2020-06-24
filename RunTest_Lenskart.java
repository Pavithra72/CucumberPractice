package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/features/Lenskart.feature"}, glue = {"steps","hooks"},
monochrome = true)

public class RunTest_Lenskart extends AbstractTestNGCucumberTests {

}


//, dryRun = true, snippets = SnippetType.CAMELCASE