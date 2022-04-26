package tn.enicar.groupb.hospitalmanager.Patient;

import tn.enicar.groupb.hospitalmanager.Salle.Salle;

import javax.persistence.*;

@Entity(name="patient")
@Table(name="patient")
public class Patient {
    @Id
    @SequenceGenerator(name="seq_patient", sequenceName = "seq_patient",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_patient")
    private long id;
    private String name;
    @ManyToOne
    private Salle salle;

    public Patient(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Patient(String name) {
        this.name = name;

    }
    public Patient(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
