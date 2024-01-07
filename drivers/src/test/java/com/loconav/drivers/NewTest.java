package com.loconav.drivers;

import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.loconav.utils.BrowserUtils;
import com.microsoft.playwright.Page;

public class NewTest {
	BrowserUtils browserUtils;
	Page page;
	InitPage initPage;
	LoginPage loginPage;
	VehiclesPage vehiclesPage;
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		browserUtils=new BrowserUtils();
		page=browserUtils.startBrowser("chrome");
		initPage= new InitPage(page);
		loginPage=initPage.navigateToURL();
		vehiclesPage=loginPage.loginToLocoNavApp(null, null);
	}
@AfterMethod
public void afterMethod(){
	
}
@Test
public void newTest() throws Exception{
vehiclesPage.searchVehicles("");
	        
}
}
