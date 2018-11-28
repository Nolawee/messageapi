package com.nolawee.messageapi.model;

public class ErrorMessage {
    private String err_msg;

    public ErrorMessage() {
    }

    public ErrorMessage(String err_msg, Hash hash) {
        this.err_msg = err_msg;
    }


    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = "Message Not Found";
    }

}
