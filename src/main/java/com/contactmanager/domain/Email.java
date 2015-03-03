package com.contactmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Email {
    @Id
    @SequenceGenerator(name = "emailGen", sequenceName = "EMAIL_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "emailGen")
    @Column
    private Long id;
    
    @NotNull
    @Size(max = 50, message = "Email cannot be more than 50 characters")
    @Column(unique = true)
    private String email;
    
    @ManyToOne
    private Contact contact;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
