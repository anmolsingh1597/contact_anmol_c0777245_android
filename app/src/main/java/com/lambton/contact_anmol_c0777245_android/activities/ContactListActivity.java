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
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;
import com.lambton.contact_anmol_c0777245_android.adapter.ContactListAdapter;
import com.lambton.contact_anmol_c0777245_android.roomDatabase.ContactRoomDb;
import com.lambton.tovisit_anmol_c0777245_android.R;
import com.lambton.contact_anmol_c0777245_android.adapter.ContactAdapter;
import com.lambton.contact_anmol_c0777245_android.roomDatabase.ContactInfo;

import java.util.ArrayList;
import java.util.List;

public class ContactListActivity extends AppCompatActivity{

    private ContactRoomDb contactRoomDb;

    TextView noOfContacts;
    List<ContactInfo> contactInfoList;
    ListView contactListView;

ContactAdapter contactAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        initials();


    }

    private void initials() {
        contactListView = findViewById(R.id.contact_list_lv);
        noOfContacts = findViewById(R.id.tv_no_of_contacts);

        contactInfoList = new ArrayList<>();
        contactRoomDb = ContactRoomDb.getINSTANCE(this);
        loadContact();
    }

    private void loadContact() {
        contactInfoList = contactRoomDb.contactDao().getAllContacts();

        contactAdapter = new ContactAdapter(this, R.layout.contact_list,contactInfoList);
        contactListView.setAdapter(contactAdapter);
        noOfContacts.setText("No of contacts: " + contactInfoList.size());

    }

    //Design
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact_drawer, menu);

        MenuItem searchItem = menu.findItem(R.id.btnSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                contactAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.btnAdd){
            Intent intent = new Intent(ContactListActivity.this, AddContactActivity.class);
            startActivity(intent);
            finish();
        }
        if (item.getItemId() == R.id.btnSearch){

        }
        return super.onOptionsItemSelected(item);
    }

}