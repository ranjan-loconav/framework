package com.loconav.driverspage;

import java.util.Map;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.loconav.datahelpers.PropertiesReader;
import com.loconav.datahelpers.RepoReader;
import com.loconav.utils.BrowserUtils;
import com.microsoft.playwright.Page;

public class NewTest extends BaseTestClass{


	Properties props;
	InitPage initPage;
	HomePage homePage;
	MyDriversPage driversPage;
	Page page;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		props = new PropertiesReader().readPropertyFile();
		String browserSelected=System.getProperty("browser") != null?System.getProperty("browser").toLowerCase():"chrome";
		page = new BrowserUtils().startBrowserUsingSessionFile(browserSelected);
		initPage = new InitPage(page);
		homePage =initPage.landOnHomePage();
	}
	
	@Test
	public void verifyDriversPageTranslations() throws Exception {
		driversPage = homePage.NavigateToDriversPage();
		Map<String,Object> repoReader = new RepoReader().returnLangMap("DriversPage.json", "DriversPage");
		initPage.verifyTranslations(repoReader);
	}
	
	@Test
	public void verifyAddDriverModalTranslations() throws Exception {
		driversPage = homePage.NavigateToDriversPage();
		driversPage.clickAddDrivers();
		Map<String,Object> labelsAndButtons = new RepoReader().returnLangMap("DriversPage.json", "Add Driver labels buttons");
		initPage.verifyTranslations(labelsAndButtons);
		driversPage.clickSaveDriver();
		Map<String,Object> errormsgs = new RepoReader().returnLangMap("DriversPage.json", "Modal Errors");
		initPage.verifyTranslations(errormsgs);
	}
	
	@AfterMethod(alwaysRun = true)
	public void killBrowser() {
		initPage.killBrowser();
	}
	
}
