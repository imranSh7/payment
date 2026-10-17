package in.payment.imran.model;

public class CheckoutResponse {

	private Long checkoutId;
	private Long customerId;
	private String customerName;
	private String paymentMethod;
	private Double totalAmount;
	private String status;

	public CheckoutResponse(Long checkoutId, Long customerId, String customerName, String paymentMethod,
			Double totalAmount, String status) {
		super();
		this.checkoutId = checkoutId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.paymentMethod = paymentMethod;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public CheckoutResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCheckoutId() {
		return checkoutId;
	}

	public void setCheckoutId(Long checkoutId) {
		this.checkoutId = checkoutId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
