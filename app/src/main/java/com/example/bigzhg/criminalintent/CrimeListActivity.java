package com.example.bigzhg.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by BigZhg on 2017/1/15.
 */

public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
