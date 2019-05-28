package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.firebase.iid.aj */
final class C17707aj implements ServiceConnection {
    final Messenger bwS;
    C32097ao bwT;
    @GuardedBy("this")
    final Queue<C32098c<?>> bwU;
    @GuardedBy("this")
    final SparseArray<C32098c<?>> bwV;
    final /* synthetic */ C25584ai bwW;
    @GuardedBy("this")
    int state;

    private C17707aj(C25584ai c25584ai) {
        this.bwW = c25584ai;
        AppMethodBeat.m2504i(108820);
        this.state = 0;
        this.bwS = new Messenger(new Handler(Looper.getMainLooper(), new C25585ak(this)));
        this.bwU = new ArrayDeque();
        this.bwV = new SparseArray();
        AppMethodBeat.m2505o(108820);
    }

    /* synthetic */ C17707aj(C25584ai c25584ai, byte b) {
        this(c25584ai);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final boolean mo32789f(Message message) {
        AppMethodBeat.m2504i(108822);
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            new StringBuilder(41).append("Received response to request: ").append(i);
        }
        synchronized (this) {
            try {
                C32098c c32098c = (C32098c) this.bwV.get(i);
                if (c32098c == null) {
                    new StringBuilder(50).append("Received response for unknown request: ").append(i);
                } else {
                    this.bwV.remove(i);
                    zzu();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        c32098c.mo52661a(new C0908d(4, "Not supported by GmsCore"));
                    } else {
                        c32098c.zzb(data);
                    }
                    AppMethodBeat.m2505o(108822);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108822);
            }
        }
        return true;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: fk */
    public final synchronized void mo32790fk(int i) {
        AppMethodBeat.m2504i(108829);
        C32098c c32098c = (C32098c) this.bwV.get(i);
        if (c32098c != null) {
            new StringBuilder(31).append("Timing out request: ").append(i);
            this.bwV.remove(i);
            c32098c.mo52661a(new C0908d(3, "Timed out waiting for response"));
            zzu();
        }
        AppMethodBeat.m2505o(108829);
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.m2504i(108823);
        Log.isLoggable("MessengerIpcClient", 2);
        if (iBinder == null) {
            zza(0, "Null service connection");
            AppMethodBeat.m2505o(108823);
        } else {
            try {
                this.bwT = new C32097ao(iBinder);
                this.state = 2;
                zzt();
                AppMethodBeat.m2505o(108823);
            } catch (RemoteException e) {
                zza(0, e.getMessage());
                AppMethodBeat.m2505o(108823);
            }
        }
        return;
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.m2504i(108825);
        Log.isLoggable("MessengerIpcClient", 2);
        zza(2, "Service disconnected");
        AppMethodBeat.m2505o(108825);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zzv() {
        AppMethodBeat.m2504i(108828);
        if (this.state == 1) {
            zza(1, "Timed out while binding");
        }
        AppMethodBeat.m2505o(108828);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: b */
    public final synchronized boolean mo32788b(C32098c c32098c) {
        boolean z = false;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.m2504i(108821);
            switch (this.state) {
                case 0:
                    this.bwU.add(c32098c);
                    if (this.state == 0) {
                        z = true;
                    }
                    Preconditions.checkState(z);
                    Log.isLoggable("MessengerIpcClient", 2);
                    this.state = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (ConnectionTracker.getInstance().bindService(this.bwW.bvF, intent, this, 1)) {
                        this.bwW.bwP.schedule(new C37305al(this), 30, TimeUnit.SECONDS);
                    } else {
                        zza(0, "Unable to bind to service");
                    }
                    AppMethodBeat.m2505o(108821);
                    break;
                case 1:
                    this.bwU.add(c32098c);
                    AppMethodBeat.m2505o(108821);
                    break;
                case 2:
                    this.bwU.add(c32098c);
                    zzt();
                    AppMethodBeat.m2505o(108821);
                    break;
                case 3:
                case 4:
                    AppMethodBeat.m2505o(108821);
                    z2 = false;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unknown state: " + this.state);
                    AppMethodBeat.m2505o(108821);
                    throw illegalStateException;
            }
        }
        return z2;
    }

    private final void zzt() {
        AppMethodBeat.m2504i(108824);
        this.bwW.bwP.execute(new C32096am(this));
        AppMethodBeat.m2505o(108824);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zza(int i, String str) {
        AppMethodBeat.m2504i(108826);
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String str2 = "Disconnected: ";
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                valueOf = new String(str2);
            }
        }
        IllegalStateException illegalStateException;
        switch (this.state) {
            case 0:
                illegalStateException = new IllegalStateException();
                AppMethodBeat.m2505o(108826);
                throw illegalStateException;
            case 1:
            case 2:
                Log.isLoggable("MessengerIpcClient", 2);
                this.state = 4;
                ConnectionTracker.getInstance().unbindService(this.bwW.bvF, this);
                C0908d c0908d = new C0908d(i, str);
                for (C32098c a : this.bwU) {
                    a.mo52661a(c0908d);
                }
                this.bwU.clear();
                for (int i2 = 0; i2 < this.bwV.size(); i2++) {
                    ((C32098c) this.bwV.valueAt(i2)).mo52661a(c0908d);
                }
                this.bwV.clear();
                AppMethodBeat.m2505o(108826);
                break;
            case 3:
                this.state = 4;
                AppMethodBeat.m2505o(108826);
                break;
            case 4:
                AppMethodBeat.m2505o(108826);
                break;
            default:
                illegalStateException = new IllegalStateException("Unknown state: " + this.state);
                AppMethodBeat.m2505o(108826);
                throw illegalStateException;
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zzu() {
        AppMethodBeat.m2504i(108827);
        if (this.state == 2 && this.bwU.isEmpty() && this.bwV.size() == 0) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(this.bwW.bvF, this);
        }
        AppMethodBeat.m2505o(108827);
    }
}
