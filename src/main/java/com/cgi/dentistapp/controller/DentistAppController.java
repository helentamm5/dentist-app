package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.model.Dentist;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {
    @Autowired
    private DentistVisitService dentistVisitService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping()
    public List<Dentist> getAllDentists() {
        return dentistVisitService.findAllDentists();
    }

    @GetMapping("/")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO, Model model) {
        model.addAttribute("dentists", dentistVisitService.findAllDentists());
        return "form";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult, Model model) {
        boolean exists = false;
        List<DentistVisitEntity> visits = dentistVisitService.findAllVisits(null);
        DentistVisitEntity entity = new DentistVisitEntity(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
        for (DentistVisitEntity visit : visits) {
            if (visit.getDentistName().equals(entity.getDentistName()) && visit.getVisitTime().compareTo(entity.getVisitTime()) == 0) {
                exists = true;
                break;
            }
        }
        if (bindingResult.hasErrors() || exists) {
            final String errorMessage = "See aeg on juba broneeritud!";
            model.addAttribute("dentists", dentistVisitService.findAllDentists());
            model.addAttribute("errorMessage", errorMessage);
            return "form";
        }
        dentistVisitService.addVisit(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
        return "redirect:/visits";
    }


}
