package org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MailVerificationTest {
    private MailVerification mailVerification;

    private String[] validEmails = {
            "user@example.com",
            "User.Name@domain.co.uk",
            "first.last@sub.domain.gov.ma",
            "a@ab.cd",
            "TEST@EXAMPLE.COM",
            "user123@domain.com",
            "user_name@domain.co"
    };

    private String[] invalidEmails = {
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
            "user@domain.c_m",
            "user@-domain.com",
            ".user@domain.com",
            "user.@domain.com"
    };

    @BeforeEach
    public void setUp() {
        // Initialize with a default email
        mailVerification = new MailVerification("fahchouchmed@outlook.com");
        assertNotNull(mailVerification);
    }

    @Test
    public void testValidEmails() {
        for (String email : validEmails) {
            mailVerification.setEmail(email);
            Assertions.assertTrue(mailVerification.estValide(),
                    "expected valid for email: " + email);
        }
    }

    @Test
    public void testInvalidEmails() {
        for (String email : invalidEmails) {
            mailVerification.setEmail(email);
            assertFalse(mailVerification.estValide(),
                    "expected invalid for email: " + email);
        }
    }
}
