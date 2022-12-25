package com.obsqura.projectwithpom;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CommonHeadderMenuPage;
import pages.FormSubmitPage;
import pages.FormSubmitPageWithParameterization;
import utilities.DataProviderUtility;

public class FormSubmitPageWithParameterizationTest extends Base{
	CommonHeadderMenuPage commonHeadderMenuPageObj;
	FormSubmitPageWithParameterization formSubmitPageWithParameterizationObj;
	@Test
	@Parameters({ "firstNameValue","lastNameValue","userNameValue","cityValue","stateValue","zipValue"})
	public void verifyFormSubmitPage(String firstNameValue,String lastNameValue,String userNameValue,String cityValue,String stateValue,String zipValue) throws IOException {
		commonHeadderMenuPageObj=new CommonHeadderMenuPage(driver);
		commonHeadderMenuPageObj.leftSideMenuClick("Form Submit");
		formSubmitPageWithParameterizationObj=new FormSubmitPageWithParameterization(driver);
		formSubmitPageWithParameterizationObj.submitFormWithParameterTestNG(firstNameValue, lastNameValue, userNameValue, cityValue, stateValue, zipValue);
		
		
		
	}
	
	
}
