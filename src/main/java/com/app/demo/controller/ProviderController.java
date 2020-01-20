package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Provider;
import com.app.demo.service.AddressService;
import com.app.demo.service.ProviderService;



@RestController
public class ProviderController {

	@Autowired
	private ProviderService proService;
	
	@Autowired
	private AddressService addrService ;

	
	@RequestMapping(method=RequestMethod.POST , value="/provider")
	public void addProvider(@RequestBody Provider provider ) {
		proService.addProvider(provider);
	}

	
	@PutMapping("provider/update/{id}")
	public void updateAddress(@PathVariable(value = "id") Integer id,@RequestBody Address address ) {
		addrService.updateProviderAddress(id, address);
	}
	
}
