package com.mycompany.login;
import java.util.Scanner;

public class Login
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        // Objects for login and messaging features
        LoginMethods user = new LoginMethods();
        MessageClass msg = new MessageClass();

        // User registration
        System.out.print("Enter first name: ");
        String firstName = scan.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scan.nextLine();

        System.out.print("Enter username: ");
        String username = scan.nextLine();

        System.out.print("Enter password: ");
        String password = scan.nextLine();

        System.out.print("Enter cellphone number: ");
        String cell = scan.nextLine();

        System.out.println(
                user.registerUser(
                        firstName,
                        lastName,
                        username,
                        password,
                        cell
                )
        );

        // User login
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter username: ");
        String loginUser = scan.nextLine();

        System.out.print("Enter password: ");
        String loginPass = scan.nextLine();

        boolean status =
                user.loginUser(loginUser, loginPass);

        System.out.println(
                user.returnLoginStatus(status)
        );

        // Allow access only if login is successful
        if(status)
        {
            System.out.println("\nWelcome to QuickChat.");
        }
        else
        {
            return;
        }

        int choice = 0;

        // Display menu until user quits
        while(choice != 3)
        {
            System.out.println("\n===== QUICKCHAT MENU =====");

            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Stored Messages");
            System.out.println("4) Quit");

            System.out.print("Choose option: ");

            choice = scan.nextInt();
            scan.nextLine();

            // Send messages
            if(choice == 1)
            {
                System.out.print(
                        "How many messages would you like to send? " );

                int numMessages = scan.nextInt();
                scan.nextLine();

                // Loop through all messages
                for(int i = 0; i < numMessages; i++)
                {
                    System.out.println(
                            "\nMessage " + (i + 1)
                    );

                    // Collect recipient number
                    System.out.print(
                            "Enter recipient number: "
                    );

                    String recipient =
                            scan.nextLine();

                    System.out.println(
                            msg.checkRecipientCell(recipient)
                    );

                    // Collect message text
                    System.out.print(
                            "Enter your message: "
                    );

                    String text =
                            scan.nextLine();

                    System.out.println(
                            msg.checkMessageLength(text)
                    );

                    // Generate message ID and hash
                    String id =
                            msg.generateMessageID();

                    String hash =
                            msg.createMessageHash(
                                    id,
                                    i,
                                    text
                            );

                    System.out.println(
                            "Message ID: " + id
                    );

                    System.out.println(
                            "Message Hash: " + hash
                    );

                    // Message options
                    System.out.println("\n1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message");

                    int sendChoice =
                            scan.nextInt();

                    scan.nextLine();

                    System.out.println(
                            msg.SentMessage(sendChoice)
                    );

                    // Save message details
                    msg.addMessage(
                            id,
                            hash,
                            recipient,
                            text
                    );
                }

                // Display total messages sent
                System.out.println(
                        "\nTotal messages sent: "
                        + msg.returnTotalMessages()
                );
            }

            // Future feature placeholder
            else if(choice == 2)
            {
                System.out.println("Longest Message:");
                System.out.println(msg);
            }

            // Exit program
            else if(choice == 3)
            {
                System.out.println("\n===== STORED MESSAGES MENU =====");
                System.out.println("1) Display Sender and Recipient");
                System.out.println("2) Display Longest Message");
                System.out.println("3) Search by Message ID");
                System.out.println("4) Search by Recipient");
                System.out.println("5) Delete by Message Hash");
                System.out.println("6) Display Report");

                int storedChoice = scan.nextInt();
                scan.nextLine();
                
                if (storedChoice == 6)
                {
                        msg.printMessages();
                }
            }

            else if(choice == 4)
            {
                System.out.println("Goodbye!");
            }
        }
    }
}