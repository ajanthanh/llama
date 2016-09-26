package com.ajanthan.twoliodemo;

/**
 * Created by ajanthan on 16-09-18.
 */
public class Message {
    public enum MessageType {SEND, RECIEVE}

    private String number;
    private String text;
    private MessageType type;

    Message(String number, String text, MessageType type){
        this.number = number;
        this.text = text;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public MessageType getType() {
        return type;
    }
}
