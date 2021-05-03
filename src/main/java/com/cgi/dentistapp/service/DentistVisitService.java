package com.cgi.dentistapp.service;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.model.Dentist;
import com.cgi.dentistapp.repository.DentistRepository;
import com.cgi.dentistapp.repository.DentistVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class DentistVisitService {
    @Autowired
    private DentistRepository dentistRepository;
    @Autowired
    private DentistVisitRepository dentistVisitRepository;
    public List<Dentist> findAllDentists() {
        return dentistRepository.findAll();
    }

    public List<DentistVisitEntity> findAllVisits(String keyword) {
        if (keyword != null) {
            return dentistVisitRepository.findAll().stream().filter(visit -> visit.getDentistName().toLowerCase()
                    .contains(keyword.toLowerCase())).collect(Collectors.toList());}
        return dentistVisitRepository.findAll();
    }
    public void addVisit(String dentistName, Date visitTime) {
        System.out.println(dentistName);
        System.out.println(visitTime);
        DentistVisitEntity entity = new DentistVisitEntity(dentistName, visitTime);
        dentistVisitRepository.save(entity);
    }
    public DentistVisitEntity getVisitById(long id) {
        DentistVisitEntity optional = dentistVisitRepository.findOne(id);
        DentistVisitEntity visit = null;
        if (optional != null) {
            visit = optional;
        } else {
            throw new RuntimeException(" Visit not found for id :: " + id);
        }
        return visit;
    }
    public void deleteVisitById(long id) {
        this.dentistVisitRepository.delete(id);
    }
}
