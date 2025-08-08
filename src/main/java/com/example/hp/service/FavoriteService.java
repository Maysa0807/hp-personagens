package com.example.hp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.hp.entity.FavoriteEntity;
import com.example.hp.repository.FavoriteRepository;

@Service
public class FavoriteService {

    private final FavoriteRepository repository;

    public FavoriteService(FavoriteRepository repository) {
        this.repository = repository;
    }

    public void addFavorite(String userId, Long characterId) {
        FavoriteEntity favorito = repository.findByUserIdAndCharacterId(userId, characterId);
        if (Objects.isNull(favorito)) {
            repository.save(new FavoriteEntity(null, userId, characterId));
        }else {
        	repository.deleteById(favorito.getId());
        }
    }

    public List<Long> getFavoritesByUserId(String userId) {
        return repository.findByUserId(userId).stream()
                         .map(FavoriteEntity::getCharacterId)
                         .toList();
    }


}
