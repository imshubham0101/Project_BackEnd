package com.app.demo.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Provider")
public class Provider {
	private Integer id;
	private String fname;
	private String lname;
	private String mobile;
	private String password;
	@JsonBackReference
	private Address address;
	@JsonIgnore
	@JsonManagedReference(value="pservice")
	private Services pservice;

	
	private Set <CustomerProvider> custProvider = new HashSet<>();
	
	public Provider() {
	}

	public Provider(String fname, String lname, String mobile, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.password = password;
		

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Column(length = 10)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne(mappedBy="pid",cascade = CascadeType.ALL)
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="s_id")
	public Services getPservice() {
		return pservice;
	}

	public void setPservice(Services pservice) {
		this.pservice = pservice;
	}

	
	
	@OneToMany(mappedBy = "provider")
	public Set<CustomerProvider> getCustProvider() {
		return custProvider;
	}

	public void setCustProvider(Set<CustomerProvider> custProvider) {
		this.custProvider = custProvider;
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", fname=" + fname + ", lname=" + lname + ", mobile=" + mobile + ", password="
				+ password + ", address=" + address + ", pservice=" + pservice + "]";
	}

	
}