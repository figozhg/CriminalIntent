package com.example.bigzhg.criminalintent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by BigZhg on 2017/1/5.
 */

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {

                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {

                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });

        mDateButton = (Button)v.findViewById(R.id.crime_date);

        /* To finish the challenge issues of Chapter 8 of
         * the <<Android Programming -- The Big Nerd Ranch Guide, 2nd ed.
         *
         * The format methods in this class implement a subset of Unicode UTS #35
         * (http://www.unicode.org/reports/tr35/#Date_Format_Patterns) patterns.
         */
        // mDateButton.setText(mCrime.getDate().toString());
        String sDate = (String)DateFormat.format("EEEE, MMMM dd, yyyy kk:mm", mCrime.getDate());
        mDateButton.setText(sDate);
        mDateButton.setEnabled(false); // It is opened after Chapter 12

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Set the criime's solved property
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }
}
