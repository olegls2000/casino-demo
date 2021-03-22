package com.bta.casino.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(exclude = "userAccounts")
@Entity
//@Table(name = "role")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Column(name = "role")
	private String role;

	@ManyToMany
	@JoinTable(
			name = "user_account_x_role",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "user_account_id")
	)
	private Set<UserAccount> userAccounts = new HashSet<>();
}
