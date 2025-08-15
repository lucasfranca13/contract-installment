package application;
import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the contract data: ");
        System.out.print("Number: ");
        Integer number = sc.nextInt(); sc.nextLine();
        System.out.print("Date (dd/MM/yyyy): ");
        String date = sc.nextLine();
        LocalDate data = null;
        System.out.print("Contract value: ");
        Double totalValue = sc.nextDouble();

        try {
            data = LocalDate.parse(date, dtf);
        } catch (DateTimeParseException e){
            System.out.println("Invalid data format. Please try again.");
            e.getMessage();
        }

        Contract obj = new Contract(number, data, totalValue);

        System.out.print("Enter the number of installments: ");
        Integer installmentNumber = sc.nextInt(); sc.nextLine();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(obj, installmentNumber);

        System.out.println("\nInstallments: \n");
        for (Installment installment : obj.getInstallments()){
            System.out.println(installment);
        }

        sc.close();

    }
}