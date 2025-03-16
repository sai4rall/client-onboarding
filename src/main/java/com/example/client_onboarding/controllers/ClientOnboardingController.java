package com.example.client_onboarding.controllers;

import com.example.client_onboarding.dao.request.ClientService;
import com.example.client_onboarding.service.ClientOnboardingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@AllArgsConstructor
@RestController
public class ClientOnboardingController {
    ClientOnboardingService clientOnboardingService;
    @PostMapping("/onboard")
    public ClientService createClientService(@Valid @RequestBody  ClientService clientService) {
        return clientOnboardingService.onBoardClient(clientService);
    }
}
