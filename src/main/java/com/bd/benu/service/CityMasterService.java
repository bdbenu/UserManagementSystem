/**
 * 30-Aug-2024
 *
 */
package com.bd.benu.service;

import java.util.List;

import com.bd.benu.model.CityMaster;

/**
 * benudharmunda
 * 30-Aug-2024
 */
public interface CityMasterService {

	
	public boolean createCity(CityMaster cityMaster);
	
	public List<CityMaster> getAllCityies();
	
}
