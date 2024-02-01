package com.personal.auth.model;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document("user")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 4191059910808709988L;
	
	@Id
    private String id;
	private String email;
	private String password;
	
	@Builder.Default
	private boolean isAccountNonExpired = true;
	
	@Builder.Default
	private boolean isAccountNonLocked = true;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}
	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
