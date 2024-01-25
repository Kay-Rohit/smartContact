package com.example.demo_motu.services;

import com.example.demo_motu.dto.ContactDetailsResponse;
import com.example.demo_motu.entity.ContactDetails;
import com.example.demo_motu.repository.ContactDetailsRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactDetailsService {

    private final ContactDetailsRepository contactDetailsRepository;

    public ContactDetailsService(ContactDetailsRepository contactDetailsRepository) {
        this.contactDetailsRepository = contactDetailsRepository;
    }

    public List<ContactDetails> showAllContacts()
    {
        return contactDetailsRepository.findAll();
    }

    public ContactDetails showContactById(String id) throws Exception
    {
        return contactDetailsRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("No User Found with id:" + id));
    }

    public ContactDetailsResponse showFewDetailsContactById(String id) throws Exception
    {
        ContactDetails contactDetails = contactDetailsRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("No User Found with id:" + id));
        ContactDetailsResponse contactDetailsResponse = new ContactDetailsResponse();
        contactDetailsResponse.setFirstName(contactDetails.getFirstName());
        contactDetailsResponse.setAddress(contactDetails.getAddress());

        return contactDetailsResponse;
    }

    public Boolean addContacts(ContactDetails data)
    {
        ContactDetails details = contactDetailsRepository.save(data);
        System.out.println(details);
        if(details != null)
            return true;
        return false;
    }
}
