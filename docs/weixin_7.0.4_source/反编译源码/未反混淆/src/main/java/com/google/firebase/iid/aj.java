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

final class aj implements ServiceConnection {
    final Messenger bwS;
    ao bwT;
    @GuardedBy("this")
    final Queue<c<?>> bwU;
    @GuardedBy("this")
    final SparseArray<c<?>> bwV;
    final /* synthetic */ ai bwW;
    @GuardedBy("this")
    int state;

    private aj(ai aiVar) {
        this.bwW = aiVar;
        AppMethodBeat.i(108820);
        this.state = 0;
        this.bwS = new Messenger(new Handler(Looper.getMainLooper(), new ak(this)));
        this.bwU = new ArrayDeque();
        this.bwV = new SparseArray();
        AppMethodBeat.o(108820);
    }

    /* synthetic */ aj(ai aiVar, byte b) {
        this(aiVar);
    }

    /* Access modifiers changed, original: final */
    public final boolean f(Message message) {
        AppMethodBeat.i(108822);
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            new StringBuilder(41).append("Received response to request: ").append(i);
        }
        synchronized (this) {
            try {
                c cVar = (c) this.bwV.get(i);
                if (cVar == null) {
                    new StringBuilder(50).append("Received response for unknown request: ").append(i);
                } else {
                    this.bwV.remove(i);
                    zzu();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        cVar.a(new d(4, "Not supported by GmsCore"));
                    } else {
                        cVar.zzb(data);
                    }
                    AppMethodBeat.o(108822);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108822);
            }
        }
        return true;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void fk(int i) {
        AppMethodBeat.i(108829);
        c cVar = (c) this.bwV.get(i);
        if (cVar != null) {
            new StringBuilder(31).append("Timing out request: ").append(i);
            this.bwV.remove(i);
            cVar.a(new d(3, "Timed out waiting for response"));
            zzu();
        }
        AppMethodBeat.o(108829);
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(108823);
        Log.isLoggable("MessengerIpcClient", 2);
        if (iBinder == null) {
            zza(0, "Null service connection");
            AppMethodBeat.o(108823);
        } else {
            try {
                this.bwT = new ao(iBinder);
                this.state = 2;
                zzt();
                AppMethodBeat.o(108823);
            } catch (RemoteException e) {
                zza(0, e.getMessage());
                AppMethodBeat.o(108823);
            }
        }
        return;
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(108825);
        Log.isLoggable("MessengerIpcClient", 2);
        zza(2, "Service disconnected");
        AppMethodBeat.o(108825);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zzv() {
        AppMethodBeat.i(108828);
        if (this.state == 1) {
            zza(1, "Timed out while binding");
        }
        AppMethodBeat.o(108828);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized boolean b(c cVar) {
        boolean z = false;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.i(108821);
            switch (this.state) {
                case 0:
                    this.bwU.add(cVar);
                    if (this.state == 0) {
                        z = true;
                    }
                    Preconditions.checkState(z);
                    Log.isLoggable("MessengerIpcClient", 2);
                    this.state = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (ConnectionTracker.getInstance().bindService(this.bwW.bvF, intent, this, 1)) {
                        this.bwW.bwP.schedule(new al(this), 30, TimeUnit.SECONDS);
                    } else {
                        zza(0, "Unable to bind to service");
                    }
                    AppMethodBeat.o(108821);
                    break;
                case 1:
                    this.bwU.add(cVar);
                    AppMethodBeat.o(108821);
                    break;
                case 2:
                    this.bwU.add(cVar);
                    zzt();
                    AppMethodBeat.o(108821);
                    break;
                case 3:
                case 4:
                    AppMethodBeat.o(108821);
                    z2 = false;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unknown state: " + this.state);
                    AppMethodBeat.o(108821);
                    throw illegalStateException;
            }
        }
        return z2;
    }

    private final void zzt() {
        AppMethodBeat.i(108824);
        this.bwW.bwP.execute(new am(this));
        AppMethodBeat.o(108824);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zza(int i, String str) {
        AppMethodBeat.i(108826);
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
                AppMethodBeat.o(108826);
                throw illegalStateException;
            case 1:
            case 2:
                Log.isLoggable("MessengerIpcClient", 2);
                this.state = 4;
                ConnectionTracker.getInstance().unbindService(this.bwW.bvF, this);
                d dVar = new d(i, str);
                for (c a : this.bwU) {
                    a.a(dVar);
                }
                this.bwU.clear();
                for (int i2 = 0; i2 < this.bwV.size(); i2++) {
                    ((c) this.bwV.valueAt(i2)).a(dVar);
                }
                this.bwV.clear();
                AppMethodBeat.o(108826);
                break;
            case 3:
                this.state = 4;
                AppMethodBeat.o(108826);
                break;
            case 4:
                AppMethodBeat.o(108826);
                break;
            default:
                illegalStateException = new IllegalStateException("Unknown state: " + this.state);
                AppMethodBeat.o(108826);
                throw illegalStateException;
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zzu() {
        AppMethodBeat.i(108827);
        if (this.state == 2 && this.bwU.isEmpty() && this.bwV.size() == 0) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(this.bwW.bvF, this);
        }
        AppMethodBeat.o(108827);
    }
}
