/**
 *benudharmunda
 * 09-Sept-2024
 *
 */
package com.bd.benu.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bd.benu.model.QutoteResponseApi;

/**
 * benudharmunda
 * 09-Sept-2024
 */
@Service
public class DashboardServiceImpl implements DashboardService{
	
	private String qutoeApiUrl ="https://dummyjson.com/quotes/random";

	@Override
	public QutoteResponseApi getQutoes() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<QutoteResponseApi> forEntity = rt.getForEntity(qutoeApiUrl, QutoteResponseApi.class);
		QutoteResponseApi body = forEntity.getBody();
		
		return body;
	}
	

}
