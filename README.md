#Splash Activity Sample

There are things we'd like to run once and only once in a lifetime of an app.
Such as Database creation and population, and introduction screens to new users.

Since we want it to run **on the first launch of the app *only***, it is wasteful to add logic to our main activity's
onCreate() to check *every time* if it's our first run or not.

It would be great if we could set a flag in Android's `PackageMAnager`, so it will run the correct
`Activity` each time, without further logic.

This projects demonstrates how to do just that - using a manifest element called `activity-alias`, plus 
 some logic in the splash activity to mark the main activity as enabled once it is complete.
 
Next time the user starts the app - the splash will be skipped, and the main activity will be lauched
directly - without any overhead.
 
 One cavaet - once the PM is updated, further launch of the app from AndroidStudio will still try to
 start the disabled splash first - and it will fail. So you'll need to add a new "Run Configuration"
and select the main activity as the start point of your app.
 
 -Amir Uval
 