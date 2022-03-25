package hcmute.edu.vn.caculator_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.*;

public class MainActivity extends AppCompatActivity {

    TextView display;
    String displayStr = "";
    Double result = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews() {
        display = (TextView)  findViewById(R.id.display);
    }
    private void setDisplays(String givenValue) {
        if (givenValue == "x") givenValue = "*";
        if (givenValue == "÷") givenValue = "/";
        displayStr = displayStr + givenValue;
        display.setText(displayStr);
    }
    // Button 1
    public void button1OnClick(View view) {
        setDisplays("1");
    }
    // Button 2
    public void button2OnClick(View view) {
        setDisplays("2");
    }
    // Button 3
    public void button3OnClick(View view) {
        setDisplays("3");
    }
    // Button 4
    public void button4OnClick(View view) {
        setDisplays("4");
    }
    // Button 5
    public void button5OnClick(View view) {
        setDisplays("5");
    }
    // Button 6
    public void button6OnClick(View view) {
        setDisplays("6");
    }
    // Button 7
    public void button7OnClick(View view) {
        setDisplays("7");
    }
    // Button 8
    public void button8OnClick(View view) {
        setDisplays("8");
    }
    // Button 9
    public void button9OnClick(View view) {
        setDisplays("9");
    }
    // Button 0
    public void button0OnClick(View view) {
        setDisplays("0");
    }
    // Button Add
    public void buttonAddOnClick(View view) {
        continueCalculator();
        setDisplays("+");
    }
    // Button Subtract
    public void buttonSubOnClick(View view) {
        continueCalculator();
        setDisplays("-");
    }
    // Button Multiple
    public void buttonMulOnClick(View view) {
        continueCalculator();
        setDisplays("x");
    }
    // Button Division
    public void buttonDivOnClick(View view) {
        continueCalculator();
        setDisplays("÷");
    }
    // Button Dot
    public void buttonDotOnClick(View view) {
        setDisplays(".");
    }
    // Button Cancel
    public void buttonCancelOnClick(View view) {
        display.setText("");
        displayStr = "";
        result = null;
    }
    // Button Equal
    public void buttonEqualOnClick(View view) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double) engine.eval(displayStr);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if (result != null) {
            display.setText(String.valueOf(result.doubleValue()));
        }
    }
    public void continueCalculator(){
        if(result != null){
            displayStr = String.valueOf(result.doubleValue());
        }
    }
    public void clearNumber() {

    }
}