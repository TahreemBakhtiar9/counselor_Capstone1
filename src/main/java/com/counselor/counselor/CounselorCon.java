package com.counselor.counselor;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
@RequestMapping("/counselor")
public class CounselorCon {
    @Autowired
    private CounselorRepo counselorRepo;
    @GetMapping("/get")
    public ResponseEntity<?> getCounselors() {
        List<Counselor> counselors = counselorRepo.findAll();
        if (!counselors.isEmpty()) {
            return ResponseEntity.ok(counselors);
        } else {
            String errorMessage = "Unable to get Counselor data";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCounselorById(@PathVariable Long id) {
        Optional<Counselor> counselor = counselorRepo.findById(id);
        
        if (counselor.isPresent()) {
            return ResponseEntity.ok(counselor.get());
        } else {
            String errorMessage = "This id does not Exist";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<?> postCounselors(@RequestBody Counselor counselor){
        if (counselor != null) {
            return ResponseEntity.ok(counselorRepo.save(counselor));
        }
        return ResponseEntity.ok("Error Data is not posted");
    }
    
    @PostMapping("/{id}")
    public ResponseEntity<?> updateCounselor(@PathVariable Long id, @RequestBody Counselor newCounselor) {
        Counselor existingCounselor = counselorRepo.findById(id).orElse(null);
        if (existingCounselor != null) {
            existingCounselor.setSpecialization(newCounselor.getSpecialization());
            existingCounselor.setDescription(newCounselor.getDescription());
            return ResponseEntity.ok(counselorRepo.save(existingCounselor));
        }
            return ResponseEntity.ok("Unable to update data");   
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCounselor(@PathVariable Long id) {
        if (counselorRepo.existsById(id)) {
            counselorRepo.deleteById(id);
            return ResponseEntity.ok("Data is deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Counselor not found");
        }
    }
    
}