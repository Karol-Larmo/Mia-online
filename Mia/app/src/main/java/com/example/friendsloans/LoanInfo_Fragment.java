package com.example.friendsloans;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.friendsloans.loans.LoanListContent;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoanInfo_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoanInfo_Fragment extends Fragment {

   private MyLoanRecyclerViewAdapter myLoanRecyclerViewAdapter;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoanInfo_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoanInfo_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoanInfo_Fragment newInstance(String param1, String param2) {
        LoanInfo_Fragment fragment = new LoanInfo_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loan_info_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            LoanListContent.Loan receivedLoan = intent.getParcelableExtra(MainActivity.loanExtra);
            if (receivedLoan != null) {
                displayLoan(receivedLoan);
            }
        }
    }

    public void displayLoan(LoanListContent.Loan loan)
    {
        FragmentActivity activity = getActivity();
        TextView nameTextV = activity.findViewById(R.id.name);
        TextView descTextV = activity.findViewById(R.id.desc);
        TextView cashTextV = activity.findViewById(R.id.cash);

        nameTextV.setText(loan.contact.name);
        descTextV.setText(loan.details);
        cashTextV.setText(loan.amount);

    }


}