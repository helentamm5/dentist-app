package com.cgi.dentistapp.repository;

import com.cgi.dentistapp.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
