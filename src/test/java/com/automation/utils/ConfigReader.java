package com.automation.utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;
    public static void initConfig(){
        properties=new Properties();
        try{
            properties.load(new FileReader("src/test/resources/config/config.properties"));
        } catch (Exception e) {
            System.out.println("unable to load config file!!");
        }
    }

    public static String getConfigValue(String key){
        return properties.getProperty(key);
    }

    public static void setConfigValue(String key,String value){
        properties.setProperty(key, value);
    }
}
