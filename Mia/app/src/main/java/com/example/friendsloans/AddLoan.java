package com.example.friendsloans;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.friendsloans.contacts.ContactListContent;
import com.example.friendsloans.loans.LoanListContent;

public class AddLoan extends AppCompatActivity implements ContactFragment.OnContactFragmentInteractionListener{

    ContactFragment.OnContactFragmentInteractionListener listener;
    LoanListContent.Loan loan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loan);


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void SearchContact(View view) {
        EditText name_s= findViewById(R.id.searchname);
        String name_search = name_s.getText().toString();

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null,null,null,null);

        while(cursor.moveToNext())
        {

            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
            String phoneNumber="";
            String email="";

            Log.i("INFOO", name );

            if (name.contains(name_search)) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

                Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[] {id}, null);
                while(phoneCursor.moveToNext())
                {
                    phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }


                Cursor emailCursor = resolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?", new String[] {id}, null);
                while(phoneCursor.moveToNext())
                {
                   email = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                }



                Log.i("INFOO2", name + " " + id + " " + phoneNumber );

                ContactListContent.Contact c = new ContactListContent.Contact(id,name,phoneNumber,email);
                ContactListContent.addItem(c);
            }

        }
        View w = findViewById(R.id.contactsFragment);
        ((ContactFragment) getSupportFragmentManager().findFragmentById(R.id.contactsFragment)).notifyDataChange();

    }

    @Override
    public void onContactFragmentClickInteraction(ContactListContent.Contact contact, int position) {
        Intent intent_a = new Intent(this, AddLoan_value.class );
        intent_a.putExtra("Intent_value", contact);
        startActivityForResult(intent_a,1);
    }

    @Override
    public void onContactFragmentLongClickInteraction(int position) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            loan = (LoanListContent.Loan) data.getExtras().getParcelable("juhuu");
            //LoanListContent.addItem(loan);
            Toast.makeText(this,"Loan created", Toast.LENGTH_LONG).show();

            ContactListContent.ITEMS.clear();
            ContactListContent.ITEM_MAP.clear();
            finish();

        }
    }



}


