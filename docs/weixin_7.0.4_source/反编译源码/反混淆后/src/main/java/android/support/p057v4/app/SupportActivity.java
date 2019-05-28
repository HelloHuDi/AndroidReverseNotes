package android.support.p057v4.app;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ReportFragment;
import android.os.Bundle;
import android.support.p057v4.p065f.C0417m;

/* renamed from: android.support.v4.app.SupportActivity */
public class SupportActivity extends Activity implements LifecycleOwner {
    private C0417m<Class<? extends C0313a>, C0313a> mExtraDataMap = new C0417m();
    private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    /* renamed from: android.support.v4.app.SupportActivity$a */
    public static class C0313a {
    }

    public void putExtraData(C0313a c0313a) {
        this.mExtraDataMap.put(c0313a.getClass(), c0313a);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
    }

    /* Access modifiers changed, original: protected */
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.markState(State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public <T extends C0313a> T getExtraData(Class<T> cls) {
        return (C0313a) this.mExtraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }
}
