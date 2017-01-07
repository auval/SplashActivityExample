package com.mindtheapps.splashactivityexample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClicked(View view) {
        // revert to splash
        String s = getApplicationContext().getPackageName();
        ComponentName cm = new ComponentName(s, s + ".AliasActivity");
        ComponentName cm2 = new ComponentName(s, s + ".SplashActivity");
        PackageManager pm = this.getPackageManager();
        pm.setComponentEnabledSetting(cm2, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        pm.setComponentEnabledSetting(cm, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        Intent newActivity = new Intent(this, SplashActivity.class);
        startActivity(newActivity);

        finish();

    }
}
