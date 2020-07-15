package com.lambton.contact_anmol_c0777245_android.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lambton.contact_anmol_c0777245_android.roomDatabase.ContactInfo;
import com.lambton.contact_anmol_c0777245_android.roomDatabase.ContactRoomDb;
import com.lambton.tovisit_anmol_c0777245_android.R;
import com.google.android.material.snackbar.Snackbar;


public class AddContactActivity extends AppCompatActivity implements View.OnClickListener {

    private ContactRoomDb contactRoomDb;

    EditText firstNameEditText, lastNameEditText, emailEditText, contactEditText, addressEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        initials();
    }

    private void initials() {
        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);
        emailEditText = findViewById(R.id.email);
        contactEditText = findViewById(R.id.phoneNumber);
        addressEditText = findViewById(R.id.address);

        findViewById(R.id.addContactButton).setOnClickListener(this);
        findViewById(R.id.contactListButton).setOnClickListener(this);

        // Room database
        contactRoomDb = ContactRoomDb.getINSTANCE(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addContactButton:
                addContactToDatabase();
                break;
            case R.id.contactListButton:
                showContactList();
                break;
        }
    }

    private void showContactList() {

        startActivity(new Intent(this, ContactListActivity.class));
        finish();

    }

    private void addContactToDatabase() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String contact = contactEditText.getText().toString().trim();
        String address = addressEditText.getText().toString().trim();

        if(firstName.isEmpty()){
            firstNameEditText.setError("First Name is required");
            firstNameEditText.requestFocus();
            return;
        }
        if(email.isEmpty()){
            emailEditText.setError("First Name is necessary");
            emailEditText.requestFocus();
            return;
        }
        if(contact.isEmpty()){
            contactEditText.setError("First Name is necessary");
            contactEditText.requestFocus();
            return;
        }

        // insert into room db
        ContactInfo contactInfo = new ContactInfo(firstName,lastName,email,contact,address);
        contactRoomDb.contactDao().insertContact(contactInfo);
        Snackbar.make(findViewById(android.R.id.content),"Contact Inserted",Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        firstNameEditText.setText("");
        lastNameEditText.setText("");
        emailEditText.setText("");
        contactEditText.setText("");
        addressEditText.setText("");

        firstNameEditText.requestFocus();
        lastNameEditText.clearFocus();
        emailEditText.clearFocus();
        contactEditText.clearFocus();
        addressEditText.clearFocus();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddContactActivity.this, ContactListActivity.class);
        startActivity(intent);
        finish();
    }
}