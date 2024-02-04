package com.letcode.SecureBankSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CodedController {
    private List<Contact> contacts = new ArrayList<>();

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Welcome to Coded";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody Fields fields) {
        String name = fields.getName();
        return "Goodbye," + name;
    }

    @PostMapping("/addContact")
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        if (contactExists(contact.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Contact already exists! \n Pleae try again.");
        }
        contacts.add(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body("Contact Added Successfully!");
    }

    private boolean contactExists(String name) {
        return contacts.stream().anyMatch(c -> c.getName().equals(name));
    }

    @GetMapping("/getContactDetails")
    public ResponseEntity<Object> getContactDetails(@RequestParam String name) {
        Optional<Contact> foundContact = contacts.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();

        if (foundContact.isPresent()) {
            return ResponseEntity.ok(foundContact.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found.");
        }
    }
}

