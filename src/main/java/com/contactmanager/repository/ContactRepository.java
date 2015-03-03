package com.contactmanager.repository;

import com.contactmanager.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oevbuoma on 3/2/15.
 */
public interface ContactRepository extends JpaRepository<Contact, Long>{
}
