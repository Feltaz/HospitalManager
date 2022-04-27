package tn.enicar.groupb.hospitalmanager.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firtstname;
    private final String lastname;
    private final String email;
    private final String password;
}
