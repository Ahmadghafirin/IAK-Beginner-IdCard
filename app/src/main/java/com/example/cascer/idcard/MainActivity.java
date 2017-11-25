package com.example.cascer.idcard;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvPhone, tvBio;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tv_nama);
        tvEmail = findViewById(R.id.tv_email);
        tvPhone = findViewById(R.id.tv_phone);
        tvBio = findViewById(R.id.tv_bio);

        String intentName = getIntent().getStringExtra("new_name");
        String intentEmail = getIntent().getStringExtra("new_email");
        String intentPhone = getIntent().getStringExtra("new_phone");
        String intentBio = getIntent().getStringExtra("new_bio");

        String name, email, phone, bio;

        name = intentName != null && !intentName.isEmpty()
                ? intentName : "Ahmad Ghafirin";

        email = intentEmail != null && !intentEmail.isEmpty()
                ? intentEmail : "ahmadghafirin@gmail.com";

        phone = intentPhone != null && !intentPhone.isEmpty()
                ? intentPhone : "082282733769";

        bio = intentBio != null && !intentBio.isEmpty()
                ? intentBio : "Android Developer";

        tvName.setText(name);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvBio.setText(bio);
    }

    public void edit(View view) {
        Intent intent = new Intent(this, EditIdCardActivity.class);
        intent.putExtra("name", String.valueOf(tvName.getText()));
        intent.putExtra("email", String.valueOf(tvEmail.getText()));
        intent.putExtra("phone", String.valueOf(tvPhone.getText()));
        intent.putExtra("bio", String.valueOf(tvBio.getText()));
        startActivity(intent);
    }
}
