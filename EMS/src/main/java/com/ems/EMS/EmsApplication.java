package com.ems.EMS;
 
import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 
import com.ems.EMS.model.Employee;
import com.ems.EMS.model.EmsAppConfig;
import com.ems.EMS.model.HR;
import com.ems.EMS.model.Payroll;
import com.ems.EMS.model.Performance;
import com.ems.EMS.service.EmployeeService;
import com.ems.EMS.service.HRService;
import com.ems.EMS.service.PayrollService;
import com.ems.EMS.service.PerformanceService;
 
@SpringBootApplication
public class EmsApplication {
 
	public static void main(String[] args) {
////		SpringApplication.run(EmsApplication.class, args);
//
////		ApplicationContext context = new ClassPathXmlApplicationContext("emsConfiguration.xml");
//	
//		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppConfig.class);
//		
//		Employee emp = context.getBean("employee", Employee.class);
////		Employee emp2 = context.getBean("employee2", Employee.class);
//		Payroll payroll = context.getBean("payroll", Payroll.class);
//		Performance performance = context.getBean("performance", Performance.class);
//		HR hr = context.getBean("hr", HR.class);
//		
//		System.out.println(emp);
//		System.out.println("Calculated Salary: " + payroll.calculateSalary());
//		System.out.println(performance);
//		hr.displayEmployees();
		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppConfig.class);
		EmployeeService empService = context.getBean(EmployeeService.class);
		HRService hrService = context.getBean(HRService.class);
        PayrollService payrollService = context.getBean(PayrollService.class);
        PerformanceService performanceService = context.getBean(PerformanceService.class);
		
		
		System.out.println("Calculated salary: " + empService.calAnnualSalary());
		
		
        hrService.displayAllEmployees();
        Employee employee = hrService.getEmpById(1);
        System.out.println("Fetched Employee: " + employee);
        System.out.println("-----------------");
        payrollService.printPayrollReceipt();
        System.out.println(performanceService.isEligibleForPromotion());;
        performanceService.printPerformanceDetails();
	}
 
}