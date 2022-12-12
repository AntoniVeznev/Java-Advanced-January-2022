package Exercises.E04StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Vomer\\OneDrive - Software University (SoftUni)\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        long sum = 0;

        byte[] allBytes = Files.readAllBytes(Path.of(path));
        for (byte ascii : allBytes) {
            if (ascii != 10 && ascii != 13) {
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
