package edu.guilford;

import java.time.Year;
import java.util.Scanner;

import javax.swing.text.html.parser.DTD;

/**
 * Hello world!
 *
 */
public class userPassword 
{
    public static void main( String[] args )
    {
        //insatiate a new user object
        user userMe = new user();
        //create a scanner object
        Scanner input = new Scanner(System.in);

        // Ask the user for their first name and print it out
        System.out.println("What is your first name?: ");
        String firstname = input.nextLine();
        userMe.setFirstname(firstname);
        System.out.println("Your first name is: " + userMe.getFirstname());

        // Ask the user for their last name and print it out
        System.out.println("What is your last name?: ");
        String lastname = input.nextLine();
        userMe.setLastname(lastname);
        System.out.println("Your last name is: " + userMe.getLastname());

        // Ask the user for holiday and print it out
        System.out.println("What is your favorite holiday?: ");
        String favholiday = input.nextLine();
        userMe.setFavholiday(favholiday);
        System.out.println("Your favorite holiday is: " + userMe.getFavholiday());

        // Ask the user for color and print it out
        System.out.println("What is your favorite color?: ");
        String favcolor = input.nextLine();
        userMe.setFavcolor(favcolor);
        System.out.println("Your favorite color is: " + userMe.getFavcolor());

        // Ask the user for animal and print it out
        System.out.println("What is your favorite animal?: ");
        String favanimal = input.nextLine();
        userMe.setFavanimal(favanimal);
        System.out.println("Your favorite animal is: " + userMe.getFavanimal());

        // Ask the user for season and print it out
        System.out.println("What is your favorite season?: ");
        String favseason = input.nextLine();
        userMe.setFavseason(favseason);
        System.out.println("Your favorite season is: " + userMe.getFavseason());

        //generate a password for the user based on their first name, last name, favorite holiday, favorite color, favorite animal, and favorite season
        userMe.generatePassword();
        //Let the class handle managing the attributes, and then use the driver program to get the password and print it out
        System.out.println("Your password is: " + userMe.getPassword());

        //encrypt the password using the AES class
        AES aes = new AES();

        //// Use the AES encryption algorithm to setKey and encrypt the password from AES.java
        aes.setKey("ThisisASecretKey");
        String strToEncrypt = userMe.getPassword();
        String encryptedPassword = aes.encrypt(strToEncrypt,"ThisisASecretKey");
        System.out.println("Your encrypted password is: " + encryptedPassword);

        //decrypt the password using the AES class
        String strToDecrypt = encryptedPassword;
        String decryptedPassword = aes.decrypt(strToDecrypt, "ThisIsASecretKey");
        System.out.println("Your decrypted password is: " + decryptedPassword + "\n");  

        //Make user decide if they want to decrypt the password
        //System.out.println("Would you like to decrypt your password? (y/n)");
        
        //String decrypt = input.nextLine();
        //if(decrypt == "y") {
            //String strToDecrypt = encryptedPassword;
            //String decryptedPassword = aes.decrypt(strToDecrypt, "ThisIsASecretKey");
            //System.out.println("Your decrypted password is: " + decryptedPassword + "\n");  
        
//}
        //else {
            //System.out.println("Thanks, you've chosen not to decrypt your password!");
       // }
    }
}

