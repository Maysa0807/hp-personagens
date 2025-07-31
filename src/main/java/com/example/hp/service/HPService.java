package com.example.hp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dto.HPDto;
import com.example.hp.mapper.HPMapper;
import com.example.hp.repository.HPRepository;

@Service
public class HPService {
	private final HPRepository hpRepository;
	private final HPMapper hpMapper;

	public HPService(HPRepository hpRepository, HPMapper hpMapper) {
		this.hpRepository = hpRepository;
		this.hpMapper = hpMapper;
	}

	@Transactional
	public List<HPDto> getHP() {
		return hpMapper.entitiesToDtos(hpRepository.findAll());
	}

	@Transactional
	public List<HPDto> filtro(String nome, String house) {

		return hpMapper
				.entitiesToDtos(hpRepository.findByNameContainingIgnoreCaseOrHouseContainingIgnoreCase(nome, house));
	}
}
