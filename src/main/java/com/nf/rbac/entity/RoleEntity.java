package com.nf.rbac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleEntity {
	private String id;
	private String name;
	private String description;
	public RoleEntity() {}

	
}
