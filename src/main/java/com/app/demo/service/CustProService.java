package com.app.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.pojos.Customer;
import com.app.demo.pojos.CustomerProvider;
import com.app.demo.pojos.Provider;
import com.app.demo.repository.CustomerProviderRepository;

@Service
public class CustProService {
	
	//@Autowired
	//private CustProRepository custProRepo;

	@Autowired
	private CustomerProviderRepository custProRepo;
	
	public CustomerProvider setCustPro(CustomerProvider custPro) {
		
		
		return custProRepo.save(custPro);
	}

	public List<Customer> getAllCustsOfPro(Provider pro) {
		
		List<CustomerProvider> custPro = new ArrayList<>(); 
		List<Customer> custs = new ArrayList<>(); 
				custProRepo.findAllByProvider(pro).forEach(custPro :: add);
				for(CustomerProvider c : custPro) {
					System.out.println(c.getCustomer());
					custs.add(c.getCustomer());
					
				}
				
				return custs;
	}

}
