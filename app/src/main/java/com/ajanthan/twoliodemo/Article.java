package com.ajanthan.twoliodemo;

import java.util.ArrayList;

/**
 * Created by ajanthan on 16-09-18.
 */
public class Article {
    private String text;
    private String author;
    private String score;
    private String date;
    private int numChildren;
    private ArrayList<Article> children;

    Article(String text, String author, String score, String date, int numChildren, ArrayList<Article> children){
        this.text = text;
        this.author = author;
        this.score = score;
        this.date = date;
        this. numChildren = numChildren;
        if(children!=null && !children.isEmpty()){
            this.children = children;
        }else{
            children = new ArrayList<>();
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumChildren() {
        return numChildren + " comments";  //Todo fix
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public ArrayList<Article> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Article> children) {
        this.children = children;
    }
}
