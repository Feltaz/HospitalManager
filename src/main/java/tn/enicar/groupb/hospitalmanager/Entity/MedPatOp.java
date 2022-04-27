package tn.enicar.groupb.hospitalmanager.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class MedPatOp implements Serializable {
    Long medOp;
    Long patOp;
    Long id_op;

    public MedPatOp() {
    }

    public MedPatOp(Long medOp, Long patOp, Long id_op) {
        this.medOp = medOp;
        this.patOp = patOp;
        this.id_op = id_op;
    }

    public Long getMedOp() {
        return medOp;
    }

    public void setMedOp(Long medOp) {
        this.medOp = medOp;
    }

    public Long getPatOp() {
        return patOp;
    }

    public void setPatOp(Long patOp) {
        this.patOp = patOp;
    }

    public Long getId_op() {
        return id_op;
    }

    public void setId_op(Long id_op) {
        this.id_op = id_op;
    }

    @Override
    public String toString() {
        return "MedPatOp{" +
                "medOp=" + medOp +
                ", patOp=" + patOp +
                ", id_op=" + id_op +
                '}';
    }
}
