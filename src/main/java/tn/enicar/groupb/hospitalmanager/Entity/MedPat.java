package tn.enicar.groupb.hospitalmanager.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MedPat implements Serializable {
    Long med;
    Long pat;
    Long id_cons;



    public Long getMed() {
        return med;
    }

    public void setMed(Long med) {
        this.med = med;
    }

    public Long getPat() {
        return this.pat;
    }

    public void setPat(Long pat) {
        this.pat = pat;
    }

    public Long getId_cons() {
        return id_cons;
    }

    public void setId_cons(Long id_cons) {
        this.id_cons = id_cons;
    }

    public MedPat() {
    }

    public MedPat(Long med, Long pat, Long id_cons) {
        this.med = med;
        this.pat = pat;
        this.id_cons = id_cons;
    }
}
