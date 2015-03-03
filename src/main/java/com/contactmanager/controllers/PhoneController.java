package com.contactmanager.controllers;

import com.contactmanager.domain.Contact;
import com.contactmanager.domain.Phone;
import com.contactmanager.repository.ContactRepository;
import com.contactmanager.repository.PhoneRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@Transactional
@RequestMapping(value = "/contact/{contactId}/phone")
public class PhoneController {
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private PhoneRepository phoneRepository;

    /**
     * Save phone number for contact* 
     * @param contactId
     * @param phone
     * @return
     * @throws org.json.JSONException
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String savePhone(@PathVariable Long contactId, @RequestParam String phone) throws JSONException {
        Contact contact = contactRepository.findOne(contactId);

        Phone contactPhone = new Phone();
        contactPhone.setPhone(phone);
        contactPhone.setContact(contact);
        phoneRepository.save(contactPhone);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("id", contactPhone.getId());
        jsonObject.put("phone", contactPhone.getPhone());

        return jsonObject.toString();
    }

    /**
     * Delete an phone number of a contact 
     * @param contactId
     * @param phoneId
     * @return
     * @throws JSONException
     */
    @RequestMapping(value = "/delete/{phoneId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String deletePhone(@PathVariable Long contactId, @PathVariable Long phoneId) throws JSONException {
        Phone phone = phoneRepository.findOne(phoneId);
        phoneRepository.delete(phone);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);

        return jsonObject.toString();
    }
}
