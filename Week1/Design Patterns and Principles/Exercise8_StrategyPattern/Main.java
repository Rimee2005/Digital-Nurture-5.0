public class Main {


public static void main(String[] args) {

    PaymentContext paymentContext = new PaymentContext();

    paymentContext.setPaymentStrategy(
            new CreditCardPayment());
    paymentContext.makePayment(5000);

    paymentContext.setPaymentStrategy(
            new PayPalPayment());
    paymentContext.makePayment(2500);
}


}
