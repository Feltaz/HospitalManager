package tn.enicar.groupb.hospitalmanager.Salle;
import tn.enicar.groupb.hospitalmanager.Patient.Patient;

import java.util.List;

public class Salle {
    private int id;
    private List<Patient> patients;
    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
