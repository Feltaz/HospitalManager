package tn.enicar.groupb.hospitalmanager.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import tn.enicar.groupb.hospitalmanager.AppUser.AppUserRole;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {//this is the registration request format the user needs to provide a JSON with these fields in order for them to register
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final AppUserRole role;
}
