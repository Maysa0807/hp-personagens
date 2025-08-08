package com.example.hp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FavoriteDTO {
	private Long id;
	private String userId;
	private Long characterId;
}
