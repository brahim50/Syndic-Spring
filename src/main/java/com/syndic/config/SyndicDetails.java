package com.syndic.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.syndic.model.Syndic;

public class SyndicDetails implements UserDetails {
	
	private Syndic syndic;

	public SyndicDetails(Syndic syndic) {
		super();
		this.syndic = syndic;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		
		return syndic.getPassword();
	}

	@Override
	public String getUsername() {
		
		return syndic.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
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
	public String getFirstName() {
		return syndic.getNom();
	}
	
	public String getLastName() {
		return syndic.getPrenom();
	}
	
	public int getIdS() {
		return syndic.getId();
	}
	public String getCity() {
		return syndic.getVille();
	}
	public String getPhone() {
		return syndic.getTele();
	}
	public String getPhotos() {
		return syndic.getImage();
	}
	

}
