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
    RadioButton male;
    RadioButton female;
    RadioButton others;
    EditText bDate;
    EditText emailAdd;
    EditText PhoneNum;
    EditText Program;
    EditText YrLevel;
    EditText StudentID;
    EditText HomeAddress;
    EditText Nationality;
    Button Submit;
    Button Clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        Fname = (EditText) findViewById(R.id.txtFname);
        Lname = (EditText) findViewById(R.id.txtLname);
        bDate = (EditText) findViewById(R.id.txtBDate);
        emailAdd = (EditText) findViewById(R.id.txtEmail);
        PhoneNum = (EditText) findViewById(R.id.numNumber);
        Program = (EditText) findViewById(R.id.txtProgram);
        YrLevel = (EditText) findViewById(R.id.txtYearLvl);
        StudentID = (EditText) findViewById(R.id.txtStudID);
        HomeAddress = (EditText) findViewById(R.id.txtAddress);
        Nationality = (EditText) findViewById(R.id.txtNation);
        male = (RadioButton) findViewById(R.id.radMale);
        female = (RadioButton) findViewById(R.id.radFemale);
        others = (RadioButton) findViewById(R.id.radOthers);


        Submit = (Button) findViewById(R.id.btnSumbit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = Fname.getText().toString();
                String lname = Lname.getText().toString();
                String BDate = bDate.getText().toString();
                String Email = emailAdd.getText().toString();
                String Phonenum = PhoneNum.getText().toString();
                String HomeAdd = HomeAddress.getText().toString();
                String program = Program.getText().toString();
                String year_level = YrLevel.getText().toString();
                String stdID = StudentID.getText().toString();
                String nation = Nationality.getText().toString();

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

                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);
                intent.putExtra("fname_key", fname);
                intent.putExtra("lname_key",  lname);
                intent.putExtra("gender_key",  gender);
                intent.putExtra("birth_date_key",  BDate);
                intent.putExtra("email_add_key",  Email);
                intent.putExtra("phone_num_key",  Phonenum);
                intent.putExtra("home_add_key",  HomeAdd);
                intent.putExtra("course_key",  program);
                intent.putExtra("year_lvl_key",  year_level);
                intent.putExtra("student_id",  stdID);
                intent.putExtra("nationality",  nation);

                startActivity(intent);
            }
        });

        Clear = (Button) findViewById(R.id.btnClear);
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fname.setText("");
                Lname.setText("");
                emailAdd.setText("");
                PhoneNum.setText("");
                Program.setText("");
                bDate.setText("");
                YrLevel.setText("");
                StudentID.setText("");
                HomeAddress.setText("");
                Nationality.setText("");
                male.setSelected(false);
                female.setSelected(false);
                others.setSelected(false);
            }
        });
    }
}
