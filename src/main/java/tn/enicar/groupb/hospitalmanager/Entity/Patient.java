package tn.enicar.groupb.hospitalmanager.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id ;
    private String name ;
    private String email ;
    private String possibleIllness ;
    private String phone ;
    private String imageUrl ;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", possibleIllness='" + possibleIllness + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public Patient() {
    }

    public Patient(Long id, String name, String email, String possibleIllness, String phone, String imageUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.possibleIllness = possibleIllness;
        this.phone = phone;
        this.imageUrl = imageUrl;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPossibleIllness() {
        return possibleIllness;
    }

    public void setPossibleIllness(String possibleIllness) {
        this.possibleIllness = possibleIllness;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
