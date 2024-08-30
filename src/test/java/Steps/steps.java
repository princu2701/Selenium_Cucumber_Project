package Steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {

	WebDriver driver;

	WebDriverWait wait;

	JavascriptExecutor jsExecutor;

	Actions actions;

	ExtentReports reports;

	ExtentTest test;

//Created Method for Taking shots everywhere
	public void shots(int n) throws IOException {

		TakesScreenshot tScreenshot = (TakesScreenshot) driver;

		File fis = tScreenshot.getScreenshotAs(OutputType.FILE);

		File file = new File("C:\\Users\\Prince Raj\\OneDrive\\Documents\\Prjct Shots\\Cucumber\\cucum" + n + ".png");

		FileUtils.copyFile(fis, file);

	}

	@Given("User Opened the Browser and Entered URL")
	public void user_opened_the_browser_and_entered_url() {

		reports = new ExtentReports(
				"C:\\Users\\Prince Raj\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Selenium_Cucumber_Project\\CucumberReport.html");

		test = reports.startTest("Cucumber Selenium");
//Used Chrome Browser for implementation of Cucumber Project
		driver = new FirefoxDriver();
//Used JavaScriptExecutor in Cucumber as  it works well in working with elements in cucumber
		jsExecutor = (JavascriptExecutor) driver;
//Used Actions as we need for hovering on products in web application
		actions = new Actions(driver);
//Used implicit waits as it works globally
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//Also introduced explicit waits so that i can work also on specific elements as per conditions needed
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//Inserted Targeted Project Url
		driver.get("https://www.naaptol.com/");

	}

	@Given("Moves to Categories and Car and Accessories")
	public void moves_to_categories_and_car_and_accessories() throws IOException {

		// Used waits variable as per the conditions
		WebElement categories = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Shopping Categories']")));

		// Used actions variable here to hover on Shopping Categories Elements
		actions.moveToElement(categories).perform();

		// Used waits variable as per the conditions
		WebElement CarandBike = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[@href='/shop-online/automobiles.html'])[1]")));

		// Used actions variable for hovering on the Car and Bike Accessories
		actions.moveToElement(CarandBike).perform();

		test.log(LogStatus.PASS, "Hover Over Categories,CarandBikeAccessories");
	}

	@When("User Clicks on Car Accessories")
	public void user_clicks_on_car_accessories() throws IOException {

		// Created element so that later on it can be used in jsExecutor
		WebElement Bike = driver
				.findElement(By.xpath("(//*[@href='/shop-online/automobiles/car-accessories.html'])[1]"));

		// Used jsExecutor for clicking on Bike element
		jsExecutor.executeScript("arguments[0].click()", Bike);

		test.log(LogStatus.PASS, "Clicked Successfully on Car Accessories");
	}

	@When("Clicks on Top Image")
	public void clicks_on_top_image() throws IOException {

		// Creating WebElement Variable for clicking on Banner Image through jsExecutor
		WebElement topElement = driver.findElement(By.cssSelector(
				"[src='//layout.naptol.com/usr/local/csp/staticContent/naaptolAds/Category-Banner-Car-Accessories-18-09-23.jpg']"));

		// Used jsExecutor for clicking on Banner Element
		jsExecutor.executeScript("arguments[0].click()", topElement);

		test.log(LogStatus.PASS, "Validated the working of Banner at the Car Accessories Page");
		// Taken Screenshot
		shots(0);
	}

	@Then("Car Utilities Page should get opened")
	public void car_utilities_page_should_get_opened() throws InterruptedException, IOException {

		String element = driver.getTitle();

//Asserted the Current Title of the WebPage
		Assert.assertEquals(element,
				"Car Utilities Online Store in India - Buy Car Utilities at Best Price on Naaptol Online Shopping");
//Used Thread.sleep for waiting for the close the browser after 2 seconds
		Thread.sleep(2000);

		test.log(LogStatus.PASS, "Successfully Asserted the Utilities Page Title");

		shots(1);
//Used driver.close for Closing the browser instance after performing tasks 
		driver.close();

	}

	@When("User moves to a product and Clicks on QuickView")
	public void user_moves_to_a_product_and_clicks_on_quick_view() {

		// Creating variable for performing activities on Car Utilities element
		WebElement Utility = driver.findElement(By.cssSelector(".cate_Main"));

		jsExecutor.executeScript("arguments[0].click()", Utility);

		// Creating variable for hovering on the Product
		WebElement Prods = driver.findElement(By.xpath("(//img[@class='square'])[1]"));

		actions.moveToElement(Prods).perform();

		// Creating Variable for clicking on QuickView
		WebElement QuickV = driver.findElement(By.xpath("(//*[.='Quick View'])[2]"));

		jsExecutor.executeScript("arguments[0].click()", QuickV);

		test.log(LogStatus.PASS,
				"Moved to Car Utility and Hovered Over the Product and Clicked Successfully on QuickView Box");

	}

	@Then("Product Box Should get Opened")
	public void product_box_should_get_opened() throws IOException {

		String BoxAssertion = driver.findElement(By.cssSelector(".prepaidFreeShip")).getText();

		Assert.assertEquals(BoxAssertion, "Free Shipping for Diamond Members");

		test.log(LogStatus.PASS, "Successfully Asserted the Box Presence after clicking on QuickView");

		shots(2);

		driver.close();
	}

	@Given("Moves to Categories and Car and Bike Accessories")
	public void moves_to_categories_and_car_and_bike_accessories() {

		WebElement categories = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Shopping Categories']")));

		actions.moveToElement(categories).perform();

		WebElement CarandBike = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[@href='/shop-online/automobiles.html'])[1]")));

		actions.moveToElement(CarandBike).perform();

		test.log(LogStatus.PASS, "Successfully Hovered Over Car and Bike functionality");

	}

	@When("User Clicks on Car Accessories and Clicks on Product")
	public void user_clicks_on_car_accessories_and_clicks_on_product() {

		WebElement CarAccessories = driver
				.findElement(By.xpath("(//*[@href='/shop-online/automobiles/car-accessories.html'])[1]"));

		jsExecutor.executeScript("arguments[0].click()", CarAccessories);

		WebElement Prod = driver.findElement(By.cssSelector(
				"[src='//images.naptol.com/usr/local/csp/staticContent/product_images/horizontal/185x185/Dent-Remover-DentR-1.jpg']"));

		jsExecutor.executeScript("arguments[0].click()", Prod);

		String Parent = driver.getWindowHandle();

		Set<String> Child = driver.getWindowHandles();
//Handling a new Window after creating strig variables for windowhandles
		for (String All : Child) {

			if (!All.equals(Parent)) {

				driver.switchTo().window(All);

				driver.findElement(By.cssSelector("[alt='title=']")).click();
			}

		}

		test.log(LogStatus.PASS, "Successfully Handled the new window and Added the product to Cart");
	}

	@When("Clicks on Add to Cart")
	public void clicks_on_add_to_cart() {

		// Activity have been performed above so not needed to call here
		driver.manage().window().maximize();

	}

	@Then("Add to Cart Box should get opened")
	public void add_to_cart_box_should_get_opened() throws IOException {

		String Cart = driver.findElement(By.xpath("//*[.='OFFER']")).getText();

		Assert.assertEquals(Cart, "OFFER");

		test.log(LogStatus.PASS, "Successfully Asserted the Add to Cart Box");

		shots(4);

		driver.quit();

	}

	@When("Clicks on Search box of Box and enters a Brand Name")
	public void clicks_on_search_box_of_box_and_enters_a_brand_name() {

		WebElement BrandSearch = driver.findElement(By.cssSelector("[placeholder='Search Brand']"));

		// Created variable and called it here to work on it
		BrandSearch.sendKeys("Y");

		test.log(LogStatus.PASS, "Successfully Entered the text in Search Box");
	}

	@When("Clicks on Options")
	public void clicks_on_options() {

		driver.findElement(By.linkText("Yoviq")).click();

	}

	@Then("Brand Products should get displayed")
	public void brand_products_should_get_displayed() throws IOException {

		String Youviq = driver.findElement(By.xpath("//*[.='Yoviq Car Accessories']")).getText();

		Assert.assertEquals(Youviq, "Yoviq Car Accessories");

		test.log(LogStatus.PASS, "Successfully Created and Asserted the visibility of the searched products");

		shots(5);

		driver.close();

	}

	@When("User Clicks on Car Accessories and Enters Min and Max in Range Box")
	public void user_clicks_on_car_accessories_and_enters_min_and_max_in_range_box() {

		WebElement CarAccessories = driver
				.findElement(By.xpath("(//*[@href='/shop-online/automobiles/car-accessories.html'])[1]"));

		jsExecutor.executeScript("arguments[0].click()", CarAccessories);

		WebElement Utility = driver.findElement(By.cssSelector(".cate_Main"));

		jsExecutor.executeScript("arguments[0].click()", Utility);

		WebElement Minimum = driver.findElement(By.cssSelector("#fromPriceRange"));

		Minimum.sendKeys("200");

		WebElement Maximum = driver.findElement(By.cssSelector("#toPriceRange"));

		Maximum.sendKeys("400");

		test.log(LogStatus.PASS, "Successfully entered the min and max range of the products to visit");

	}

	@When("Clicks on Go button")
	public void clicks_on_go_button() {

		WebElement ButtonGo = driver.findElement(By.xpath("(//*[@class='button_1'])[2]"));

		jsExecutor.executeScript("arguments[0].click()", ButtonGo);

		test.log(LogStatus.PASS, "Succesfully Clicked on the button Go to see the demanded results");

	}

	@Then("Price Range should get displayed")
	public void price_range_should_get_displayed() throws IOException {

		String element = driver.getTitle();

		Assert.assertEquals(element,
				"Car Utilities Online Store in India - Buy Car Utilities at Best Price on Naaptol Online Shopping");

		test.log(LogStatus.PASS, "Asserted that Title of the Page");

		shots(6);

		driver.close();
	}

	@When("Clicks on wishlist icon")
	public void clicks_on_wishlist_icon() throws InterruptedException {

		WebElement Wish = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='wish2'])[19]")));

		jsExecutor.executeScript("arguments[0].click()", Wish);

		Thread.sleep(2000);

	}

	@Then("Login Box should get Opened")
	public void login_box_should_get_opened() throws IOException {

		String logBoxElement = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#registration-basic-panel-submit")))
				.getText();
//Since there is no text so this will be blank
		Assert.assertEquals(logBoxElement, "");

		test.log(LogStatus.PASS, "Successfully Clicked on the wishlist button and asserted the Continue button");

		shots(7);

		driver.close();
	}

	@When("Clicks on any Product")
	public void clicks_on_any_product() {

		WebElement Prod = driver.findElement(By.cssSelector(
				"[src='//images.naptol.com/usr/local/csp/staticContent/product_images/horizontal/185x185/Dent-Remover-DentR-1.jpg']"));

		jsExecutor.executeScript("arguments[0].click()", Prod);

	}

	@Then("Same product should be opened in a new Page")
	public void same_product_should_be_opened_in_a_new_page() throws IOException {

		String Par = driver.getWindowHandle();

		Set<String> Chil = driver.getWindowHandles();

		for (String All : Chil) {

			if (!All.equals(Par)) {

				driver.switchTo().window(All);

			}

		}

		test.log(LogStatus.PASS, "Successfully Opened and Handled a new window");

		shots(8);

		driver.quit();
	}

	@When("Clicks on Front Image and Select Cash on Delivery")
	public void clicks_on_front_image_and_select_cash_on_delivery() {

		WebElement topElement = driver.findElement(By.cssSelector(
				"[src='//layout.naptol.com/usr/local/csp/staticContent/naaptolAds/Category-Banner-Car-Accessories-18-09-23.jpg']"));

		jsExecutor.executeScript("arguments[0].click()", topElement);

		WebElement CODButton = driver.findElement(By.cssSelector("#iscod"));

		jsExecutor.executeScript("arguments[0].click()", CODButton);

		test.log(LogStatus.PASS, "Clicked and Banner and Clicked on COD button successfully");

	}

	@Then("COD products should get displayed")
	public void cod_products_should_get_displayed() throws IOException {

		String CODWordElement = driver.findElement(By.xpath("(//*[.='COD'])[1]")).getText();

		Assert.assertEquals(CODWordElement, "COD");

		test.log(LogStatus.PASS, "Successfully Verified the Working of Cod and Asserted the COD products");

		shots(9);

		reports.flush();

		reports.endTest(test);

		driver.close();
	}

}
