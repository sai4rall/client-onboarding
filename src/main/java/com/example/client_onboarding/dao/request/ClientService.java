package com.example.client_onboarding.dao.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
@Data
public class ClientService {
    @NotEmpty(message = "Client name must not be empty")
    String clientName;

    @NotEmpty(message = "Service enrolled must not be empty")
    String serviceEnrolled;


}
