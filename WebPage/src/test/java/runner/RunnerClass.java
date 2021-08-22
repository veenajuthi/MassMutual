package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
//	strict = true,
	features = {"WebPage\\Features\\WebPage.feature"}
)

public class RunnerClass {
	
}
