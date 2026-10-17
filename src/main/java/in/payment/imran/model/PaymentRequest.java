package in.payment.imran.model;

public class PaymentRequest {
	private Long checkoutId;
	private String customerId;
	private String paymentMethod;
	private Double amount;

	public PaymentRequest(Long checkoutId, String customerId, String paymentMethod, Double amount) {
		super();
		this.checkoutId = checkoutId;
		this.customerId = customerId;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
	}

	public PaymentRequest() {
		super();
	}

	public Long getCheckoutId() {
		return checkoutId;
	}

	public void setCheckoutId(Long checkoutId) {
		this.checkoutId = checkoutId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
