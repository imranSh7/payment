package in.payment.imran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.payment.imran.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
	


}
