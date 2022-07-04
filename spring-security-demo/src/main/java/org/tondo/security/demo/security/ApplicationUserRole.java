package org.tondo.security.demo.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Modeling user roles and permissions as an enum
 * @author TondoDev
 *
 */
public enum ApplicationUserRole {
	STUDENT,
	ADMIN(
			ApplicationUserPermission.STUDENT_READ, 
			ApplicationUserPermission.STUDENT_WRITE, 
			ApplicationUserPermission.COURSE_READ, 
			ApplicationUserPermission.COURSE_WRITE),
	
	ADMINTRAINEE(
			ApplicationUserPermission.STUDENT_READ, 
			ApplicationUserPermission.COURSE_READ
			);
	
	private Set<ApplicationUserPermission> permissions;
	
	
	private ApplicationUserRole(ApplicationUserPermission... applicationUserPermissions) {
		this.permissions = new HashSet<ApplicationUserPermission>(Arrays.asList(applicationUserPermissions));
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		// converts to the structure accepted by spring security
		Set<SimpleGrantedAuthority> authorities = this.permissions.stream()
			.map(perm -> new SimpleGrantedAuthority(perm.getPermission()))
			.collect(Collectors.toSet());
		
		// adds the entry for role itself, with required prefis ROLE_ 
		authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return authorities;
	}
}
