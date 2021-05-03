package com.cgi.dentistapp;

import com.cgi.dentistapp.model.Dentist;
import com.cgi.dentistapp.repository.DentistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DentistAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(DentistAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(DentistRepository dentistRepository) {
        return args -> {
            dentistRepository.save(new Dentist("Pille", "Ploom"));
            dentistRepository.save(new Dentist("Kalev", "Kaalikas"));
            dentistRepository.save(new Dentist("Mari", "Maasikas"));
            dentistRepository.save(new Dentist("Malle", "Mustikas"));
            dentistRepository.save(new Dentist("Asta", "Ananass"));
        };
    }
}
