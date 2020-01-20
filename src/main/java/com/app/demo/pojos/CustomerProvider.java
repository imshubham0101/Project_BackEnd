package com.app.demo.pojos;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CustomerProvider {
	
	@EmbeddedId
	CustomerProviderKey id ;
	
	@ManyToOne
	@MapsId("cust_id")
	@JoinColumn(name="cust_id")
	Customer customer;
	
	@ManyToOne
	@MapsId("provider_id")
	@JoinColumn(name="provider_id")
	Provider provider;
		
	int rating;

	public CustomerProviderKey getId() {
		return id;
	}

	public void setId(CustomerProviderKey id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "CustomerProvider [id=" + id + ", customer=" + customer + ", provider=" + provider + ", rating=" + rating
				+ "]";
	}

	
	
	
	
	
	

}
