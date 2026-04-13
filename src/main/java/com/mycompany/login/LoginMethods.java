package com.mycompany.login;


public class LoginMethods 
{
    //stores user info after registration and private means only this class can access them.
    private String username;
    private String password;
    private String phoneNumber;
    
    //Check Username 
    public boolean checkUserName(String username)
    {
        return username.contains("_") && username.length()<= 5;
    }
    
    //check password 
    public boolean checkPasswordComplexity(String password)
  {
    boolean hasCapital = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;
    
    for (char c: password.toCharArray())
    {
        if (Character.isUpperCase(c)) 
        {
            hasCapital = true;            
        }
        else if (Character.isDigit(c))
        {
            hasNumber= true;
        }
        else if (! Character.isLetterOrDigit(c))
        {
            hasSpecial = true;
        }
    }
        return password.length()>= 8 && hasSpecial && hasNumber && hasCapital;
  } 
    // check the phone number
    public boolean checkCellPhoneNumber(String phoneNumber) 
    {
        return phoneNumber.startsWith("+27") && phoneNumber.length() == 12;
    }

    // Register User
    public String registerUser(String username, String password, String phoneNumber) 
    {

        if (!checkUserName(username)) 
        {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) 
        {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(phoneNumber)) 
        {
            return "Cell phone number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;

        return "User has been registered successfully.";
    }

    // Login User
    public boolean loginUser(String username, String password)  
    {
        return username  != null && password  != null && username.equals(this.username) && password.equals(this.password);
    }

    // Return Login Status
    public String returnLoginStatus(boolean status) 
    {
        if (status) 
        {
            return "Welcome " + username + ", it is great to see you again.";
        } 
        else
        {
            return "Username or password incorrect, please try again.";
        }
    }

}
