package Exercises.E04StreamsFilesAndDirectories;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {

        String path = "C:\\Users\\Vomer\\OneDrive - Software University (SoftUni)\\Desktop\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);
        File[] allFiles = folder.listFiles();

        int folderSize = 0;
        for (File file : allFiles) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);
    }
}
