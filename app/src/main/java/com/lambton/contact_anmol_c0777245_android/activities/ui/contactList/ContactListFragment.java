package com.lambton.contact_anmol_c0777245_android.activities.ui.contactList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lambton.contact_anmol_c0777245_android.roomDatabase.ContactInfo;
import com.lambton.contact_anmol_c0777245_android.roomDatabase.ContactRoomDb;
import com.lambton.tovisit_anmol_c0777245_android.R;

import java.util.List;


public class ContactListFragment extends Fragment {

    private ContactRoomDb contactRoomDb;

    List<ContactInfo> contactInfoList;
    ListView contactListView;

    private ContactListViewModel contactListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactListViewModel =
                ViewModelProviders.of(this).get(ContactListViewModel.class);
        View root = inflater.inflate(R.layout.activity_contact_list, container, false);
        final ListView list = root.findViewById(R.id.contact_list_lv);


        return root;
    }
}