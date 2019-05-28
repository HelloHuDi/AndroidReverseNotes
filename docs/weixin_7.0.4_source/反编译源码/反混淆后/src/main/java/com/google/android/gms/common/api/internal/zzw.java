package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import android.support.p057v4.p065f.C6197a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzw implements zzbp {
    private final Looper zzcn;
    private final GoogleApiManager zzcq;
    private final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<AnyClientKey<?>, zzv<?>> zzgg = new HashMap();
    private final Map<AnyClientKey<?>, zzv<?>> zzgh = new HashMap();
    private final Map<Api<?>, Boolean> zzgi;
    private final zzav zzgj;
    private final GoogleApiAvailabilityLight zzgk;
    private final Condition zzgl;
    private final boolean zzgm;
    private final boolean zzgn;
    private final Queue<ApiMethodImpl<?, ?>> zzgo = new LinkedList();
    @GuardedBy("mLock")
    private boolean zzgp;
    @GuardedBy("mLock")
    private Map<zzh<?>, ConnectionResult> zzgq;
    @GuardedBy("mLock")
    private Map<zzh<?>, ConnectionResult> zzgr;
    @GuardedBy("mLock")
    private zzz zzgs;
    @GuardedBy("mLock")
    private ConnectionResult zzgt;

    public zzw(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<AnyClientKey<?>, Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList, zzav zzav, boolean z) {
        AppMethodBeat.m2504i(60983);
        this.zzga = lock;
        this.zzcn = looper;
        this.zzgl = lock.newCondition();
        this.zzgk = googleApiAvailabilityLight;
        this.zzgj = zzav;
        this.zzgi = map2;
        this.zzgf = clientSettings;
        this.zzgm = z;
        HashMap hashMap = new HashMap();
        for (Api api : map2.keySet()) {
            hashMap.put(api.getClientKey(), api);
        }
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zzp zzp = (zzp) obj;
            hashMap2.put(zzp.mApi, zzp);
        }
        Object obj2 = null;
        Object obj3 = 1;
        Object obj4 = null;
        for (Entry entry : map.entrySet()) {
            Object obj5;
            Object obj6;
            Object obj7;
            Api api2 = (Api) hashMap.get(entry.getKey());
            Client client = (Client) entry.getValue();
            if (!client.requiresGooglePlayServices()) {
                obj5 = obj4;
                obj6 = null;
                obj7 = obj2;
            } else if (((Boolean) this.zzgi.get(api2)).booleanValue()) {
                int obj52 = 1;
                obj6 = obj3;
                obj7 = obj2;
            } else {
                obj52 = 1;
                obj6 = obj3;
                obj7 = 1;
            }
            zzv zzv = new zzv(context, api2, looper, client, (zzp) hashMap2.get(api2), clientSettings, abstractClientBuilder);
            this.zzgg.put((AnyClientKey) entry.getKey(), zzv);
            if (client.requiresSignIn()) {
                this.zzgh.put((AnyClientKey) entry.getKey(), zzv);
            }
            obj4 = obj52;
            obj3 = obj6;
            obj2 = obj7;
        }
        boolean z2 = obj4 != null && obj3 == null && obj2 == null;
        this.zzgn = z2;
        this.zzcq = GoogleApiManager.zzbf();
        AppMethodBeat.m2505o(60983);
    }

    private final ConnectionResult zza(AnyClientKey<?> anyClientKey) {
        AppMethodBeat.m2504i(60992);
        this.zzga.lock();
        try {
            zzv zzv = (zzv) this.zzgg.get(anyClientKey);
            if (this.zzgq == null || zzv == null) {
                this.zzga.unlock();
                AppMethodBeat.m2505o(60992);
                return null;
            }
            ConnectionResult connectionResult = (ConnectionResult) this.zzgq.get(zzv.zzm());
            return connectionResult;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60992);
        }
    }

    private final boolean zza(zzv<?> zzv, ConnectionResult connectionResult) {
        AppMethodBeat.m2504i(61000);
        if (!connectionResult.isSuccess() && !connectionResult.hasResolution() && ((Boolean) this.zzgi.get(zzv.getApi())).booleanValue() && zzv.zzae().requiresGooglePlayServices() && this.zzgk.isUserResolvableError(connectionResult.getErrorCode())) {
            AppMethodBeat.m2505o(61000);
            return true;
        }
        AppMethodBeat.m2505o(61000);
        return false;
    }

    static /* synthetic */ boolean zza(zzw zzw, zzv zzv, ConnectionResult connectionResult) {
        AppMethodBeat.m2504i(61002);
        boolean zza = zzw.zza(zzv, connectionResult);
        AppMethodBeat.m2505o(61002);
        return zza;
    }

    private final boolean zzaf() {
        AppMethodBeat.m2504i(60995);
        this.zzga.lock();
        try {
            if (this.zzgp && this.zzgm) {
                for (AnyClientKey zza : this.zzgh.keySet()) {
                    ConnectionResult zza2 = zza(zza);
                    if (zza2 != null) {
                        if (!zza2.isSuccess()) {
                        }
                    }
                    this.zzga.unlock();
                    AppMethodBeat.m2505o(60995);
                    return false;
                }
                this.zzga.unlock();
                AppMethodBeat.m2505o(60995);
                return true;
            }
            this.zzga.unlock();
            AppMethodBeat.m2505o(60995);
            return false;
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60995);
        }
    }

    @GuardedBy("mLock")
    private final void zzag() {
        AppMethodBeat.m2504i(60998);
        if (this.zzgf == null) {
            this.zzgj.zzim = Collections.emptySet();
            AppMethodBeat.m2505o(60998);
            return;
        }
        HashSet hashSet = new HashSet(this.zzgf.getRequiredScopes());
        Map optionalApiSettings = this.zzgf.getOptionalApiSettings();
        for (Api api : optionalApiSettings.keySet()) {
            ConnectionResult connectionResult = getConnectionResult(api);
            if (connectionResult != null && connectionResult.isSuccess()) {
                hashSet.addAll(((OptionalApiSettings) optionalApiSettings.get(api)).mScopes);
            }
        }
        this.zzgj.zzim = hashSet;
        AppMethodBeat.m2505o(60998);
    }

    @GuardedBy("mLock")
    private final void zzah() {
        AppMethodBeat.m2504i(60999);
        while (!this.zzgo.isEmpty()) {
            execute((ApiMethodImpl) this.zzgo.remove());
        }
        this.zzgj.zzb(null);
        AppMethodBeat.m2505o(60999);
    }

    @GuardedBy("mLock")
    private final ConnectionResult zzai() {
        AppMethodBeat.m2504i(61001);
        int i = 0;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        for (zzv zzv : this.zzgg.values()) {
            Api api = zzv.getApi();
            ConnectionResult connectionResult3 = (ConnectionResult) this.zzgq.get(zzv.zzm());
            if (!connectionResult3.isSuccess() && (!((Boolean) this.zzgi.get(api)).booleanValue() || connectionResult3.hasResolution() || this.zzgk.isUserResolvableError(connectionResult3.getErrorCode()))) {
                int priority;
                if (connectionResult3.getErrorCode() == 4 && this.zzgm) {
                    priority = api.zzj().getPriority();
                    if (connectionResult == null || i > priority) {
                        i = priority;
                        connectionResult = connectionResult3;
                    }
                } else {
                    priority = api.zzj().getPriority();
                    if (connectionResult2 != null && i2 <= priority) {
                        priority = i2;
                        connectionResult3 = connectionResult2;
                    }
                    i2 = priority;
                    connectionResult2 = connectionResult3;
                }
            }
        }
        if (connectionResult2 == null || connectionResult == null || i2 <= i) {
            AppMethodBeat.m2505o(61001);
            return connectionResult2;
        }
        AppMethodBeat.m2505o(61001);
        return connectionResult;
    }

    private final <T extends ApiMethodImpl<? extends Result, ? extends AnyClient>> boolean zzb(T t) {
        AppMethodBeat.m2504i(60986);
        AnyClientKey clientKey = t.getClientKey();
        ConnectionResult zza = zza(clientKey);
        if (zza == null || zza.getErrorCode() != 4) {
            AppMethodBeat.m2505o(60986);
            return false;
        }
        t.setFailedResult(new Status(4, null, this.zzcq.zza(((zzv) this.zzgg.get(clientKey)).zzm(), System.identityHashCode(this.zzgj))));
        AppMethodBeat.m2505o(60986);
        return true;
    }

    static /* synthetic */ ConnectionResult zzf(zzw zzw) {
        AppMethodBeat.m2504i(61003);
        ConnectionResult zzai = zzw.zzai();
        AppMethodBeat.m2505o(61003);
        return zzai;
    }

    static /* synthetic */ void zzi(zzw zzw) {
        AppMethodBeat.m2504i(61004);
        zzw.zzag();
        AppMethodBeat.m2505o(61004);
    }

    static /* synthetic */ void zzj(zzw zzw) {
        AppMethodBeat.m2504i(61005);
        zzw.zzah();
        AppMethodBeat.m2505o(61005);
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        AppMethodBeat.m2504i(60988);
        connect();
        while (isConnecting()) {
            try {
                this.zzgl.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                connectionResult = new ConnectionResult(15, null);
                AppMethodBeat.m2505o(60988);
                return connectionResult;
            }
        }
        if (isConnected()) {
            connectionResult = ConnectionResult.RESULT_SUCCESS;
            AppMethodBeat.m2505o(60988);
            return connectionResult;
        } else if (this.zzgt != null) {
            connectionResult = this.zzgt;
            AppMethodBeat.m2505o(60988);
            return connectionResult;
        } else {
            connectionResult = new ConnectionResult(13, null);
            AppMethodBeat.m2505o(60988);
            return connectionResult;
        }
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        ConnectionResult connectionResult;
        AppMethodBeat.m2504i(60989);
        connect();
        long toNanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (toNanos <= 0) {
                try {
                    disconnect();
                    connectionResult = new ConnectionResult(14, null);
                    AppMethodBeat.m2505o(60989);
                    return connectionResult;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    connectionResult = new ConnectionResult(15, null);
                    AppMethodBeat.m2505o(60989);
                    return connectionResult;
                }
            }
            toNanos = this.zzgl.awaitNanos(toNanos);
        }
        if (isConnected()) {
            connectionResult = ConnectionResult.RESULT_SUCCESS;
            AppMethodBeat.m2505o(60989);
            return connectionResult;
        } else if (this.zzgt != null) {
            connectionResult = this.zzgt;
            AppMethodBeat.m2505o(60989);
            return connectionResult;
        } else {
            connectionResult = new ConnectionResult(13, null);
            AppMethodBeat.m2505o(60989);
            return connectionResult;
        }
    }

    public final void connect() {
        AppMethodBeat.m2504i(60987);
        this.zzga.lock();
        try {
            if (!this.zzgp) {
                this.zzgp = true;
                this.zzgq = null;
                this.zzgr = null;
                this.zzgs = null;
                this.zzgt = null;
                this.zzcq.zzr();
                this.zzcq.zza(this.zzgg.values()).addOnCompleteListener(new HandlerExecutor(this.zzcn), new zzy(this, null));
                this.zzga.unlock();
                AppMethodBeat.m2505o(60987);
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60987);
        }
    }

    public final void disconnect() {
        AppMethodBeat.m2504i(60990);
        this.zzga.lock();
        try {
            this.zzgp = false;
            this.zzgq = null;
            this.zzgr = null;
            if (this.zzgs != null) {
                this.zzgs.cancel();
                this.zzgs = null;
            }
            this.zzgt = null;
            while (!this.zzgo.isEmpty()) {
                ApiMethodImpl apiMethodImpl = (ApiMethodImpl) this.zzgo.remove();
                apiMethodImpl.zza(null);
                apiMethodImpl.cancel();
            }
            this.zzgl.signalAll();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60990);
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.m2504i(60984);
        if (this.zzgm && zzb((ApiMethodImpl) t)) {
            AppMethodBeat.m2505o(60984);
            return t;
        } else if (isConnected()) {
            this.zzgj.zzir.zzb(t);
            ApiMethodImpl doRead = ((zzv) this.zzgg.get(t.getClientKey())).doRead((ApiMethodImpl) t);
            AppMethodBeat.m2505o(60984);
            return doRead;
        } else {
            this.zzgo.add(t);
            AppMethodBeat.m2505o(60984);
            return t;
        }
    }

    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.m2504i(60985);
        AnyClientKey clientKey = t.getClientKey();
        if (this.zzgm && zzb((ApiMethodImpl) t)) {
            AppMethodBeat.m2505o(60985);
            return t;
        }
        this.zzgj.zzir.zzb(t);
        ApiMethodImpl doWrite = ((zzv) this.zzgg.get(clientKey)).doWrite((ApiMethodImpl) t);
        AppMethodBeat.m2505o(60985);
        return doWrite;
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.m2504i(60991);
        ConnectionResult zza = zza(api.getClientKey());
        AppMethodBeat.m2505o(60991);
        return zza;
    }

    public final boolean isConnected() {
        AppMethodBeat.m2504i(60993);
        this.zzga.lock();
        try {
            boolean z = this.zzgq != null && this.zzgt == null;
            this.zzga.unlock();
            AppMethodBeat.m2505o(60993);
            return z;
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60993);
        }
    }

    public final boolean isConnecting() {
        AppMethodBeat.m2504i(60994);
        this.zzga.lock();
        try {
            boolean z = this.zzgq == null && this.zzgp;
            this.zzga.unlock();
            AppMethodBeat.m2505o(60994);
            return z;
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60994);
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        AppMethodBeat.m2504i(60996);
        this.zzga.lock();
        try {
            if (!this.zzgp || zzaf()) {
                this.zzga.unlock();
                AppMethodBeat.m2505o(60996);
                return false;
            }
            this.zzcq.zzr();
            this.zzgs = new zzz(this, signInConnectionListener);
            this.zzcq.zza(this.zzgh.values()).addOnCompleteListener(new HandlerExecutor(this.zzcn), this.zzgs);
            this.zzga.unlock();
            AppMethodBeat.m2505o(60996);
            return true;
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60996);
        }
    }

    public final void maybeSignOut() {
        AppMethodBeat.m2504i(60997);
        this.zzga.lock();
        try {
            this.zzcq.maybeSignOut();
            if (this.zzgs != null) {
                this.zzgs.cancel();
                this.zzgs = null;
            }
            if (this.zzgr == null) {
                this.zzgr = new C6197a(this.zzgh.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zzv zzm : this.zzgh.values()) {
                this.zzgr.put(zzm.zzm(), connectionResult);
            }
            if (this.zzgq != null) {
                this.zzgq.putAll(this.zzgr);
            }
            this.zzga.unlock();
            AppMethodBeat.m2505o(60997);
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60997);
        }
    }

    public final void zzz() {
    }
}
