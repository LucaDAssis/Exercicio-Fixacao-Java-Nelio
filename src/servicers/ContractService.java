package servicers;

import Interface.OnlinePaymentService;
import domain.entities.Contract;
import domain.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
      double basciQuota = contract.getTotalValue() / months;

      for (int i = 1; i <= months; i++) {
          LocalDate dateDue = contract.getDate().plusMonths(i);

          double interest = onlinePaymentService.interest(basciQuota, i);
          double fee = onlinePaymentService.paymentFee(basciQuota + interest);
          double quota = basciQuota + interest + fee;

          contract.getInstallment().add(new Installment(dateDue, quota));
      }

    }
}
