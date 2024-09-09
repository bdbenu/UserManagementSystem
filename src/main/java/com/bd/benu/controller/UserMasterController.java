/**
 *benudharmunda
 * 31-Aug-2024
 *
 */
package com.bd.benu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bd.benu.model.Dashboard;
import com.bd.benu.model.QutoteResponseApi;
import com.bd.benu.model.UsersMaster;
import com.bd.benu.repositary.UserMasterRepositary;
import com.bd.benu.service.DashboardService;
import com.bd.benu.service.UsersMasterService;
import com.bd.benu.util.EmailUitils;

import jakarta.mail.MessagingException;

/**
 * benudharmunda 31-Aug-2024
 */

@Controller
public class UserMasterController {

	@Autowired
	private UserMasterRepositary userMasterRepositary;

	@Autowired
	private EmailUitils emailUitils;
	
	@Autowired
	private DashboardService dashboardService;

	@Autowired
	private UsersMasterService masterService;

	@GetMapping(value = "/users")
	public String loadUser(Model model) {

		UsersMaster master = new UsersMaster();
		model.addAttribute("master", master);

		return "usermaster";
	}

	@GetMapping("/loadlogin")
	public String loadLogin(Model model) {

		UsersMaster master = new UsersMaster();
		model.addAttribute("master", master);

		return "login";
	}

	@PostMapping("/usercreated")
	public String userRegistartion(@ModelAttribute("master") UsersMaster master, Model model) throws MessagingException {

		System.out.println("master.getPassword()"+master.getPassword());
		System.out.println("master.getEmail()"+master.getEmail());
		boolean createUser = masterService.createUser(master);
		if (createUser) {
			model.addAttribute("sucMsg", "User Regsietr successfull.....!!!!!");
		} else {
			model.addAttribute("failMsg", "User Regsietr Failed.....!!!!!");
		}

		return "usermaster";

	}

	@GetMapping("/reset-password")
	public String resetPassword(Model model) {
		
		UsersMaster master = new UsersMaster();
		model.addAttribute("master", master);
		
		return "resetpassword";
	}
	
	@GetMapping("/resetPassword")
	public String resetPassword(@RequestParam("email") String email,Model model) {
		UsersMaster master = new UsersMaster();
		master.setEmail(email);
		model.addAttribute(email, master);
		return"resetpassword";
	}
	
	@PostMapping("/checkDupicateEmail")
	public String duplicateEmailCheck(UsersMaster master,Model model) {
		 boolean findByEmail = masterService.findByEmail(master.getEmail());
		 if(findByEmail) {
			 model.addAttribute("avail", "email is alraedy exsit");
				 
			 
		 }else {
			 model.addAttribute("failMsg", "email is alraedy exsit");
			 
			 
		 }
		 
		 return "usermaster";
	}
	@PostMapping("/checkLogin")
	public String loadLoginCheck(UsersMaster master,Model model) {
		UsersMaster login = masterService.login(master);
		if(login==null) {
			model.addAttribute("emasg", "invalid credential");
		}else {
			String newPassword = login.getPwdReset();
			if("Y".equals(newPassword)) {
			return	"redirect:dashboard";
			}else {
				//display reset passwprd
				return "redirect:resetPassword?email="+master.getEmail();
			}
		}
		
		return"login";
	}
	@GetMapping("/dashboard")
	public String loadDashboard(Model model) {
		
		QutoteResponseApi qutoes = dashboardService.getQutoes();
		model.addAttribute("qutoes", qutoes);
		return"dashboard";
	}
	
	public String resetPassword(UsersMaster master,Model model) {
		boolean resetPassword = masterService.resetPassword(master);
		if(resetPassword) {
			return "redirect:dashboard";
		}
		return "resetpassword";
	}

}
