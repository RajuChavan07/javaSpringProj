package com.npci.profiledbapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.profiledbapp.MyException.ProfileNotFoundException;
import com.npci.profiledbapp.beans.Contact;
import com.npci.profiledbapp.beans.Profile;
import com.npci.profiledbapp.dao.ProfileDao;

import jakarta.transaction.Transactional;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	// Injecting Dao layer
	@Autowired
	private ProfileDao profileDao; // Spring injecting auto-impl dao layer

	@Override
	public Profile store(Profile profile) {
		
		return profileDao.save(profile); // Saves and return the saved entity
	}

	@Override
	public Profile fetchProfile(int id) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		return profileDao.findById(id)
				
				.orElseThrow(() -> new ProfileNotFoundException ("Profile "+ id+ " not found"));
	}

	@Override
	public List<Profile> findProfiles() {
		// TODO Auto-generated method stub
		return  profileDao.findAll();
	}

	@Override
	public Profile findProfile(long phone) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		return profileDao.findByPhone(phone).orElseThrow(() -> new ProfileNotFoundException ("Profile phone"+ phone+ " not found"));
	}

	@Override
	public Profile updateProfilePhone(int id, long phone) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		Profile profile = fetchProfile(id);
		profile.setPhone(phone);
		return profileDao.save(profile);
	}

	@Override
	public void deleteProfile(int id) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		Profile profile = fetchProfile(id);
		profileDao.delete(profile);
	}

	@Transactional // required when you use JPQL to update
	@Override
	public Profile updateNameByPhone(long phone, String name) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		profileDao.updateNameByPhone(name, phone);
		return findProfile(phone);
	}

	@Override
	public Contact saveContact(Contact contact, int id) throws ProfileNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Profile> p= profileDao.findById(id);
		//Contact c=contact.setId(p.get());
		
		return null;
	}

}
