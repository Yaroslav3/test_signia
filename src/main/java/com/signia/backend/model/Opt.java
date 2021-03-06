package com.signia.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@ToString
@Table(name = "Opt")
public class Opt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "sessionId")
    private String sessionId;

    @Column(name = "code")
    private String code;

    @Column(name = "dateCreateOpt")
    private ZonedDateTime dateCreateOpt;

    @Column(name = "id_authorization")
    private Long idAuthorization;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_authorization", insertable = false, updatable = false)
    private Authorization aut;

    public Opt() {
    }

    public Opt(String sessionId, String code, ZonedDateTime dateCreateOpt, Long idAuthorization, Authorization aut) {
        this.sessionId = sessionId;
        this.code = code;
        this.dateCreateOpt = dateCreateOpt;
        this.idAuthorization = idAuthorization;
        this.aut = aut;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ZonedDateTime getDateCreateOpt() {
        return dateCreateOpt;
    }

    public void setDateCreateOpt(ZonedDateTime dateCreateOpt) {
        this.dateCreateOpt = dateCreateOpt;
    }

    public Long getIdAuthorization() {
        return idAuthorization;
    }

    public void setIdAuthorization(Long idAuthorization) {
        this.idAuthorization = idAuthorization;
    }

    public Authorization getAut() {
        return aut;
    }

    public void setAut(Authorization aut) {
        this.aut = aut;
    }
}
