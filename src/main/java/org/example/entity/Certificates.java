package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "certificate_details")
public class Certificates {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getE1() {
        return e1;
    }

    public void setE1(Employee e1) {
        this.e1 = e1;
    }

    public int getCertificate_id() {
        return certificate_id;
    }

    public void setCertificate_id(int certificate_id) {
        this.certificate_id = certificate_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int certificate_id;

    private String title;

    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Employee e1;
}
