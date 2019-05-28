package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzz<T> {
    final int what;
    final int zzck;
    final TaskCompletionSource<T> zzcl = new TaskCompletionSource();
    final Bundle zzcm;

    zzz(int i, int i2, Bundle bundle) {
        this.zzck = i;
        this.what = i2;
        this.zzcm = bundle;
    }

    public String toString() {
        int i = this.what;
        int i2 = this.zzck;
        zzu();
        return "Request { what=" + i + " id=" + i2 + " oneWay=false}";
    }

    /* Access modifiers changed, original: final */
    public final void zzd(zzaa zzaa) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzaa);
            new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length()).append("Failing ").append(valueOf).append(" with ").append(valueOf2);
        }
        this.zzcl.setException(zzaa);
    }

    public abstract void zzh(Bundle bundle);

    public abstract boolean zzu();
}
