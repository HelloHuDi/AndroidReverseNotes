package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* renamed from: com.google.firebase.iid.y */
public final class C17711y implements ServiceConnection {
    private final Context bvF;
    private C17709w bwA;
    private boolean bwB;
    private final Intent bwx;
    private final ScheduledExecutorService bwy;
    private final Queue<C37308u> bwz;

    public C17711y(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
        AppMethodBeat.m2504i(108778);
        AppMethodBeat.m2505o(108778);
    }

    private C17711y(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.m2504i(108779);
        this.bwz = new ArrayDeque();
        this.bwB = false;
        this.bvF = context.getApplicationContext();
        this.bwx = new Intent(str).setPackage(this.bvF.getPackageName());
        this.bwy = scheduledExecutorService;
        AppMethodBeat.m2505o(108779);
    }

    /* renamed from: a */
    public final synchronized void mo32798a(Intent intent, PendingResult pendingResult) {
        AppMethodBeat.m2504i(108780);
        Log.isLoggable("EnhancedIntentService", 3);
        this.bwz.add(new C37308u(intent, pendingResult, this.bwy));
        zzc();
        AppMethodBeat.m2505o(108780);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.m2504i(108782);
        synchronized (this) {
            try {
                this.bwB = false;
                this.bwA = (C17709w) iBinder;
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    String valueOf = String.valueOf(componentName);
                    new StringBuilder(String.valueOf(valueOf).length() + 20).append("onServiceConnected: ").append(valueOf);
                }
                zzc();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108782);
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.m2504i(108783);
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            new StringBuilder(String.valueOf(valueOf).length() + 23).append("onServiceDisconnected: ").append(valueOf);
        }
        zzc();
        AppMethodBeat.m2505o(108783);
    }

    private final synchronized void zzc() {
        AppMethodBeat.m2504i(108781);
        Log.isLoggable("EnhancedIntentService", 3);
        while (!this.bwz.isEmpty()) {
            Log.isLoggable("EnhancedIntentService", 3);
            if (this.bwA == null || !this.bwA.isBinderAlive()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    new StringBuilder(39).append("binder is dead. start connection? ").append(!this.bwB);
                }
                if (!this.bwB) {
                    this.bwB = true;
                    try {
                        if (ConnectionTracker.getInstance().bindService(this.bvF, this.bwx, this, 65)) {
                            AppMethodBeat.m2505o(108781);
                        }
                    } catch (SecurityException e) {
                    }
                    while (!this.bwz.isEmpty()) {
                        ((C37308u) this.bwz.poll()).finish();
                    }
                }
                AppMethodBeat.m2505o(108781);
            } else {
                Log.isLoggable("EnhancedIntentService", 3);
                C37308u c37308u = (C37308u) this.bwz.poll();
                C17709w c17709w = this.bwA;
                if (Binder.getCallingUid() != Process.myUid()) {
                    SecurityException securityException = new SecurityException("Binding only allowed within app");
                    AppMethodBeat.m2505o(108781);
                    throw securityException;
                }
                Log.isLoggable("EnhancedIntentService", 3);
                if (c17709w.bwu.mo32805i(c37308u.intent)) {
                    c37308u.finish();
                } else {
                    Log.isLoggable("EnhancedIntentService", 3);
                    c17709w.bwu.bwk.execute(new C17710x(c17709w, c37308u));
                }
            }
        }
        AppMethodBeat.m2505o(108781);
    }
}
