package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzbd implements zzbp, zzq {
    private final Context mContext;
    private final AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    final zzav zzfq;
    private final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    private final GoogleApiAvailabilityLight zzgk;
    final Map<AnyClientKey<?>, Client> zzil;
    private final Condition zziz;
    private final zzbf zzja;
    final Map<AnyClientKey<?>, ConnectionResult> zzjb = new HashMap();
    private volatile zzbc zzjc;
    private ConnectionResult zzjd = null;
    int zzje;
    final zzbq zzjf;

    public zzbd(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<AnyClientKey<?>, Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList, zzbq zzbq) {
        AppMethodBeat.i(60816);
        this.mContext = context;
        this.zzga = lock;
        this.zzgk = googleApiAvailabilityLight;
        this.zzil = map;
        this.zzgf = clientSettings;
        this.zzgi = map2;
        this.zzdh = abstractClientBuilder;
        this.zzfq = zzav;
        this.zzjf = zzbq;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzp) obj).zza(this);
        }
        this.zzja = new zzbf(this, looper);
        this.zziz = lock.newCondition();
        this.zzjc = new zzau(this);
        AppMethodBeat.o(60816);
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        AppMethodBeat.i(60820);
        connect();
        while (isConnecting()) {
            try {
                this.zziz.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                connectionResult = new ConnectionResult(15, null);
                AppMethodBeat.o(60820);
                return connectionResult;
            }
        }
        if (isConnected()) {
            connectionResult = ConnectionResult.RESULT_SUCCESS;
            AppMethodBeat.o(60820);
            return connectionResult;
        } else if (this.zzjd != null) {
            connectionResult = this.zzjd;
            AppMethodBeat.o(60820);
            return connectionResult;
        } else {
            connectionResult = new ConnectionResult(13, null);
            AppMethodBeat.o(60820);
            return connectionResult;
        }
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        ConnectionResult connectionResult;
        AppMethodBeat.i(60821);
        connect();
        long toNanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (toNanos <= 0) {
                try {
                    disconnect();
                    connectionResult = new ConnectionResult(14, null);
                    AppMethodBeat.o(60821);
                    return connectionResult;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    connectionResult = new ConnectionResult(15, null);
                    AppMethodBeat.o(60821);
                    return connectionResult;
                }
            }
            toNanos = this.zziz.awaitNanos(toNanos);
        }
        if (isConnected()) {
            connectionResult = ConnectionResult.RESULT_SUCCESS;
            AppMethodBeat.o(60821);
            return connectionResult;
        } else if (this.zzjd != null) {
            connectionResult = this.zzjd;
            AppMethodBeat.o(60821);
            return connectionResult;
        } else {
            connectionResult = new ConnectionResult(13, null);
            AppMethodBeat.o(60821);
            return connectionResult;
        }
    }

    @GuardedBy("mLock")
    public final void connect() {
        AppMethodBeat.i(60819);
        this.zzjc.connect();
        AppMethodBeat.o(60819);
    }

    @GuardedBy("mLock")
    public final void disconnect() {
        AppMethodBeat.i(60822);
        if (this.zzjc.disconnect()) {
            this.zzjb.clear();
        }
        AppMethodBeat.o(60822);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(60833);
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.zzjc);
        for (Api api : this.zzgi.keySet()) {
            printWriter.append(str).append(api.getName()).println(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            ((Client) this.zzil.get(api.getClientKey())).dump(concat, fileDescriptor, printWriter, strArr);
        }
        AppMethodBeat.o(60833);
    }

    @GuardedBy("mLock")
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(60817);
        t.zzx();
        ApiMethodImpl enqueue = this.zzjc.enqueue(t);
        AppMethodBeat.o(60817);
        return enqueue;
    }

    @GuardedBy("mLock")
    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(60818);
        t.zzx();
        ApiMethodImpl execute = this.zzjc.execute(t);
        AppMethodBeat.o(60818);
        return execute;
    }

    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.i(60823);
        AnyClientKey clientKey = api.getClientKey();
        if (this.zzil.containsKey(clientKey)) {
            ConnectionResult connectionResult;
            if (((Client) this.zzil.get(clientKey)).isConnected()) {
                connectionResult = ConnectionResult.RESULT_SUCCESS;
                AppMethodBeat.o(60823);
                return connectionResult;
            } else if (this.zzjb.containsKey(clientKey)) {
                connectionResult = (ConnectionResult) this.zzjb.get(clientKey);
                AppMethodBeat.o(60823);
                return connectionResult;
            }
        }
        AppMethodBeat.o(60823);
        return null;
    }

    public final boolean isConnected() {
        return this.zzjc instanceof zzag;
    }

    public final boolean isConnecting() {
        return this.zzjc instanceof zzaj;
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    public final void maybeSignOut() {
    }

    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(60829);
        this.zzga.lock();
        try {
            this.zzjc.onConnected(bundle);
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(60829);
        }
    }

    public final void onConnectionSuspended(int i) {
        AppMethodBeat.i(60830);
        this.zzga.lock();
        try {
            this.zzjc.onConnectionSuspended(i);
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(60830);
        }
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        AppMethodBeat.i(60828);
        this.zzga.lock();
        try {
            this.zzjc.zza(connectionResult, api, z);
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(60828);
        }
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzbe zzbe) {
        AppMethodBeat.i(60831);
        this.zzja.sendMessage(this.zzja.obtainMessage(1, zzbe));
        AppMethodBeat.o(60831);
    }

    /* Access modifiers changed, original: final */
    public final void zzb(RuntimeException runtimeException) {
        AppMethodBeat.i(60832);
        this.zzja.sendMessage(this.zzja.obtainMessage(2, runtimeException));
        AppMethodBeat.o(60832);
    }

    /* Access modifiers changed, original: final */
    public final void zzbc() {
        AppMethodBeat.i(60824);
        this.zzga.lock();
        try {
            this.zzjc = new zzaj(this, this.zzgf, this.zzgi, this.zzgk, this.zzdh, this.zzga, this.mContext);
            this.zzjc.begin();
            this.zziz.signalAll();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(60824);
        }
    }

    /* Access modifiers changed, original: final */
    public final void zzbd() {
        AppMethodBeat.i(60825);
        this.zzga.lock();
        try {
            this.zzfq.zzaz();
            this.zzjc = new zzag(this);
            this.zzjc.begin();
            this.zziz.signalAll();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(60825);
        }
    }

    /* Access modifiers changed, original: final */
    public final void zzf(ConnectionResult connectionResult) {
        AppMethodBeat.i(60826);
        this.zzga.lock();
        try {
            this.zzjd = connectionResult;
            this.zzjc = new zzau(this);
            this.zzjc.begin();
            this.zziz.signalAll();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(60826);
        }
    }

    @GuardedBy("mLock")
    public final void zzz() {
        AppMethodBeat.i(60827);
        if (isConnected()) {
            ((zzag) this.zzjc).zzap();
        }
        AppMethodBeat.o(60827);
    }
}
