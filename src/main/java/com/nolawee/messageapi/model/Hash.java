package com.nolawee.messageapi.model;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    private String digest;

    public Hash() {
    }

    public Hash(String messageText) {
        this.setDigest(Create256ShaHash(messageText));
    }

    public static String Create256ShaHash (String message) {

        // https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java/5531479
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] bytes = digest.digest(message.getBytes(StandardCharsets.UTF_8));

        // https://gist.github.com/avilches/750151
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));

        return result.toString();

    }


    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}
