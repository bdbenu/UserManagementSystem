/**
 *benudharmunda
 * 30-Aug-2024
 *
 */
package com.bd.benu.service;

import java.util.List;

import com.bd.benu.model.CountryMaster;

/**
 * benudharmunda 30-Aug-2024
 */
public interface CountryMasterService {

	public boolean createCountry(CountryMaster countryMaster);

	public List<CountryMaster> getAllCountry();

}
