package ua.university;

import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) throws Exception {
        Path tempDir = Files.createTempDirectory("java_io_demo");

        Path csvFile = tempDir.resolve("payments.csv");
        Files.writeString(csvFile, "id,email,status,amountCents\n1,a@mail.com,PAID,15000\n2,b@mail.com,NEW,5000\nerror_row\n");
        LoadResult result = PaymentLoader.loadWithStats(csvFile);
        System.out.println("Task 1");
        System.out.println("Valid: " + result.payments().size() + ", Invalid: " + result.invalidLines());

        Path reportFile = tempDir.resolve("report.txt");
        PaymentReportWriter.writeReport(reportFile, result.payments(), result.invalidLines());
        System.out.println("\nTask 2");
        System.out.println(Files.readString(reportFile));

        Path inbox = tempDir.resolve("practical-data/inbox");
        Path archive = tempDir.resolve("practical-data/archive");
        InboxArchiver.prepareTestData(inbox);
        InboxArchiver.archiveTmpFiles(inbox, archive);
        System.out.println("Task 3");
        System.out.println("Files in archive: " + Files.list(archive).count());
        System.out.println("Files left in inbox: " + Files.list(inbox).count());

        Path base = tempDir.resolve("baseDir");
        System.out.println("\nTask 4");
        System.out.println("Safe resolve: " + PathSafety.safeResolve(base, "reports/2025.txt"));
        try {
            PathSafety.safeResolve(base, "../secret.txt");
        } catch (IllegalArgumentException e) {
            System.out.println("Blocked: " + e.getMessage());
        }

        Path binFile = tempDir.resolve("status.bin");
        StatusFile.initFile(binFile, 10);
        StatusFile.updateStatus(binFile, 3, (byte) 99);
        System.out.println("\nTask 5");
        System.out.println("Byte at index 3: " + StatusFile.readStatus(binFile, 3));
    }
}