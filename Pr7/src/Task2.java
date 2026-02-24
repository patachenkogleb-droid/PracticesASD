import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PaymentGatewayException extends Exception {
    public PaymentGatewayException(String message) {
        super(message);
    }
}

class AppException extends RuntimeException {
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}

class OrderProcessingException extends AppException {
    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public void checkout(String orderId, String userEmail) {
        try {
            callExternalGateway();
        } catch (PaymentGatewayException e) {
            String contextMessage = String.format("Checkout failed for orderId: %s, email: %s", orderId, userEmail);

            log.error(contextMessage, e);

            throw new OrderProcessingException(contextMessage, e);
        }
    }

    private void callExternalGateway() throws PaymentGatewayException {
        throw new PaymentGatewayException("Connection refused by payment provider");
    }
}