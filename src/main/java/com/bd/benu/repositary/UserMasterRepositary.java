/**
 *benudharmunda
 * 31-Aug-2024
 *
 */
package com.bd.benu.repositary;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bd.benu.model.UsersMaster;

import jakarta.transaction.Transactional;
import java.util.List;

/**
 * benudharmunda 31-Aug-2024
 */
public interface UserMasterRepositary extends JpaRepository<UsersMaster, Serializable> {

	public boolean findByEmail(String email);

	@Transactional
	@Query("UPDATE UsersMaster u SET u.password = :password WHERE u.email = :email")
	void updatePasswordByEmail(@Param("email") String email, @Param("password") String password);

	public UsersMaster findByEmailAndPassword(String email, String password);

}
