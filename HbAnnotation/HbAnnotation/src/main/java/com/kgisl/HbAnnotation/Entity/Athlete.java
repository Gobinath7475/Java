package com.kgisl.HbAnnotation.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Athlete")
public class Athlete {

    @Id
    private int athlete_id;

    @Column(unique = true)
    private String athlete_name;

    public Athlete(int athlete_id, String athlete_name) {
        this.athlete_id = athlete_id;
        this.athlete_name = athlete_name;
    }

    public Athlete() {
    }

    public int getAthlete_id() {
        return athlete_id;
    }

    public void setAthlete_id(int athlete_id) {
        this.athlete_id = athlete_id;
    }

    public String getAthlete_name() {
        return athlete_name;
    }

    public void setAthlete_name(String athlete_name) {
        this.athlete_name = athlete_name;
    }

}
