package tn.enicar.groupb.hospitalmanager.Salle;
import tn.enicar.groupb.hospitalmanager.Patient.Patient;
import tn.enicar.groupb.hospitalmanager.Service.Service;

import javax.persistence.*;
import java.util.List;

@Entity(name="salle")
@Table(name="salle")
public class Salle {
    @Id
    @SequenceGenerator(name="seq_salle", sequenceName="seq_salle", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_salle")
    private long id;
    @OneToMany(mappedBy = "salle")
    private List<Patient> patients;
    @ManyToOne
    private Service service;
    public Salle(long id, List<Patient> patients) {
        this.id = id;
        this.patients = patients;
    }

    public Salle() {
    }

    public Salle(List<Patient> patients) {
        this.patients = patients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
