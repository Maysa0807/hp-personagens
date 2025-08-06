package com.example.hp.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hp.dto.EmailRecordDto;
import com.example.hp.dto.HPDto;
import com.example.hp.service.HPService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/personagens")
@CrossOrigin("*")
@Log4j2
public class HPController {

	private final HPService hpService;

	public HPController(HPService hpService) {
		this.hpService = hpService;
	}

	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<HPDto>> getAllHP() {	
		return ResponseEntity.ok(hpService.getHP());
	}

	@GetMapping("/filtro")
	public ResponseEntity<List<HPDto>> filtro(@RequestParam(required = false) String name,
			@RequestParam(required = false) String house, @AuthenticationPrincipal Jwt jwt) {		
		
		hpService.validarPrimeiroLogin(jwt);
		return ResponseEntity.ok(hpService.filtro(name, house));
	}
	
}
