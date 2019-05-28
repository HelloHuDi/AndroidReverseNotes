package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.a.a;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class d {
    static int UB = -1;
    private static boolean UC = false;

    public abstract void addContentView(View view, LayoutParams layoutParams);

    public abstract <T extends View> T findViewById(int i);

    public abstract void fj();

    public abstract void fk();

    public abstract boolean fl();

    public abstract a getDrawerToggleDelegate();

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract void invalidateOptionsMenu();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, LayoutParams layoutParams);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charSequence);

    public abstract b startSupportActionMode(b.a aVar);

    public static d a(Activity activity, c cVar) {
        return a(activity, activity.getWindow(), cVar);
    }

    public static d a(Dialog dialog, c cVar) {
        return a(dialog.getContext(), dialog.getWindow(), cVar);
    }

    private static d a(Context context, Window window, c cVar) {
        if (VERSION.SDK_INT >= 24) {
            return new f(context, window, cVar);
        }
        if (VERSION.SDK_INT >= 23) {
            return new h(context, window, cVar);
        }
        return new g(context, window, cVar);
    }

    d() {
    }

    public static boolean fm() {
        return UC;
    }
}
