package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.DataProviderUtility;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class FormSubmitPageWithParameterization {
	WebDriver driver;
	By firstNameField=By.xpath("//input[@id='validationCustom01']");
	By lastNameField=By.xpath("//input[@id='validationCustom02']");
	By userNameField=By.xpath("//input[@id='validationCustomUsername']");
	By cityField=By.xpath("//input[@id='validationCustom03']");
	By stateField=By.xpath("//input[@id='validationCustom04']");
	By zipField=By.xpath("//input[@id='validationCustom05']");
	By checkBoxField=By.xpath("//input[@id='invalidCheck']");
	By submitFormButton=By.xpath("//button[@class='btn btn-primary']");
	By message=By.xpath("//div[@id='message-one']");
	public FormSubmitPageWithParameterization(WebDriver driver) {
		this.driver=driver;
	}
	public void submitFormWithParameterTestNG(String firstNameValue,String lastNameValue,String userNameValue,String cityValue,String stateValue,String zipValue) {
		driver.navigate().to("https://selenium.obsqurazone.com/form-submit.php");
		String actualMessage,expectedMessage="Form has been submitted successfully!";
		WebElement firstNameElement=driver.findElement(firstNameField);
		WebElement lastNameElement=driver.findElement(lastNameField);
		WebElement userNameElement=driver.findElement(userNameField);
		WebElement cityElement=driver.findElement(cityField);
		WebElement stateElement=driver.findElement(stateField);
		WebElement zipElement=driver.findElement(zipField);
		WebElement agreeButtonCheckBox=driver.findElement(checkBoxField);
		WebElement submitFormButtonElement=driver.findElement(submitFormButton);
		WebElement finalMessageElement=driver.findElement(message);
		firstNameElement.sendKeys(firstNameValue);
		lastNameElement.sendKeys(lastNameValue);
		userNameElement.sendKeys(userNameValue);
		cityElement.sendKeys(cityValue);
		stateElement.sendKeys(stateValue);
		zipElement.sendKeys(zipValue);
		if(agreeButtonCheckBox.isSelected()==false) {
		agreeButtonCheckBox.click();
		WaitUtility.waitForElementClickable(driver, checkBoxField);
		}
		Assert.assertTrue(true, "Checkbox is already selected");
		submitFormButtonElement.click();
		WaitUtility.waitForElementClickable(driver,submitFormButtonElement);
		actualMessage=finalMessageElement.getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Actual and expected messages are different");
		}
}
