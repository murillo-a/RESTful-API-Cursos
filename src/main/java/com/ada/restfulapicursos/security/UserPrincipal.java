package com.ada.restfulapicursos.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ada.restfulapicursos.model.User;

public class UserPrincipal implements UserDetails {

	    private Long id;
	    private String nombre;
	    private String apellido;
	    private String email;
	    private String pw;
	    private Collection<? extends GrantedAuthority> authorities;

	    public UserPrincipal(Long id, String nombre, String apellido, String email, String pw, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pw = pw;
        this.authorities = authorities;
	    }
	    
	    public static UserPrincipal build(User user){
	        List<GrantedAuthority> authorities =
	                user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
	        return new UserPrincipal(user.getId(), user.getNombre(), user.getApellido(), user.getEmail(), user.getPw(), authorities);
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getApellido() {
	        return apellido;
	    }
	    
	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    @Override
	    public String getPassword() {
	        return pw;
	    }

	 //TODO revisar spring security email
	    @Override
	    public String getUsername() {
	        return email;
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
