package campaigns;

import org.testng.annotations.Test;

import generic.utility.BaseClass;
import object.repository.HomePage;
import object.repository.campaigns.CampaignPage;
import object.repository.campaigns.CreateNewCampaignPage;

public class CreateNewCampaignTestWithMarketingGroupTest extends BaseClass {

	@Test
	public void createNewCampaignTestWithMarketingGroupTest() throws InterruptedException {

		String CNAME = "HP Pendrive";
		String EXEPDATE = "01-27-2024";

		HomePage hp = new HomePage(d);
		hp.clickOnCampaignLinkText(d);
		System.out.println("Campaign Link Text Clicked!");

		CampaignPage cp = new CampaignPage(d);
		cp.clickOnAddCampaignBtn();
		System.out.println("Add Campaign Button Clicked!");

		CreateNewCampaignPage cncp = new CreateNewCampaignPage(d);
		cncp.createNewCampaignWithMarketingGroup(d, CNAME, EXEPDATE);
		System.out.println("Save Button Clicked");

	}
}
