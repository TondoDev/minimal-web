package org.tondo.security.demo.security;

public enum ApplicationUserPermission {
	
	
	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write");
	
	private final String permission;
	
	private ApplicationUserPermission(String perm) {
		this.permission =perm;
	}
	
	public String getPermission() {
		return permission;
	}
}
