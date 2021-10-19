package com.aptem.tests;


import org.testng.annotations.Test;

import com.aptemui.base.ActionMethods;
import com.aptemui.base.BaseDriver;
import com.aptemui.extent.ExtentTestManager;
import com.aptemui.utils.ResourceHandler;

public class TenantLevelTest extends BaseDriver{
	
	
//	private SignInPageObject signInPageObject;
	//=new SignInPageObject(BaseDriver.driver);
	
	
	@Test
	public void disableComplianceDocumentsAtTenantLevel() {
		
		signInPageObject.enterUsername(ResourceHandler.getPropValue("app_username"))	;	
//		  .clickNext()
//		  .clickTenant()
//		  .clickDefaultTenant()
//		  .clickNextAfterSelectedTenant()
//		  .enterPassword(ResourceHandler.getPropValue("app_password"))
//		  .clickSignInButton()
//		  .searchTenant("laxmi")
//		  .clickTenantSearchButton()
//		  .clickTenantURLLink("laxmi", "disable") 
//		  .navigateToLearnersAccount(ResourceHandler.getPropValue("learner_url"))
//		  .signInLearnerAccount(
//				  ResourceHandler.getPropValue("learner_username"),
//				  ResourceHandler.getPropValue("learner_password")
//				  )
//		  .clickSideMenuAndLearningPlan()
//		  .verifyContent("Learning Plan")
		  ;
		 
		
		
		
		
	}
	
	@Test
	public void enableComplianceDocumentsAtTenantLevel() {
		
		signInPageObject.enterUsername(ResourceHandler.getPropValue("app_username"))
		.clickNext();//locator changed for fail
		;	
		/*
		 * .clickNext() .clickTenant() .clickDefaultTenant()
		 * .clickNextAfterSelectedTenant()
		 * .enterPassword(ResourceHandler.getPropValue("app_password"))
		 * .clickSignInButton() .searchTenant("laxmi") .clickTenantSearchButton()
		 * .clickTenantURLLink("laxmi", "enable")
		 * .navigateToLearnersAccount(ResourceHandler.getPropValue("learner_url"))
		 * .signInLearnerAccount( ResourceHandler.getPropValue("learner_username"),
		 * ResourceHandler.getPropValue("learner_password") )
		 * .clickSideMenuAndLearningPlan() .verifyContent("Learning Plan") ;
		 */
	
	
	}
	
	@Test
	public void  addDocumentsToTheLearnersProgramme() {
		
		try {
			//String name = ActionMethods.getSaltString();
			String name="auto-test";
			signInPageObject 
			.enterUsername(ResourceHandler.getPropValue("app_username"));
//							.clickNext()
//							  .clickTenant() 
//							  .clickDefaultTenant()
//							  .clickNextAfterSelectedTenant()
//							  .enterPassword(ResourceHandler.getPropValue("app_password"))
//							  .clickSignInButton()
//							  .searchTenant("laxmi")
//							  .clickTenantSearchButton()
//							  .clickTenantURLLinkForLearnerProgramme("laxmi", "enable", name)
//							  .navigateToLearnersAccount(ResourceHandler.getPropValue("laxmi_profile_url"))
//							  .clickRefreshIconOfComplianceDocuments()
//							  .clickUpdateForLearnersProgramme(name)
//							  .clickYesOfCommitmentStatement()
//			  .navigateToLearnersAccount(ResourceHandler.getPropValue("learner_url"))
//			  .signInLearnerAccount(
//					  ResourceHandler.getPropValue("learner_username"),
//					  ResourceHandler.getPropValue("learner_password")
//					  )
//			  .clickSideMenuAndLearningPlan()
//			  .verifyContentNOTDisplayed("Learning Plan")
//			  .clickSideMenuAndDocuments()
//			  .clickActionsRequired()
//			 //// .clickReviewSign()
//			  .clickSign(name)
//			  .switchToSignWindowAndClickHereToSign()
//			  .clickSaveForReviewSign()
//			  .pageRefresh()
//			  .verifyContent("Learning Plan")
//			  ;
		} catch (Exception | AssertionError e) {
			ExtentTestManager.logEventToReport("error", e.getMessage(), " Test steps has not been completed");
		}
	
	
	}
	

}
