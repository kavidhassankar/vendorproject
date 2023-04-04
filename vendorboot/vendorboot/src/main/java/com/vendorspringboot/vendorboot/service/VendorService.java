package com.vendorspringboot.vendorboot.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendorspringboot.vendorboot.DTO.Vendor;
import com.vendorspringboot.vendorboot.repository.VendorRepository;

@Service
public class VendorService {

	@Autowired
	public VendorRepository repository;

	public void save(Vendor vendor) throws ClassNotFoundException, SQLException {
		repository.save(vendor);
	}

	public List<Vendor> getAll() throws ClassNotFoundException, SQLException {

		return repository.getAll();

	}


	public List<Vendor> findById(int id) throws ClassNotFoundException, SQLException {
		  
		return repository.findById(id);
	}

	public void update(Vendor vendor) throws ClassNotFoundException, SQLException {

		repository.update(vendor);
	
	}

	public void deleteById(Vendor vendor) throws ClassNotFoundException, SQLException {
		
		repository.deleteById(vendor);
	}


}