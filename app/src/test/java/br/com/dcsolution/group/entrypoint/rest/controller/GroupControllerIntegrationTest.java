package br.com.dcsolution.group.entrypoint.rest.controller;

import br.com.dcsolution.common.dto.PaginationDto;
import br.com.dcsolution.group.dataprovider.repository.GroupRepository;
import br.com.dcsolution.group.dto.GroupDto;
import br.com.dcsolution.group.presenter.request.GroupRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GroupControllerIntegrationTest {

    final HttpHeaders headers = new HttpHeaders();
    private String URL_BASE;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GroupRepository groupRepository;

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() throws MalformedURLException {
        URL_BASE = new URL("http://localhost:" + port + "/group").toString();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    void error() throws JsonProcessingException {

        final HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(new GroupRequest()),
                headers);

        ResponseEntity<String> response = restTemplate.postForEntity(URL_BASE,
                request, String.class);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void save() throws Exception {

        final HttpEntity<String> request = new HttpEntity<>(objectMapper
                .writeValueAsString(GroupStub.groupInputStub()),
                headers);

        ResponseEntity<String> response = restTemplate.postForEntity(URL_BASE,
                request, String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, groupRepository.findAll(1, 1).getTotalItems());
    }

    @Test
    void findAll(){
        groupRepository.save(GroupStub.groupStub());
        ResponseEntity<String> response = restTemplate.getForEntity(URL_BASE+"?page=0&size=10", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}