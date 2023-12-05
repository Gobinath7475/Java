package com.KGiSL.JpaProject;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
// import jakarta.persistence.ManyToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int s_id;
    private String s_name;

    @ManyToMany(targetEntity = Library.class)
    private List lib;

    public Student(int s_id, String s_name, List lib) {
        super();
        this.s_id = s_id;
        this.s_name = s_name;
        this.lib = lib;
    }

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List getLib() {
        return lib;
    }

    public void ListLib(List lib) {
        this.lib = lib;
    }

    public int getS_id() {
        return s_id;
    }

    public void ListS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void ListS_name(String s_name) {
        this.s_name = s_name;
    }
}