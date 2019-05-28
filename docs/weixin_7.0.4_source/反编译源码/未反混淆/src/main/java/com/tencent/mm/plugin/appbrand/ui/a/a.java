package com.tencent.mm.plugin.appbrand.ui.a;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.MMActivity;

public abstract class a extends ContextWrapper implements LifecycleObserver, b {
    public void N(Intent intent) {
    }

    @OnLifecycleEvent(Event.ON_RESUME)
    public void onActivityDidResume() {
    }

    @OnLifecycleEvent(Event.ON_PAUSE)
    public void onActivityWillPause() {
    }

    public a(MMActivity mMActivity) {
        super(mMActivity);
    }

    /* Access modifiers changed, original: protected|final */
    public final MMActivity aNg() {
        return (MMActivity) getBaseContext();
    }

    @OnLifecycleEvent(Event.ON_CREATE)
    public final void onActivityDidCreateCall() {
        N(((MMActivity) getBaseContext()).getIntent());
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    public void onActivityWillDestroy() {
        View findViewById = ((MMActivity) getBaseContext()).findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            com.tencent.mm.plugin.appbrand.widget.j.a.k((ViewGroup) findViewById);
        }
    }
}
