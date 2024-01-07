package com.loconav.drivers;

import java.io.File;

import com.loconav.datahelpers.RepoReader;
import com.microsoft.playwright.Page;

public class MyDriverspagee extends InitPage {
	RepoReader driversRepo;
	
	public MyDriverspagee(Page page) throws Exception {
		super(page);
		driversRepo =  new RepoReader();
	}
	public MyDriverspagee verifyElements() {
		return this;
	}

	public MyDriverspagee clickAddDrivers() throws Exception {
		String btnAddDriver = driversRepo.getSelectorFor("btnAddDriver");
		String cmbCountry = driversRepo.getSelectorFor("cmbCountry");
		String optCountry = driversRepo.getSelectorFor("optCountry");
		String optCountryForguarantor = driversRepo.getSelectorFor("optCountryForguarantor");
		String name = driversRepo.getSelectorFor("name");
		String phoneNumber = driversRepo.getSelectorFor("phoneNumber");
		String personalIdentificationNumber = driversRepo.getSelectorFor("personalIdentificationNumber");
		String trackingID = driversRepo.getSelectorFor("trackingID");
		String guarantorName = driversRepo.getSelectorFor("guarantorName");
		String guarantorPhoneNumber = driversRepo.getSelectorFor("guarantorPhoneNumber");
		String clickAddDriver = driversRepo.getSelectorFor("clickAddDriver");
		playwrightUtils.click(btnAddDriver)
		               .click(cmbCountry)
		               .click(optCountry.replace("COUNTRY", "India (+91)"));
		playwrightUtils.fill(name, "ranjann123")
		               .fill(phoneNumber, "7879098776")
		               .fill(personalIdentificationNumber, "123434562345")
		               .fill(trackingID, "90io90uyttrer")
		               .fill(guarantorName, "ranjkk")
		               .fill(guarantorPhoneNumber, "7989890987");
	    playwrightUtils.click(optCountryForguarantor)
                       .click(optCountryForguarantor.replace("COUNTRY", "India (+91)"))
                       .uploadFile(() -> page.locator("//*[@name='profilePicture.image']//parent::label").click(), 
							   System.getProperty("user.dir")+File.separator+"pom.xml")
                       .click(clickAddDriver);
		return new MyDriverspagee(page);
	}
	public MyDriverspagee searchDrivers() throws Exception {
		 String txtSearch=driversRepo.getSelectorFor("txtSearch");
		 playwrightUtils.fill(txtSearch, "ran");
		 return new MyDriverspagee(page); 
		
	}
	


}
