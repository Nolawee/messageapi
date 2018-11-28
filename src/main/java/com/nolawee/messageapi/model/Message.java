package com.nolawee.messageapi.model;

public class Message {
    private String text;
    private Hash hash;

    public Message() {
    }

    public Message(String text, Hash hash) {
        this.text = text;
        this.hash = hash;
    }

    public Hash getMessageHash() {
        return hash;
    }

    public void setMessageHash(Hash messageHash) {
        this.hash = messageHash;
    }

    public void setMessageHash() {
        this.setMessageHash(new Hash(this.getText()));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Hash getHash() {
        return hash;
    }

    public void setHash(Hash hash) {
        this.hash = hash;
    }

    public void setHash() {

    }
}
