package com.contactmanager.controllers;

import com.contactmanager.domain.Contact;
import com.contactmanager.repository.ContactRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

@Controller
@Transactional
@RequestMapping(value = {"/", "/contact"})
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;
    
    /**
     * List all contacts
     * @param model
     * @return
     */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listContact(ModelMap model) {
		model.addAttribute("contacts", contactRepository.findAll());
        
		return "contact/list";
	}

    /**
     * Show the create contact form
     * @param model
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createContact(ModelMap model) {
        model.addAttribute("contact", new Contact());
        
        return "contact/create";
    }

    /**
     * Save contact
     * @param contact
     * @param bindingResult
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute @Valid Contact contact, BindingResult bindingResult, 
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "contact/create";
        }

        contact.setDateCreated(new GregorianCalendar());
        contact.setImage("/resources/images/default.png");
        contactRepository.save(contact);
        
        redirectAttributes.addFlashAttribute("flashMessage", contact.getFirstName() + " " + contact.getSurname() + " " +
                "was successfully added");
        return "redirect:/";
    }

    /**
     * Display contact to edit* 
     * @param contactId
     * @param modelMap
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/edit/{contactId}", method = RequestMethod.GET)
    public String editContact(@PathVariable Long contactId, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        Contact contact = contactRepository.findOne(contactId);
        if (contact == null) {
            redirectAttributes.addFlashAttribute("flashError", "The contact requested does not exist");
            return "contact/list";
        }
        
        modelMap.addAttribute("contact", contact);
        
        return "contact/edit";
    }

    /**
     * Update contact* 
     * @param contactId
     * @param contact
     * @param bindingResult
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/update/{contactId}", method = RequestMethod.POST)
    public String updateContact(@PathVariable Long contactId, @ModelAttribute @Valid Contact contact, 
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        Contact contact1 = contactRepository.findOne(contactId);
        if (contact1 == null) {
            redirectAttributes.addFlashAttribute("flashError", "The contact requested does not exist");
            return "contact/list";
        }
        
        if (bindingResult.hasErrors()) {
            return "contact/edit";
        }
        
        contact1.setFirstName(contact.getFirstName());
        contact1.setSurname(contact.getSurname());
        contact1.setDescription(contact.getDescription());
        contactRepository.save(contact1);
        
        redirectAttributes.addFlashAttribute("flashMessage", "Contact has been updated");
        return "redirect:/";
    }

    /**
     * Delete contact*
     * @param contactId
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/delete/{contactId}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable Long contactId, RedirectAttributes redirectAttributes) {
        Contact contact = contactRepository.findOne(contactId);
        if (contact == null) {
            redirectAttributes.addFlashAttribute("flashError", "The contact requested does not exist");
            return "contact/list";
        }
        
        contactRepository.delete(contact);
        
        redirectAttributes.addFlashAttribute("flashMessage", contact.getFirstName() + " " + contact.getSurname() + " " +
                "has been deleted");
        return "redirect:/";
    }

    /**
     * Show details of a contact*
     * @param contactId
     * @param modelMap
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/details/{contactId}", method = RequestMethod.GET)
    public String details(@PathVariable Long contactId, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        if (contactRepository.exists(contactId) == false) {
            redirectAttributes.addFlashAttribute("flashError", "The contact requested does not exist");
            return "contact/list";
        }
        
        Contact contact = contactRepository.findOne(contactId);
        Hibernate.initialize(contact.getEmails());
        Hibernate.initialize(contact.getPhones());
        modelMap.addAttribute("contact", contact);
        
        return "contact/details";
    }

    /**
     * Upload file to server. Still has lost of issues that needs to be straightened out*
     * @param image
     * @param contactId
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/uploadImage/{contactId}", method = RequestMethod.POST)
    public String uploadImage(@RequestParam MultipartFile image, @PathVariable Long contactId,
                              RedirectAttributes redirectAttributes) {
        if (!image.isEmpty()) {  
            if (!image.getContentType().equals("image/jpeg") && !image.getContentType().equals("image/png")
                    && !image.getContentType().equals("image/gif")) {
                redirectAttributes.addFlashAttribute("flashError", "File must be an image");
                return "redirect:/contact/details/" + contactId;
            }
            
            try {
                String filePath = "/absolute/path/to/upload/dir";
                String filename = "/dir/" + contactId + ".jpg";
                image.transferTo(new File(filePath + "/" + filename));
                
                Contact contact = contactRepository.findOne(contactId);
                contact.setImage(filename);
                contactRepository.save(contact);

                return "redirect:/contact/details/" + contactId;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        redirectAttributes.addFlashAttribute("flashError", "Please upload a file");
        return "redirect:/contact/details/" + contactId;
    }
}