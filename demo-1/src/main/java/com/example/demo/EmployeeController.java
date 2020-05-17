package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.ConditionBean;
import com.example.demo.domain.EmployeeBean;
import com.example.demo.service.EmployeeService;

@Controller
@PropertySource("display.properties")
public class EmployeeController {

	@Value("${title}")
	private String title;

	@Autowired
	private EmployeeService service;

	@RequestMapping("/show")
	public String show(Model model) {

		EmployeeForm form = new EmployeeForm();
		EmployeeBean bean = new EmployeeBean();
		bean.setId("1");
		bean.setName(title);
		bean.setMailAddress("ken@mail.com");
		form.setEmployee(bean);
		model.addAttribute("employeeForm", form);
		return "contents/employee";
	}


	@RequestMapping("/detail")
	public String detail(@ModelAttribute("employeeForm") EmployeeForm form, Model model) {

		ConditionBean con = new ConditionBean();
		con.setName(form.getEmployee().getName());
		List<EmployeeBean> result = service.search(con);

		EmployeeListForm listForm = new EmployeeListForm();
		listForm.setEmployees(result);

		model.addAttribute("employeeListForm", listForm);

		return "contents/employeeList";
	}
}
