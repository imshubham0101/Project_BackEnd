package com.app.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.pojos.Customer;
import com.app.demo.pojos.CustomerProvider;
import com.app.demo.pojos.CustomerProviderKey;
import com.app.demo.pojos.Provider;
import com.app.demo.service.CustProService;

@RestController
@CrossOrigin
public class CustProController {
	
	@Autowired
	private CustProService custProService;
	
	@Autowired
	private CustomerController custController;
	
	@Autowired
	private ProviderController proController ;

	
	
	@PostMapping("/custpro/{custId}/{proId}")
	public ResponseEntity<?>  getCustProDetails(@PathVariable Integer custId,@PathVariable Integer proId,@RequestBody CustomerProvider custPro  ) {
	
		if(custController.getCust(custId) == null && proController.getPro(proId)== null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		CustomerProviderKey custProKey = new CustomerProviderKey(custId,proId);
		custPro.setId(custProKey);
		CustomerProvider customerProvider = custProService.setCustPro(custPro);
		return new ResponseEntity<CustomerProvider>(customerProvider, HttpStatus.OK);
		
	}
	
	@GetMapping("{proId}/allCusts")
	public List<Customer> getAllCustsOfPro(@PathVariable Integer proId){
		Provider pro = proController.getPro(proId);
		//List<Customer> custs = custProService.getAllCustsOfPro(pro);
		System.out.println(pro.getFname());
		
		return custProService.getAllCustsOfPro(pro);
	}
	
	@GetMapping("{proId}/allCustsBySet")
	public Set<CustomerProvider> getAllCustsOfProSet(@PathVariable Integer proId){
		Provider pro = proController.getPro(proId);
		//List<Customer> custs = custProService.getAllCustsOfPro(pro);
		//System.out.println(pro.getFname());
		
		return pro.getCustProvider();
	}
	
	
}
