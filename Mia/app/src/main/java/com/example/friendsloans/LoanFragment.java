package com.example.friendsloans;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.friendsloans.loans.LoanListContent;

/**
 * A fragment representing a list of Items.
 */
public class LoanFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";


    private MyLoanRecyclerViewAdapter mRecyclerAdapter;
    private OnListFragmentInteractionListener mListener;

    public LoanFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LoanFragment newInstance(int columnCount) {
        LoanFragment fragment = new LoanFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            mRecyclerAdapter = new MyLoanRecyclerViewAdapter(LoanListContent.ITEMS, mListener);
            recyclerView.setAdapter(mRecyclerAdapter);
        }
        return view;
    }


    public void notifyDataChange()
    {
        mRecyclerAdapter.notifyDataSetChanged();
    }


    public interface OnListFragmentInteractionListener {
        void onListFragmentClickInteraction(LoanListContent.Loan loan, int position);
        void onListFragmentLongClickInteraction(int position);
        void onListDeleteButtonClick(int position);
    }
}