package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class RegisterationPage {

	private WebDriver driver;
	private ElementUtil eleutil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '1']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '0']");
	private By agreeCheckBox = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit' and @value='Continue']");

	private By sucessMessg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	private By pop = By.linkText("pop");


	public RegisterationPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	
	@Step("user registratiom")
	public boolean userRegister(String firstName, String lastName, String email, String telephone, String password,
			String subscribe) {

		eleutil.waitForElementVisible(this.firstName, 10).sendKeys(firstName);
		eleutil.doSendKeys(this.lastName, lastName);
		eleutil.doSendKeys(this.email, email);
		eleutil.doSendKeys(this.telephone, telephone);
		eleutil.doSendKeys(this.password, password);
		eleutil.doSendKeys(this.confirmpassword, password);

		if (subscribe.equalsIgnoreCase("yes")) {
			eleutil.doClick(subscribeYes);
		} else {
			eleutil.doClick(subscribeNo);
		}

		eleutil.doClick(agreeCheckBox);
		eleutil.doClick(continueBtn);

		String regSuccessMessg = eleutil.waitForElementVisible(sucessMessg, 5).getText();
		System.out.println(regSuccessMessg);

		if (regSuccessMessg.equals(AppConstants.USER_REG_SUCCESS_MESSG)) {
			eleutil.doClick(logoutLink);
			eleutil.doClick(registerLink);
			return true;
		}
		return false;

	}

}
