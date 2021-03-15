package com.bta.casino.model;


import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "simple_game_result")
public class SimpleGameResult implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Enumerated(value = STRING)
	private SimpleResult result;

	@Column(name = "date_time")
	private LocalDateTime dateTime;
}
