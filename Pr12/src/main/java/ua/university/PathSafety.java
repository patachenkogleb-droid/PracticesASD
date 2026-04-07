package ua.university;

import java.nio.file.Path;

public class PathSafety {

    public static Path safeResolve(Path base, String userInput) {
        Path absoluteBase = base.toAbsolutePath().normalize();
        Path absoluteResolved = absoluteBase.resolve(userInput).normalize();

        if (!absoluteResolved.startsWith(absoluteBase)) {
            throw new IllegalArgumentException("Path traversal attempt detected: " + userInput);
        }

        return absoluteResolved;
    }
}