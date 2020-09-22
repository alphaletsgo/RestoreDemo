package cn.isif.restoredemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceFragmentCompat;

/**
 * https://stackoverflow.com/questions/32487206/inner-preferencescreen-does-not-open-with-preferencefragmentcompat/32723340
 */

public class SettingsFragment extends PreferenceFragmentCompat {
    final String TAG = "SettingsFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d(TAG, "onAttach...");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        Log.d(TAG, "onCreate...");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated...");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        Log.d(TAG, "onCreatePreferences...");
//        setPreferencesFromResource(R.xml.root_preferences, rootKey);
//        addPreferencesFromResource(R.xml.root_preferences);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        Log.d(TAG, "onCreateView...");
        addPreferencesFromResource(R.xml.root_preferences);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart...");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume...");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause...");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop...");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView...");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy...");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach...");
        super.onDetach();
    }
}
