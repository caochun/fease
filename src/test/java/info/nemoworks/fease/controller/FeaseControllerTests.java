package info.nemoworks.fease.controller;


import info.nemoworks.fease.controller.FeaseController;
import info.nemoworks.fease.repository.mysql.ContractEntityRepository;
import info.nemoworks.fease.repository.neo4j.ContractNodeRepository;
import info.nemoworks.fease.repository.neo4j.CustomerNodeRepository;
import info.nemoworks.fease.service.FeaseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FeaseController.class)
@ActiveProfiles("neo4j")
public class FeaseControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FeaseService feaseService;

    @MockBean
    private ContractNodeRepository contractNodeRepository;

    @MockBean
    private CustomerNodeRepository customerNodeRepository;

    @MockBean
    private Neo4jTemplate neo4jTemplate;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/archive/ping")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("pong")));
    }
}
