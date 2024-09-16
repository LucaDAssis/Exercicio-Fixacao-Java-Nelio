package Interface;

public interface OnlinePaymentService {

    double paymentFee(double amount);
    Double interest(double amount, Integer moths);
}
