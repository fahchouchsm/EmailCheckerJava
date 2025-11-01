package org;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MailVerificationTest {
    private MailVerification mailVerification;

    private final String[] validEmails = {
            "user@example.com",
            "User.Name@domain.co.uk",
            "first.last@sub.domain.gov.ma",
            "TEST@EXAMPLE.COM",
            "user123@domain.com",
            "user_name@domain.co"
    };

    private final String[] invalidEmails = {
            "",
            null,
            "plainaddress",
            "@no-local-part.com",
            "user@.com",
            "user@domain.c",
            "user@domain..com",
            "user@domain,com",
            "user@domaincom",
            "user@domain.",
            "user@-domain.com",
            ".user@domain.com",
            "user.@domain.com"
    };

    @BeforeEach
    public void setUp() {
        mailVerification = new MailVerification("fahchouchmed@outlook.com");
        assertNotNull(mailVerification);
    }


    @Test
    public void testInvalidEmails() {
        for (String email : invalidEmails) {
            System.out.println(email);
            mailVerification.setEmail("email");
            assertFalse(mailVerification.estValide(),
                    "Expected invalid for email: " + email);
        }
    }

    @Test
    public void testValidEmails() {
        for (String email : validEmails) {
            mailVerification.setEmail(email);
            assertTrue(mailVerification.estValide());
        }
    }
}
