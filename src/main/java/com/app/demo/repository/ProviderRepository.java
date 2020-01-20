package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.pojos.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}
