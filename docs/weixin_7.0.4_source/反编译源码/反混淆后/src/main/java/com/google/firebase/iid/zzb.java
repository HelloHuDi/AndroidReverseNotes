package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.p057v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
    final ExecutorService bwk;
    private Binder bwl;
    private int bwm;
    private int bwn;
    private final Object lock;

    public zzb() {
        String str = "Firebase-";
        String valueOf = String.valueOf(getClass().getSimpleName());
        this.bwk = Executors.newSingleThreadExecutor(new NamedThreadFactory(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)));
        this.lock = new Object();
        this.bwn = 0;
    }

    /* renamed from: h */
    private final void m52237h(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.lock) {
            this.bwn--;
            if (this.bwn == 0) {
                stopSelfResult(this.bwm);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: f */
    public Intent mo32803f(Intent intent) {
        return intent;
    }

    /* renamed from: g */
    public abstract void mo32804g(Intent intent);

    /* renamed from: i */
    public boolean mo32805i(Intent intent) {
        return false;
    }

    public final synchronized IBinder onBind(Intent intent) {
        Log.isLoggable("EnhancedIntentService", 3);
        if (this.bwl == null) {
            this.bwl = new C17709w(this);
        }
        return this.bwl;
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.lock) {
            this.bwm = i2;
            this.bwn++;
        }
        Intent f = mo32803f(intent);
        if (f == null) {
            m52237h(intent);
            return 2;
        } else if (mo32805i(f)) {
            m52237h(intent);
            return 2;
        } else {
            this.bwk.execute(new C45075t(this, f, intent));
            return 3;
        }
    }
}
