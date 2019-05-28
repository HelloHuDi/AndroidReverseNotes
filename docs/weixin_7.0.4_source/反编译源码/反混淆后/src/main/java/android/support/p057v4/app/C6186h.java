package android.support.p057v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.h */
public abstract class C6186h<E> extends C0331f {
    /* renamed from: CX */
    final int f1768CX;
    final Activity mActivity;
    final Context mContext;
    final FragmentManagerImpl mFragmentManager;
    final Handler mHandler;

    public abstract E onGetHost();

    C6186h(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler);
    }

    private C6186h(Activity activity, Context context, Handler handler) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.f1768CX = 0;
    }

    /* renamed from: a */
    public void mo14003a(String str, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: dl */
    public boolean mo14004dl() {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    /* renamed from: dm */
    public void mo14005dm() {
    }

    /* renamed from: a */
    public void mo14000a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    /* renamed from: a */
    public void mo14001a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        C6184a.m9878a(this.mActivity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* renamed from: a */
    public void mo14002a(Fragment fragment, String[] strArr, int i) {
    }

    /* renamed from: H */
    public boolean mo13999H(String str) {
        return false;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.f1768CX;
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
