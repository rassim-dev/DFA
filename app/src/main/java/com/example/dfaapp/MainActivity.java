package com.example.dfaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mButton;
    EditText mEdit;
    TextView mText;
    TextView mStates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button1);
        mEdit = (EditText) findViewById(R.id.editText1);
        mText = (TextView) findViewById(R.id.textView1);
        mStates = (TextView) findViewById(R.id.tvStates);
    }

   /* Scanner scan = new Scanner(System.in);
 String s = scan.next();
 int dfaState = 0; **/

 public void readUser (View view){
 String s = mEdit.getText().toString();
  int dfaState;
     dfaState = 0;
     for (char letter : s.toCharArray()) {
    switch (dfaState) {
        case 0:
            dfaState = (letter=='i')? 1 : 0;
                break;
        case 1:
            dfaState = (letter=='n')? 2 : ((letter=='i')? 1 : 0);
                break;
        case 2:
            dfaState = (letter=='g')? 3 : ((letter=='i')? 1 : 0);
                break;
        case 3:
            dfaState = (letter=='i')? 1 : 0;

        }
     }
     if (dfaState==3){
         mStates.setText("State 3, Final State!");
         mText.setText("accepted");
     } else if(dfaState==0){
         mStates.setText("State 0, Initial State!");
         mText.setText("rejected");
     } else if(dfaState==1){
         mStates.setText("State 1");
         mText.setText("rejected");
     } else if(dfaState==2){
         mStates.setText("State 2");
         mText.setText("rejected");
     }



     }

}


