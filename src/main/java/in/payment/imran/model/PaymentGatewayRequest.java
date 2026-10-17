package in.payment.imran.model;

public class PaymentGatewayRequest {

	private Double amount;

	private String paymentMethod;

	public PaymentGatewayRequest(Double amount, String paymentMethod) {
		super();
		this.amount = amount;
		this.paymentMethod = paymentMethod;
	}

	public PaymentGatewayRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
