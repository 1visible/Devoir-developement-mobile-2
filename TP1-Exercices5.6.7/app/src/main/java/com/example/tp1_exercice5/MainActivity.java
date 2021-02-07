package com.example.tp1_exercice5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ConfirmDialog.DataInterface {

    private Button button;
    private EditText firstName, lastName, age, skillsDomain, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        age = (EditText) findViewById(R.id.age);
        skillsDomain = (EditText) findViewById(R.id.skills_domain);
        phoneNumber = (EditText) findViewById(R.id.phone_number);

        button = (Button) findViewById(R.id.validate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                DialogFragment confirmDialog = new ConfirmDialog();
                confirmDialog.show(getSupportFragmentManager(), "confirm_dialog");
            }
        });
    }

    @Override
    public Map<String, String> getData() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("FIRSTNAME", firstName.getText().toString());
        data.put("LASTNAME", lastName.getText().toString());
        data.put("AGE", age.getText().toString());
        data.put("SKILLS_DOMAIN", skillsDomain.getText().toString());
        data.put("PHONE_NUMBER", phoneNumber.getText().toString());
        return data;
    }
}