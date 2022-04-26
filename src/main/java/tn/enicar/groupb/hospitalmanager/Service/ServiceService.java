package tn.enicar.groupb.hospitalmanager.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import tn.enicar.groupb.hospitalmanager.Patient.Patient;
import tn.enicar.groupb.hospitalmanager.Salle.Salle;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    public List<Service> getService(){
        return List.of(new Service(1L,
                        "service bellil",
                        3L,
                        List.of(new Salle(1l,
                                List.of(new Patient(1L,
                                        "moetaz")))),
                        List.of(new Salle(1l,
                                        List.of(new Patient(2L,
                                                "taz")
                                        )
                                )
                        )
                )
        );
    }
}
