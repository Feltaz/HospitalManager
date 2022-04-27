package tn.enicar.groupb.hospitalmanager.registration;

import lombok.AllArgsConstructor;
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
public class RegistrationService {
 private final EmailValidator emailValidator;//validate email
 private final AppUserService appUserService; //this service is needed to call upon the appuser services
    private final ConfirmationTokenService confirmationTokenService;
    public String register(RegistrationRequest request) { //register service
        boolean isValidEmail=emailValidator.
                test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(//signup the user
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.EMPLOYEE
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
        throw new IllegalStateException("email already taken");
    }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
}
