package com.bta.casino.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bta.casino.model.Role;
import com.bta.casino.model.UserAccount;

public class UserDetailsCasino implements UserDetails {

	private UserAccount userAccount;

	public UserDetailsCasino(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userAccount.getRoles().stream()
					   .map(Role::getRole)
					   .map(str -> (GrantedAuthority) () -> str)
					   .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return userAccount.getPassword();
	}

	@Override
	public String getUsername() {
		return userAccount.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
