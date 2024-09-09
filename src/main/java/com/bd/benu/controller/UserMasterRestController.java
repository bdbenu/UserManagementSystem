/**
 *benudharmunda
 * 02-Sept-2024
 *
 */
package com.bd.benu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bd.benu.model.UsersMaster;
import com.bd.benu.service.UsersMasterService;

/**
 * benudharmunda
 * 02-Sept-2024
 */

@RestController
public class UserMasterRestController {
	@Autowired
	private UsersMasterService masterService;
	
	@GetMapping("/findbyemail")
	public UsersMaster getEmail(@RequestParam("email")String email) {
		
		return null;
	}
	
	@PutMapping("/updatepassword")
    public ResponseEntity<String> updatePassword(@Param("email") String email, @Param("password") String password) {
		masterService.updatePassword(email, password);
        return ResponseEntity.ok("Password updated successfully");
    }

}
