package cucumber.step.definition;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AppTest {
	WebDriver driver;

	@Given("^I am on Straittimes website$")
	public void i_am_on_Straittimes_website() throws Throwable {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/resources/config.properties");
		prop.load(input);
		//launch firefox browser 
		String geckoDriver = prop.getProperty("gecko.driver.path");
		System.setProperty("webdriver.gecko.driver", geckoDriver);	
		driver = new FirefoxDriver();
		//Launch the Straitstimes Website
		driver.get("https://www.straitstimes.com/");
	}

	@When("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() throws Throwable {
		WebDriverWait waitConfirm = new WebDriverWait(driver, 20);		
		WebElement loginLink = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div[2]/nav/div[2]/div/ul/li[1]/a")));
		loginLink.click();
	}

	@When("^I enter valid username and password$")
	public void i_enter_valid_username_and_password() throws Throwable {
		WebDriverWait waitConfirm = new WebDriverWait(driver, 20);
		WebElement emailTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("j_username")));
		emailTextbox.sendKeys("trmr999003@gmail.com");
		WebElement passwordTextbox = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.id("j_password")));
		passwordTextbox.sendKeys("@d3v3l0p3r4C");
	}

	@When("^I click on the “Sign In“ button$")
	public void i_click_on_the_Sign_In_button() throws Throwable {
		WebDriverWait waitConfirm = new WebDriverWait(driver, 20);
		WebElement loginButton = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div/div[1]/div[2]/div/div[2]/form/button")));
		loginButton.click();
	}

	@Then("^I successfully logged in$")
	public void i_successfully_logged_in() throws Throwable {
		WebDriverWait waitConfirm = new WebDriverWait(driver, 20);
		WebElement loggedInCredential = waitConfirm.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div/div[2]/nav/div[2]/div/ul/li[1]/a")));
		String loggedInUsername = loggedInCredential.getText();
		loggedInUsername.equals("trmr999003@gmail.com") ;
	}

	@Then("^I should see the “picture/video” in the main article$")
	public void i_should_see_the_picture_video_in_the_main_article() throws Throwable {
		driver.findElement(By.id("myPlayerID_html5_api"));
	}

	@When("^I click on the main article$")
	public void i_click_on_the_main_article() throws Throwable {
		WebDriverWait waitConfirm = new WebDriverWait(driver, 20);
		WebElement mainArticle = waitConfirm.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/section/div/section/div/div/div/div/div[2]/div/div/div/div[5]/div/div/div/div/a")));
		mainArticle.click();
	}

	@Then("^I should see the same “picture/video” in the main article$")
	public void i_should_see_the_same_picture_video_in_the_main_article() throws Throwable {
		driver.findElement(By.xpath("/html/body/header/div/div[2]/nav/ul/li[2]/ul"));
		driver.findElement(By.xpath("/html/body/div[6]/div/section/div/section/div/div[2]/div[1]/div[1]/div/div/figure/picture/img"));
	}
}
