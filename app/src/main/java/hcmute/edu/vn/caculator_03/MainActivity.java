package hcmute.edu.vn.caculator_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    //    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
//    Button btnAdd, btnSub, btnDot, btnDiv, btnMul, btnCancel, btnEqual;
//    TextView display;   //Màn hình hiển thị kết quả các phép toán;
//    String calculate; //Tính toán
//    String calculus;  //Phép toán
    TextView displayScreen;
    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews() {
        displayScreen = (TextView) findViewById(R.id.display);
    }

    private void setWorkings(String givenValue) {
        workings = workings + givenValue;
        displayScreen.setText(workings);
    }

    public void clearOnClick(View view) {
        workings = "";
        displayScreen.setText("0");
    }
    public void equalOnClick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double) engine.eval(workings);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG).show();
        }
        if (result != null)
            displayScreen.setText(String.valueOf(result.doubleValue()));
    }
    public void plusOnClick(View view) {
        setWorkings("+");
    }

    public void minusOnClick(View view) {
        setWorkings("-");
    }

    public void mulOnClick(View view) {
        setWorkings("*");
    }

    public void divOnClick(View view) {
        setWorkings("/");
    }
    public void decimalOnClick(View view) { setWorkings("."); }
    public void zeroOnClick(View view) {
        setWorkings("0");
    }
    public void oneOnClick(View view) {
        setWorkings("1");
    }
    public void twoOnClick(View view) {
        setWorkings("2");
    }
    public void threeOnClick(View view) {
        setWorkings("3");
    }
    public void fourOnClick(View view) {
        setWorkings("4");
    }
    public void fiveOnClick(View view) {
        setWorkings("5");
    }
    public void sixOnClick(View view) {
        setWorkings("6");
    }
    public void sevenOnClick(View view) {
        setWorkings("7");
    }
    public void eightOnClick(View view) {
        setWorkings("8");
    }
    public void nineOnClick(View view) {
        setWorkings("9");
    }
}
