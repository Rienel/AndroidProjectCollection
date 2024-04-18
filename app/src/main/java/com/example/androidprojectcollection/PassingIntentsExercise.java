package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PassingIntentsExercise extends AppCompatActivity {

    EditText Fname;
    EditText Lname;
    EditText MFname;
    EditText MLname;
    EditText FFname;
    EditText FLname;
    RadioButton male;
    RadioButton female;
    RadioButton others;
    EditText bDate;
    EditText emailAdd;
    EditText PhoneNum;
    EditText Address;
    EditText Course;
    EditText YrLevel;
    Button Submit;
    Button Clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        Submit = (Button) findViewById(R.id.btnSumbit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        PassingIntentsExercise.this, PassingIntentsExercise2.class
                );
                startActivity(intent);
            }
        });

        Clear = (Button) findViewById(R.id.btnClear);
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fname.setText("");
                Lname.setText("");
                MFname.setText("");
                MLname.setText("");
                FFname.setText("");
                FLname.setText("");
                emailAdd.setText("");
                PhoneNum.setText("");
                Address.setText("");
                Course.setText("");
                bDate.setText("");
                YrLevel.setText("");
                male.setSelected(false);
                female.setSelected(false);
                others.setSelected(false);
            }
        });
    }
    public void onClick(View v) {
        String fname = Fname.getText().toString();
        String lname = Lname.getText().toString();

        String mfname = MFname.getText().toString();
        String mlname = MLname.getText().toString();

        String ffname = FFname.getText().toString();
        String flname = FLname.getText().toString();

        String gender;
        if(male.isChecked()) {
            gender = "Male";
        } else if (female.isChecked()) {
            gender = "Female";
        } else if(others.isChecked()) {
            gender = "Others";
        } else {
            gender = "Unknown";
        }

        String BDate = bDate.getText().toString();
        String Email = emailAdd.getText().toString();
        String Phonenum = PhoneNum.getText().toString();
        String HomeAdd = Address.getText().toString();
        String course = Course.getText().toString();
        String year_level = YrLevel.getText().toString();

        Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
            intent.putExtra("fname_key", fname);
            intent.putExtra("lname_key",  lname);
            intent.putExtra("Mfname_key",  mfname);
            intent.putExtra("Mlname_key",  mlname);
            intent.putExtra("Ffname_key",  ffname);
            intent.putExtra("Flname_key",  flname);
            intent.putExtra("gender_key",  gender);
            intent.putExtra("birth_date_key",  BDate);
            intent.putExtra("email_add_key",  Email);
            intent.putExtra("phone_num_key",  Phonenum);
            intent.putExtra("home_add_key",  HomeAdd);
            intent.putExtra("course_key",  course);
            intent.putExtra("year_lvl_key",  year_level);

            startActivity(intent);
    }
}
