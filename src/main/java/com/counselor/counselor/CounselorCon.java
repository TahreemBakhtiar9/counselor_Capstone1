package com.counselor.counselor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.Id;
@CrossOrigin("*")
@RestController
@RequestMapping("/counselor")
public class CounselorCon {
    @Autowired
    private CounselorRepo counselorRepo;
    @GetMapping("/get")
    public List<Counselor> getCounselors(){
        return this.counselorRepo.findAll();
    }
    @PostMapping("/post")
    public void postCounselors(@RequestBody Counselor counselor){
        this.counselorRepo.save(counselor);
    }
    @PutMapping("/{id}")
    public void updateCounselor(@PathVariable Long id, @RequestBody Counselor newCounselor) {
        Counselor existingCounselor = counselorRepo.findById(id).orElse(null);
        if (existingCounselor != null) {
            existingCounselor.setSpecialization(newCounselor.getSpecialization());
            existingCounselor.setDescription(newCounselor.getDescription());
            counselorRepo.save(existingCounselor);
        }
    }

    
    @DeleteMapping("/{id}")
    public void deleteCounselor(@PathVariable Long id){
        this.counselorRepo.deleteById(id);
    }
}