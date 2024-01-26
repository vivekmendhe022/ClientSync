package object.repository.campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	@FindBy(xpath="//button[contains(@id,'Campaigns_listView_basicAction_LBL_ADD_RECORD')]")
	private WebElement AddCampaignBtn;

	public CampaignPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public void clickOnAddCampaignBtn() {
		AddCampaignBtn.click();
	}
	
}
