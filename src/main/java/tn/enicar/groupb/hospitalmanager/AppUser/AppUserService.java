package tn.enicar.groupb.hospitalmanager.AppUser;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService { //find users once they try to login
    private final AppUserRepository appUserRepository;
    private final static String USER_NOT_FOUND_MSG=
            "user with email %s not found";


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(
                String.format(USER_NOT_FOUND_MSG,
                        email)
                )
        );
    }
}
