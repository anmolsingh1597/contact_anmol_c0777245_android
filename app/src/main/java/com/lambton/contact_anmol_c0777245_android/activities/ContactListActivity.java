package com.lambton.contact_anmol_c0777245_android.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;


import com.google.android.material.navigation.NavigationView;
import com.lambton.contact_anmol_c0777245_android.roomDatabase.ContactRoomDb;
import com.lambton.tovisit_anmol_c0777245_android.R;
import com.lambton.contact_anmol_c0777245_android.adapter.ContactAdapter;
import com.lambton.contact_anmol_c0777245_android.roomDatabase.ContactInfo;

import java.util.ArrayList;
import java.util.List;

public class ContactListActivity extends AppCompatActivity{

    private ContactRoomDb contactRoomDb;

    List<ContactInfo> contactInfoList;
    ListView contactListView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        initials();


    }

    private void initials() {
        contactListView = findViewById(R.id.contact_list_lv);

        contactInfoList = new ArrayList<>();
        contactRoomDb = ContactRoomDb.getINSTANCE(this);
        loadContact();
    }

    private void loadContact() {
        contactInfoList = contactRoomDb.contactDao().getAllContacts();

        ContactAdapter contactAdapter = new ContactAdapter(this, R.layout.contact_list,contactInfoList);
        contactListView.setAdapter(contactAdapter);

    }

    //Design
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact_drawer, menu);
        return true;
    }

}