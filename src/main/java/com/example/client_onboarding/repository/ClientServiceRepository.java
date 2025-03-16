package com.example.client_onboarding.repository;

import com.example.client_onboarding.dao.request.ClientService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;

//@Repository
public interface ClientServiceRepository extends JpaRepository<ClientService, Long> {
    @Query("UPDATE ClientService c SET c.clientName = ?1, c.serviceEnrolled = ?2 WHERE c.uuid = ?3")
    void updateClientService(@NotEmpty(message = "Client name must not be empty") String clientName, @NotEmpty(message = "Service enrolled must not be empty") String serviceEnrolled, String uuid);
}