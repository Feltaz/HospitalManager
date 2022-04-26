package tn.enicar.groupb.hospitalmanager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicar.groupb.hospitalmanager.Entity.Operation;
import tn.enicar.groupb.hospitalmanager.Repo.OperationRepositry;

import java.util.List;

@Service
public class OperationService {
        private OperationRepositry operationRepo;
        @Autowired
        public OperationService(OperationRepositry operationRepo){
            this.operationRepo=operationRepo;
        }
        public List<Operation> findAllOp() {
            return this.operationRepo.findAll();
        }
        public Operation addOp(Operation opr){
            return this.operationRepo.save(opr);
        }
        public void deleteOp(Long id){
            this.operationRepo.findOpById(id).orElseThrow(()->new IllegalStateException("cette operation ayant cet ID " +
                    "n'existe pas"));
            this.operationRepo.deleteOpById(id);
        }
        public Operation updateOp(Operation opr,Long id){
            this.operationRepo.findOpById(id).orElseThrow(()->new IllegalStateException("cette operation ayant cet ID " +
                    "n'existe pas"));
            return this.operationRepo.save(opr);
        }

        public Operation chercherOp(Long id){

            return this.operationRepo.findOpById(id).orElseThrow(()->new IllegalStateException("cette operation ayant cet ID " +
                    "n'existe pas"));
        }


}
