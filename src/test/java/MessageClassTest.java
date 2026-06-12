package com.mycompany.login;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageClassTest
{
    MessageClass msg = new MessageClass();

    // Test valid recipient number
    @Test
    public void testRecipientNumberSuccess()
    {
        String result =
                msg.checkRecipientCell("+27718693002");

        assertEquals(
                "Cell phone number successfully captured.",
                result
        );
    }

    // Test invalid recipient number
    @Test
    public void testRecipientNumberFailure()
    {
        String result =
                msg.checkRecipientCell("0812345678");

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                result
        );
    }

    // Test valid message length
    @Test
    public void testMessageLengthSuccess()
    {
        String result =
                msg.checkMessageLength("Hello");

        assertEquals(
                "Message ready to send.",
                result
        );
    }

    // Test message exceeding 250 characters
    @Test
    public void testMessageLengthFailure()
    {
        String longMessage =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        String result =
                msg.checkMessageLength(longMessage);

        assertTrue(
                result.contains(
                        "Message exceeds 250 characters"
                )
        );
    }

    // Test message hash creation
    @Test
    public void testCreateMessageHash()
    {
        String hash =
                msg.createMessageHash(
                        "1234567890",
                        0,
                        "Hi tonight"
                );

        assertEquals(
                "12:0:HITONIGHT",
                hash
        );
    }

    // Test message ID length
    @Test
    public void testMessageIDLength()
    {
        boolean result =
                msg.checkMessageID("1234567890");

        assertTrue(result);
    }
}