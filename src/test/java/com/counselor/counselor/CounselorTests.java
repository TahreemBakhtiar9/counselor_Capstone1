package com.counselor.counselor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Answers.valueOf;

import java.sql.Date;

import org.junit.jupiter.api.Test;

public class CounselorTests {
    

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private Long counselorId;
    // private String specialization;
    // private Date created;
    // private Date update;
    // private String description;

    @Test
    void testingId(){
        Counselor counselor= new Counselor();
         long counselorId = 4L;
         counselor.setCounselorId(counselorId);
         assertEquals(counselorId, counselor.getCounselorId());

    }

    @Test
    void testingSpecialization(){
        Counselor counselor = new Counselor();
        String specialization = "MBBS";
        counselor.setSpecialization(specialization);
        assertEquals(specialization, counselor.getSpecialization());
    }

    @Test
    void testingCreatedDate(){
        Counselor counselor = new Counselor();
        String createdDate = "2303-06-23";
        Date date = Date.valueOf(createdDate);
        counselor.setCreated(date);
        assertEquals(date, counselor.getCreated());
    }

  

}
