package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {

    TextView Name;
    TextView Gender;
    TextView Birthdate;
    TextView PhoneNumber;
    TextView Email;
    TextView Program;
    TextView StudentID;
    TextView YearLevel;
    TextView Address;
    TextView Nationality;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        Intent intent = getIntent();

        Name = findViewById(R.id.Name);
        Gender = findViewById(R.id.Gender);
        Birthdate = findViewById(R.id.Birthdate);
        PhoneNumber = findViewById(R.id.PhoneNum);
        Email = findViewById(R.id.Email);
        Program = findViewById(R.id.Program);
        StudentID = findViewById(R.id.StdID);
        YearLevel = findViewById(R.id.YrLevel);
        Address = findViewById(R.id.Address);
        Nationality = findViewById(R.id.Nationality);

        String fname = intent.getStringExtra("fname_key");
        String lname = intent.getStringExtra("lname_key");
        String fullname = fname + " " + lname;
        String gender = intent.getStringExtra("gender_key");
        String BDate = intent.getStringExtra("birth_date_key");
        String email = intent.getStringExtra("email_add_key");
        String Phonenum = intent.getStringExtra("phone_num_key");
        String HomeAdd = intent.getStringExtra("home_add_key");
        String program = intent.getStringExtra("course_key");
        String year_level = intent.getStringExtra("year_lvl_key");
        String stdID = intent.getStringExtra("student_id");
        String nation = intent.getStringExtra("nationality");

        Name.setText(fullname);
        Gender.setText(gender);
        Birthdate.setText(BDate);
        PhoneNumber.setText(Phonenum);
        Email.setText(email);
        Program.setText(program);
        StudentID.setText(stdID);
        YearLevel.setText(year_level);
        Address.setText(HomeAdd);
        Nationality.setText(nation);

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        PassingIntentsExercise2.this, PassingIntentsExercise.class
                );
                startActivity(intent);
            }
        });
    }
}