package com.app.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.pojos.Address;
import com.app.demo.pojos.Customer;
import com.app.demo.service.AddressService;
import com.app.demo.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private AddressService addrService ;

	@RequestMapping("login/{mobile}")
	public ResponseEntity<?> login(@PathVariable String mobile)
	{
		             Customer login = service.login(mobile);
		if (login == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Customer>(login, HttpStatus.OK);
	}
	
	@RequestMapping("login")
	public String getCustomer() {
		return "Shubham Phalke";
	}
	
	@RequestMapping("c/{id}")
	public Optional<Customer>findCust(@PathVariable Integer id){
		return service.findCust(id);
	}
	
	@RequestMapping("cad/{id}")
	public List<Address> findCustAddr(@PathVariable Integer id){
		return addrService.findByCustId(id);
	}
	
	@RequestMapping("cpin/{id}")
	public String findCustPin(@PathVariable Integer id){
		return addrService.findCustsPincode(id);
	}
	@RequestMapping("customers/{id}")
	public Customer getCust(@PathVariable Integer id) {
		System.out.println(service.getCust(id));
		return service.getCust(id);
	}
	
	@RequestMapping("custs")
	public List<Customer> getAllCusts(){
		return service.getAllCustomers();
		
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/cust")
	public void addCust(@RequestBody Customer cust ) {
		Address addr = cust.getAddress();
		addr.setCid(cust);
		cust.setAddress(addr);
		System.out.println(addr.getCity());
		System.out.println(addr.getCid());
		
		service.addCust(cust);
		addrService.saveAddr(addr);
	}
	
	@PutMapping("cust/update/{id}")
	public void updateAddress(@PathVariable(value = "id") Integer id,@RequestBody Address address ) {
		addrService.updateAddress( id,  address);
	}
	
	
}
