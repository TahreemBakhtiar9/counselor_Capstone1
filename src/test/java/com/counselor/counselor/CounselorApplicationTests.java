package com.counselor.counselor;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        mockMvc.perform(get("/counselor/get")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void postAllCounselors() throws Exception {
        Counselor counselor1 = new Counselor(1L, "FCPS", new Date(), new Date(), "5 years Experience");
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(counselor1);
        mockMvc.perform(post("/counselor/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }
    @Test
    public void DeleteCounselors() throws Exception {
        mockMvc.perform(delete("/counselor/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void UpdateCounselors() throws Exception {
        Counselor counselor1 = new Counselor(1L, "FCPS", new Date(), new Date(), "9 years Experience");
        when(counselorRepo.findById(1L)).thenReturn(Optional.of(counselor1));
        mockMvc.perform(put("/counselor/52")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}