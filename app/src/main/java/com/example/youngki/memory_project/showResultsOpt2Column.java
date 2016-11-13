package com.example.youngki.memory_project;

public class showResultsOpt2Column {
    private String letter;
    private String number;
    private String accuracy;
    private String correct;

    public showResultsOpt2Column (String ltr,String num, String crect, String acc){
        letter = ltr;
        number = num;
        accuracy = acc;
        correct = crect;
    }


    public String getLetter() {
        return letter;
    }

    public String getValue() {
        return number;
    }

    public String getCorrect() {return correct;}

    public String getAcc() {return accuracy;}


}
