package com.uniarcadia.pixaclubapp.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {

    public static ArrayList<String> getDirectoryPaths(String directory, ArrayList<String> pathArray) {
        File file = new File(directory);
        File[] listFiles = file.listFiles();
        for (File currentFile : listFiles) {
            if (currentFile.isDirectory()) {
                pathArray.add(currentFile.getPath());
                getDirectoryPaths(currentFile.getPath(), pathArray);
            }
        }

        return pathArray;
    }

    public static ArrayList<String> getFilePaths(String dir) {
        ArrayList<String> pathArray = new ArrayList<>();
        File file = new File(dir);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File currentFile : listFiles) {
                if (currentFile.isFile()) {
                    pathArray.add(currentFile.getPath());
                }
            }
        }

        return pathArray;
    }


}
