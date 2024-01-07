package com.loconav.drivers;

import java.util.Properties;
import com.loconav.datahelpers.PropertiesReader;
import com.loconav.utils.PlaywrightUtils;
import com.microsoft.playwright.Page;

public class InitPage {
	public PlaywrightUtils playwrightUtils;
	public Page page;
	

	public InitPage(Page page) {
		this.page = page;
		playwrightUtils = new PlaywrightUtils(page, 60000);

	}

	public LoginPage navigateToURL() throws Exception {
		Properties props = new PropertiesReader().readPropertyFile();
		playwrightUtils.navigate(props.getProperty("appurl"));
		return new LoginPage(page);
	}

	
}
