package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.EmployeeBean;

@Mapper
public interface EmployeeMapper {
	List<EmployeeBean> selectAll();
}
