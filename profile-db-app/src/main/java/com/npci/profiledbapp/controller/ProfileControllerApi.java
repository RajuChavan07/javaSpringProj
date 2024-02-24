package com.npci.profiledbapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.profiledbapp.MyException.ProfileNotFoundException;
import com.npci.profiledbapp.beans.Profile;
import com.npci.profiledbapp.service.ProfileService;

@RestController
@RequestMapping ("/api/profile")
public class ProfileControllerApi {

	@Autowired
	private ProfileService profileService;
	
	// Storing the Profile
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeApi(@RequestBody Profile profile){
		// We can directly retun responseEntity by saving the profile with HTTP status code 201
		return ResponseEntity.status(201).body(profileService.store(profile));
	}
	
	// finding the profile based on id 
	@GetMapping(path="/{id}")
	public ResponseEntity<Object> findApi (@PathVariable int id){
		try {
			return ResponseEntity.status(200).body(profileService.fetchProfile(id));
			
		}catch(ProfileNotFoundException ex) {
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage :=>", ex.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
	
	// Finding all Profiles
	@GetMapping(path="/getAllProfiles")
	public ResponseEntity<Object> getAllProfileData() {
		List <Profile> getProfileList = profileService.findProfiles();
		return ResponseEntity.status(200).body(getProfileList);
		
	}
	
	@PutMapping(path="/{phone}/{name}")
	public ResponseEntity<Object> updateNameByPhone(@PathVariable long phone, @PathVariable String name){
		try {
			return ResponseEntity.status(200).body(profileService.updateNameByPhone(phone, name));
		} catch(ProfileNotFoundException e) {
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", e.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
}
