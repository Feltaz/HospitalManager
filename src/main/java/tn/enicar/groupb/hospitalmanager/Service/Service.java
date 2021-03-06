package tn.enicar.groupb.hospitalmanager.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tn.enicar.groupb.hospitalmanager.Patient.Patient;
import tn.enicar.groupb.hospitalmanager.Salle.Salle;

import javax.persistence.*;
import java.util.List;

@Entity(name="service")
@Table(name="service")
public class Service {
    @Id
    @SequenceGenerator(name = "service_seq", sequenceName = "service_seq", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "service_seq")
    private long id;
    private String nom;
    private long nbLits;

@JsonIgnore
    @OneToMany(mappedBy = "service")
    private List<Salle> salleDeSoin;
@JsonIgnore
    @OneToMany(mappedBy = "service")
    private List<Salle> salleOperation;
    //getters and setters, toString and hashCode
 public Service(){}


    public Service(long id, String nom, long nbLits, List<Salle> salleDeSoin, List<Salle> salleOperation) {
        this.id = id;
        this.nom = nom;
        this.nbLits = nbLits;
        this.salleDeSoin = salleDeSoin;
        this.salleOperation = salleOperation;
    }

    public Service(long id, String nom, long nbLits, List<Salle> salleDeSoin) {
        this.id = id;
        this.nom = nom;
        this.nbLits = nbLits;
        this.salleDeSoin = salleDeSoin;
    }

    public Service( String nom, long nbLits) {

        this.nom = nom;
        this.nbLits = nbLits;
    }

    public Service(String nom, long nbLits, List<Salle> salleDeSoin, List<Salle> salleOperation) {
        this.nom = nom;
        this.nbLits = nbLits;
        this.salleDeSoin = salleDeSoin;
        this.salleOperation = salleOperation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getNbLits() {
        return nbLits;
    }

    public void setNbLits(long nbLits) {
        this.nbLits = nbLits;
    }

    public List<Salle> getSalleDeSoin() {
        return salleDeSoin;
    }

    public void setSalleDeSoin(List<Salle> salleDeSoin) {
        this.salleDeSoin = salleDeSoin;
    }

    public List<Salle> getSalleOperation() {
        return salleOperation;
    }

    public void setSalleOperation(List<Salle> salleOperation) {
        this.salleOperation = salleOperation;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbLits=" + nbLits +
                '}';
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
