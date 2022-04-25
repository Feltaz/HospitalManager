package tn.enicar.groupb.hospitalmanager.Service;

import tn.enicar.groupb.hospitalmanager.Salle.Salle;

import java.util.List;

public class Service {
    private long id;
    private String nom;
    private long nbLits;
    private List<Salle> salleDeSoin;
    private List<Salle> salleOperation;
    //getters and setters, toString and hashCode

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
                ", salleDeSoin=" + salleDeSoin +
                ", salleOperation=" + salleOperation +
                '}';
    }

    //hashcode  .
    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
