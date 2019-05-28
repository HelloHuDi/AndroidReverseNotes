package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class h<E> extends f {
    final int CX;
    final Activity mActivity;
    final Context mContext;
    final FragmentManagerImpl mFragmentManager;
    final Handler mHandler;

    public abstract E onGetHost();

    h(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler);
    }

    private h(Activity activity, Context context, Handler handler) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.CX = 0;
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean dl() {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    public void dm() {
    }

    public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    public void a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        a.a(this.mActivity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void a(Fragment fragment, String[] strArr, int i) {
    }

    public boolean H(String str) {
        return false;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.CX;
    }

    public View onFindViewById(int i) {
        return null;
    }

    public boolean onHasView() {
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void onAttachFragment(Fragment fragment) {
    }
}
