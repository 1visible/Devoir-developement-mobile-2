package com.example.tp1_exercice5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class SecondActivity extends AppCompatActivity {

    private Button buttonOk, buttonBack;
    private TextView firstName, lastName, age, skillsDomain, phoneNumber;
    private String firstNameData, lastNameData, ageData, skillsDomainData, phoneNumberData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firstNameData = getIntent().getStringExtra("FIRSTNAME");
        lastNameData = getIntent().getStringExtra("LASTNAME");
        ageData = getIntent().getStringExtra("AGE");
        skillsDomainData = getIntent().getStringExtra("SKILLS_DOMAIN");
        phoneNumberData = getIntent().getStringExtra("PHONE_NUMBER");

        firstName = (TextView) findViewById(R.id.firstname);
        lastName = (TextView) findViewById(R.id.lastname);
        age = (TextView) findViewById(R.id.age);
        skillsDomain = (TextView) findViewById(R.id.skills_domain);
        phoneNumber = (TextView) findViewById(R.id.phone_number);

        buttonOk = (Button) findViewById(R.id.ok);
        buttonBack = (Button) findViewById(R.id.back);

        // Ajout des données aux TextView pour affichage.
        firstName.append(firstNameData);
        lastName.append(lastNameData);
        age.append(ageData);
        skillsDomain.append(skillsDomainData);
        phoneNumber.append(phoneNumberData);

        // Retour à l'activité précédente
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

        // Passage à la 3ème activité
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getBaseContext(), ThirdActivity.class);
                intent.putExtra("PHONE_NUMBER", phoneNumberData);
                startActivity(intent);
            }
        });
    }
}
