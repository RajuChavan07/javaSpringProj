package com.npci.profiledbapp.service;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;

import com.npci.profiledbapp.MyException.ProfileNotFoundException;
import com.npci.profiledbapp.beans.Contact;
import com.npci.profiledbapp.beans.Profile;

public interface ProfileService {
	public Profile store (Profile profile); //must call dao.save (Profile)
	public Profile fetchProfile(int id) throws ProfileNotFoundException; // calls dao.findByID(id)
	public List<Profile> findProfiles(); // call dao.findAll()
	public Profile findProfile(long phone) throws ProfileNotFoundException; // calls dao.findPhone(phone)
	public Profile updateProfilePhone(int id, long phone) throws ProfileNotFoundException;  // calls find Profile(), setPhone()
	public void deleteProfile(int id) throws ProfileNotFoundException;
	
	// below code to update the name by phone number
	public Profile updateNameByPhone(long phone, String name) throws ProfileNotFoundException;
	public Contact saveContact(Contact contact, int id) throws ProfileNotFoundException;
 
}
