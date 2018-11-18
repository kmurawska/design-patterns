package com.kmurawska.designpatterns.builder;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuilderWithOrderAndMandatoryFieldsTest {
    private static final String FROM = "someone1@somewhere.com";
    private static final String TO = "someone2@somewhere.com";
    private static final String SUBJECT = "subject";
    private static final String CONTENT = "content";
    private static final String ATTACHMENT_1 = "attachment1";
    private static final String ATTACHMENT_2 = "attachment2";

    @Test
    void build() {
        EmailMessage emailMessage = EmailMessage.email()
                .from(FROM)
                .to(TO)
                .subject(SUBJECT)
                .content(CONTENT)
                .attachment(ATTACHMENT_1)
                .attachment(ATTACHMENT_2);

        assertEquals(FROM, emailMessage.getFrom());
        assertEquals(TO, emailMessage.getTo());
        assertEquals(SUBJECT, emailMessage.getSubject());
        assertEquals(CONTENT, emailMessage.getContent());
        assertEquals(Stream.of(ATTACHMENT_1, ATTACHMENT_2).collect(toSet()), new HashSet<>(emailMessage.getAttachments()));
    }
}