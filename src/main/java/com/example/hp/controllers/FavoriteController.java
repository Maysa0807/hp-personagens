package com.example.hp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hp.dto.HPDto;
import com.example.hp.service.FavoriteService;
import com.example.hp.util.AuthUtil;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/favorites")
@CrossOrigin("*")
@AllArgsConstructor
public class FavoriteController {

    private final FavoriteService service;

    @PostMapping
    public ResponseEntity<Void> addFavorite(@RequestBody HPDto dto) {
        String userId = AuthUtil.getUserId(); // <- do token
        service.addFavorite(userId, dto.getId());
        return ResponseEntity.ok().build();
    }

}
