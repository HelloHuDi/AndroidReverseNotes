package com.google.android.gms.iid;

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

final class zzt implements ServiceConnection {
    @GuardedBy("this")
    int state;
    final Messenger zzcc;
    zzy zzcd;
    @GuardedBy("this")
    final Queue<zzz<?>> zzce;
    @GuardedBy("this")
    final SparseArray<zzz<?>> zzcf;
    final /* synthetic */ zzr zzcg;

    private zzt(zzr zzr) {
        this.zzcg = zzr;
        AppMethodBeat.i(57603);
        this.state = 0;
        this.zzcc = new Messenger(new Handler(Looper.getMainLooper(), new zzu(this)));
        this.zzce = new ArrayDeque();
        this.zzcf = new SparseArray();
        AppMethodBeat.o(57603);
    }

    private final void zzr() {
        AppMethodBeat.i(57607);
        this.zzcg.zzbz.execute(new zzw(this));
        AppMethodBeat.o(57607);
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(57606);
        Log.isLoggable("MessengerIpcClient", 2);
        if (iBinder == null) {
            zzd(0, "Null service connection");
            AppMethodBeat.o(57606);
        } else {
            try {
                this.zzcd = new zzy(iBinder);
                this.state = 2;
                zzr();
                AppMethodBeat.o(57606);
            } catch (RemoteException e) {
                zzd(0, e.getMessage());
                AppMethodBeat.o(57606);
            }
        }
        return;
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(57608);
        Log.isLoggable("MessengerIpcClient", 2);
        zzd(2, "Service disconnected");
        AppMethodBeat.o(57608);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zzd(int i, String str) {
        AppMethodBeat.i(57609);
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
                AppMethodBeat.o(57609);
                throw illegalStateException;
            case 1:
            case 2:
                Log.isLoggable("MessengerIpcClient", 2);
                this.state = 4;
                ConnectionTracker.getInstance().unbindService(this.zzcg.zzk, this);
                zzaa zzaa = new zzaa(i, str);
                for (zzz zzd : this.zzce) {
                    zzd.zzd(zzaa);
                }
                this.zzce.clear();
                for (int i2 = 0; i2 < this.zzcf.size(); i2++) {
                    ((zzz) this.zzcf.valueAt(i2)).zzd(zzaa);
                }
                this.zzcf.clear();
                AppMethodBeat.o(57609);
                break;
            case 3:
                this.state = 4;
                AppMethodBeat.o(57609);
                break;
            case 4:
                AppMethodBeat.o(57609);
                break;
            default:
                illegalStateException = new IllegalStateException("Unknown state: " + this.state);
                AppMethodBeat.o(57609);
                throw illegalStateException;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean zzd(Message message) {
        AppMethodBeat.i(57605);
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            new StringBuilder(41).append("Received response to request: ").append(i);
        }
        synchronized (this) {
            try {
                zzz zzz = (zzz) this.zzcf.get(i);
                if (zzz == null) {
                    new StringBuilder(50).append("Received response for unknown request: ").append(i);
                } else {
                    this.zzcf.remove(i);
                    zzs();
                    Bundle data = message.getData();
                    if (data.getBoolean("unsupported", false)) {
                        zzz.zzd(new zzaa(4, "Not supported by GmsCore"));
                    } else {
                        zzz.zzh(data);
                    }
                    AppMethodBeat.o(57605);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(57605);
            }
        }
        return true;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized boolean zze(zzz zzz) {
        boolean z = false;
        boolean z2 = true;
        synchronized (this) {
            AppMethodBeat.i(57604);
            switch (this.state) {
                case 0:
                    this.zzce.add(zzz);
                    if (this.state == 0) {
                        z = true;
                    }
                    Preconditions.checkState(z);
                    Log.isLoggable("MessengerIpcClient", 2);
                    this.state = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (ConnectionTracker.getInstance().bindService(this.zzcg.zzk, intent, this, 1)) {
                        this.zzcg.zzbz.schedule(new zzv(this), 30, TimeUnit.SECONDS);
                    } else {
                        zzd(0, "Unable to bind to service");
                    }
                    AppMethodBeat.o(57604);
                    break;
                case 1:
                    this.zzce.add(zzz);
                    AppMethodBeat.o(57604);
                    break;
                case 2:
                    this.zzce.add(zzz);
                    zzr();
                    AppMethodBeat.o(57604);
                    break;
                case 3:
                case 4:
                    AppMethodBeat.o(57604);
                    z2 = false;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unknown state: " + this.state);
                    AppMethodBeat.o(57604);
                    throw illegalStateException;
            }
        }
        return z2;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zzg(int i) {
        AppMethodBeat.i(57612);
        zzz zzz = (zzz) this.zzcf.get(i);
        if (zzz != null) {
            new StringBuilder(31).append("Timing out request: ").append(i);
            this.zzcf.remove(i);
            zzz.zzd(new zzaa(3, "Timed out waiting for response"));
            zzs();
        }
        AppMethodBeat.o(57612);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zzs() {
        AppMethodBeat.i(57610);
        if (this.state == 2 && this.zzce.isEmpty() && this.zzcf.size() == 0) {
            Log.isLoggable("MessengerIpcClient", 2);
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(this.zzcg.zzk, this);
        }
        AppMethodBeat.o(57610);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void zzt() {
        AppMethodBeat.i(57611);
        if (this.state == 1) {
            zzd(1, "Timed out while binding");
        }
        AppMethodBeat.o(57611);
    }
}
