package com.example.langones_calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sets up the display of the textview
        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        //clears the "Enter in a value" text to make way for inputted digits
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
    }
    //this allows the numbers to be inputted
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        //this statement allows the cursor to input numbers from left to right
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    //each button corresponds to the number/symbol that will be inputted in the textView
    public void zeroBTN (View view){
        updateText("0");
    }

    public void oneBTN(View view){
        updateText("1");
    }

    public void twoBTN(View view){
        updateText("2");
    }

    public void threeBTN(View view){
        updateText("3");
    }

    public void fourBTN(View view){
        updateText("4");
    }

    public void fiveBTN(View view){
        updateText("5");
    }

    public void sixBTN(View view){
        updateText("6");
    }

    public void sevenBTN(View view){
        updateText("7");
    }

    public void eightBTN(View view){
        updateText("8");
    }

    public void nineBTN(View view){
        updateText("9");
    }

    public void divideBTN(View view){
        updateText("÷");
    }

    public void multiplyBTN(View view){
        updateText("×");
    }

    public void additionBTN(View view){
        updateText("+");
    }

    public void subtractionBTN(View view){
        updateText("-");
    }

    public void pointBTN(View view){
        updateText(".");
    }

    public void equalBTN(View view){
        String xp = display.getText().toString();

        xp = xp.replaceAll("÷", "/");
        xp = xp.replaceAll("×", "*");

        Expression exp = new Expression(xp);
        //this code does the calculation of the inputted equations
        String answer = String.valueOf(exp.calculate());

        display.setText(answer);
        display.setSelection(answer.length());
    }
    //removes all inputted values
    public void clearBTN(View view){
        display.setText("");
    }

    public void openparenthesisBTN(View view){
        updateText("(");
    }

    public void closeparenthesisBTN(View view){
        updateText(")");
    }

    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos !=0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);

        }
    }
}
