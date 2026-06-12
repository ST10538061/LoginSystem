package com.mycompany.login;

import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class MessageClass
{
    // Stores all sent messages
    private ArrayList<String> sentMessages = new ArrayList<>();
    private ArrayList<String> disregardedMessages = new ArrayList<>();

    private ArrayList<String> storedMessages = new ArrayList<>();

    private ArrayList<String> messageHashes = new ArrayList<>();

    private ArrayList<String> messageIDs = new ArrayList<>();

    // Counts total messages sent
    private int totalMessages = 0;

    // Checks if message ID is 10 characters or less
    public boolean checkMessageID(String id)
    {
        return id.length() <= 10;
    }

    // Checks recipient cellphone number format
    public String checkRecipientCell(String cell)
    {
        if(cell.startsWith("+27") && cell.length() <= 12)
        {
            return "Cell phone number successfully captured.";
        }
        else
        {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Checks message length
    public String checkMessageLength(String msg)
    {
        if(msg.length() <= 250)
        {
            return "Message ready to send.";
        }
        else
        {
            int excess = msg.length() - 250;

            return "Message exceeds 250 characters by "
                    + excess
                    + ", please reduce the size.";
        }
    }

    // Generates random 10-digit message ID
    public String generateMessageID()
    {
        Random rand = new Random();

        long number = 1000000000L
                + (long)(rand.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // Creates message hash
    public String createMessageHash(String id,
                                    int msgNum,
                                    String msg)
    {
        String[] words = msg.split(" ");

        String firstWord = words[0];

        String lastWord =
                words[words.length - 1];

        String hash =
                id.substring(0, 2)
                + ":"
                + msgNum
                + ":"
                + firstWord
                + lastWord;

        return hash.toUpperCase();
    }

    // Handles send/store/disregard options
    public String SentMessage(int option)
    {
        switch(option)
        {
            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

         default:
         return "Invalid option.";
        }
    }

    // Adds messages to ArrayList
    public void addMessage(String id,
                           String hash,
                           String recipient,
                           String message)
    {
        String details =
                "Message ID: " + id
                + "\nMessage Hash: " + hash
                + "\nRecipient: " + recipient
                + "\nMessage: " + message
                + "\n";

       sentMessages.add(details);

       messageIDs.add(id);
       messageHashes.add(hash);

       totalMessages++;
    }

    // Displays all stored messages
    public void printMessages()
    {
        for(String message : sentMessages)
        {
            System.out.println(message);
        }
    }

    // Returns total messages sent
    public int returnTotalMessages()
    {
        return totalMessages;
    }

    // Stores messages in JSON file
    public void storeMessage(String id,
                             String hash,
                             String recipient,
                             String message)
    {
        try
        {
            FileWriter writer =
                    new FileWriter("messages.json", true);

            writer.write("{\n");

            writer.write(
                    "\"MessageID\": \"" + id + "\",\n"
            );

            writer.write(
                    "\"MessageHash\": \"" + hash + "\",\n"
            );

            writer.write(
                    "\"Recipient\": \"" + recipient + "\",\n"
            );

            writer.write(
                    "\"Message\": \"" + message + "\"\n"
            );

            writer.write("}\n\n");

            writer.close();

            System.out.println(
                    "Message successfully stored in JSON."
            );
        }
        catch(IOException e)
        {
            System.out.println(
                    "Error storing message."
            );
        }
    }
    public void displayReport()
{
    System.out.println("\n===== MESSAGE REPORT =====");

    for(String msg : sentMessages)
    {
        System.out.println(msg);
        System.out.println("-------------------");
    }
}
}