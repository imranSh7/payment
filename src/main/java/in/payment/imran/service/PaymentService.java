package in.payment.imran.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.payment.imran.entity.Payment;
import in.payment.imran.event.PaymentCompletedEvent;
import in.payment.imran.event.PaymentEventProducer;
import in.payment.imran.model.CheckoutResponse;
import in.payment.imran.model.PaymentGatewayRequest;
import in.payment.imran.model.PaymentGatewayResponse;
import in.payment.imran.model.PaymentRequest;
import in.payment.imran.model.PaymentResponse;
import in.payment.imran.repository.PaymentRepository;

@Service
public class PaymentService {

	private final PaymentRepository paymentRepository;
	private final PaymentEventProducer paymentEventProducer;

	private final RestTemplate restTemplate;

	public PaymentService(PaymentRepository paymentRepository, PaymentEventProducer paymentEventProducer,
			RestTemplate restTemplate) {
		super();
		this.paymentRepository = paymentRepository;
		this.paymentEventProducer = paymentEventProducer;
		this.restTemplate = restTemplate;
	}

	public PaymentResponse makePayment(PaymentRequest request) {

		// 1. Fetch Checkout Details

		CheckoutResponse checkoutResponse = restTemplate
				.getForObject("http://localhost:7009/checkouts/" + request.getCheckoutId(), CheckoutResponse.class);

		// 2. Call Payment Gateway

		PaymentGatewayRequest gatewayRequest = new PaymentGatewayRequest();

		gatewayRequest.setAmount(checkoutResponse.getTotalAmount());

		gatewayRequest.setPaymentMethod(request.getPaymentMethod());

		PaymentGatewayResponse gatewayResponse = restTemplate.postForObject("http://localhost:7014/gateway/pay",
				gatewayRequest, PaymentGatewayResponse.class);

		// 3. Save Payment

		Payment payment = new Payment();

		payment.setCheckoutId(checkoutResponse.getCheckoutId());

		payment.setCustomerId(checkoutResponse.getCustomerId());

		payment.setAmount(checkoutResponse.getTotalAmount());

		payment.setPaymentMethod(request.getPaymentMethod());

		payment.setStatus(gatewayResponse.getStatus());

		payment.setTransactionId(gatewayResponse.getTransactionId());

		payment.setPaymentDate(LocalDateTime.now());

		Payment saved = paymentRepository.save(payment);

		// 4. Response

		PaymentResponse response = new PaymentResponse();

		response.setPaymentId(saved.getPaymentId());

		response.setStatus(saved.getStatus());

		response.setTransactionId(saved.getTransactionId());

		PaymentCompletedEvent event = new PaymentCompletedEvent();

		event.setPaymentId(saved.getPaymentId());
		event.setCheckoutId(saved.getCheckoutId());
		event.setCustomerId(saved.getCustomerId());
		event.setCustomerName(saved.getCustomerName());
		event.setAmount(saved.getAmount());
		event.setPaymentMethod(saved.getPaymentMethod());
		event.setTransactionId(saved.getTransactionId());
		event.setStatus(saved.getStatus());

//		rabbitTemplate.convertAndSend(exchange, routingKey, event);

		paymentEventProducer.publishPaymentCompletedEvent(event);

		return response;

//		Payment payment = new Payment();
//
////		payment.setOrderId(request.getOrderId());
//		payment.setAmount(request.getAmount());
//		payment.setStatus("SUCCESS");
//		payment.setPaymentDate(LocalDateTime.now());
//
//		Payment savedPayment = paymentRepository.save(payment);
//
//		PaymentResponse response = new PaymentResponse();
//
//		response.setPaymentId(savedPayment.getPaymentId());
////		response.setOrderId(savedPayment.getOrderId());
//		response.setAmount(savedPayment.getAmount());
//		response.setStatus(savedPayment.getStatus());
//		response.setMessage("Payment Successfull");

	}

}
