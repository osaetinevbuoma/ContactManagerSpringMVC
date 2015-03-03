package com.contactmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Contact {
    @Id
    @SequenceGenerator(name = "contactGen", sequenceName = "CONTACT_GEN")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "contactGen")
    @Column
    private Long id;
    
    @NotNull(message = "First name is required")
    @Size(max = 50, message = "First Name cannot be more than 50 characters")
    @Column
    private String firstName;
    
    @NotNull(message = "Surname is required")
    @Size(max = 50, message = "Surname cannot be more than 50 characters")
    @Column
    private String surname;

    @Size(max = 255)
    @Column
    private String image;
    
    @NotNull(message = "Description is required")
    @Size(max = 2000000, message = "Description is too long")
    @Column
    private String description;
    
    @Column
    private Calendar dateCreated;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<Email> emails = new HashSet<Email>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<Phone> phones = new HashSet<Phone>();

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Calendar dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
