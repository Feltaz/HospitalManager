package tn.enicar.groupb.hospitalmanager.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enicar.groupb.hospitalmanager.AppUser.AppUser;
import tn.enicar.groupb.hospitalmanager.AppUser.AppUserRole;
import tn.enicar.groupb.hospitalmanager.AppUser.AppUserService;

@Service
@AllArgsConstructor
public class RegistrationService {
 private final EmailValidator emailValidator;//validate email
 private final AppUserService appUserService; //this service is needed to call upon the appuser services
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
}
