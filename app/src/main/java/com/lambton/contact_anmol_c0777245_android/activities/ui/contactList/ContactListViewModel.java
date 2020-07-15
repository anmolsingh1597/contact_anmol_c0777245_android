package com.lambton.contact_anmol_c0777245_android.activities.ui.contactList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContactListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContactListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}