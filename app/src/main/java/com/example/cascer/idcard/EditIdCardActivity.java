package com.example.cascer.idcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toolbar;

public class EditIdCardActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone, etBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_id_card);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_number);
        etBio = findViewById(R.id.et_bio);

        String name, email, phone, bio;
        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phone");
        bio = getIntent().getStringExtra("bio");

        etName.setText(name);
        etEmail.setText(email);
        etPhone.setText(phone);
        etBio.setText(bio);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public void save(View view) {
        String nama, email, phone, bio;
        nama = etName.getText().toString();
        email = etEmail.getText().toString();
        phone = etPhone.getText().toString();
        bio = etBio.getText().toString();


        if (nama.isEmpty()) {
            etName.setError("Name harus diisi!");
            etName.requestFocus();
            return;
        } else if (email.isEmpty()) {
            etEmail.setError("Email harus diisi!");
            etEmail.requestFocus();
            return;
        } else if (phone.isEmpty()) {
            etPhone.setError("Phone Harus diisi!");
            etPhone.requestFocus();
        } else if (bio.isEmpty()) {
            etBio.setError("Bio Harus diisi!");
            etBio.requestFocus();
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("new_name", nama);
        intent.putExtra("new_email", email);
        intent.putExtra("new_phone", phone);
        intent.putExtra("new_bio", bio);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
