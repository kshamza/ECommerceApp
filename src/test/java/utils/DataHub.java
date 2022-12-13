package utils;

import java.util.Random;

public class DataHub {

    public static String emailAddress = "adamsandler";
    public static String password = "adamsandler";
    public static String dayOfBirth = "15";
    public static String monthOfBirth = "5";
    public static String yearOfBirth = "1975";
    public static String companyName = "Sandlers Inc.";

    public static String registeredEmail;

    public static String searchTerm = "shoes";

    public static String getEmailAddress(){
        Random rG = new Random();
        registeredEmail = emailAddress + rG.nextInt(1000) + "@gmail.com";
        return registeredEmail;
    }


}
