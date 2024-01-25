package com.example.demo_motu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetails {
    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String notes;

}
