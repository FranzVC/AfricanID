package com.example.africanid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_submit);

        final TextView label1 = findViewById(R.id.label_birthdayTittle);
        final TextView label2 = findViewById(R.id.label_genderTittle);
        final TextView txtBirthday = (TextView)findViewById(R.id.label_birthday);
        final TextView txtGender = (TextView)findViewById(R.id.label_gender);

        label1.setVisibility(View.INVISIBLE);
        label2.setVisibility(View.INVISIBLE);
        txtBirthday.setVisibility(View.INVISIBLE);
        txtGender.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtBx = (EditText)findViewById(R.id.txtBx_data);
                String idNumber = txtBx.getText().toString();

                if(idNumber.length()==13) {
                    label1.setVisibility(View.VISIBLE);
                    label2.setVisibility(View.VISIBLE);
                    txtBirthday.setVisibility(View.VISIBLE);
                    txtGender.setVisibility(View.VISIBLE);
                    String birthDay = idNumber.substring(0, 6);
                    birthDay = birthDay.substring(4, 6) + "/" + birthDay.substring(2, 4) + "/" + birthDay.substring(0, 2);
                    txtBirthday.setText(birthDay);

                    String gender = idNumber.substring(6, 10);
                    if (gender.charAt(0) < '5') {
                        txtGender.setText("Female");
                    } else {
                        txtGender.setText("Male");
                    }
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"ID invalid",Toast.LENGTH_SHORT);
                    toast.setGravity(0,2,2);
                    toast.show();
                }
            }
        });
    }
}
