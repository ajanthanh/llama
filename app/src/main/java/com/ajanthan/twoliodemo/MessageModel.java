package com.ajanthan.twoliodemo;

import java.util.ArrayList;

/**
 * Created by ajanthan on 16-09-18.
 */
public class MessageModel {
    private static MessageModel instance;

    private ArrayList<Message> received;
    private ArrayList<Article> processed;

    public static MessageModel getInstance(){
        if(instance == null){
            instance = new MessageModel();
        }
        return instance;
    }

    MessageModel(){
        received = new ArrayList<>();
        processed = new ArrayList<>();
        processed.add(new Article("CEO Can now be prosecuted Line war Criminals at the Hague",
                "Ajanthan in Askreddit","2199","10 hours",201,new ArrayList<Article>()));
        processed.add(new Article("CEO Can now be prosecuted Line war Criminals at the Hague",
                "Ajanthan in Askreddit","2199","10 hours",201,new ArrayList<Article>()));
        processed.add(new Article("CEO Can now be prosecuted Line war Criminals at the Hague",
                "Ajanthan in Askreddit","2199","10 hours",201,new ArrayList<Article>()));
    }

    public void addMessage(Message message){
        received.add(message);
        processMessage();
    }

    public ArrayList<Article> getProcessedArticles(){
        return processed;
    }

    private void processMessage(){
        // Todo: convert recieved messages into articles
        // Todo: call an update
    }

    public void clearProcessedMesaages(){
        processed = new ArrayList<>();
    }
}
