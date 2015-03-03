package com.contactmanager.repository;

import com.contactmanager.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by oevbuoma on 3/2/15.
 */
public interface EmailRepository extends JpaRepository<Email, Long> {
}
