/**
 *benudharmunda
 * 30-Aug-2024
 *
 */
package com.bd.benu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.benu.model.CountryMaster;
import com.bd.benu.repositary.CountryMasterRepositray;

/**
 * benudharmunda
 * 30-Aug-2024
 */

@Service
public class CountryMasterServiceImpl implements CountryMasterService{
	
	@Autowired
	private CountryMasterRepositray countryMasterRepositray;

	@Override
	public boolean createCountry(CountryMaster countryMaster) {
		
		CountryMaster save = countryMasterRepositray.save(countryMaster);
		
		return save.getCountryId()!=null;
	}

	@Override
	public List<CountryMaster> getAllCountry() {
		
		return countryMasterRepositray.findAll();
	}

}
