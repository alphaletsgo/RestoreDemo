package cn.isif.third;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

/**
 * 测试fragment恢复
 */
public class SettingsActivity extends AppCompatActivity {
    SettingsFragment settingsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        settingsFragment = (SettingsFragment)getSupportFragmentManager().findFragmentById(R.id.settings);
        if (null==settingsFragment){settingsFragment = new SettingsFragment();}
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, settingsFragment)
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * SettingFragment
     */
    public static class SettingsFragment extends PreferenceFragmentCompat {
        final String TAG = "SettingsFragment";

        @Override
        public void onSaveInstanceState(@NonNull Bundle outState) {
            Log.d(TAG,"onSaveInstanceState");
            super.onSaveInstanceState(outState);
        }

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }

        @Override
        public void onDestroy() {
            Log.d(TAG,"onDestroy");
            super.onDestroy();
        }
    }
}