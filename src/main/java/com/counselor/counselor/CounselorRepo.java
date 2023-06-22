package com.counselor.counselor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounselorRepo extends JpaRepository<Counselor, Long>{

    Optional<Counselor> findByUserId(Long userId);
    
}
