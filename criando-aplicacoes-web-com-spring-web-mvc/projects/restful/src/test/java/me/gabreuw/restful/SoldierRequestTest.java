package me.gabreuw.restful;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.gabreuw.restful.domain.Soldier;
import me.gabreuw.restful.dto.SoldierResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class SoldierRequestTest {

    @Autowired
    private MockMvc mockMvc;

    @Spy
    private ObjectMapper objectMapper;

    @Test
    void callGet() throws Exception {
        SoldierResponse soldier = SoldierResponseTest.create();
        String jsonOutString = objectMapper
                .writerWithView(Soldier.class)
                .writeValueAsString(soldier);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/soldiers/1")
                                .header("meu_header", "")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(
                        MockMvcResultMatchers
                                .header()
                                .string("Content-Type", "application/json;charset-UTF-8")
                )
                .andExpect(
                        MockMvcResultMatchers
                                .status()
                                .isOk()
                )
                .andExpect(
                        MockMvcResultMatchers
                                .content()
                                .json(jsonOutString)
                );
    }

}
