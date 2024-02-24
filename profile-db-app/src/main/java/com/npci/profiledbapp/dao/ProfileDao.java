package com.npci.profiledbapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.npci.profiledbapp.beans.Profile;

public interface ProfileDao  extends JpaRepository<Profile, Integer>{
	@Query("select p from Profile p where p.phone = ?1")
	public Optional<Profile> findByPhone(long phone);
	
	// service layer calls Optional<Profile> op = findByPhone()
		// op.orElseThrow(() => exception-object): returns profile or throws ProfileNotFoundException
		// update query with @Modify
		@Modifying
		@Query("update Profile p set p.name = ?2 where p.phone = ?1")
		public int updateNameByPhone(String name, long phone);
}
