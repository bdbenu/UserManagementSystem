
package com.bd.benu.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.benu.model.UsersMaster;
import com.bd.benu.repositary.UserMasterRepositary;
import com.bd.benu.util.EmailUitils;
import com.bd.benu.util.UsersUtils;

@Service
public class UsersMasterImpl implements UsersMasterService {
	
	@Autowired
	private EmailUitils emailUitils;

	@Autowired
	private UserMasterRepositary masterRepositary;

	@Override
	public boolean createUser(UsersMaster master) {
		
		master.setPwdReset("N");
		master.setPassword(UsersUtils.generatePassword(6));
		
		System.out.println(master.getPassword());
		try {
			emailUitils.sendEmail(master.getEmail(), "Password", master.getPassword());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UsersMaster save = masterRepositary.save(master);
		return save.getUserId()!=null;
	}

	@Override
	public boolean findByEmail(String email) {
		
		return masterRepositary.findByEmail(email);
	}

	@Override
	public void updatePassword(String email, String password) {
		masterRepositary.updatePasswordByEmail(email, password);
	}

	@Override
	public UsersMaster login(UsersMaster master) {
		
		UsersMaster findByEmailAndPassword = masterRepositary.findByEmailAndPassword(master.getEmail(), master.getPassword());
		if(findByEmailAndPassword!=null) {
			return findByEmailAndPassword;
		}
		return null;
	}

	@Override
	public boolean resetPassword(UsersMaster master) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Integer, String> getAllCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getAllStste(Integer countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getAllCity(Integer stateId) {
		// TODO Auto-generated method stub
		return null;
	}

}
