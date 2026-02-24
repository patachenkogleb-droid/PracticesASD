class SimpleLogger implements Logger {
    private final String className;

    public SimpleLogger(String className) {
        this.className = className;
    }

    private void log(String level, String message, Object... args) {
        String formattedMessage = message;
        for (Object arg : args) {
            formattedMessage = formattedMessage.replaceFirst("\\{\\}", String.valueOf(arg));
        }
        System.out.printf("[%s] %s: %s%n", level, className, formattedMessage);
    }

    @Override
    public void info(String message, Object... args) {
        log("INFO", message, args);
    }

    @Override
    public void warn(String message, Object... args) {
        log("WARN", message, args);
    }

    @Override
    public void error(String message, Object... args) {
        log("ERROR", message, args);
    }
}

class LoggerFactory {
    public static Logger getLogger(Class<?> clazz) {
        return new SimpleLogger(clazz.getName());
    }
}

class CheckoutService {
    private static final Logger log = LoggerFactory.getLogger(CheckoutService.class);

    public void checkout(String orderId, String token, String status) {
        if ("TIMEOUT".equals(status)) {
            log.error("Gateway timeout for order: {}", orderId);
            return;
        }

        if ("DECLINED".equals(status)) {
            log.warn("Payment declined for order: {}. Token: {}", orderId, "***");
            return;
        }

        log.info("Checkout successful for order: {}", orderId);
    }
}