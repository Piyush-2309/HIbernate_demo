package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "certificate_details")
public class Certificates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int certificate_id;

    private String title;

    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Employee e1;
}
