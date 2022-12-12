package Exercises.E04StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Vomer\\OneDrive - Software University (SoftUni)\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        PrintWriter writer = new PrintWriter("output_line_numbers.txt");
        int number = 1;
        for (String line : allLines) {
            writer.println(number + ". " + line);
            number++;
        }

        writer.close();
    }
}
