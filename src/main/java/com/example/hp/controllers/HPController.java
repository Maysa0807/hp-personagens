package com.example.hp.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hp.dto.HPDto;
import com.example.hp.service.HPService;

@RestController
@RequestMapping("/personagens")
@CrossOrigin("*")
public class HPController {

	private final HPService hpService;

	public HPController(HPService hpService) {
		this.hpService = hpService;
	}

	@GetMapping
	public ResponseEntity<List<HPDto>> getAllHP() {
		return ResponseEntity.ok(hpService.getHP());
	}

	@GetMapping("/filtro")
	public ResponseEntity<List<HPDto>> filtro(@RequestParam(required = false) String name,
			@RequestParam(required = false) String house) {
		return ResponseEntity.ok(hpService.filtro(name, house));
	}
}
