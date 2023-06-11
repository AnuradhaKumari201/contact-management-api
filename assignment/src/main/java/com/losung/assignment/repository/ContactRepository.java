package com.losung.assignment.repository;

import com.losung.assignment.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByFirstNameEqualsIgnoreCase(@Nullable String firstName);

    List<Contact> findByLastNameEqualsIgnoreCase(@Nullable String lastName);

    List<Contact> findByEmailEqualsIgnoreCase(@Nullable String email);
}
