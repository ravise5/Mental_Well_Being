package com.back4app.quickstartexampleapp;

public class UCLA {

    private String mQuestion;

    private int mResponse;

    public UCLA(String question){
        mQuestion = question;

    }

    String getQuestion(){
        return mQuestion;
    }

    int getResponse(){
        return mResponse;
    }

    void updateResponse(int r){
        mResponse = r;
    }
}
