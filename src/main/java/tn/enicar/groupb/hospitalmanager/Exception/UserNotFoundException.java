package tn.enicar.groupb.hospitalmanager.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message) ;
    }
}
