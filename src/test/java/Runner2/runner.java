package Runner2;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\Prince Raj\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Selenium_Cucumber_Project\\src\\test\\resources\\Feature Files\\BikeAccessories.feature", glue = "Steps2")
public class runner extends AbstractTestNGCucumberTests {

}