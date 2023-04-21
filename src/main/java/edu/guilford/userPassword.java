package edu.guilford;

import java.util.Scanner;

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
        
        //encrypt the password using the AES class
        AES aes = new AES();

        String encryptedPassword = aes.encrypt(userMe.getPassword());
        System.out.println("Your encrypted password is: " + encryptedPassword);



}
