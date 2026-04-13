package com.mycompany.login;
import java.util.Scanner;

public class Login
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        LoginMethods user = new LoginMethods();
        
        // Register the user by asking for their details 
        System.out.print("Enter username: ");
        String username= scan.nextLine();
        
        System.out.print("Enter password: ");        
        String password = scan.nextLine();
        
        System.out.print("Enter phone number (+27....) : ");
        String phone= scan.nextLine();
        
        //We are asking the login system to take our info to check it
        String results= user.registerUser(username, password, phone);
        System.out.println(results);
        
        //Printing the heading 
        System.out.println("======================================================================");
        System.out.println("                Login                                                 ");
        System.out.println("======================================================================");
        
        System.out.println("Enter username: ");
        String loginUser=scan.nextLine();
        
        System.out.println("Enter password: ");
        String loginPass=scan.nextLine();
        
        //system is checking if info is true
        boolean status= user.loginUser(loginUser, loginPass);
        System.out.println(user.returnLoginStatus(status));
                
    }
}
