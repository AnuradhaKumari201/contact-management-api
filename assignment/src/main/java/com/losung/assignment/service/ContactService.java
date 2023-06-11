package com.losung.assignment.service;

import com.losung.assignment.domain.Contact;
import com.losung.assignment.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;


    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContact(Long id) {
        return contactRepository.findById(id);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void updateContact(Long id, Contact contact) {
        boolean contactExists = contactRepository.existsById(id);
        if (contactExists) {
            Contact contct = getContact(id).get();
            contct.setFirstName(contact.getFirstName());
            contct.setLastName(contact.getLastName());
            contct.setPhoneNumber(contact.getPhoneNumber());
            contct.setEmail(contact.getEmail());
            contactRepository.save(contct);
        }
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> findByFirstName(String firstName) {
            return contactRepository.findByFirstNameEqualsIgnoreCase(firstName);
    }

    public List<Contact> findByLastName(String lastName) {
        return contactRepository.findByLastNameEqualsIgnoreCase(lastName);
    }

    public List<Contact> findByEmail(String email) {
        return contactRepository.findByEmailEqualsIgnoreCase(email);
    }
}
