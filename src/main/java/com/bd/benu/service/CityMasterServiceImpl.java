/**
 *benudharmunda
 * 30-Aug-2024
 *
 */
package com.bd.benu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.benu.model.CityMaster;
import com.bd.benu.repositary.CityMasterRepositary;

/**
 * benudharmunda
 * 30-Aug-2024
 */

@Service
public class CityMasterServiceImpl implements CityMasterService{
	
	@Autowired
	private CityMasterRepositary cityMasterRepositary;

	@Override
	public boolean createCity(CityMaster cityMaster) {
		
		CityMaster citymaster = cityMasterRepositary.save(cityMaster);
		
		if(citymaster.getCityId()!=null) {
			
		}
		
		return false;
	}

	@Override
	public List<CityMaster> getAllCityies() {
		
		return cityMasterRepositary.findAll();
	}

}
