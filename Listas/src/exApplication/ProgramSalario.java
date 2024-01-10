package exApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employees;

public class ProgramSalario {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employees> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int quantity = sc.nextInt();
		
		for (int i=1; i<=quantity; i++) {
			
			System.out.println("\nEmplyoee #" + i + ":");
	 		
			System.out.print("Id: ");
			Integer idEmplyoee = sc.nextInt();
			while(hasId(list, idEmplyoee)) {
				System.out.print("Id already taken! Try again: ");
				idEmplyoee = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String nameEmplyoee = sc.nextLine();
			
			System.out.print("Salary: ");
			Double salaryEmplyoee = sc.nextDouble();
			
			Employees emp = new Employees(idEmplyoee, nameEmplyoee, salaryEmplyoee);
			list.add(emp);
			
		}
		
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();
		Integer pos = position(list, idSalary);
		
		if (pos == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			list.get(pos).increaseSalary(percentage);
		}
		
		System.out.println("\nList of employees:");
		for (Employees emp : list) {
			System.out.println(emp);
		}
		
		
		sc.close();
		
	}
	
	public static Integer position(List<Employees> list, int id) {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Employees> list, int id) {
		Employees emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
