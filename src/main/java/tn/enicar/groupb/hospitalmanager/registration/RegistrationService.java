package tn.enicar.groupb.hospitalmanager.registration;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import tn.enicar.groupb.hospitalmanager.AppUser.AppUser;
import tn.enicar.groupb.hospitalmanager.AppUser.AppUserRole;
import tn.enicar.groupb.hospitalmanager.AppUser.AppUserService;
import tn.enicar.groupb.hospitalmanager.registration.token.ConfirmationToken;
import tn.enicar.groupb.hospitalmanager.registration.token.ConfirmationTokenService;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Log4j2
public class RegistrationService {
 private final EmailValidator emailValidator;//validate email
 private final AppUserService appUserService; //this service is needed to call upon the appuser services
    private final ConfirmationTokenService confirmationTokenService;
    public String register(RegistrationRequest request) { //register service
        boolean isValidEmail=emailValidator.
                test(request.getEmail());
        if (!isValidEmail) {
            log.warn("invalid email");
            throw new IllegalStateException("email not valid");
        }
        log.info(String.format("Registered with email %s", request.getEmail()));
        return appUserService.signUpUser(//signup the user
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getRole()
            )
        );
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.
                getToken(token).
                orElseThrow(()->
                        new IllegalStateException("token not found"));
    if(confirmationToken.getConfirmedAt()!= null){
        log.warn("token already confirmed");
        throw new IllegalStateException("email already taken");
    }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            log.warn("confirmation with an expired token");
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        log.info(String.format("token confirmed for user %s", confirmationToken.getAppUser().getEmail()));
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        log.info(String.format("User %s enabled",confirmationToken.getAppUser().getEmail()));
        return "confirmed";
    }
}
