package com.loconav.drivers;

import com.loconav.datahelpers.RepoReader;
import com.microsoft.playwright.Page;

public class LoginPage extends InitPage{
	RepoReader loginRepo;
	
	public LoginPage(Page page) throws Exception {
		super(page); 
		loginRepo= new RepoReader();
	}
public VehiclesPage loginToLocoNavApp(String username, String password) throws Exception{
	String txtUsername = loginRepo.getSelectorFor("txtUsername");
	String txtPassword = loginRepo.getSelectorFor("txtPassword");
	String btnSigIn = loginRepo.getSelectorFor("btnLogin");
	playwrightUtils.fill(txtUsername, username)	
               .fill(txtPassword, password)
               .click(btnSigIn);
return new VehiclesPage(page);
}

	}


