package in.payment.imran.model;

public class PaymentResponse {

	private Long paymentId;
	private Double amount;
	private String status;
	private String message;
	private String transactionId;

	public PaymentResponse(Long paymentId, Double amount, String status, String message, String transactionId) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.status = status;
		this.message = message;
		this.transactionId = transactionId;
	}

	public PaymentResponse() {
		super();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
