package com.example.client_onboarding.service;

import com.example.client_onboarding.dao.request.ClientService;
import com.example.client_onboarding.util.AppUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ClientOnboardingService {
    public ClientService onBoardClient(@Valid ClientService clientService) {
      String uuid= AppUtils.generateUUID();
        System.out.printf("uuid: %s", uuid);
return clientService;
    }
}
