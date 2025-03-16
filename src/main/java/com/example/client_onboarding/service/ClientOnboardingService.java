package com.example.client_onboarding.service;

import com.example.client_onboarding.dao.request.ClientService;
import com.example.client_onboarding.repository.ClientServiceRepository;
import com.example.client_onboarding.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;


import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClientOnboardingService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    ClientServiceRepository clientServiceRepository;



    public ClientOnboardingService(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withProcedureName("your_stored_procedure_name");
    }

    public ClientService onBoardClient(@Valid ClientService clientService) {
        String uuid = AppUtils.generateUUID();
        System.out.printf("uuid: %s", uuid);

        clientServiceRepository.updateClientService(clientService.getClientName(), clientService.getServiceEnrolled(), uuid);


        HashMap<String, String> procArgs = new HashMap<>();
        procArgs.put("uuid", uuid);
        procArgs.put("serviceName", clientService.getServiceEnrolled());
        procArgs.put("clientName", clientService.getClientName());

        callStoredProcedure(Map.of("uuid", uuid));
        return clientService;
    }


    public Map<String, Object> callStoredProcedure(Map<String, Object> inParams) {
        return simpleJdbcCall.execute(inParams);
    }
}
