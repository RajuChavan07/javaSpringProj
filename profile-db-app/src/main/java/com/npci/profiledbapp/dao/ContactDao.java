package com.npci.profiledbapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.npci.profiledbapp.beans.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer>{	

	// public Contact getContacts(int id);
}
