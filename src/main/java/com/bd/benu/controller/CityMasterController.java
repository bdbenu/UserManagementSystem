
package com.bd.benu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.benu.model.CityMaster;
import com.bd.benu.repositary.CityMasterRepositary;

/**
 * benudharmunda 
 * 30-Aug-2024
 */
@Controller
public class CityMasterController {
	
	@Autowired
	private CityMasterRepositary cityMasterRepositary;

	@GetMapping(value = { "/", "/load" })
	public String loadCity(Model model) {

		CityMaster cityMaster = new CityMaster();
		model.addAttribute("cityMaster", cityMaster);
		
		return "citymaster";
	}
	
	@PostMapping("/createCity")
	public String createCity(CityMaster cityMaster,Model model) {
		
		CityMaster cityCreadetd = cityMasterRepositary.save(cityMaster);
		
		if(cityCreadetd.getCityId()!=null) {
			
			model.addAttribute("sucMsg", " City Creadted Successfully....");
		}else {
			model.addAttribute("failMsg", " City Creadted Failed....");
		}
		
		return "citymaster";
	}

}
