package generic.utility;

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

	@BeforeSuite
	public void BSConfig() {
		System.out.println("Connected to Database");
	}

	@BeforeClass
	public void BCConfig() {
		// Launch browser
		String BROWSER = "chrome";
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
		d.manage().window().maximize();
		
		// wait for page to load
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// navigate to main URL
		d.get("http://localhost/vtigercrm/");
	}

	@BeforeMethod
	public void BMConfig() {
		// Login to application
		String USERNAME="admin";
		String PASSWORD="admin";
		
		HomePage hp=new HomePage(d);
		hp.loginToApplication(USERNAME, PASSWORD);
		
		System.out.println("Login");
		
	}

	@AfterMethod
	public void AMConfig() {
		// Logout to application
		HomePage hp=new HomePage(d);
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
