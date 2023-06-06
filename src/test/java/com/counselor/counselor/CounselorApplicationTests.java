package com.counselor.counselor;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.when;
@WebMvcTest
public class CounselorApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    private JacksonTester<Counselor> jsoncounselor;
    @MockBean
    private CounselorRepo counselorRepo;
    @Test
    public void getAllCounselors() throws Exception {
        Counselor counselor1 = new Counselor(1L, "FCPS", new Date(), new Date(), "5 years Experience");
        Counselor counselor2 = new Counselor(2L, "FCPS", new Date(), new Date(), "5 years Experience");
        Counselor counselor3 = new Counselor(3L, "FCPS", new Date(), new Date(), "5 years Experience");
        List<Counselor> counselors = new ArrayList<>();
        counselors.add(counselor1);
        counselors.add(counselor2);
        counselors.add(counselor3);
        when(counselorRepo.findAll()).thenReturn(counselors);
        mockMvc.perform(get("/counselor")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void postAllCounselors() throws Exception {
        Counselor counselor1 = new Counselor(1L, "FCPS", new Date(), new Date(), "5 years Experience");
        Counselor counselor2 = new Counselor(2L, "FCPS", new Date(), new Date(), "5 years Experience");
        Counselor counselor3 = new Counselor(3L, "FCPS", new Date(), new Date(), "5 years Experience");
        // List<Counselor> counselors = new ArrayList<>();
        // counselors.add(counselor1);
        // counselors.add(counselor2);
        // counselors.add(counselor3);
            // when(counselorRepo.save(counselors)).thenReturn(counselors);
            // when(counselorRepo.save(Mockito.any(Counselor.class))).thenReturn(counselors);
        mockMvc.perform(post("/counselor/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsoncounselor.write(counselor1).getJson()))
                .andExpect(status().isOk());
    }
}