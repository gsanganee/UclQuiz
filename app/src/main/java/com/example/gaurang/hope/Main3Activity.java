package com.example.gaurang.hope;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main3Activity extends Activity {
    // Sets up the buttons, textview and radiogroup used
    Button bt;
    TextView tv;
    RadioGroup rg;
    RadioButton r1,r2,r3;
    //Array of questions
    public static String questions []= {
            "1.	How many teeth should a human adult have, including wisdom teeth?",
            "2.	What is the freezing point of water?",
            "3.	What does an anemometer measure?",
            "4.	How many bones are there in the human body?",
            "5.	What is the Chemical Symbol for Iron?",
            "6.	Which vitamin does sunlight provide to humans?",
            "7.	Which metal makes the strongest magnets?",
            "8.	What is the strongest muscle in the human body?",
            "9.	Where are red blood cells made?",
            "10. What number is neutral measured at on the PH Scale?"
};
    //Array of answers put in order of the questions
    String answers []= {
            "32",
            "0 degrees Celsius",
            "The speed of wind",
            "206",
            "Fe",
            "Vitamin D",
            "Iron",
            "The tongue",
            "In the bone marrow",
            "7",
    };
    //Array of options put in order of the questions (3 for each question with 1 correct answer)
    String opts []= {
            "28","32","342",
            "0 degrees Celsius","32 degrees Celsius","15 degrees Celsius",
            "The speed of wind","The speed of light","The speed of sound",
            "206","196","226",
            "I","Fe","Fr",
            "Vitamin A","Vitamin E","Vitamin D",
            "Steel","Magnesium","Iron",
            "The tongue", "Triceps", "Bicep",
            "In the bone marrow","The heart","The liver",
            "9","7","5"

    };
    //Initialises the position and the integer "correct"
    int position=0;
    public static int correct;
    @Override
    //Sets up the OnCreate method with the quiz layout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main3);
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
                    Intent in = new Intent(getApplicationContext(),result3.class);
                    startActivity(in);
                }
            }
        });
    }
}
