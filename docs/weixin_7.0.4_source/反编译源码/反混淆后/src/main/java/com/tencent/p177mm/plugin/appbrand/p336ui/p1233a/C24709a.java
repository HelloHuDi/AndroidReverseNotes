package com.tencent.p177mm.plugin.appbrand.p336ui.p1233a;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.widget.p1541j.C38614a;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.a.a */
public abstract class C24709a extends ContextWrapper implements LifecycleObserver, C19766b {
    /* renamed from: N */
    public void mo41600N(Intent intent) {
    }

    @OnLifecycleEvent(Event.ON_RESUME)
    public void onActivityDidResume() {
    }

    @OnLifecycleEvent(Event.ON_PAUSE)
    public void onActivityWillPause() {
    }

    public C24709a(MMActivity mMActivity) {
        super(mMActivity);
    }

    /* Access modifiers changed, original: protected|final */
    public final MMActivity aNg() {
        return (MMActivity) getBaseContext();
    }

    @OnLifecycleEvent(Event.ON_CREATE)
    public final void onActivityDidCreateCall() {
        mo41600N(((MMActivity) getBaseContext()).getIntent());
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    public void onActivityWillDestroy() {
        View findViewById = ((MMActivity) getBaseContext()).findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            C38614a.m65459k((ViewGroup) findViewById);
        }
    }
}
