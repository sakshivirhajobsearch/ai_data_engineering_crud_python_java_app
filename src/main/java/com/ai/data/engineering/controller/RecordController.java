package com.ai.data.engineering.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ai.data.engineering.model.RecordEntity;
import com.ai.data.engineering.service.RecordService;

@RestController
@RequestMapping("/records")
public class RecordController {

	@Autowired
	private RecordService service;

	@GetMapping
	public List<RecordEntity> getAll() {
		return service.getAllRecords();
	}

	@GetMapping("/{id}")
	public RecordEntity getById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping
	public RecordEntity create(@RequestBody RecordEntity record) {
		return service.create(record);
	}

	@PutMapping("/{id}")
	public RecordEntity update(@PathVariable int id, @RequestBody RecordEntity record) {
		return service.update(id, record);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
}