package com.example.techeazy.student_management_system.model;

import jakarta.persistence.*;


@Entity
@Table(name = "subject_table")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long id;

    @Column(name = "subject_name")
    private String name;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name="ques_ans",joinColumns = @JoinColumn(name = "que_id"),inverseJoinColumns = @JoinColumn(name = "ans_id"))
//     private List<Answer> answers;


    public Subject() {
    }

    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Subject{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
