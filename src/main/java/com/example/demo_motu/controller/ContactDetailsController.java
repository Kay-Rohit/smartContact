package com.example.demo_motu.controller;

import com.example.demo_motu.dto.ContactDetailsResponse;
import com.example.demo_motu.entity.ContactDetails;
import com.example.demo_motu.services.ContactDetailsService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactDetailsController {

    private final ContactDetailsService contactDetailsService;

    public ContactDetailsController(ContactDetailsService contactDetailsService) {
        this.contactDetailsService = contactDetailsService;
    }

    @GetMapping("/show-contacts")
    private ResponseEntity<?> showContacts(){
        List<ContactDetails> contactDetails = contactDetailsService.showAllContacts();
        if(contactDetails.isEmpty())
            return ResponseEntity.ok().body("No Data found");
        return ResponseEntity.ok().body(contactDetails);
    }

    @GetMapping("/show-contact/{id}")
    private ResponseEntity<?> showContact(@NotNull @PathVariable String id){
        try {
//            ContactDetails contactDetail = contactDetailsService.showContactById(id);
            ContactDetailsResponse contactDetail = contactDetailsService.showFewDetailsContactById(id);
            return ResponseEntity.ok(contactDetail);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(300).body(e.getMessage());
        }

    }
    
    @PostMapping("/add-contact")
    private ResponseEntity<?> addContacts(@RequestBody ContactDetails data){
        Boolean flag = contactDetailsService.addContacts(data);
        if(flag)
            return ResponseEntity.ok().body("added successfully");
        return ResponseEntity.badRequest().body("Something went wrong");
    }
}
