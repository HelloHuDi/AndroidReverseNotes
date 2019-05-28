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

public final class y implements ServiceConnection {
    private final Context bvF;
    private w bwA;
    private boolean bwB;
    private final Intent bwx;
    private final ScheduledExecutorService bwy;
    private final Queue<u> bwz;

    public y(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
        AppMethodBeat.i(108778);
        AppMethodBeat.o(108778);
    }

    private y(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(108779);
        this.bwz = new ArrayDeque();
        this.bwB = false;
        this.bvF = context.getApplicationContext();
        this.bwx = new Intent(str).setPackage(this.bvF.getPackageName());
        this.bwy = scheduledExecutorService;
        AppMethodBeat.o(108779);
    }

    public final synchronized void a(Intent intent, PendingResult pendingResult) {
        AppMethodBeat.i(108780);
        Log.isLoggable("EnhancedIntentService", 3);
        this.bwz.add(new u(intent, pendingResult, this.bwy));
        zzc();
        AppMethodBeat.o(108780);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(108782);
        synchronized (this) {
            try {
                this.bwB = false;
                this.bwA = (w) iBinder;
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    String valueOf = String.valueOf(componentName);
                    new StringBuilder(String.valueOf(valueOf).length() + 20).append("onServiceConnected: ").append(valueOf);
                }
                zzc();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108782);
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(108783);
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            new StringBuilder(String.valueOf(valueOf).length() + 23).append("onServiceDisconnected: ").append(valueOf);
        }
        zzc();
        AppMethodBeat.o(108783);
    }

    private final synchronized void zzc() {
        AppMethodBeat.i(108781);
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
                            AppMethodBeat.o(108781);
                        }
                    } catch (SecurityException e) {
                    }
                    while (!this.bwz.isEmpty()) {
                        ((u) this.bwz.poll()).finish();
                    }
                }
                AppMethodBeat.o(108781);
            } else {
                Log.isLoggable("EnhancedIntentService", 3);
                u uVar = (u) this.bwz.poll();
                w wVar = this.bwA;
                if (Binder.getCallingUid() != Process.myUid()) {
                    SecurityException securityException = new SecurityException("Binding only allowed within app");
                    AppMethodBeat.o(108781);
                    throw securityException;
                }
                Log.isLoggable("EnhancedIntentService", 3);
                if (wVar.bwu.i(uVar.intent)) {
                    uVar.finish();
                } else {
                    Log.isLoggable("EnhancedIntentService", 3);
                    wVar.bwu.bwk.execute(new x(wVar, uVar));
                }
            }
        }
        AppMethodBeat.o(108781);
    }
}
