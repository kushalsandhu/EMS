package com.ems.EMS.model;

public class Payroll {

	private int employeeId;
	private double baseSalary;
	private double bonuses;
	private double deductions;
	
	public Payroll() {
		
	}
	public Payroll(int employeeId, double baseSalary, double bonuses, double deductions) {
		super();
		this.employeeId = employeeId;
		this.baseSalary = baseSalary;
		this.bonuses = bonuses;
		this.deductions = deductions;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public double getBonuses() {
		return bonuses;
	}
	public void setBonuses(double bonuses) {
		this.bonuses = bonuses;
	}
	public double getDeductions() {
		return deductions;
	}
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	
	public double calculateSalary() {
		return baseSalary + bonuses - deductions;
	}
}
