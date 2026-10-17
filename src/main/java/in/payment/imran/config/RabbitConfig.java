package in.payment.imran.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	

    @Value("${rabbitmq.exchange}")
    private String exchangeName;

//    @Value("${rabbitmq.queue}")
//    private String queueName;
//
//    @Value("${rabbitmq.routing-key}")
//    private String routingKey;
//
//    @Bean
//    public Queue paymentQueue() {
//        return QueueBuilder
//                .durable(queueName)
//                .build();
//    }
    @Bean
    public FanoutExchange paymentExchange() {
        return new FanoutExchange(exchangeName, true, false);
    }

//    @Bean
//    public Exchange paymentExchange() {
//        return new DirectExchange(exchangeName, true, false);
//    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());

        return rabbitTemplate;
    }
    
//    @Bean
//    public Binding paymentBinding(Queue paymentQueue,
//                                  FanoutExchange paymentExchange) {
//
//        return BindingBuilder
//                .bind(paymentQueue)
//                .to(paymentExchange);
//    }

//    @Bean
//    public Binding paymentBinding(Queue paymentQueue,
//                                  Exchange paymentExchange) {
//
//        return BindingBuilder
//                .bind(paymentQueue)
//                .to((DirectExchange) paymentExchange)
//                .with(routingKey);
//    }

}
