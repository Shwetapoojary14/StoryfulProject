package hellocucumber;

import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Objects;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	public static WebDriver driver = null;
	public static String firstname="//*[@id=\"first_name\"]";
	public static String lastName="//*[@id=\"last_name\"]";
	public static String email="//*[@id=\"user_email\"]";
	public static String pwd="//*[@id=\"user_password\"]";
	public static String AGTC = "//*[@id=\"terms\"]";
	public static String robotcheck= "//*[@id=\"recaptcha-anchor\"]/div[1]";
	public static String signUp= "//*[@id=\"send\"]";
			
			
	@Before
	public void init() {
		openWebPage();
	}

	private void openWebPage() {
		{
			System.setProperty(
					"webdriver.edge.driver",
					"C:\\Shweta\\project\\Selenium\\edgedriver_win64\\msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();

			driver = new EdgeDriver(options);

			// Maximize the browser
			driver.manage().window().maximize();

			// Launch Website
			driver.get("https://signin.storyful.com/trial/signup-form-01489905846464720243");	
		}
	}

	@Given("on the sign-up page")
	public void anExampleScenario() {


	}

	@When("user fills the \"(.*?)\"$ field with \\\"(.*?)\"$")
	public void allStepDefinitionsAreImplemented(String textbox , String value) throws Exception {
		if(textbox == null || value == null || StringUtils.isBlank(textbox) || StringUtils.isBlank(value)) {
			throw new Exception("Check Feature file");
		}
	
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'nav-sub-li literal-management')]")));
		try {
			if(textbox.equalsIgnoreCase("First Name")) {
				findElementByXpath(driver, firstname).click();
				sendText(driver, firstname, value);
			}else if (textbox.equalsIgnoreCase("Last Name")) {
				findElementByXpath(driver, lastName).click();
				sendText(driver, lastName, value);
				
			}else if (textbox.equalsIgnoreCase("Email")) {
				findElementByXpath(driver, email).click();
				sendText(driver, email, value);
				
			}else if(textbox.equalsIgnoreCase("Password")) {
				findElementByXpath(driver, pwd).click();
				sendText(driver, pwd, value);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("user click on the \"(.*?)\"$ checkbox")
	public void theScenarioPasses() {
	}
	
	public WebElement findElementByXpath(WebDriver driver, String xpath) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 300);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			Thread.sleep(1000);
			WebElement el = driver.findElement(By.xpath(xpath));

			return el;

		} catch (org.openqa.selenium.NoSuchElementException nsee) {
			System.out.println(xpath + " not found on Try ");
		}
		return null;
	}
	
	public void sendText(WebDriver driver, String xpath, String value) {
		WebElement searchbox = driver.findElement(By.xpath(xpath));
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("arguments[0].value='" + value + "';", searchbox);
	}

}
