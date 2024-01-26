package object.repository.campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utility.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility {

	// Campaign Details Components

	@FindBy(name = "campaignname")
	private WebElement CampaignNameTextField;

	@FindBy(xpath = "(//span[text()='Admin Administrator'])[2]")
	private WebElement AssignedToDropDownList;

	/**
	 * AssignedToDropDownList
	 */
	@FindBy(xpath = "//div[@id='select2-result-label-52']")
	private WebElement AssignedToAdminAdministrator;

	@FindBy(xpath = "//div[@id='select2-result-label-12']")
	private WebElement AssignedToMarketingGroup;

	@FindBy(xpath = "//div[@id='select2-result-label-13']")
	private WebElement AssignedToSupportGroup;

	@FindBy(xpath = "//div[@id='select2-result-label-14']")
	private WebElement AssignedToTeamSelling;

	@FindBy(name = "closingdate")
	private WebElement ExpectedCloseDateTextField;

	// Expectations & Actuals Components

	// Description Details Components

	// Save Button
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement SaveBtn;

	public CreateNewCampaignPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewCampaignWithAdminAdministrator(WebDriver d, String CNAME, String EXEPDATE) {
		CampaignNameTextField.sendKeys(CNAME);
		ExpectedCloseDateTextField.sendKeys(EXEPDATE);
		SaveBtn.click();
	}
	
	public void createNewCampaignWithMarketingGroup(WebDriver d, String CNAME, String EXEPDATE) {
		CampaignNameTextField.sendKeys(CNAME);
		AssignedToDropDownList.click();
		hoverOnWebElement(d, AssignedToMarketingGroup);
		waitForElementToClickAble(d, AssignedToMarketingGroup);
		AssignedToMarketingGroup.click();
		ExpectedCloseDateTextField.sendKeys(EXEPDATE);
		SaveBtn.click();
	}

}
