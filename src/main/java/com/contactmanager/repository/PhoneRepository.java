package com.contactmanager.repository;

import com.contactmanager.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oevbuoma on 3/2/15.
 */
public interface PhoneRepository extends JpaRepository<Phone, Long>{
}
