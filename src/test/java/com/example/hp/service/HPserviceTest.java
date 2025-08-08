package com.example.hp.service;

import com.example.hp.dto.EmailRecordDto;
import com.example.hp.dto.HPDto;
import com.example.hp.mapper.HPMapper;
import com.example.hp.producers.UserProducer;
import com.example.hp.repository.FavoriteRepository;
import com.example.hp.repository.HPRepository;
import com.example.hp.util.AuthUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class HPServiceTest {

    @Mock
    private HPRepository hpRepository;

    @Mock
    private FavoriteRepository favoriteRepository;

    @Mock
    private HPMapper hpMapper;

    @Mock
    private UserProducer userProducer;

    @InjectMocks
    private HPService hpService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getHP_DeveRetornarListaDeDtos() {
        // Arrange
        var dtoList = List.of(new HPDto());
        when(hpRepository.findAll()).thenReturn(List.of());
        when(hpMapper.entitiesToDtos(List.of())).thenReturn(dtoList);

        // Act
        List<HPDto> result = hpService.getHP();

        // Assert
        assertThat(result).isEqualTo(dtoList);
        verify(hpRepository).findAll();
        verify(hpMapper).entitiesToDtos(List.of());
    }

    @Test
    void validarPrimeiroLogin_ComJwt_DevePublicarMensagem() {
        // Arrange
        Jwt jwt = mock(Jwt.class);
        when(jwt.getClaim("sub")).thenReturn(UUID.randomUUID().toString());
        when(jwt.getClaim("email")).thenReturn("teste@example.com");
        when(jwt.getClaim("name")).thenReturn("Fulano");

        // Act
        hpService.validarPrimeiroLogin(jwt);

        // Assert
        verify(userProducer, times(1)).publishMessageEmail(any(EmailRecordDto.class));
    }

    @Test
    void validarPrimeiroLogin_ComJwtNulo_NaoDevePublicarMensagem() {
        // Act
        hpService.validarPrimeiroLogin(null);

        // Assert
        verify(userProducer, never()).publishMessageEmail(any());
    }
}