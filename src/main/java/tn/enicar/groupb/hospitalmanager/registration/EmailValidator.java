package tn.enicar.groupb.hospitalmanager.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {//this used to test for the existance of the  email used for registration
        String regex = "^(.+)@(.+)$";//regex for email

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(s).matches();//return true if the email is valid by the regex

    }
}
