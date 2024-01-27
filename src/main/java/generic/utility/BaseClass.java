package generic.utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.repository.HomePage;

public class BaseClass {

	public WebDriver d = null;

	public PropertyFileUtility putil = new PropertyFileUtility();
	public WebDriverUtility wutil = new WebDriverUtility();

	@BeforeSuite
	public void BSConfig() {
		System.out.println("Connected to Database");
	}

	@BeforeClass
	public void BCConfig() throws IOException {

		// Launch browser
		String URL = putil.readDataFromPropertyFile("url");

		String BROWSER = putil.readDataFromPropertyFile("browser");
		switch (BROWSER) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
			System.out.println(BROWSER + " browser launch");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
			System.out.println(BROWSER + " browser launch");
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			d = new EdgeDriver();
			System.out.println(BROWSER + " browser launch");
			break;

		default:
			System.out.println(BROWSER + " is invalid browser.");
			break;
		}

		// maximize screen
		wutil.maximizeCurrentWindow(d);

		// wait for page to load
		wutil.waitToPageLoad(d);

		// navigate to main URL
		d.get(URL);

	}

	@BeforeMethod
	public void BMConfig() throws IOException {

		// Login to application
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");

		HomePage hp = new HomePage(d);
		hp.loginToApplication(USERNAME, PASSWORD);

		System.out.println("Login");

	}

	@AfterMethod
	public void AMConfig() {
		// Logout to application
		HomePage hp = new HomePage(d);
		hp.logoutToApplication();
		System.out.println("Logout");
	}

	@AfterClass
	public void ACConfig() {
		// Quit Browser
		d.quit();
	}

	@AfterSuite
	public void ASConfig() {
		System.out.println("Dis-Connected to Database");
	}
}
