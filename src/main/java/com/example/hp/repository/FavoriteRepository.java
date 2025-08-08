package com.example.hp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hp.entity.FavoriteEntity;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {
	
	Boolean existsByUserIdAndCharacterId(String userId, Long characterId);
	
	FavoriteEntity findByUserIdAndCharacterId(String userId, Long characterId);
	
    List<FavoriteEntity> findByUserId(String userId);

}