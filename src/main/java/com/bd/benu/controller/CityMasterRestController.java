/**
 *benudharmunda
 * 30-Aug-2024
 *
 */
package com.bd.benu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * benudharmunda
 * 30-Aug-2024
 */
@RestController
public class CityMasterRestController {
	
	@GetMapping("/test")
	public String testApi() {
		
		return"API TESTED";
	}

}
