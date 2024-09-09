
package com.bd.benu.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * benudharmunda 31-Aug-2024
 */
@Entity
@Table(name = "USERS_MASTER")
public class UsersMaster {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "UNAME")
	private String uname;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;

	@Column(name = "password")
	private String password;

	@Column(name = "COUNTRY_ID")
	private String countryId;

	@Column(name = "STATE_ID")
	private String stateId;
	
	@Column(name = "CITY_ID")
	private String cityId;
	@Column(name = "PWD_RESET")
	private String pwdReset;

	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private String createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE")
	private String updatedDate;
	
	@Transient
	private String newPassword;
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getPwdReset() {
		return pwdReset;
	}

	public void setPwdReset(String pwdReset) {
		this.pwdReset = pwdReset;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
