package com.example.hp.mapper;

import com.example.hp.dto.HPDto;
import com.example.hp.entity.HPEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface HPMapper {
    HPDto entityToDto(HPEntity HP);
    HPEntity dtoToEntity(HPDto HP);

    List<HPDto> entitiesToDtos(List<HPEntity> HP);
}
