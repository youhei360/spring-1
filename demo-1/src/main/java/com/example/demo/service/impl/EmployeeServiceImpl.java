package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.ConditionBean;
import com.example.demo.domain.EmployeeBean;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper mapper;

	@Transactional
	public List<EmployeeBean> search(ConditionBean con) {

		List<EmployeeBean> list = mapper.selectAll();
		return list;

	}
}
