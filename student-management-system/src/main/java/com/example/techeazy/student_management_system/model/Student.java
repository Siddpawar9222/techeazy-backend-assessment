package com.example.techeazy.student_management_system.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String name ;

    @Column(name = "student_username")
    private String username ;

    @Column(name = "student_address")
    private String address ;

    @OneToMany
    @Column(name = "student_subjects")
    @JoinTable(name="student_subject",joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "subject_id"))
     private List<Subject> subjects ;


    public Student() {
    }


    public Student(Long id, String name, String username, String address, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.address = address;
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
