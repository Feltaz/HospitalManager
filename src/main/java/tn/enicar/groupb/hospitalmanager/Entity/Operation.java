package tn.enicar.groupb.hospitalmanager.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Operation {
    @EmbeddedId
    MedPatOp op;
    Date dateOperation;
    int numSalle;
    @ManyToOne()
    @JoinColumn(name="medOp",referencedColumnName = "id_med",updatable = false,insertable = false)
    Medecin docteurResponsable;
    @ManyToOne()
    @JoinColumn(name="patOp",referencedColumnName = "id_pat",updatable = false,insertable = false)
    Patient patientOpéré;

    @ManyToMany
    Set<Medecin> medecinsParticipants;

    public Operation() {
    }

    public Operation(MedPatOp op, Date dateOperation, int numSalle, Set<Medecin> medecinsParticipants) {
        this.op = op;
        this.dateOperation = dateOperation;
        this.numSalle = numSalle;
        this.medecinsParticipants = medecinsParticipants;
    }

    public MedPatOp getOp() {
        return op;
    }

    public void setOp(MedPatOp op) {
        this.op = op;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public Medecin getDocteurResponsable() {
        return docteurResponsable;
    }

    public void setDocteurResponsable(Medecin docteurResponsable) {
        this.docteurResponsable = docteurResponsable;
    }

    public Patient getPatientOpéré() {
        return patientOpéré;
    }

    public void setPatientOpéré(Patient patientOpéré) {
        this.patientOpéré = patientOpéré;
    }

    public Set<Medecin> getMedecinsParticipants() {
        return medecinsParticipants;
    }

    public void setMedecinsParticipants(Set<Medecin> medecinsParticipants) {
        this.medecinsParticipants = medecinsParticipants;
    }

    @Override
    public String
    toString() {
        return "operation{" +
                "op=" + op +
                ", dateOperation=" + dateOperation +
                ", numSalle=" + numSalle +
                ", docteurResponsable=" + docteurResponsable +
                ", patientOpéré=" + patientOpéré +
                ", medecinsParticipants=" + medecinsParticipants +
                '}';
    }
}
