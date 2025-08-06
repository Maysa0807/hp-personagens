package com.example.hp.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dto.EmailRecordDto;
import com.example.hp.dto.HPDto;
import com.example.hp.mapper.HPMapper;
import com.example.hp.producers.UserProducer;
import com.example.hp.repository.HPRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HPService {
	private final HPRepository hpRepository;
	private final HPMapper hpMapper;
	private final UserProducer userProducer;

	@Transactional
	public List<HPDto> getHP() {
		return hpMapper.entitiesToDtos(hpRepository.findAll());
	}

	@Transactional
	public List<HPDto> filtro(String nome, String house) {
		return hpMapper
				.entitiesToDtos(hpRepository.findByNameContainingIgnoreCaseOrHouseContainingIgnoreCase(nome, house));
	}
	
	
	public void validarPrimeiroLogin(Jwt jwt){
		if (Objects.nonNull(jwt)) {
			EmailRecordDto emailRecord = new EmailRecordDto(UUID.fromString(jwt.getClaim("sub")), jwt.getClaim("email"), "Cadastro realizado com sucesso!", jwt.getClaim("name") + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os personagens da nossa plataforma!");			
			//ENVIA MENSAGEM PARA BROKER rabbitmq
			userProducer.publishMessageEmail(emailRecord);
		}
	}
}
