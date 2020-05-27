package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.ConditionBean;
import com.example.demo.domain.EmployeeBean;
import com.example.demo.mapper1.EmployeeMapper1;
import com.example.demo.mapper2.EmployeeMapper2;
import com.example.demo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper1 mapper1;

	@Autowired
	private EmployeeMapper2 mapper2;

	@Transactional
	public List<EmployeeBean> search(ConditionBean con) {

		List<EmployeeBean> list = mapper1.selectAll();
		return list;

	}

	@Transactional(transactionManager = "txManager2")
	public List<EmployeeBean> search2(ConditionBean con) {

		List<EmployeeBean> list = mapper2.selectAll();
		return list;

	}
}
