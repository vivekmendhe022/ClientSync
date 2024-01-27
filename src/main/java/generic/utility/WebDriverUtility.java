package generic.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void hoverOnWebElement(WebDriver d, WebElement elemenet) {
		Actions action = new Actions(d);
		action.moveToElement(elemenet).perform();
	}

	public void waitForElementToClickAble(WebDriver d, WebElement element) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToinvisibility(WebDriver d, WebElement element) {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By) element));
	}

	public void maximizeCurrentWindow(WebDriver d) {
		d.manage().window().maximize();
	}

	public void waitToPageLoad(WebDriver d) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void scrollIntoView(WebDriver d, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void scrollByView(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public void jsClick(WebDriver d, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].click()", element);
	}

}
