package com.example.hp.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HPDto implements Serializable {

	private static final long serialVersionUID = 2179848382333252018L;
	
	private Long id;
	private String name;
	private LocalDate bornDate;
	private String house;
	private String base64Img;
	private String varinha;
	private String patrono;
	private boolean favorito;

}
