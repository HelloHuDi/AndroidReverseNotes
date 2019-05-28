package android.support.multidex;

import android.app.Application;
import android.content.Context;

public class MultiDexApplication extends Application {
    /* Access modifiers changed, original: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C31843a.m51591H(this);
    }
}
