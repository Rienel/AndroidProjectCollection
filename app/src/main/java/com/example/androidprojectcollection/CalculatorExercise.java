package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


import java.util.Stack;

public class CalculatorExercise extends AppCompatActivity {

    Button zero, one, two, three, four, five, six, seven, eight, nine, point, equal, add, sub, mul, div;
    TextView txtResult;
    TextView txtString;
    int pos = 0;
    boolean changed = false;
    Stack stack = new Stack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);

        txtResult = findViewById(R.id.txtResult);

        zero = (Button) findViewById(R.id.btnZero);
        one = (Button) findViewById(R.id.btnOne);
        two = (Button) findViewById(R.id.btnTwo);
        three = (Button) findViewById(R.id.btnThree);
        four = (Button) findViewById(R.id.btnFour);
        five = (Button) findViewById(R.id.btnFive);
        six = (Button) findViewById(R.id.btnSix);
        seven = (Button) findViewById(R.id.btnSeven);
        eight = (Button) findViewById(R.id.btnEight);
        nine = (Button) findViewById(R.id.btnNine);
        equal = (Button) findViewById(R.id.btnEquals);
        add = (Button) findViewById(R.id.btnAdd);
        sub = (Button) findViewById(R.id.btnSub);
        mul = (Button) findViewById(R.id.btnMul);
        div = (Button) findViewById(R.id.btnDiv);
        point = (Button) findViewById(R.id.btnPoint);
        txtString = findViewById(R.id.txtString);
        add = findViewById(R.id.btnAdd);
        sub = findViewById(R.id.btnSub);
        mul = findViewById(R.id.btnMul);
        div = findViewById(R.id.btnDiv);
        equal = findViewById(R.id.btnEquals);

        List<Button> nums = new ArrayList<>();
        nums.add(zero);
        nums.add(one);
        nums.add(two);
        nums.add(three);
        nums.add(four);
        nums.add(five);
        nums.add(six);
        nums.add(seven);
        nums.add(eight);
        nums.add(nine);

        List<Button> ops = new ArrayList<>();
        ops.add(add);
        ops.add(sub);
        ops.add(mul);
        ops.add(div);

        for (Button btn : nums) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button pressedBtn = (Button) view;
                    String num = pressedBtn.getText().toString();

                    if (txtResult.getText().equals("0")) {
                        txtResult.setText(num);
                    } else {
                        if (txtResult.getText().toString().substring(pos, txtResult.length()).equals("0") && !changed) {
                            txtResult.setText(txtResult.getText().toString().substring(0, pos) + num);
                        } else {
                            txtResult.setText(txtResult.getText() + num);
                        }
                    }

                    if (stack.isEmpty() || changed) {
                        stack.push(txtResult.getText().toString().substring(pos, txtResult.length()));
                        changed = false;
                    } else {
                        stack.pop();
                        stack.push(txtResult.getText().toString().substring(pos, txtResult.length()));
                    }

                    String result = Sequential(((Stack<String>) stack.clone()));
                    try {
                        if (isNotInt(result)) {
                            txtString.setText("= " + Float.parseFloat(result));
                        } else {
                            txtString.setText("= " + ((int) Float.parseFloat(result)));
                        }
                    } catch (NumberFormatException ne) {
                        txtString.setText(result);
                    }
                }
            });
        }

        point = findViewById(R.id.btnPoint);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button point = (Button) view;
                String p = point.getText().toString();

                if (stack.isEmpty()) {
                    txtResult.setText("0.");
                    stack.push("0");
                } else if (changed) {
                    txtResult.setText(txtResult.getText() + "0.");
                    stack.push("0");
                    changed = false;
                } else if (!txtResult.getText().toString().substring(pos, txtResult.length()).contains(".") && stack.size() % 2 != 0) {
                    txtResult.setText(txtResult.getText() + p);
                } else if (txtResult.getText().charAt(txtResult.length() - 1) == '.') {
                    txtResult.setText(txtResult.getText().toString().substring(0, txtResult.length() - 1));
                }
            }
        });



        for (Button btn : ops) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button op = (Button) view;
                    String operator = op.getText().toString();

                    switch(operator) {
                        case "+":
                            if (!(txtResult.getText().toString().charAt(txtResult.length()-1) == '.') && !stack.isEmpty()) {
                                if (!stack.peek().equals("+") && !changed) {
                                    stack.push("+");
                                    txtResult.setText(txtResult.getText() + "+");
                                } else {
                                    txtResult.setText(txtResult.getText().toString().substring(0, txtResult.length()-1) + "+");
                                    stack.pop();
                                    stack.push("+");
                                }

                                pos = txtResult.length();
                                changed = true;
                            }
                            break;
                        case "-":
                            if (!(txtResult.getText().toString().charAt(txtResult.length()-1) == '.') && !stack.isEmpty()) {
                                if (!stack.peek().equals("-") && !changed) {
                                    stack.push("-");
                                    txtResult.setText(txtResult.getText() + "-");
                                } else {
                                    txtResult.setText(txtResult.getText().toString().substring(0, txtResult.length()-1) + "-");
                                    stack.pop();
                                    stack.push("-");
                                }

                                pos = txtResult.length();
                                changed = true;
                            }
                            break;
                        case "*":
                            if (!(txtResult.getText().toString().charAt(txtResult.length()-1) == '.') && !stack.isEmpty()) {
                                if (!stack.peek().equals("*") && !changed) {
                                    stack.push("*");
                                    txtResult.setText(txtResult.getText() + "*");
                                } else {
                                    txtResult.setText(txtResult.getText().toString().substring(0, txtResult.length()-1) + "*");
                                    stack.pop();
                                    stack.push("*");
                                }

                                pos = txtResult.length();
                                changed = true;
                            }
                            break;
                        case "/":
                            if (!(txtResult.getText().toString().charAt(txtResult.length()-1) == '.') && !stack.isEmpty()) {
                                if (!stack.peek().equals("/") && !changed) {
                                    stack.push("/");
                                    txtResult.setText(txtResult.getText() + "/");
                                } else {
                                    txtResult.setText(txtResult.getText().toString().substring(0, txtResult.length()-1) + "/");
                                    stack.pop();
                                    stack.push("/");
                                }

                                pos = txtResult.length();
                                changed = true;
                            }
                            break;
                    }
                }
            });
        }

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(txtResult.getText().toString().charAt(txtResult.length()-1) == '.') && stack.size()%2 != 0) {
                    String res = MDAS(((Stack<String>)stack.clone()));
                    try {
                        double roundedResult = Math.round(Double.parseDouble(res) * 100.0) / 100.0;
                        txtString.setText("= " + String.format("%.2f", roundedResult));
                    } catch (NumberFormatException ne) {
                        txtString.setText(res);
                    }
                    txtResult.setText("0");
                    stack = new Stack<>();
                    changed = false;
                    pos = 0;
                }
            }
        });
    }

    public String Sequential(Stack s) {
        String result = "";
        Stack<String> finalStack = new Stack<>();
        while (!s.isEmpty()) {
            finalStack.push(s.pop().toString());
        }
        while(!(finalStack.size() == 1)) {
            float initNum = Float.parseFloat(finalStack.pop());
            float secondNum, res;
            switch(finalStack.pop()) {
                case "+":
                    secondNum = Float.parseFloat(finalStack.pop());
                    res = initNum + secondNum;
                    finalStack.push(String.valueOf(res));
                    break;
                case "-":
                    secondNum = Float.parseFloat(finalStack.pop());
                    res = initNum - secondNum;
                    finalStack.push(String.valueOf(res));
                    break;
                case "*":
                    secondNum = Float.parseFloat(finalStack.pop());
                    res = initNum * secondNum;
                    finalStack.push(String.valueOf(res));
                    break;
                case "/":
                    secondNum = Float.parseFloat(finalStack.pop());
                    if (secondNum == 0) {
                        return "Can't divide by zero.";
                    }
                    res = initNum / secondNum;
                    finalStack.push(String.valueOf(res));
                    break;
            }
        }
        result = finalStack.pop();
        return result;
    }

    public boolean isNotInt(String s) {
        float num = Float.parseFloat(s);
        return num - Math.floor(num) > 0;
    }

    public String MDAS(Stack s) {
        String result = "";
        Stack<String> secondStack = new Stack<>();
        while (!s.isEmpty()) {
            float firstNum;
            float secondNum, res;
            switch (s.peek().toString()){
                case "*":
                    s.pop();
                    firstNum = Float.parseFloat(s.pop().toString());
                    secondNum = Float.parseFloat(secondStack.pop());
                    res = firstNum * secondNum;
                    secondStack.push(String.valueOf(res));
                    break;
                case "/":
                    s.pop();
                    firstNum = Float.parseFloat(s.pop().toString());
                    secondNum = Float.parseFloat(secondStack.pop());
                    if (secondNum == 0) {
                        return "Can't divide by zero.";
                    }
                    res = firstNum / secondNum;
                    secondStack.push(String.valueOf(res));
                    break;
                default:
                    secondStack.push(s.pop().toString());
            }
        }
        s = postFix(((Stack<String>) secondStack.clone()));
        secondStack = new Stack<>();
        while (!s.isEmpty()) {
            float firstNum;
            float secondNum, res;
            switch (s.peek().toString()){
                case "+":
                    s.pop();
                    firstNum = Float.parseFloat(s.pop().toString());
                    secondNum = Float.parseFloat(secondStack.pop());
                    res = firstNum + secondNum;
                    secondStack.push(String.valueOf(res));
                    break;
                case "-":
                    s.pop();
                    firstNum = Float.parseFloat(s.pop().toString());
                    secondNum = Float.parseFloat(secondStack.pop());
                    res = firstNum - secondNum;
                    secondStack.push(String.valueOf(res));
                    break;
                default:
                    secondStack.push(s.pop().toString());
            }
        }
        result = secondStack.pop();
        return result;
    }

    public Stack postFix (Stack s) {
        Stack<String> reversed = new Stack<>();
        while (!s.isEmpty()) {
            reversed.push(s.pop().toString());
        }
        return reversed;
    }
}