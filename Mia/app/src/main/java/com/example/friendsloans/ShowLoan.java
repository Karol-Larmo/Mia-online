package com.example.friendsloans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.friendsloans.loans.LoanListContent;

import static com.example.friendsloans.MainActivity.loanExtra;

public class ShowLoan extends AppCompatActivity implements LoanFragment.OnListFragmentInteractionListener {


    public static final String loanExtra = "loanExtra";
    LoanFragment.OnListFragmentInteractionListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_loan);
        Log.i("Loaninfo", "test Loan list loeaded");
    }





    @Override
    public void onListFragmentClickInteraction(LoanListContent.Loan loan, int position) {
        Log.i("Loaninfo", "test Loan info Click");
        //Toast.makeText(this, "test123", Toast.LENGTH_LONG).show();
       Intent intent = new Intent(getApplicationContext(), LoanInfo_Activity.class);
       intent.putExtra(loanExtra,loan);
       startActivity(intent);
        //StartLoanInfoActivity(loan,position);
    }

    @Override
    public void onListFragmentLongClickInteraction(int position) {
        Intent intent = new Intent(getApplicationContext(), LoanInfo_Activity.class);
        //
        startActivity(intent);


    }
}