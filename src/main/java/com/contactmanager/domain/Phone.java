package com.contactmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Phone {
    @Id
    @SequenceGenerator(name = "phoneGen", sequenceName = "PHONE_GEN")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "phoneGen")
    @Column
    private Long id;
    
    @NotNull
    @Size(max = 20, message = "Phone number cannot be more than 20 characters")
    @Column
    private String phone;
    
    @ManyToOne
    private Contact contact;

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
