package com.example.friendsloans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    }




private void StartLoanInfoActivity(LoanListContent.Loan loan, int position)
{

}


    @Override
    public void onListFragmentClickInteraction(LoanListContent.Loan loan, int position) {
        Toast.makeText(this, "test123", Toast.LENGTH_LONG).show();
       Intent intent = new Intent(this, LoanInfo_Activity.class);
       intent.putExtra(loanExtra,loan);
       startActivity(intent);
        //StartLoanInfoActivity(loan,position);
    }

    @Override
    public void onListFragmentLongClickInteraction(int position) {
        Toast.makeText(this, "test4 - " +position, Toast.LENGTH_LONG).show();
        //LoanInfo_Fragment loanInfo_fragment = (LoanInfo_Fragment) getSupportFragmentManager().findFragmentById(R.id.displayLoanInfo);
       // loanInfo_fragment.displayLoan(loan);


    }
}