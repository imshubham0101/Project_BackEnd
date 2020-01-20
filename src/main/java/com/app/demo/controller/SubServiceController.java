package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.pojos.SubServices;
import com.app.demo.service.SubFacilityService;

@RestController
public class SubServiceController {

	@Autowired
	private SubFacilityService subFacilityService ;
	
	
	
	
	@PostMapping("{serviceName}/{subServiceName}")
	public void addSubService(@PathVariable String serviceName ,@PathVariable String subServiceName) {
		subFacilityService.addSubService(serviceName,subServiceName);
		
	}
	
	@GetMapping("{serviceName}")
	public List<SubServices>getAllSubServices(@PathVariable String serviceName ){
		return subFacilityService.getAllSubServices(serviceName);
	}
}
