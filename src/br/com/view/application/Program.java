package br.com.view.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.model.entities.Contract;
import br.com.model.entities.Installment;
import br.com.model.services.ContractService;
import br.com.model.services.PaypalService;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		System.out.println("Enter contract data: ");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Number of contract");
		Integer number = sc.nextInt();
		
		System.out.println("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		
		System.out.println("Contract value: ");
		Double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		System.out.println("Enter number of installments: ");
		int n = sc.nextInt();
		
		
		ContractService cs = new ContractService(new PaypalService());//Aqui é realizado a injeção de dependência.
		
		cs.processContract(contract, n);
		
		System.out.println("Installments: ");
		
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		
		
		
		sc.close();
	}
}
