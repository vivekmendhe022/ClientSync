package leads;

import org.testng.annotations.Test;

import generic.utility.BaseClass;
import object.repository.HomePage;
import object.repository.leads.CreateNewLeadPage;
import object.repository.leads.LeadsPage;

public class CreateNewLeadWithIndustryTest extends BaseClass {

	@Test
	public void createNewLeadWithIndustryTest() throws InterruptedException {

		String LASTNAME = "Roy";

		HomePage hp = new HomePage(d);
		hp.clickOnLeadsLinkText(d);
		System.out.println("Leads Link Text Clicked");

		LeadsPage lp = new LeadsPage(d);
		lp.clickOnAddLeadButton();
		System.out.println("Add Leads Button Clicked");

		CreateNewLeadPage cnlp = new CreateNewLeadPage(d);
		cnlp.createNewLeadWithIndustry(d, LASTNAME);
		System.out.println("Saved Button Clicked");

	}
}
