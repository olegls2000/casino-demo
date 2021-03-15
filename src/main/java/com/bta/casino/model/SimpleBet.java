package com.bta.casino.model;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "simple_bet")
public class SimpleBet implements Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Enumerated(value = STRING)
	private SimpleResult bet;

	@Column(name = "bet_value")
	private Integer betValue;

	private Boolean active;

	@ManyToOne
	@JoinColumn(name = "user_account_id", nullable = false)
	private UserAccount userAccount;
}
