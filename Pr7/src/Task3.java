import java.io.IOException;

class ReceiptGenerationException extends RuntimeException {
    public ReceiptGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ReceiptWriter implements AutoCloseable {
    public void write(String orderId) throws IOException {
        System.out.println("Writing receipt for: " + orderId);
        throw new IOException("Failed to write to disk");
    }

    @Override
    public void close() {
        System.out.println("ReceiptWriter closed automatically.");
    }
}

class ReceiptService {
    public void generate(String orderId) {
        try (ReceiptWriter writer = new ReceiptWriter()) {
            writer.write(orderId);
        } catch (IOException e) {
            throw new ReceiptGenerationException("Error generating receipt for " + orderId, e);
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        ReceiptService service = new ReceiptService();
        try {
            service.generate("Order-456");
        } catch (ReceiptGenerationException e) {
            System.out.println("Caught exception: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
    }
}