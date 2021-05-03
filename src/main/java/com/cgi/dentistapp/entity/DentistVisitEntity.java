package com.cgi.dentistapp.entity;
import javax.persistence.*;
import java.util.Date;
@Entity
public class DentistVisitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dentistName;
    private Date visitTime;
    public DentistVisitEntity(String dentistName, Date visitTime) {
        this.dentistName = dentistName;
        this.visitTime = visitTime;
    }
    public DentistVisitEntity() {
    }
    public Long getId() {
        return id;
    }
    public String getDentistName() {
        return dentistName;
    }
    public Date getVisitTime() {
        return visitTime;
    }
}
