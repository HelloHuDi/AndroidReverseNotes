package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class c<T> {
    final int bvC;
    final TaskCompletionSource<T> bvD = new TaskCompletionSource();
    final Bundle bvE;
    final int what;

    c(int i, int i2, Bundle bundle) {
        this.bvC = i;
        this.what = i2;
        this.bvE = bundle;
    }

    /* Access modifiers changed, original: final */
    public final void a(d dVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(dVar);
            new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length()).append("Failing ").append(valueOf).append(" with ").append(valueOf2);
        }
        this.bvD.setException(dVar);
    }

    /* Access modifiers changed, original: final */
    public final void p(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            new StringBuilder((String.valueOf(valueOf).length() + 16) + String.valueOf(valueOf2).length()).append("Finishing ").append(valueOf).append(" with ").append(valueOf2);
        }
        this.bvD.setResult(t);
    }

    public String toString() {
        int i = this.what;
        int i2 = this.bvC;
        return "Request { what=" + i + " id=" + i2 + " oneWay=" + zzw() + "}";
    }

    public abstract void zzb(Bundle bundle);

    public abstract boolean zzw();
}
