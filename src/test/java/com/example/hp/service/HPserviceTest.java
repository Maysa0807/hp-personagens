package com.example.hp.service;

import com.example.hp.dto.EmailRecordDto;
import com.example.hp.dto.HPDto;
import com.example.hp.entity.HPEntity;
import com.example.hp.mapper.HPMapper;
import com.example.hp.producers.UserProducer;
import com.example.hp.repository.FavoriteRepository;
import com.example.hp.repository.HPRepository;
import com.example.hp.util.AuthUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
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
    void getHP_Teste_RetornandoListaDeDtos(){
    	List<HPDto> listHPDto = List.of(new HPDto());
    	when(hpRepository.findAll()).thenReturn(List.of());
    	when(hpMapper.entitiesToDtos(any())).thenReturn(listHPDto);
    	
    	List<HPDto> resultDto = hpService.getHP();
    	
    	assertThat(resultDto).isEqualTo(listHPDto);
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
    
    @Test
    void filtro() {
    	
    	List<HPEntity> listEntity = List.of(new HPEntity());
    	List<HPDto> listHPDto = List.of(new HPDto());
    	
    	MockedStatic<AuthUtil> mockedStatic = mockStatic(AuthUtil.class);
    	
    	mockedStatic.when(() -> AuthUtil.getUserId()).thenReturn("asdfasdfasdfa sdf");
    	
    	when(hpRepository.findByNameContainingIgnoreCaseOrHouseContainingIgnoreCase(any(), any())).thenReturn(listEntity);
    	when(hpMapper.entitiesToDtos(any())).thenReturn(listHPDto);
    	
        // Act
    	List<HPDto> listHPDtoResult = hpService.filtro("teste", "teste");

        // Assert
        assertThat(listHPDtoResult.size()).isEqualTo(1);
    }
}