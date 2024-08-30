package Steps2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {

	WebDriver driver;

	Actions actions;

	JavascriptExecutor jsExecutor;

	WebDriverWait wait;

	@Given("User Opened the Browser and Entered Url")
	public void user_opened_the_browser_and_entered_url() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.naaptol.com/");

		actions = new Actions(driver);

		jsExecutor = (JavascriptExecutor) driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@When("User Moves to Shopping Categories and Car and Bike Accessories")
	public void user_moves_to_shopping_categories_and_car_and_bike_accessories() {

		WebElement ShopCategory = driver.findElement(By.cssSelector(".arrowNav"));

		actions.moveToElement(ShopCategory).build().perform();

		WebElement CarandBike = driver.findElement(By.xpath("(//*[@class='catIconMenu automobiles'])[1]"));

		actions.moveToElement(CarandBike).build().perform();

	}

	@When("Clicks on Bike Accessories")
	public void clicks_on_bike_accessories() {

		WebElement BikeAccessories = driver
				.findElement(By.xpath("(//*[@href='/shop-online/automobiles/bike-accessories.html'])[1]"));

		jsExecutor.executeScript("arguments[0].click()", BikeAccessories);
	}

	@When("Enters Pincode and Click on Set")
	public void enters_pincode_and_click_on_set() {

		WebElement Pins = driver.findElement(By.cssSelector("[id='pincode']"));

		Pins.sendKeys("800014");

		driver.findElement(By.xpath("(//*[@class='button_1'])[1]")).click();

	}

	@Then("That area available products would have been shown")
	public void that_area_available_products_would_have_been_shown() {

		Assert.assertEquals(driver.getTitle(),
				"Bike Accessories Online Store in India - Buy Bike Accessories at Best Price on Naaptol Online Shopping");

		driver.close();

	}

	@When("Enters Pincode ,Clicks on Cash On Delivery")
	public void enters_pincode_clicks_on_cash_on_delivery() {

		WebElement Pins = driver.findElement(By.cssSelector("[id='pincode']"));

		Pins.sendKeys("800014");

		driver.findElement(By.xpath("(//*[@class='button_1'])[1]")).click();

		driver.findElement(By.cssSelector("#iscod")).click();

	}

	@When("Clicks on Branded,Search By Price and Clicks on Clear All")
	public void clicks_on_branded_search_by_price_and_clicks_on_clear_all() throws InterruptedException {

		WebElement Brand = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#brandFilterBox8313")));

		jsExecutor.executeScript("arguments[0].click()", Brand);

		WebElement Price = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#priceFilterBox1")));

		jsExecutor.executeScript("arguments[0].click()", Price);

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//*[@class='sml_link'])[1]")).click();

	}

	@Then("All filters should get cleared")
	public void all_filters_should_get_cleared() {

		String Personalisedsearch = driver.findElement(By.cssSelector("#ps_off")).getText();

		Assert.assertEquals(Personalisedsearch, "[OFF]");

		driver.close();

	}

	@When("Clicked on All Checkboxes")
	public void clicked_on_all_checkboxes() throws InterruptedException {

		driver.findElement(By.xpath("(//*[@class='sml_link'])[1]")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.name("201 - 400"))).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("401 - 600"))));

		driver.findElement(By.name("401 - 600")).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("601 - 800"))));

		driver.findElement(By.name("601 - 800")).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("801 - 1000"))));

		driver.findElement(By.name("801 - 1000")).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("1401 - 2200"))));

		driver.findElement(By.name("1401 - 2200")).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("2201 - 3800"))));

		driver.findElement(By.name("2201 - 3800")).click();

	}

	@When("Unchecked All CheckBoxes")
	public void unchecked_all_check_boxes() {

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("201 - 400"))));

		driver.findElement(By.name("201 - 400")).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("401 - 600"))));

		driver.findElement(By.name("401 - 600")).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("601 - 800"))));

		driver.findElement(By.name("601 - 800")).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("801 - 1000"))));

		driver.findElement(By.name("801 - 1000")).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("1401 - 2200"))));

		driver.findElement(By.name("1401 - 2200")).click();

		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.name("2201 - 3800"))));

		driver.findElement(By.name("2201 - 3800")).click();
	}

	@Then("All Range products should be available")
	public void all_range_products_should_be_available() {

		String Found = driver.findElement(By.cssSelector(".found")).getText();

		Assert.assertEquals(Found, Found);

		driver.close();

	}

	@When("Enters Minimum and Maximum Ranges and Clicks on Go button")
	public void enters_minimum_and_maximum_ranges_and_clicks_on_go_button() throws InterruptedException {

		WebElement FromRange = driver.findElement(By.cssSelector("#fromPriceRange"));

		FromRange.sendKeys("200");

		WebElement ToRangeElement = driver.findElement(By.cssSelector("#toPriceRange"));

		ToRangeElement.sendKeys("250");

		WebElement GoButton = driver.findElement(By.xpath("(//*[@class='button_1'])[2]"));

		FromRange.clear();

		ToRangeElement.clear();

		GoButton.click();

		FromRange.sendKeys("300");

		ToRangeElement.sendKeys("400");

		GoButton.click();

		FromRange.clear();

		ToRangeElement.clear();

		GoButton.click();

		FromRange.sendKeys("1000");

		ToRangeElement.sendKeys("5000");

		GoButton.click();

		FromRange.clear();

		ToRangeElement.clear();

		GoButton.click();

		FromRange.sendKeys("2000");

		ToRangeElement.sendKeys("10000");

		GoButton.click();

		FromRange.clear();

		ToRangeElement.clear();

		FromRange.sendKeys("100");

		ToRangeElement.sendKeys("50");

		GoButton.click();

		FromRange.clear();

		ToRangeElement.clear();

		FromRange.sendKeys("122");

		ToRangeElement.sendKeys("-1203");

		GoButton.click();

		FromRange.clear();

		ToRangeElement.clear();

		FromRange.sendKeys("121");

		ToRangeElement.sendKeys("121212121212");

		GoButton.click();

		FromRange.clear();

		ToRangeElement.clear();

		FromRange.sendKeys("012102");

		ToRangeElement.sendKeys("910");

		GoButton.click();

		FromRange.clear();

		ToRangeElement.clear();

		FromRange.sendKeys("100");

		ToRangeElement.sendKeys("10000");

		GoButton.click();

	}

	@Then("Products should be shown")
	public void products_should_be_shown() {

		String Found = driver.findElement(By.cssSelector(".found")).getText();

		Assert.assertEquals(Found, Found);

		driver.close();

	}

	@When("User Moves to Shopping Categories")
	public void user_moves_to_shopping_categories() {

		WebElement ShopCategory = driver.findElement(By.cssSelector(".arrowNav"));

		actions.moveToElement(ShopCategory).build().perform();

	}

	@When("Clicks on Car and Bike Accessories")
	public void clicks_on_car_and_bike_accessories() {

		driver.findElement(By.xpath("(//*[@class='catIconMenu automobiles'])[1]")).click();

	}

	@When("Clicks on Every Brand Name")
	public void clicks_on_every_brand_name() {

		driver.findElement(By.linkText("Branded")).click();

		driver.navigate().back();

		driver.findElement(By.linkText("Yoviq")).click();

		driver.navigate().back();

		driver.findElement(By.linkText("AVL")).click();

		driver.findElement(By.linkText("CM")).click();

		driver.findElement(By.linkText("GR Multi Utility")).click();

		driver.navigate().back();

		driver.findElement(By.linkText("Hop n Go")).click();

	}

	@Then("Every Brand Products name should be visible")
	public void every_brand_products_name_should_be_visible() {

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.naaptol.com/brands/hop-n-go/automobiles.html");

		driver.close();
	}

	@When("Clicks on Bike Accessories and on a Product")
	public void clicks_on_bike_accessories_and_on_a_product() {

		driver.findElement(By.cssSelector("[alt='Bike Accessories']")).click();

		driver.findElement(By.linkText("Portable Oil & Fuel Transfer Pump")).click();

	}

	@When("Added Product to the Cart and Increased the number of Product")
	public void added_product_to_the_cart_and_increased_the_number_of_product() throws InterruptedException {

		String main = driver.getWindowHandle();

		Set<String> mix = driver.getWindowHandles();

		for (String All : mix) {

			if (!All.equals(main)) {

				driver.switchTo().window(All);

				driver.findElement(By.cssSelector("[id='cart-panel-button-0']")).click();

				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".input_Special_2")))
						.clear();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".input_Special_2")))
						.sendKeys("2");
				;

			}

		}
	}

	@Then("Message should be displayed")
	public void message_should_be_displayed() {

		String Quantity = driver.findElement(By.cssSelector(".font-bold-imp")).getText();

		Assert.assertEquals(Quantity, "(1)");

		driver.quit();

	}

}
