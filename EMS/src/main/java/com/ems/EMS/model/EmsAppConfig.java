package com.ems.EMS.model;
 
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
 
@Configuration
@ComponentScan(basePackages = "com.ems.EMS")
@PropertySource("classpath:application.properties")  // load the properties file
public class EmsAppConfig {
 
	//Address Bean
//	@Bean
//	public Address address() {
//		Address address = new Address();
//		address.setStreet("Behind Railway Station");
//		address.setCity("Navi Mumbai");
//		address.setState("Maharashtra");
//		address.setZipcode("43452");
//		return address;
//	}
//	@Bean
//	public Department department() {
//		Department department = new Department();
//		department.setDeptId(3);
//		department.setDeptName("Operations");
//		return department;
//	}
//	@Bean
//	public List<String> skills() {
//		return Arrays.asList("Java", "MySQL", "Spring Framework");
//	}
//	@Bean
//	public Employee employee() {
//		Employee employee = new Employee();
//		employee.setId(3);
//		employee.setName("Rahul");
//		employee.setEmail("rahul@gmail.com");
//		employee.setPhone("23534534");
//		employee.setSalary(66000);
//		employee.setAddress(address()); //inject address bean -> just pass the name address
//		employee.setDepartment(department());
//		employee.setSkills(skills());
//		return employee;
//	}
//	@Bean
//	public Payroll payroll() {
//		Payroll payroll = new Payroll();
//		payroll.setBaseSalary(66000);
//		return payroll;
//	}
//	@Bean
//	public Performance performance() {
//		Performance performance = new Performance();
//		performance.setEmployeeId(3);
//		performance.setRating(4.9);
//		performance.setFeedback("Excellent");
//		return performance;
//	}
//	@Bean
//	public Map<Integer, Employee> empRecords() {
//		Map<Integer, Employee> records = new HashMap<>();
//		records.put(3, employee());
//		return records;
//	}
//	@Bean
//	public HR hr() {
//		HR hr = new HR();
//		hr.setEmployeeRecords(empRecords());
//		return hr;
//	}
	
	//Address Bean
	@Value("${address.street}")
	private String street;
	@Value("${address.city}")
	private String city;
	@Value("${address.state}")
	private String state;
	@Value("${address.zipcode}")
	private String zipcode;
	
	@Bean
	public Address address() {
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZipcode(zipcode);
		return address;
	
	
		
	
}
	//Department Bean
	@Value("${department.id}")
	private int deptid;
	@Value("${department.name}")
	private String deptName;
	
	@Bean
	public Department department() {
		Department department = new Department();
		department.setDeptId(deptid);
		department.setDeptName(deptName);
		return department;
	}
	
	@Value("${employee.skills}")
	private String skillsString;
	
	@Bean
	public List<String> skills(){
		return Arrays.asList(skillsString.split(","));
	}
	
	// Employee Bean
	@Value("${employee.id}")
	private int empId;
	@Value("${employee.name}")
	private String empName;
	@Value("${employee.email}")
	private String email ;
	@Value("${employee.phone}")
	private String phone ;
	@Value("${employee.salary}")
	private double salary ;
	@Value("${employee.designation}")
	private String designation ;
	
	@Bean
	public Employee employee() {
		Employee employee = new Employee();
		employee.setId(empId);
		employee.setName(empName);
		employee.setEmail(email);
		employee.setPhone(phone);
		employee.setSalary(salary);
		employee.setDesignation(designation);
		employee.setAddress(address()); //inject address bean -> just pass the name address
		employee.setDepartment(department());
		employee.setSkills(skills());
		return employee;
	}
	
	@Value ("${performance.projectsHandled}")
	private String projectsHandled;
	@Bean
	public List<String> projectsHandled(){
		return Arrays.asList(projectsHandled.split(","));
	}
	@Value("${performance.employeeId}")
	private int employeeId;
	@Value("${performance.rating}")
	private double rating;
	@Value("${performance.feedback}")
	private String feedback;
	@Value("${performance.eligibleForPromotion}")
	private boolean eligibleForPromotion;

	@Bean
		public Performance performance() {
			Performance performance = new Performance();
			performance.setEmployeeId(employeeId);
			performance.setRating(rating);
			performance.setFeedback(feedback);
			performance.setProjectsHandled(projectsHandled());
			performance.setEligibleForPromotion(eligibleForPromotion);
			return performance;
		}
	
	// Payroll bean
    @Value("${payroll.baseSalary}")
    private double baseSalary;
    @Value("${payroll.bonuses}")
    private double bonuses;
    @Value("${payroll.deduction}")
    private double deduction; 
    @Bean
    public Payroll payroll() {
        Payroll payroll = new Payroll();
        payroll.setBaseSalary(baseSalary);
        payroll.setBonuses(bonuses);
        payroll.setDeductions(deduction);
        return payroll;
    }
	   @Bean
		public Map<Integer, Employee> empRecords() {
			Map<Integer, Employee> records = new HashMap<>();
			records.put(employeeId, employee());
			return records;
		}
		@Bean
		public HR hr() {
			HR hr = new HR();
			hr.setEmployeeRecords(empRecords());
			return hr;
		}
	}

	
	
	
	
	
