public record Order(long id, String userEmail, long totalCents) {
    public Order {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (userEmail == null || !userEmail.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (totalCents < 0) {
            throw new IllegalArgumentException("Invalid total");
        }
    }
}