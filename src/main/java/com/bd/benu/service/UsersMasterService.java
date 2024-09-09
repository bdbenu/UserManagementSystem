/**
 *benudharmunda
 * 31-Aug-2024
 *
 */
package com.bd.benu.service;

import java.util.Map;

import com.bd.benu.model.UsersMaster;

/**
 * benudharmunda 31-Aug-2024
 */
public interface UsersMasterService {

	public boolean createUser(UsersMaster master);

	public boolean findByEmail(String email);

	public void updatePassword(String email, String password);

	public UsersMaster login(UsersMaster master);

	public boolean resetPassword(UsersMaster master);
	
	public Map<Integer, String> getAllCountry();
	
	public Map<Integer, String> getAllStste(Integer countryId);
	
	public Map<Integer, String> getAllCity(Integer stateId);

}
