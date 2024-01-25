package com.example.demo_motu.repository;

import com.example.demo_motu.entity.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, String> {
}
