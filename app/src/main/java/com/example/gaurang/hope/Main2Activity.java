package com.example.gaurang.hope;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

//Quiz 2 - Food
public class Main2Activity extends Activity {
    // Sets up the buttons, textview and radiogroup used
    Button bt2;
    TextView tv2;
    RadioGroup rg2;
    RadioButton r4,r5,r6;
    //Array of questions
    public static String questions []= {
            "1.What ingredient makes bread rise?",
            "2.What is the main ingredient used in guacamole?",
            "3.What is Tofu made of?",
            "4.From which country does Feta cheese originate?",
            "5.What type of plant do prickly pears grow on?",
            "6.What term is given to someone who does not eat meat?",
            "7.Beef, cherry and plum are all types of what?",
            "8.Which famous drink is taken as a shot and is accompanied by a citrus fruit and salt?",
            "9.What is the most common alcoholic beverage?",
            "10.Grape Seed, Sesame and Ground Nut are all types of what?"
    };
    //Array of answers put in order of the questions
    String answers []= {
            "Yeast",
            "Avocado",
            "Soya beans",
            "Greece",
            "Cactus",
            "Vegetarian",
            "Tomato",
            "Tequila",
            "Beer",
            "Oil",
    };
    //Array of options put in order of the questions (3 for each question with 1 correct answer)
    String opts []= {
            "Yeast", "Flour", "Baking powder",
            "Chick peas","Grapes","Avocado",
            "Soya beans","Kidney beans","Cheese",
            "Italy","Greece","France",
            "Cactus","Trees","Shrubs",
            "Vegan","Vegetarian","Idiot",
            "Tomato","Potato","Meat",
            "Rum","Vodka","Tequila",
            "Wine", "Beer", "Champagne",
            "Oil","Fruit","Nuts"
    };
    //Initialises the position and the integer "correct"
    int position=0;
    public static int correct;

    //Sets up the OnCreate method with the quiz layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);
    //Defining the Button, TextView, RadioGroup and RadioButtons by finding their relative ids)
        tv2=(TextView)findViewById(R.id.question2);
        bt2=(Button)findViewById(R.id.movebut);
        rg2=(RadioGroup)findViewById(R.id.rg2);
        r4=(RadioButton)findViewById(R.id.r4);
        r5=(RadioButton)findViewById(R.id.r5);
        r6=(RadioButton)findViewById(R.id.r6);
    //Sets the text of the TextView and RadioButtons according to the position of the questions and answers starting with the 0th position. (first question)
        tv2.setText(questions[position]);
        r4.setText(opts[position]);
        r5.setText(opts[position+1]);
        r6.setText(opts[position+2]);

    //Sets up the onClickListener
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    //The selected answer in found using its ID and changed into a string
                RadioButton selectedans = (RadioButton) findViewById(rg2.getCheckedRadioButtonId());
                String selectedansText = selectedans.getText().toString();
    //If the string is the same as the answer in the specific position then 1 is added to the value of "correct"
                if (selectedansText==answers[position]) {
                    correct++;
                }
    //The position is increased by 1 (moving onto the next question/phase)
                position++;
    //If the position is less than the amount of questions then the next question is presented and the loop begins again, otherwise the results page is shown
                if(position<questions.length){
                    tv2.setText(questions[position]);
                    r4.setText(opts[position*3]);
                    r5.setText(opts[position*3+1]);
                    r6.setText(opts[position*3+2]);
                }else{
    //Displays the Results page
                    Intent in = new Intent(getApplicationContext(),result2.class);
                    startActivity(in);

                }
            }
        });
    }
}
