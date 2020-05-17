package com.example.demo.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeBean implements Serializable {
	private String id;
	private String name;
	private String mailAddress;

}
