package tn.enicar.groupb.hospitalmanager.Entity;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Medecin {
        @Id
        @Column(name = "id_med")
        Long id;
        String nom;
        String prenom;
        String specialite;
        String emailMed;
        int telMed
        @Column(unique = true,nullable = false)
        String login;
        String mdp;
        @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,mappedBy = "doctor")
        List<Consultation> consm;
        @ManyToOne
        Service serv;
        @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,mappedBy = "docteurResponsable")
        List<Operation> opmed;

        @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,mappedBy = "medecinsParticipants")
        Set<Operation> operationsmed;

    public Medecin() {
    }

    public Medecin(Long id, String nom, String prenom, String specialite, String emailMed, int telMed, Service serv) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.emailMed = emailMed;
        this.telMed = telMed;
        this.serv = serv;
    }

    public Medecin(Long id, String nom, String prenom, String specialite, String emailMed, int telMed) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.emailMed = emailMed;
        this.telMed = telMed;
    }
}
