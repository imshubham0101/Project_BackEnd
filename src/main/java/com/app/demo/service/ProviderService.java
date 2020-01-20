package com.app.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Provider;
import com.app.demo.pojos.Services;
import com.app.demo.repository.ProviderRepository;
import com.app.demo.repository.ServiceRepository;

@Service
public class ProviderService {

	@Autowired
	private AddressService addrService;

	
	@Autowired
	private ServiceRepository serviceRepo;
	
	@Autowired
	private ProviderRepository providerRepo;
	
	
	public void addProvider(Provider provider) {
		Address address = provider.getAddress();
		address.setPid(provider);
		Services service = serviceRepo.findBySname(provider.getPservice().getSname()); 
		provider.setPservice(service);
		//System.out.println(service.getSname());
		
		providerRepo.save(provider);
		addrService.saveAddr(address);
		
		
		
	}
	
}
