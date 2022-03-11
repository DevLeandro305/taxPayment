package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int taxPayers = scan.nextInt();
		
		for (int i = 0; i < taxPayers; i++) {
			System.out.print("Individual or company (i/c)? ");
			char choise = scan.next().charAt(0);
			
			scan.nextLine();
			
			System.out.print("Name: ");
			String name = scan.nextLine();
			
			System.out.print("Anual Income: ");
			Double anualIncome = scan.nextDouble();
			
			if(choise == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = scan.nextDouble();
				
				TaxPayer tp = new Individual(name, anualIncome, healthExpenditures);
				list.add(tp);
			} else {
				System.out.print("Numeber of employees: ");
				int numberOfEmployees = scan.nextInt();
				
				TaxPayer tp = new Company(name, anualIncome, numberOfEmployees);
				list.add(tp);
			}
		}
		
		System.out.println();
		System.out.println("TAX PAID");
		
		double sum = 0;
		
		for (TaxPayer taxPayer : list) {
			System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
			sum += taxPayer.tax();
		}
			
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		scan.close();
	}

}
