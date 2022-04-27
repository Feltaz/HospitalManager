package tn.enicar.groupb.hospitalmanager.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {//this used to test for the existance of the  email used for registration
        //TODO : Regex to validate email
        return true; //for testing purposes this will be set to true
    }
}
