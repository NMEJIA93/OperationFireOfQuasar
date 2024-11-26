package operationFireOfQuasar.operationFireOfQuasar.IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class RestAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenValidRequest_whenPostToTopSecret_thenReturn200AndResponseBody() throws Exception {
        // Crea el cuerpo de la solicitud
        String requestBody = objectMapper.writeValueAsString(Map.of(
                "satellites", List.of(
                        Map.of(
                                "name", "kenobi",
                                "distance", 100.0,
                                "message", List.of("este", "", "", "mensaje", "")
                        ),
                        Map.of(
                                "name", "skywalker",
                                "distance", 115.5,
                                "message", List.of("", "es", "", "", "secreto")
                        ),
                        Map.of(
                                "name", "sato",
                                "distance", 142.7,
                                "message", List.of("este", "", "un", "", "")
                        )
                )
        ));

        // Realiza la solicitud POST
        ResultActions result = mockMvc.perform(post("/topsecret/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));

        // Verifica el estado de respuesta y cuerpo
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.position.x").isNotEmpty())
                .andExpect(jsonPath("$.position.y").isNotEmpty())
                .andExpect(jsonPath("$.message").value("este es un mensaje secreto"));
    }

}
