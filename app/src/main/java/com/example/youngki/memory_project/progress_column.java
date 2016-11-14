package com.example.youngki.memory_project;

public class progress_column{
    private String letter;
    private String number;
    private String accuracy;
    private String streak;

    public progress_column (String ltr,String num, String acc, String strk){
        letter = ltr;
        number = num;
        accuracy = acc;
        streak = strk;
    }


    public String getLetter() {
        return letter;
    }

    public String getValue() {
        return number;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public String getStreak() {return streak;}


}
