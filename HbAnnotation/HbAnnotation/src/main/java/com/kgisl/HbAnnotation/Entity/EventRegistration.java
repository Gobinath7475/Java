package com.kgisl.HbAnnotation.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "Event_Registration")
public class EventRegistration {

    @Id
    private int registration_id;

    @OneToOne
    @JoinColumn(name = "event_id", unique = true)
    private Event event;

    @OneToOne
    @JoinColumn(name = "athlete_id", unique = true)
    private Athlete athlete;

    @Column(name = "registration_date", unique = true)
    private Date registration_date;

    public EventRegistration(int registration_id, Event event, Athlete athlete, Date registration_date) {
        this.registration_id = registration_id;
        this.event = event;
        this.athlete = athlete;
        this.registration_date = registration_date;
    }

    public EventRegistration() {
    }

    public int getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(int registration_id) {
        this.registration_id = registration_id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

}