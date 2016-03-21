package com.example.gaurang.hope;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Gaurang on 13/03/2016.
 */
public class Main2Activity extends Activity {

    Button bt2;
    TextView tv2;
    RadioGroup rg2;
    RadioButton r4,r5,r6;

    public static String questions []= {"1.\tWhat ingredient makes bread rise?","2.\tWhat is the main ingredient used in guacamole?","3.\tWhat is Tofu made of?","4.\tFrom which country does Feta cheese originate?","5.\tWhat type of plant do prickly pears grow on?"};
    String answers []= {"Yeast","Avocado","Soya beans","Greece","Cactus"};
    String opts []= {"Yeast", "Flour", "Baking powder","Chick peas","Grapes","Avocado","Soya beans","Kidney beans","Cheese", "Italy","Greece","France","Cactus","Trees","Shrubs"};

    int position=0;
    public static int correct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);

        tv2=(TextView)findViewById(R.id.question2);
        bt2=(Button)findViewById(R.id.movebut);
        rg2=(RadioGroup)findViewById(R.id.rg2);
        r4=(RadioButton)findViewById(R.id.r4);
        r5=(RadioButton)findViewById(R.id.r5);
        r6=(RadioButton)findViewById(R.id.r6);

        tv2.setText(questions[position]);
        r4.setText(opts[position]);
        r5.setText(opts[position+1]);
        r6.setText(opts[position+2]);



        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton selectedans = (RadioButton) findViewById(rg2.getCheckedRadioButtonId());
                String selectedansText = selectedans.getText().toString();
                if (selectedansText==answers[position]) {
                    correct++;
                }
                position++;
                if(position<questions.length){

                    tv2.setText(questions[position]);
                    r4.setText(opts[position*3]);
                    r5.setText(opts[position*3+1]);
                    r6.setText(opts[position*3+2]);
                }else{

                    Intent in = new Intent(getApplicationContext(),result2.class);
                    startActivity(in);

                }
            }
        });
    }
}
