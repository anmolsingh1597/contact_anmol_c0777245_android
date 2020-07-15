package com.lambton.tovisit_anmol_c0777245_android.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.lambton.tovisit_anmol_c0777245_android.R;
import com.lambton.tovisit_anmol_c0777245_android.adapter.ContactAdapter;
import com.lambton.tovisit_anmol_c0777245_android.roomDatabase.ContactInfo;
import com.lambton.tovisit_anmol_c0777245_android.roomDatabase.ContactRoomDb;

import java.util.ArrayList;
import java.util.List;

public class ContactListActivity extends AppCompatActivity {

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
}