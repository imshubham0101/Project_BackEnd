package com.app.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.demo.pojos.Services;
import com.app.demo.pojos.SubServices;
import com.app.demo.repository.ServiceRepository;
import com.app.demo.repository.SubServiceRepository;
import com.app.demo.service.SubFacilityService;

@RestController
public class SubServiceController {

	@Autowired
	private SubFacilityService subFacilityService ;
	
	@Autowired
	private ServiceRepository serviceRepo;
	
	@Autowired
	private SubServiceRepository subServiceRepo;
	
	
	@PostMapping("{serviceName}/{subServiceName}")
	public void addSubService(@PathVariable String serviceName ,@PathVariable String subServiceName) {
		subFacilityService.addSubService(serviceName,subServiceName);
		
	}
	
	@GetMapping("{serviceName}")
	public List<SubServices>getAllSubServices(@PathVariable String serviceName ){
		return subFacilityService.getAllSubServices(serviceName);
	}
	
	
	
//	@PutMapping("{subServiceName}/{price}")
//	public double setPrice(@PathVariable String subServiceName ,@PathVariable Double price ) {
//		return subFacilityService.setPrice(subServiceName,price);
//	}
	
	@PostMapping("{serviceName}/{subServiceName}/{price}")
	public void addSubService(@PathVariable String serviceName ,
			@PathVariable String subServiceName
		,@PathVariable float price	,@RequestParam MultipartFile image 
			) {
		
		
		Services service = new Services();
		SubServices subService = new SubServices();
		service = serviceRepo.findBySname(serviceName);
		System.out.println(service.getId());
		subService.setSubservicename(subServiceName);
		subService.setServices(service);
		subService.setPrice(price);
		try {
			subService.setImages(image.getBytes());
		} catch (IOException e) {
			subService.setImages(null);
		}

		subServiceRepo.save(subService);	
		
	}
}
