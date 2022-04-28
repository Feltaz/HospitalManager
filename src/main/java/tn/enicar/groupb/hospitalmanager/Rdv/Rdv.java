package tn.enicar.groupb.hospitalmanager.Rdv;


import javax.persistence.*;
import java.time.LocalDate;

@Entity(name= "rdv")
@Table(name= "rdv")
public class Rdv {
    @Id
    @SequenceGenerator(name = "rdv_seq", sequenceName = "rdv_seq", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rdv_seq")
    private Long id;
    private LocalDate dateRdv;
    public Rdv(){}
    public Rdv(LocalDate dateRdv) {
        this.dateRdv = dateRdv;
    }

    public Rdv(Long id, LocalDate dateRdv) {
        this.id = id;
        this.dateRdv = dateRdv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(LocalDate dateRdv) {
        this.dateRdv = dateRdv;
    }

    @Override
    public String toString() {
        return "Rdv{" +
                "id=" + id +
                ", dateRdv=" + dateRdv +
                '}';
    }
    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rdv rdv = (Rdv) o;

        return id.equals(rdv.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
