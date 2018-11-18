package com.kmurawska.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

class EmailMessage {
    private final String from, to;
    private String subject, content;
    private List<String> attachments = new ArrayList<>();

    private EmailMessage(String from, String to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    static FromBuilder email() {
        return from -> to -> subject -> content -> new EmailMessage(from, to, subject, content);
    }

    interface FromBuilder {
        ToBuilder from(String from);
    }

    interface ToBuilder {
        SubjectBuilder to(String to);
    }

    interface SubjectBuilder {
        ContentBuilder subject(String subject);
    }

    interface ContentBuilder {
        EmailMessage content(String content);
    }

    EmailMessage attachment(String attachment) {
        attachments.add(attachment);
        return this;
    }

    String getFrom() {
        return from;
    }

    String getTo() {
        return to;
    }

    String getSubject() {
        return subject;
    }

    String getContent() {
        return content;
    }

    List<String> getAttachments() {
        return attachments;
    }
}