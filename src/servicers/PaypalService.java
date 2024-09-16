package servicers;

import Interface.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService {
    @Override
    public double paymentFee(double amount) {
        return amount * 0.02;
    }

    @Override
    public Double interest(double amount, Integer moths) {
        return amount * 0.01 * moths;
    }
}
