package com.lambton.contact_anmol_c0777245_android.roomDatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    void insertContact(ContactInfo contactInfo);

    @Query("DELETE FROM contact")
    void deleteAllContacts();

    @Query("DELETE FROM contact WHERE id = :id")
    int deleteContact(int id);

    @Query("UPDATE contact SET firstName = :firstName, lastName= :lastName, email = :email, phoneNumber = :phoneNumber, address = :address WHERE id = :id")
    int updateContact(int id, String firstName, String lastName, String email, String phoneNumber, String address);

    @Query("SELECT * FROM contact ORDER BY firstName")
    List<ContactInfo> getAllContacts();
}
