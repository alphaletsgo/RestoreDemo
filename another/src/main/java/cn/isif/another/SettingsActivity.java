package cn.isif.another;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class SettingsActivity extends AppCompatActivity {
    private static final String PREFERENCE_SCREENS = "PREFERENCE_SCREENS";
    private SettingsFragment settingsFragment;
    private Stack<PreferenceScreen> preferenceScreens = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content. Re-Use if possible
        String tag = SettingsFragment.class.getName();
        settingsFragment = (SettingsFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (settingsFragment == null) settingsFragment = new SettingsFragment();

        getSupportFragmentManager().beginTransaction().replace(android.R.id.content,
                settingsFragment, tag).commit();
    }

    @Override
    public void onBackPressed() {
        // need to delegate the backPress to the fragment since it cannot listen directly
        if (!settingsFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

}