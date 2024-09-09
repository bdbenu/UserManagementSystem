
package com.bd.benu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.benu.model.CountryMaster;
import com.bd.benu.repositary.CountryMasterRepositray;
import com.bd.benu.service.CountryMasterService;

/**
 * benudharmunda 31-Aug-2024
 */

@Controller
public class CountryMasterController {

	@Autowired
	private CountryMasterRepositray countryMasterRepositray;
	
	@Autowired
	private CountryMasterService countryMasterService;

	/*@GetMapping("/loadCountry")
	public String loadCountry(Model model) {

		CountryMaster country = new CountryMaster();
		model.addAttribute("country", country);
		return "country";
	}*/
	
	@GetMapping("/country")
	public String loadCountry(Model model) {
		
		CountryMaster country = new CountryMaster();
		model.addAttribute("country", country);
		
		return"country";
	}

	@PostMapping("/createcountry")
	public String createCountry(@ModelAttribute("country") CountryMaster country,Model model) {
		boolean createCountry = countryMasterService.createCountry(country);
		
		if(createCountry) {
			
		model.addAttribute("sucMsg", "Country Created Successfully.........");
		}else {
			model.addAttribute("failMsg", "Country Created failed.........");
		}
		
		return"country";
	}
	
	@GetMapping("/countrydetails")
	public String getCountryDetails(Model model) {
		
		List<CountryMaster> country = countryMasterService.getAllCountry();
		model.addAttribute("allCountry", country);
		
		return"countrylist";
	}

}
