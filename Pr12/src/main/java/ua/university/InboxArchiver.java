package ua.university;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class InboxArchiver {

    public static void prepareTestData(Path inbox) throws IOException {
        Files.createDirectories(inbox);
        Files.createFile(inbox.resolve("data1.txt"));
        Files.createFile(inbox.resolve("data2.txt"));
        Files.createFile(inbox.resolve("temp_report_1.tmp"));
        Files.createFile(inbox.resolve("temp_report_2.tmp"));
        Files.createFile(inbox.resolve("old_cache.tmp"));
    }

    public static void archiveTmpFiles(Path inbox, Path archive) throws IOException {
        if (!Files.exists(inbox)) {
            return;
        }

        Files.createDirectories(archive);

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(inbox, "*.tmp")) {
            for (Path file : stream) {
                Path target = archive.resolve(file.getFileName());
                Files.move(file, target, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }
}
