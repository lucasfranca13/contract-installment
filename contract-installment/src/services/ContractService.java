package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;
import java.util.Locale;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;
    public ContractService(services.OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){ //recebe o contrato e qtd de meses

        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;


            contract.getInstallments().add(new Installment (dueDate, quota));

        }
    }
}
