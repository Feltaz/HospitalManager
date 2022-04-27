package tn.enicar.groupb.hospitalmanager.registration.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.enicar.groupb.hospitalmanager.AppUser.AppUser;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity(name="ConfirmationToken")
public class ConfirmationToken {
    @Id
    @SequenceGenerator(name = "confirmationToken_seq", sequenceName = "aconfirmationToken_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "confirmationToken_seq")
    private long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(nullable=false,
    name="app_user_id")
    private AppUser appUser;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiredAt,
                                                          AppUser appUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt =expiredAt;
        this.appUser=appUser;
    }
}
