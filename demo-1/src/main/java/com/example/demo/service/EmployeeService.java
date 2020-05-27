package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.ConditionBean;
import com.example.demo.domain.EmployeeBean;

public interface EmployeeService {
	List<EmployeeBean> search(ConditionBean con);
	List<EmployeeBean> search2(ConditionBean con);
}
