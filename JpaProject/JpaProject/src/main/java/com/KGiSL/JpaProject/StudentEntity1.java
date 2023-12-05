package com.KGiSL.JpaProject;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class StudentEntity1 {

    @Id
    private int s_id;
    private String s_name;
    private int s_age;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Subject sub;

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sb1) {
        this.sub = sb1;
    }

    public StudentEntity1(int s_id, String s_name, int s_age, Subject sub) {
        super();
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_age = s_age;
        this.sub = sub;
    }

    public StudentEntity1() {
        super();
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getS_age() {
        return s_age;
    }

    public void setS_age(int s_age) {
        this.s_age = s_age;
    }
}
