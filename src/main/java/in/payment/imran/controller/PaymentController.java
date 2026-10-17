package in.payment.imran.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.payment.imran.model.PaymentRequest;
import in.payment.imran.model.PaymentResponse;
import in.payment.imran.service.PaymentService;

@RestController
@RequestMapping("/api/proceedToPayment")
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping
	public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentRequest request) {

		PaymentResponse response = paymentService.makePayment(request);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
