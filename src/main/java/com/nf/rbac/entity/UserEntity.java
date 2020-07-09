package com.nf.rbac.entity;

import lombok.Data;

@Data
public class UserEntity {
	private String id;
	private String username;
	private String password;
	private String name; //TODO: 删除

}
