package com.loconav.drivers;

import com.loconav.datahelpers.RepoReader;
import com.microsoft.playwright.Page;

public class VehiclesPage extends InitPage {
	RepoReader VehicleRepo;
	
 public VehiclesPage(Page page) throws Exception{
	 super(page);
	 VehicleRepo=new RepoReader();

	}
 public VehiclesPage searchVehicles(String serialNo) throws Exception {
	 String txtSearch=VehicleRepo.getSelectorFor("txtSearch");
	 playwrightUtils.fill(txtSearch, serialNo);
	 return new VehiclesPage(page);
 }

}
