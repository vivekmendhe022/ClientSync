package object.repository.leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.utility.WebDriverUtility;

public class CreateNewLeadPage extends WebDriverUtility {

	@FindBy(xpath = "//input[@id='Leads_editView_fieldName_lastname']")
	private WebElement LastNameTextField;

	@FindBy(xpath = "//div[@id='s2id_autogen3']//a[@class='select2-choice']")
	private WebElement LeadSourceDropDownList;

	@FindBy(xpath = "//div[@id='select2-result-label-54']")
	private WebElement LeadSourceWithWebSite;

	@FindBy(xpath = "//div[@id='s2id_autogen5']//a[@class='select2-choice']")
	private WebElement IndustryDropDownList;

	@FindBy(xpath = "//div[text()='Chemicals']")
	private WebElement IndustryWithChemicals;

	@FindBy(xpath = "//div[text()='Technology']")
	private WebElement IndustryWithTechnology;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement SaveButton;

	public CreateNewLeadPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createNewLeadWithLeadSource(String LASTNAME) {
		LastNameTextField.sendKeys(LASTNAME);
		LeadSourceDropDownList.click();
		LeadSourceWithWebSite.click();
		SaveButton.click();
	}

	public void createNewLeadWithIndustry(WebDriver d, String LASTNAME) throws InterruptedException {
		LastNameTextField.sendKeys(LASTNAME);
		IndustryDropDownList.click();
		hoverOnWebElement(d, IndustryWithChemicals);
		waitForElementToClickAble(d, IndustryWithChemicals);
		IndustryWithChemicals.click();
		SaveButton.click();
	}

	public void createNewLeadWithTechnology(WebDriver d, String LASTNAME) throws InterruptedException {
		LastNameTextField.sendKeys(LASTNAME);
		IndustryDropDownList.click();
		hoverOnWebElement(d, IndustryWithTechnology);
		waitForElementToClickAble(d, IndustryWithTechnology);
		IndustryWithTechnology.click();
		SaveButton.click();
	}
}
