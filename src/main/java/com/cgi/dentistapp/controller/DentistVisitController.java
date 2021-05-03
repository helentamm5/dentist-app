package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.model.Dentist;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Optional;

@Controller
@EnableAutoConfiguration
public class DentistVisitController extends WebMvcConfigurerAdapter {
    @Autowired
    private DentistVisitService dentistVisitService;

    @GetMapping("/visits")
    public String showVisits(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        model.addAttribute("visits", dentistVisitService.findAllVisits(keyword));
        return "visits";
    }

    @GetMapping("/deleteVisit/{id}")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        dentistVisitService.deleteVisitById(id);
        model.addAttribute("visits", dentistVisitService.findAllVisits(null));

        return "visits";
    }

}
