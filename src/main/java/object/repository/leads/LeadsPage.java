package object.repository.leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	@FindBy(xpath = "//button[@id='Leads_listView_basicAction_LBL_ADD_RECORD']")
	private WebElement AddLeadButton;

	public LeadsPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void clickOnAddLeadButton() {
		AddLeadButton.click();
	}

}
