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


    public String getFirstName() {
        return letter;
    }

    public String getLastName() {
        return number;
    }

    public String getFavFood() {
        return accuracy;
    }

    public String getStreak() {return streak;}


}
