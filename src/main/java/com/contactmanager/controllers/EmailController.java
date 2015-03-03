package com.contactmanager.controllers;

import com.contactmanager.domain.Contact;
import com.contactmanager.domain.Email;
import com.contactmanager.repository.ContactRepository;
import com.contactmanager.repository.EmailRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
@RequestMapping(value = "/contact/{contactId}/email")
public class EmailController {
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private EmailRepository emailRepository;

    /**
     * Save email for contact* 
     * @param contactId
     * @param email
     * @return
     * @throws JSONException
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String saveEmail(@PathVariable Long contactId, @RequestParam String email) throws JSONException {
        Contact contact = contactRepository.findOne(contactId);
        
        Email contactEmail = new Email();
        contactEmail.setEmail(email);
        contactEmail.setContact(contact);
        emailRepository.save(contactEmail);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("id", contactEmail.getId());
        jsonObject.put("email", contactEmail.getEmail());

        return jsonObject.toString();
    }

    /**
     * Delete an email of a contact 
     * @param contactId
     * @param emailId
     * @return
     * @throws JSONException
     */
    @RequestMapping(value = "/delete/{emailId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String deleteEmail(@PathVariable Long contactId, @PathVariable Long emailId) throws JSONException {
        Email email = emailRepository.findOne(emailId);
        emailRepository.delete(email);
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        
        return jsonObject.toString();
    }
}
