package de.randi2.model.security;


import java.io.Serializable;
import javax.persistence.Embeddable;

import lombok.Data;

import org.springframework.security.acls.AclFormattingUtils;
import org.springframework.security.acls.Permission;

@Embeddable
@Data
public class PermissionHibernate implements Permission, Serializable {

	private static final long serialVersionUID = -2551309525159046911L;

	private char code;
	private int mask;

	public PermissionHibernate(int mask, char code) {
		this.mask = mask;
		this.code = code;
	}
	
	public PermissionHibernate() {
	}
	




    public static final PermissionHibernate READ = new PermissionHibernate(1 << 0, 'R'); // 1
    public static final PermissionHibernate WRITE = new PermissionHibernate(1 << 1, 'W'); // 2
    public static final PermissionHibernate CREATE = new PermissionHibernate(1 << 2, 'C'); // 4
    public static final PermissionHibernate DELETE = new PermissionHibernate(1 << 3, 'D'); // 8
    public static final PermissionHibernate ADMINISTRATION = new PermissionHibernate(1 << 4, 'A'); // 16
    
	@Override
	public String getPattern() {
	   return AclFormattingUtils.printBinary(mask, code);
	}
	

}
