package in.payment.imran.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

//    @Value("${rabbitmq.routing-key}")
//    private String routingKey;

    public PaymentEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
  public void publishPaymentCompletedEvent(PaymentCompletedEvent event) {
    
    rabbitTemplate.convertAndSend(
            exchange,
            "",
            event);

//    public void publishPaymentCompletedEvent(PaymentCompletedEvent event) {
//
//        rabbitTemplate.convertAndSend(
//                exchange,
//                routingKey,
//                event);

        System.out.println("PaymentCompletedEvent Published : "
                + event.getPaymentId());

    }
}
