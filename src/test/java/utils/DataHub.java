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

    // Checkout data
    public static String country = "United States";
    public static String state = "New York";
    public static String stateValue = "16";

    public static String city = "New York";
    public static String addressFirstLine = "123 Main Street";
    public static String zipCode = "12345";
    public static String phoneNumber = "1234565555";

    public static String getEmailAddress(){
        Random rG = new Random();
        registeredEmail = emailAddress + rG.nextInt(1000) + "@gmail.com";
        return registeredEmail;
    }


}
