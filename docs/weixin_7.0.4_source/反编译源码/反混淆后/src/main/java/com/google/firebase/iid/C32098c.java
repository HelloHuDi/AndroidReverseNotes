package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.firebase.iid.c */
abstract class C32098c<T> {
    final int bvC;
    final TaskCompletionSource<T> bvD = new TaskCompletionSource();
    final Bundle bvE;
    final int what;

    C32098c(int i, int i2, Bundle bundle) {
        this.bvC = i;
        this.what = i2;
        this.bvE = bundle;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo52661a(C0908d c0908d) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(c0908d);
            new StringBuilder((String.valueOf(valueOf).length() + 14) + String.valueOf(valueOf2).length()).append("Failing ").append(valueOf).append(" with ").append(valueOf2);
        }
        this.bvD.setException(c0908d);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: p */
    public final void mo52662p(T t) {
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
