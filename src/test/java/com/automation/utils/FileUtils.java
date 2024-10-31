package com.automation.utils;

import java.io.File;
import java.util.Scanner;

public class FileUtils {
    Scanner sc;
    public FileUtils(String path){
        try{
            File f=new File(path);
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
        return fileContent;
    }
}
