package com.bta.casino.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "user_account")
public class UserAccount implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "tax_number")
	private long taxNumber;

	private LocalDate birthday;

	private String username;

	private String password;

	private String email;

	private int balance;

	@OneToMany(mappedBy = "userAccount",
			fetch = FetchType.LAZY,
			orphanRemoval = true,
			cascade = CascadeType.ALL )
	private Collection<SimpleBet> bets;
}
