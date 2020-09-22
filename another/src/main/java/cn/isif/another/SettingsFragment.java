package cn.isif.another;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class SettingsFragment extends PreferenceFragmentCompat {
    private static final String PREFERENCE_SCREENS = "PREFERENCE_SCREENS";
    private Stack<PreferenceScreen> preferenceScreens = new Stack<>();

    @Override
    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        super.onNavigateToScreen(preferenceScreen);
        preferenceScreens.push(getPreferenceScreen());
        setPreferenceScreen(preferenceScreen);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        preferenceScreens.push(getPreferenceScreen());

        ArrayList<String> keys = new ArrayList<>(preferenceScreens.size());
        for (PreferenceScreen screen : preferenceScreens) {
            keys.add(screen.getKey());
        }
        outState.putStringArrayList(PREFERENCE_SCREENS, keys);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState == null) return;

        // rebuild preferenceScreen stack
        for (String screenKey : savedInstanceState.getStringArrayList(PREFERENCE_SCREENS)) {
            if (null != screenKey){
                preferenceScreens.push((PreferenceScreen) findPreference(screenKey));
            }
        }

        if (!preferenceScreens.isEmpty()) {
            PreferenceScreen preferenceScreen = preferenceScreens.pop();
            if (preferenceScreen != getPreferenceScreen()) { // optimize if same
                setPreferenceScreen(preferenceScreen);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // account for onRestore not getting called equally to onSave
        preferenceScreens.remove(getPreferenceScreen());
    }

    public boolean onBackPressed() {
        // account for onRestore not getting called equally to onSave
        while (preferenceScreens.contains(getPreferenceScreen())) {
            preferenceScreens.remove(getPreferenceScreen());
        }

        if (!preferenceScreens.empty()) {
            setPreferenceScreen(preferenceScreens.pop());
            return true; // handled
        } else {
            return false;
        }
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setRetainInstance(true); // ensure in manifest - android:configChanges="orientation"
        // Load the preferences from an XML resource
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}
