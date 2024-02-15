package com.letcode.SecureBankSystem.controller;

import com.letcode.SecureBankSystem.bo.CreateContactRequest;
import com.letcode.SecureBankSystem.bo.CreateFarewellRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CodedController {
    private List<CreateContactRequest> contacts = new ArrayList<>();

    private boolean contactExists(String name) {
        return contacts.stream().anyMatch(c -> c.getName().equals(name));
    }

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Welcome Razan Alshatti";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello " + name + "!";
    }


    @GetMapping("/getContactDetails")
    public ResponseEntity<Object> getContactDetails(@RequestParam String name) {
        Optional<CreateContactRequest> foundContact = contacts.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();

        if (foundContact.isPresent()) {
            return ResponseEntity.ok(foundContact.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found.");
        }
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody CreateFarewellRequest fields) {
        String name = fields.getName();
        return "Goodbye," + name;
    }

    @PostMapping("/addContact")
    public ResponseEntity<String> addContact(@RequestBody CreateContactRequest contact) {
        if (contactExists(contact.getName())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Contact already exists! \n Pleae try again.");
        }
        contacts.add(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body("Contact Added Successfully!");
    }
}

