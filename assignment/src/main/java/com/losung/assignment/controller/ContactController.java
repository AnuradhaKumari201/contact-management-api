package com.losung.assignment.controller;

import com.losung.assignment.domain.Contact;
import com.losung.assignment.service.ContactService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/contact")
@SecurityRequirement(name = "apikey")
public class ContactController implements AbstractContactController {

    @Autowired
    ContactService contactService;


    @GetMapping("/")
    public ResponseEntity<List<Contact>> getAllContacts() {
        try {
            return ResponseEntity.ok(contactService.getAllContacts());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        try {
            Optional<Contact> optionalContact = contactService.getContact(id);
            if (optionalContact.isPresent()) {
                return ResponseEntity.ok(optionalContact.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PostMapping({"/"})
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        try {
            contactService.createContact(contact);
                return ResponseEntity.ok(contact);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PutMapping({"/save/{id}"})
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        try {
            contactService.updateContact(id, contact);
            return ResponseEntity.ok(contact);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        try {
            contactService.deleteContact(id);
            return ResponseEntity.ok("Contact successfully deleted with id " + id);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/firstName")
    public ResponseEntity<List<Contact>> getByFirstName(@RequestParam String firstName) {
        try {
            return ResponseEntity.ok(contactService.findByFirstName(firstName));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/lastName")
    public ResponseEntity<List<Contact>> getByLastName(@RequestParam String lastName) {
        try {
            return ResponseEntity.ok(contactService.findByLastName(lastName));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/email")
    public ResponseEntity<List<Contact>> getByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(contactService.findByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
