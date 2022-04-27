package tn.enicar.groupb.hospitalmanager.AppUser;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService { //find users once they try to login
    private final AppUserRepository appUserRepository; //appUser repository
    private final BCryptPasswordEncoder bCryptPasswordEncoder; //this is the password encoder
    private final static String USER_NOT_FOUND_MSG=  //error message when the exception is thrown
            "user with email %s not found";


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { //look for a specific user using an email if not found throw an error
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(
                String.format(USER_NOT_FOUND_MSG,
                        email)
                )
        );
    }
    public String signUpUser(AppUser appUser){//signUp a new User
       boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent(); //check if the email is already taken
       if (userExists){
           throw new IllegalStateException("email Already taken"); //error thrown when email is taken
       }
      String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword()); //encode the password so it won't be stored in plain text
       appUser.setPassword(encodedPassword);//set the password
        appUserRepository.save(appUser);
       //TODO: Send confirmation token
        return "It works";
    }
}
