package object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(id = "username")
	private WebElement UsernameTextField;

	@FindBy(id = "password")
	private WebElement PasswordTextField;

	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	private WebElement SignInButton;

	@FindBy(xpath = "//a[@role='button']")
	private WebElement AdminLookUpImg;

	@FindAll({ @FindBy(xpath = "//a[@role='button']"), @FindBy(linkText = "Sign Out") })
	private WebElement SignOutLinkText;

	@FindBy(xpath = "//div[@id='appnavigator']//span[@class='app-icon fa fa-bars']")
	private WebElement MenuIconLookUpImg;

	@FindBy(xpath = "//span[normalize-space()='MARKETING']")
	private WebElement MarketingLinkText;

	@FindBy(xpath = "//span[normalize-space()='Campaigns']")
	private WebElement CampaignLinkText;

	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getUsernameTextField() {
		return UsernameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getSignInButton() {
		return SignInButton;
	}

	public void loginToApplication(String USERNAME, String PASSWORD) {
		UsernameTextField.sendKeys(USERNAME);
		PasswordTextField.sendKeys(PASSWORD);
		SignInButton.click();
	}

	public void logoutToApplication() {
		AdminLookUpImg.click();
		SignOutLinkText.click();
	}

	public void clickOnCampaignLinkText(WebDriver d) throws InterruptedException {
		Thread.sleep(3000);
		MenuIconLookUpImg.click();
		hoverOnWebElement(d, MarketingLinkText);
		waitForElementToClickAble(d, CampaignLinkText);
		CampaignLinkText.click();
	}
}
