package utils;

import java.util.Random;

public class DataHub {

    static String emailAddress = "adamsandler";
    static String password = "adamsandler";
    static String dayOfBirth = "15";
    static String monthOfBirth = "5";
    static String yearOfBirth = "1975";
    static String companyName = "Sandlers Inc.";

    static String registeredEmail;

    static String searchTerm = "shoes";

    public static String getEmailAddress(){
        Random rG = new Random();
        registeredEmail = emailAddress + rG.nextInt(1000) + "@gmail.com";
        return registeredEmail;
    }


}
