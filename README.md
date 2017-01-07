#Splash Activity Sample

There are things we'd like to run once and only once in a lifetime of an app.
Such as Database creation and population, and introduction screens to new users.

Since we want it to run **on the first launch of the app _only_**, it is wasteful to add logic to our main activity's
onCreate() to check _every time_ if it's our first run or not.

It would be great if we could set a flag in Android's `PackageMAnager`, so it will run the correct
`Activity` each time, without further logic.

This projects demonstrates how to do just that - using a manifest element called `activity-alias`, plus 
 some logic in the splash activity to mark the main activity as enabled once it is complete.
 
Next time the user starts the app - the splash will be skipped, and the main activity will be lauched
directly - without any overhead.
 
 One caveat - once the PM is updated, further launch of the app from AndroidStudio will still try to
 start the disabled splash first - and it will fail. So you'll need to add a new "Run Configuration"
and select the main activity as the start point of your app.
 

The relevant files to inspect are:
### [AndroidManifest.xml](https://github.com/auval/SplashActivityExample/blob/master/app/src/main/AndroidManifest.xml)
  
  
```html    
<application
    android:allowBackup="true"
    android:icon="@mipmap/ic_splash"
    android:label="@string/app_name"
    android:roundIcon="@mipmap/ic_splash"
    android:supportsRtl="true"
    android:theme="@style/AppTheme">

    <activity
        android:name=".SplashActivity"
        android:icon="@mipmap/ic_splash">
        <intent-filter>
            <action android:name="android.intent.action.MAIN"/>
            <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
    </activity>

    <activity
        android:name=".MainActivity"
        android:icon="@mipmap/ic_nosplash"
        android:label="SplashSample">
    </activity>

    <activity-alias
        android:name=".AliasActivity"
        android:enabled="false"
        android:label="SplashSample"
        android:targetActivity=".MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN"/>
            <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
    </activity-alias>

</application>
```
  
### [SplashActivity.java](https://github.com/auval/SplashActivityExample/blob/master/app/src/main/java/com/mindtheapps/splashactivityexample/SplashActivity.java)
 
```java 
    String s = getApplicationContext().getPackageName();
    ComponentName cm = new ComponentName(s, s + ".AliasActivity");
    ComponentName cm2 = new ComponentName(s, s + ".SplashActivity");
    PackageManager pm = this.getPackageManager();
    pm.setComponentEnabledSetting(cm, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    pm.setComponentEnabledSetting(cm2, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
```
 
### [MainActivity.java](https://github.com/auval/SplashActivityExample/blob/master/app/src/main/java/com/mindtheapps/splashactivityexample/MainActivity.java) 
Relevant only if you want to see how to enable the splash again.


---
 [credit](http://stackoverflow.com/a/36669356/1180898)
 

 -Amir Uval
 