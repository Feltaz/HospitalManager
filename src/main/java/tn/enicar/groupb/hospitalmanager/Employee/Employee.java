package tn.enicar.groupb.hospitalmanager.Employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="employee")
@Table(name="employee")
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private Long id;
    private String nom;
    private double salaire;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String poste;
    //getters and setters.

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

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", salaire=" + salaire +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", poste='" + poste + '\'' +
                '}';
    }
    //hashCode and equals.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (Double.compare(employee.salaire, salaire) != 0) return false;
        if (nom != null ? !nom.equals(employee.nom) : employee.nom != null) return false;
        if (dateDebut != null ? !dateDebut.equals(employee.dateDebut) : employee.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(employee.dateFin) : employee.dateFin != null) return false;
        return poste != null ? poste.equals(employee.poste) : employee.poste == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        temp = Double.doubleToLongBits(salaire);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        result = 31 * result + (poste != null ? poste.hashCode() : 0);
        return result;
    }
}
