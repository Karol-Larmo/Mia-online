package com.example.friendsloans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.friendsloans.contacts.ContactListContent;
import com.example.friendsloans.loans.LoanListContent;

public class AddLoan_value extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loan_value);
    }


    public void addLoan(View view) {
        EditText amount_e = (EditText) findViewById(R.id.amount_editText);
        EditText description_e = (EditText) findViewById(R.id.description_editText);

        String amount = amount_e.getText().toString();
        String description = description_e.getText().toString();

        ContactListContent.Contact contact = getIntent().getParcelableExtra("Intent_value");
        String ID = "Loan"+contact.id;
        LoanListContent.Loan loan = new LoanListContent.Loan(ID,contact,description,amount);
        LoanListContent.addItem(loan);

        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();

    }
}