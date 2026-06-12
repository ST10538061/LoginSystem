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
    public String registerUser(String firstName,
                           String lastName,
                           String username,
                           String password,
                           String cell)
{
    this.username = username;
    this.password = password;
    this.phoneNumber = cell;

    if(!checkUserName(username))
    {
        return "Username is not correctly formatted.";
    }

    if(!checkPasswordComplexity(password))
    {
        return "Password is not correctly formatted.";
    }

    if(!checkCellPhoneNumber(cell))
    {
        return "Cell phone number incorrectly formatted.";
    }

    return "User successfully registered.";
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



