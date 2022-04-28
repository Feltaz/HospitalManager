package tn.enicar.groupb.hospitalmanager.registration;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/registration")//api path
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;//services here

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){//this method to register a new user

        return registrationService.register(request);
    }
    @GetMapping(path="confirm")
    public String confirmToken(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
