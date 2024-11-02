package com.automation.utils;

import java.io.File;
import java.util.Scanner;

public class FileUtils {
    Scanner sc;
    File f;
    public FileUtils(String path){
        try{
            f=new File(path);
            sc=new Scanner(f);
        } catch (Exception e) {
            System.out.println("unable to load file");
        }
    }

    public String getFileContent(){
        String fileContent="";
        while (sc.hasNextLine()){
            fileContent=fileContent.concat(sc.nextLine());
        }
        sc.close();
        return fileContent;
    }

    public boolean deleteFile(){
        return f.delete();
    }
}
