package in.payment.imran.model;

public class PaymentGatewayResponse {

	private String status;

	private String transactionId;

	private String message;

	public PaymentGatewayResponse(String status, String transactionId, String message) {
		super();
		this.status = status;
		this.transactionId = transactionId;
		this.message = message;
	}

	public PaymentGatewayResponse() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
