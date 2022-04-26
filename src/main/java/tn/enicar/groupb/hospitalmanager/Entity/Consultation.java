package tn.enicar.groupb.hospitalmanager.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Consultation {
    @EmbeddedId
    MedPat medPat;
    Date dateDeConsul;
    int salle;
    @ManyToOne()
    @JoinColumn(name="med",referencedColumnName = "id_med",updatable = false,insertable = false)
    Medecin doctor;
    @ManyToOne()
    @JoinColumn(name="pat",referencedColumnName = "id_pat",updatable = false,insertable = false)
    Patient pat;

    public Consultation() {
    }
    public Consultation(MedPat medPat, Date dateDeConsul, int salle, Medecin doctor, Patient pat) {
        this.medPat = medPat;
        this.dateDeConsul = dateDeConsul;
        this.salle = salle;
        this.doctor = doctor;
        this.pat = pat;
    }
    public consultation(MedPat medPat, Date dateDeConsul, int salle) {
        this.medPat = medPat;
        this.dateDeConsul = dateDeConsul;
        this.salle = salle;
    }

    public MedPat getMedPat() {
        return medPat;
    }

    public void setMedPat(MedPat medPat) {
        this.medPat = medPat;
    }

    public Date getDateDeConsul() {
        return dateDeConsul;
    }

    public void setDateDeConsul(Date dateDeConsul) {
        this.dateDeConsul = dateDeConsul;
    }

    public int getSalle() {
        return salle;
    }

    public void setSalle(int salle) {
        this.salle = salle;
    }

    public Medecin getDoctor() {
        return doctor;
    }

    public void setDoctor(Medecin doctor) {
        this.doctor = doctor;
    }

    public Patient getPat() {
        return pat;
    }

    public void setPat(Patient pat) {
        this.pat = pat;
    }

    @Override
    public String toString() {
        return "consultation{" +
                "medPat=" + medPat +
                ", dateDeConsul=" + dateDeConsul +
                ", salle=" + salle +
                ", doctor=" + doctor +
                ", pat=" + pat +
                '}';
    }
}
