package edu.guilford;

public class user {
    //attributes
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String favholiday;
    private String favcolor;
    private String favanimal;
    private String favseason;

    //constructor
    //empty constructor
    public user() {

    }

    //full constructor
    public user(String username, String firstname, String lastname, String email, String password, String favholiday, String favcolor, String favanimal, String favseason) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.favholiday = favholiday;
        this.favcolor = favcolor;
        this.favanimal = favanimal;
        this.favseason = favseason;
    }

    //getters and setters
    //username
    public String getUsername() {
        return username;
    }
    public String setUsername(String username) {
        this.username = username;
        return username;
    }
    //firstname
    public String getFirstname() {
        return firstname;
    }
    public String setFirstname(String firstname) {
        this.firstname = firstname;
        return firstname;
    }
    //lastname
    public String getLastname() {
        return lastname;
    }
    public String setLastname(String lastname) {
        this.lastname = lastname;
        return lastname;
    }
    //email
    public String getEmail() {
        return email;
    }
    public String setEmail(String email) {
        this.email = email;
        return email;
    }
    //password
    public String getPassword() {
        return password;
    }
    public String setPassword(String password) {
        this.password = password;
        return password;
    }
    //favholiday
    public String getFavholiday() {
        return favholiday;
    }
    public String setFavholiday(String favholiday) {
        this.favholiday = favholiday;
        return favholiday;
    }
    //favcolor
    public String getFavcolor() {
        return favcolor;
    }
    public String setFavcolor(String favcolor) {
        this.favcolor = favcolor;
        return favcolor;
    }
    //favanimal
    public String getFavanimal() {
        return favanimal;
    }
    public String setFavanimal(String favanimal) {
        this.favanimal = favanimal;
        return favanimal;
    }
    //favseason
    public String getFavseason() {
        return favseason;
    }
    public String setFavseason(String favseason) {
        this.favseason = favseason;
        return favseason;
    }
    

    //methods
    //generate a password for the user based on their first name, last name, favorite holiday, favorite color, favorite animal, and favorite season
    public void generatePassword() {
        //get the first letter of the user's first name
        String firstLetter = firstname.substring(0, 1);
        //get the first letter of the user's last name
        String lastLetter = lastname.substring(0, 1);
        //get the first letter of the user's favorite holiday
        String holidayLetter = favholiday.substring(0, 1);
        //get the first letter of the user's favorite color
        String colorLetter = favcolor.substring(0, 1);
        //get the first letter of the user's favorite animal
        String animalLetter = favanimal.substring(0, 1);
        //get the first letter of the user's favorite season
        String seasonLetter = favseason.substring(0, 1);
        //concatenate the first letters of the user's first name, last name, favorite holiday, favorite color, favorite animal, and favorite season
        String password = firstLetter + lastLetter + holidayLetter + colorLetter + animalLetter + seasonLetter;
        //print out password
        System.out.println("Your password is: " + password);
        

        //what is hashcode?
        //https://www.geeksforgeeks.org/understanding-hashcode-method-in-java/
        //setPassword(password.hashCode());

        //Write method that encrypts the password using the AES class 
        //and stores an encrypted version of generated password in the password attribute
        

    }
}
