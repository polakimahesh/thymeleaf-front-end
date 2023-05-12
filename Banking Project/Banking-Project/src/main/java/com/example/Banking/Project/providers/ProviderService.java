package com.example.Banking.Project.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllUserOfThatProvider(String gatewayName){
        return providerRepository.findByGatewayNameIgnoreCase(gatewayName);
    }

    public void save(Provider provider){
        providerRepository.save(provider);
    }
}
