package ua.university;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class PaymentReportWriter {

    // додав параметр invalidLines - вони ж відкинуті
    public static void writeReport(Path out, List<Payment> payments, int invalidLines) throws IOException {
        long paidTotalCents = 0;
        int countNew = 0;
        int countPaid = 0;
        int countFailed = 0;

        for (Payment p : payments) {
            switch (p.status()) {
                case NEW -> countNew++;
                case PAID -> {
                    countPaid++;
                    paidTotalCents += p.amountCents();
                }
                case FAILED -> countFailed++;
            }
        }

        Path tempFile = out.resolveSibling(out.getFileName() + ".tmp");

        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("invalidLines=" + invalidLines);
            writer.newLine();
            writer.write("paidTotalCents=" + paidTotalCents);
            writer.newLine();
            writer.write("NEW=" + countNew + ", PAID=" + countPaid + ", FAILED=" + countFailed);
            writer.newLine();
        }

        try {
            Files.move(tempFile, out, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        } catch (AtomicMoveNotSupportedException e) {
            Files.move(tempFile, out, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}