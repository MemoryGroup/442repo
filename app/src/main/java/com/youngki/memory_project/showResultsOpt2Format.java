
package com.youngki.memory_project;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class showResultsOpt2Format  extends ArrayAdapter<showResultsOpt2Column> {

    private LayoutInflater mInflater;
    private ArrayList<showResultsOpt2Column> scores;
    private int mViewResourceId;

    //http://htmlcolorcodes.com/
    private static String resRed = "#F52611";
    private static String resGreen = "#25CA2C";
    private static String resTitle = "#151417";


    public showResultsOpt2Format(Context context, int textViewResourceId, ArrayList<showResultsOpt2Column> curscor) {
        super(context, textViewResourceId, curscor);
        this.scores = curscor;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        showResultsOpt2Column current = scores.get(position);

        if (scores != null) {
            TextView letter = (TextView) convertView.findViewById(R.id.textLtr);
            TextView value = (TextView) convertView.findViewById(R.id.textNum);
            TextView correct = (TextView) convertView.findViewById(R.id.textStreak);
            TextView accuracy = (TextView) convertView.findViewById(R.id.textAcc);

            //Todo: different colored text: http://stackoverflow.com/questions/6094315/single-textview-with-two-different-colored-text

            boolean wasCorrect = false;


            if (correct!= null) {

                String test_correct = current.getCorrect();
                if (test_correct.compareTo("\u2713") == 0){
                    wasCorrect = true;
                    test_correct = "<font color=" + resGreen + ">" + test_correct + "</font>";

                }else if (test_correct.compareTo("\u2716") == 0){
                    test_correct = "<font color=" + resRed + ">" + test_correct + "</font>";
                }else{
                    test_correct = "<font color=" + resTitle + ">" + test_correct + "</font>";
                }


                //version check for deprecated method
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    correct.setText(Html.fromHtml(test_correct,Html.FROM_HTML_MODE_LEGACY));
                } else {
                    //noinspection deprecation
                    correct.setText(Html.fromHtml(test_correct));
                }


            }
            if (letter != null) {
                String test_letter = current.getLetter();
                if(wasCorrect){
                    test_letter  = "<font color=" + resGreen + ">" + test_letter + "</font>";
                }else if(test_letter.compareTo("Letter") == 0){
                    test_letter  = "<font color=" + resTitle + ">" + test_letter + "</font>";
                }else{
                    test_letter  = "<font color=" + resRed + ">" + test_letter + "</font>";
                }

                //version check for deprecated method
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    letter.setText(Html.fromHtml(test_letter,Html.FROM_HTML_MODE_LEGACY));
                } else {
                    //noinspection deprecation
                    letter.setText(Html.fromHtml(test_letter));
                }

            }
            if (value != null) {

                String test_value = current.getValue();
                if(wasCorrect){
                    test_value  = "<font color=" + resGreen + ">" + test_value + "</font>";
                }else if(test_value.compareTo("Number") == 0){
                    test_value  = "<font color=" + resTitle + ">" + test_value + "</font>";
                }else{
                    test_value  = "<font color=" + resRed + ">" + test_value + "</font>";
                }

                //version check for deprecated method
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    value.setText(Html.fromHtml(test_value,Html.FROM_HTML_MODE_LEGACY));
                } else {
                    //noinspection deprecation
                    value.setText(Html.fromHtml(test_value));
                }

            }

            if (accuracy != null) {

                String test_acc = current.getAcc();
                if(wasCorrect){
                    test_acc  = "<font color=" + resGreen + ">" + test_acc + "</font>";
                }else if(test_acc.compareTo("Overall") == 0){
                    test_acc  = "<font color=" + resTitle + ">" + test_acc + "</font>";
                }else{
                    test_acc  = "<font color=" + resRed + ">" + test_acc + "</font>";
                }

                //version check for deprecated method
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    accuracy.setText(Html.fromHtml(test_acc,Html.FROM_HTML_MODE_LEGACY));
                } else {
                    //noinspection deprecation
                    accuracy.setText(Html.fromHtml(test_acc));
                }

            }
        }

        return convertView;
    }
}
