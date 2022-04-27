package tn.enicar.groupb.hospitalmanager.AppUser;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.enicar.groupb.hospitalmanager.registration.token.ConfirmationToken;
import tn.enicar.groupb.hospitalmanager.registration.token.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class AppUserService implements UserDetailsService { //find users once they try to login
    private final AppUserRepository appUserRepository; //appUser repository
    private final ConfirmationTokenService confirmationTokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder; //this is the password encoder
    private final static String USER_NOT_FOUND_MSG=  //error message when the exception is thrown
            "user with email %s not found";


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { //look for a specific user using an email if not found throw an error
        log.info("attempting to find user with email: "+email);
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(
                String.format(USER_NOT_FOUND_MSG,
                        email)
                )
        );
    }
    public String signUpUser(AppUser appUser){//signUp a new User
        log.info("attempting to sign up user with email: "+appUser.getEmail());
       boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent(); //check if the email is already taken
       if (userExists){
           log.warn("user with email: "+appUser.getEmail()+" already exists");
           throw new IllegalStateException("email Already taken"); //error thrown when email is taken
       }
      String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword()); //encode the password so it won't be stored in plain text
       appUser.setPassword(encodedPassword);//set the password
        appUserRepository.save(appUser);
        log.info("user with email: "+appUser.getEmail()+" signed up successfully");
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken=new ConfirmationToken(token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
       confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public void enableAppUser(String email) {
        appUserRepository.enableAppUser(email);
    }
}
