package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.pojos.CustomerProvider;
import com.app.demo.pojos.CustomerProviderKey;

public interface CustomerProviderRepository extends JpaRepository<CustomerProvider,CustomerProviderKey> {

}
