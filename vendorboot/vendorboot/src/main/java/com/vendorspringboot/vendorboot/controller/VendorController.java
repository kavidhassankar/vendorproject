package com.vendorspringboot.vendorboot.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendorspringboot.vendorboot.DTO.Vendor;
import com.vendorspringboot.vendorboot.service.VendorService;

@RestController
@RequestMapping(value = "/vendor")
public class VendorController {

	@Autowired
	public VendorService vendorservice;

	@PostMapping(value = "/create")
	public void VendorCreate(@RequestBody Vendor vendor) throws ClassNotFoundException, SQLException {

		vendorservice.save(vendor);

	}

	@GetMapping(value = "/get")
	public List<Vendor> getAllvendor() throws ClassNotFoundException, SQLException {

		List<Vendor> obj = vendorservice.getAll();

		return obj;

	}

	@GetMapping(value = "/get/{id}")

	public List<Vendor> getbyid(@PathVariable int id) throws ClassNotFoundException, SQLException {

		List<Vendor> obj = vendorservice.findById(id);

		return obj;

	}

	@PutMapping(value = "/updated")

	public void VendorUpdate(@RequestBody Vendor vendor) throws ClassNotFoundException, SQLException {

		vendorservice.update(vendor);

	}
	@DeleteMapping(value="/delete")
	
	public void VendorDelete(@RequestBody Vendor vendor) throws ClassNotFoundException, SQLException {
		
		vendorservice.deleteById(vendor);
	}
	
}
