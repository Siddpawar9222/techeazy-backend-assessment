package com.example.techeazy.student_management_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_table")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(name = "admin_name")
    private  String name ;


    @Column(name = "admin_username")
    private String username ;

    @Column(name = "admin_address")
    private String address ;
}
