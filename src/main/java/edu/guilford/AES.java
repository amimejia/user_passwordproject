package edu.guilford;

/**
 *
 * @author bousabacw
 */


//These are the imports that you need to use AES encryption
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//This is the AES class
public class AES {

    //This is the secret key that is used to encrypt and decrypt the user's password
    //This is a static variable and the key in the setKey method is a local variable
    //Static is a keyword that means that the variable is shared by all instances of the class
    //(An attribute is a variable that is associated with a class)
    private static SecretKeySpec secretKey;
    
    //Static byte[] key is a static variable that is an array of bytes
    //The purpose of byte[] key is to store the key that is used to encrypt and decrypt the user's password
    //This allows us to not store it in a normal String variable but instead store it in a byte array in order to make it more secure and harder to access
    private static byte[] key;

    //This method is used to set the key that is used to encrypt and decrypt the user's password
    public static void setKey(String myKey) {
        //This try catch block is used to catch any exceptions that may occur
        //When do you know to use a try catch block?
        //You know to use a try catch block when you are using a method that throws an exception
        //A method that throws an exception is a method that may cause an error
        MessageDigest sha = null;
        try {
            //This line of code is used to convert the String myKey into a byte array
            key = myKey.getBytes("UTF-8");
            //This line of code is used to create a SHA-1 hash of the key
            //Hashing is the process of taking a string of any length and converting it into a fixed length string
            //What a difference between a hash and an array?
            //A hash is a fixed length string and an array is a variable length string
            sha = MessageDigest.getInstance("SHA-1");
            //This line of code is used to hash the key
            key = sha.digest(key);
            //This line of code is used to take the first 16 bytes of the key
            key = Arrays.copyOf(key, 16);
            //This line of code is used to create a secret key
            secretKey = new SecretKeySpec(key, "AES");
        //This catch block is used to catch any exceptions that may occur
        //NoSuchAlgorithmException is an exception that occurs when you try to use an algorithm that does not exist
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        //UnsupportedEncodingException is an exception that occurs when you try to use an encoding that does not exist
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //This method is used to encrypt the user's password
    //The String strToEncrypt is the user's password
    //The String secret is the secret key that is used to encrypt the user's password
    //The String encrypt is the encrypted user's password
    public static String encrypt(String strToEncrypt, String secret) {
        try {
            //This line of code is used to set the key that is used to encrypt the user's password
            setKey(secret);
            //This line of code is used to create a cipher
            //A cipher is an algorithm that is used to encrypt and decrypt data
            //The getInstance method is a method that is used to create an object of a class
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //This line of code is used to initialize the cipher
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //This is returning the encrypted user's password
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            //This line of code is used to print out the error message
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    //This method is used to decrypt the user's password
    public static String decrypt(String strToDecrypt, String secret) {
        try {
            //This line of code is used to set the key that is used to decrypt the user's password
            setKey(secret);
            //This line of code is used to create a cipher for decryption
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            //This line of code is used to initialize the cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            //This line of code is used to return the decrypted user's password
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            //This line of code is used to print out the error message
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    
}
