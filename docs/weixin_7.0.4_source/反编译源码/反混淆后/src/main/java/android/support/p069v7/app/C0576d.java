package android.support.p069v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.C6214a.C0573a;
import android.support.p069v7.view.C0604b;
import android.support.p069v7.view.C0604b.C0603a;
import android.support.p069v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

/* renamed from: android.support.v7.app.d */
public abstract class C0576d {
    /* renamed from: UB */
    static int f865UB = -1;
    /* renamed from: UC */
    private static boolean f866UC = false;

    public abstract void addContentView(View view, LayoutParams layoutParams);

    public abstract <T extends View> T findViewById(int i);

    /* renamed from: fj */
    public abstract void mo1399fj();

    /* renamed from: fk */
    public abstract void mo1400fk();

    /* renamed from: fl */
    public abstract boolean mo1401fl();

    public abstract C0573a getDrawerToggleDelegate();

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

    public abstract C0604b startSupportActionMode(C0603a c0603a);

    /* renamed from: a */
    public static C0576d m1253a(Activity activity, C0575c c0575c) {
        return C0576d.m1255a(activity, activity.getWindow(), c0575c);
    }

    /* renamed from: a */
    public static C0576d m1254a(Dialog dialog, C0575c c0575c) {
        return C0576d.m1255a(dialog.getContext(), dialog.getWindow(), c0575c);
    }

    /* renamed from: a */
    private static C0576d m1255a(Context context, Window window, C0575c c0575c) {
        if (VERSION.SDK_INT >= 24) {
            return new C7642f(context, window, c0575c);
        }
        if (VERSION.SDK_INT >= 23) {
            return new C7628h(context, window, c0575c);
        }
        return new C7590g(context, window, c0575c);
    }

    C0576d() {
    }

    /* renamed from: fm */
    public static boolean m1256fm() {
        return f866UC;
    }
}
