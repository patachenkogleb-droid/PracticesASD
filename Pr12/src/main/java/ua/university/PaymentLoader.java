package ua.university;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

record Payment(String id, String email, PaymentStatus status, long amountCents) {}

record LoadResult(List<Payment> payments, int invalidLines) {}

enum PaymentStatus {
    NEW, PAID, FAILED
}

public class PaymentLoader {

    public static LoadResult loadWithStats(Path csv) {
        List<Payment> payments = new ArrayList<>();
        int invalidLines = 0;

        try (BufferedReader reader = Files.newBufferedReader(csv)) {
            String header = reader.readLine();
            if (header == null) {
                return new LoadResult(payments, invalidLines);
            }

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    invalidLines++;
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length != 4) {
                    invalidLines++;
                    continue;
                }

                try {
                    String id = parts[0].trim();
                    String email = parts[1].trim();
                    PaymentStatus status = PaymentStatus.valueOf(parts[2].trim().toUpperCase());
                    long amountCents = Long.parseLong(parts[3].trim());

                    payments.add(new Payment(id, email, status, amountCents));
                } catch (IllegalArgumentException e) {
                    invalidLines++;
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return new LoadResult(payments, invalidLines);
    }
}