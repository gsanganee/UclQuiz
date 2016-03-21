package com.example.gaurang.hope;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class quiz extends Activity {
    // Sets up the buttons, textview and radiogroup used
    Button bt;
    TextView tv;
    RadioGroup rg;
    RadioButton r1,r2,r3;
    //Array of questions
    public static String questions []= {
            "1.Who played James Bond in 'Live and Let Die'?",
            "2.What was the name of the boy in the Jungle Book?",
            "3.What is the name of the actor who played the role of Harry Potter in the film series?",
            "4.What was the name of Dorothy's dog in the Wizard of Oz?",
            "5.Which film does the song 'Circle of Life' come from?",
            "6.Which movie does the following quote come from: Houston, we have a problem?",
            "7.Which movie does the following quote come from: You had me at hello?",
            "8.Which American singer/actress has appeared in Maid in Manhattan, Monster in Law and The Back Up Plan?",
            "9.Which 2008 movie starred Will Smith: Seven...?",
            "10.Charlie Chaplin insured which part of his body?",
};
    //Array of answers put in order of the questions
    String answers []= {
            "Roger Moore",
            "Mowgli",
            "Daniel Radcliffe",
            "Toto",
            "The Lion King",
            "Apollo 13",
            "Jerry Maguire",
            "Jennifer Lopez",
            "Pounds",
            "Feet",
    };
    //Array of options put in order of the questions (3 for each question with 1 correct answer)
    String opts []= {
            "Roger Moore", "Daniel Radcliff", "Idris Elba",
            "Simba","Mowgli","Tarzan",
            "Daniel Radcliffe","Rupert Grint","Alan Rickman",
            "Toto","Marley","Dodo",
            "The Lion King","the Jungle Book","Into the wild",
            "Apollo 13", "The Martian","Interstellar",
            "Jerry Maguire","Bridget Jones Diaries", "Love Actually",
            "Jennifer Lopez","Jennifer Aniston","Jennifer Lawrence",
            "Pounds","Stones","Dollars",
            "Lips","Hands","Feet"
    };
    //Initialises the position and the integer "correct"
    int position=0;
    public static int correct;
    @Override
    //Sets up the OnCreate method with the quiz layout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
    //Defining the Button, TextView, RadioGroup and RadioButtons by finding their relative ids)
        tv=(TextView)findViewById(R.id.question);
        bt=(Button)findViewById(R.id.movebt);
        rg=(RadioGroup)findViewById(R.id.rg);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);
    //Sets the text of the TextView and RadioButtons according to the position of the questions and answers starting with the 0th position. (first question)
        tv.setText(questions[position]);
        r1.setText(opts[position]);
        r2.setText(opts[position+1]);
        r3.setText(opts[position+2]);
    //Sets up the onClickListener
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    //The selected answer in found using its ID and changed into a string
                RadioButton selectedans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String selectedansText = selectedans.getText().toString();
    //If the string is the same as the answer in the specific position then 1 is added to the value of "correct"
                if (selectedansText==answers[position]) {
                    correct++;
                }
    //The position is increased by 1 (moving onto the next question/phase)
                position++;
    //If the position is less than the amount of questions then the next question is presented and the loop begins again, otherwise the results page is shown
                if(position<questions.length){
                    tv.setText(questions[position]);
                    r1.setText(opts[position*3]);
                    r2.setText(opts[position*3+1]);
                    r3.setText(opts[position*3+2]);
                }else{
    //Displays the Results page
                    Intent in = new Intent(getApplicationContext(),result.class);
                    startActivity(in);
                }
            }
        });
    }
}
