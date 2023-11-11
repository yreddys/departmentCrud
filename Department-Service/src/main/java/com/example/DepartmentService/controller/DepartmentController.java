package com.example.DepartmentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DepartmentService.model.DepartmentRequest;
import com.example.DepartmentService.model.DepartmentResponse;
import com.example.DepartmentService.service.DepartmentService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class DepartmentController {
	private DepartmentService service;

	@Autowired
	DepartmentController(DepartmentService service) {
		this.service = service;
	}

	@PostMapping("/save")
	String saveDepartment(@RequestBody DepartmentRequest departmentRequest) {
		log.info("Saving department {}", departmentRequest);
		service.savingDepartment(departmentRequest);
		return "Department saved Successfully";
	}

	@GetMapping("/{dId}")
	DepartmentResponse getDepartmentById(@PathVariable int dId) {
		log.info("Requested Department is {}", dId);
		return service.getDepartmentById(dId);
	}

	@PutMapping("/{dId}")
	DepartmentResponse updateDepartmentById(@PathVariable int dId, @RequestBody DepartmentRequest departmentRequest) {
		log.info("Requested Department is {}", dId);
		return service.updateDepartmentById(dId, departmentRequest);
	}

	@DeleteMapping("/{dId}")
	String deleteDepartmentById(@PathVariable int dId) {
		log.info("Requested Department is {}", dId);
		service.deleteDepartmentById(dId);
		return "Deeleted Successfully";
	}
}
