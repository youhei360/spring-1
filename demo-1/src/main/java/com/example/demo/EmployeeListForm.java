package com.example.demo;

import java.util.List;

import com.example.demo.domain.EmployeeBean;

import lombok.Data;

@Data
public class EmployeeListForm {
	private List<EmployeeBean> employees;
}
