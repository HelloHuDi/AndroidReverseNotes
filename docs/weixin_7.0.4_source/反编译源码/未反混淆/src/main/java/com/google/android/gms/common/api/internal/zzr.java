package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.f.a;
import android.util.Log;
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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

final class zzr implements zzbp {
    private final Context mContext;
    private final Looper zzcn;
    private final zzav zzfq;
    private final zzbd zzfr;
    private final zzbd zzfs;
    private final Map<AnyClientKey<?>, zzbd> zzft;
    private final Set<SignInConnectionListener> zzfu = Collections.newSetFromMap(new WeakHashMap());
    private final Client zzfv;
    private Bundle zzfw;
    private ConnectionResult zzfx = null;
    private ConnectionResult zzfy = null;
    private boolean zzfz = false;
    private final Lock zzga;
    @GuardedBy("mLock")
    private int zzgb = 0;

    private zzr(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<AnyClientKey<?>, Client> map, Map<AnyClientKey<?>, Client> map2, ClientSettings clientSettings, AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Client client, ArrayList<zzp> arrayList, ArrayList<zzp> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        AppMethodBeat.i(60947);
        this.mContext = context;
        this.zzfq = zzav;
        this.zzga = lock;
        this.zzcn = looper;
        this.zzfv = client;
        this.zzfr = new zzbd(context, this.zzfq, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new zzt(this, null));
        this.zzfs = new zzbd(context, this.zzfq, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new zzu(this, null));
        a aVar = new a();
        for (AnyClientKey put : map2.keySet()) {
            aVar.put(put, this.zzfr);
        }
        for (AnyClientKey put2 : map.keySet()) {
            aVar.put(put2, this.zzfs);
        }
        this.zzft = Collections.unmodifiableMap(aVar);
        AppMethodBeat.o(60947);
    }

    public static zzr zza(Context context, zzav zzav, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<AnyClientKey<?>, Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, ArrayList<zzp> arrayList) {
        IllegalStateException illegalStateException;
        AppMethodBeat.i(60946);
        Client client = null;
        a aVar = new a();
        a aVar2 = new a();
        for (Entry entry : map.entrySet()) {
            Client client2 = (Client) entry.getValue();
            if (client2.providesSignIn()) {
                client = client2;
            }
            if (client2.requiresSignIn()) {
                aVar.put((AnyClientKey) entry.getKey(), client2);
            } else {
                aVar2.put((AnyClientKey) entry.getKey(), client2);
            }
        }
        Preconditions.checkState(!aVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        a aVar3 = new a();
        a aVar4 = new a();
        for (Api api : map2.keySet()) {
            AnyClientKey clientKey = api.getClientKey();
            if (aVar.containsKey(clientKey)) {
                aVar3.put(api, (Boolean) map2.get(api));
            } else if (aVar2.containsKey(clientKey)) {
                aVar4.put(api, (Boolean) map2.get(api));
            } else {
                illegalStateException = new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                AppMethodBeat.o(60946);
                throw illegalStateException;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            zzp zzp = (zzp) obj;
            if (aVar3.containsKey(zzp.mApi)) {
                arrayList2.add(zzp);
            } else if (aVar4.containsKey(zzp.mApi)) {
                arrayList3.add(zzp);
            } else {
                illegalStateException = new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                AppMethodBeat.o(60946);
                throw illegalStateException;
            }
        }
        zzr zzr = new zzr(context, zzav, lock, looper, googleApiAvailabilityLight, aVar, aVar2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, aVar3, aVar4);
        AppMethodBeat.o(60946);
        return zzr;
    }

    @GuardedBy("mLock")
    private final void zza(int i, boolean z) {
        AppMethodBeat.i(60963);
        this.zzfq.zzb(i, z);
        this.zzfy = null;
        this.zzfx = null;
        AppMethodBeat.o(60963);
    }

    private final void zza(Bundle bundle) {
        AppMethodBeat.i(60967);
        if (this.zzfw == null) {
            this.zzfw = bundle;
            AppMethodBeat.o(60967);
            return;
        }
        if (bundle != null) {
            this.zzfw.putAll(bundle);
        }
        AppMethodBeat.o(60967);
    }

    @GuardedBy("mLock")
    private final void zza(ConnectionResult connectionResult) {
        AppMethodBeat.i(60961);
        switch (this.zzgb) {
            case 1:
                break;
            case 2:
                this.zzfq.zzc(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzab();
        this.zzgb = 0;
        AppMethodBeat.o(60961);
    }

    static /* synthetic */ void zza(zzr zzr, int i, boolean z) {
        AppMethodBeat.i(60972);
        zzr.zza(i, z);
        AppMethodBeat.o(60972);
    }

    private final boolean zza(ApiMethodImpl<? extends Result, ? extends AnyClient> apiMethodImpl) {
        AppMethodBeat.i(60965);
        AnyClientKey clientKey = apiMethodImpl.getClientKey();
        Preconditions.checkArgument(this.zzft.containsKey(clientKey), "GoogleApiClient is not configured to use the API required for this call.");
        boolean equals = ((zzbd) this.zzft.get(clientKey)).equals(this.zzfs);
        AppMethodBeat.o(60965);
        return equals;
    }

    @GuardedBy("mLock")
    private final void zzaa() {
        AppMethodBeat.i(60960);
        if (zzb(this.zzfx)) {
            if (zzb(this.zzfy) || zzac()) {
                switch (this.zzgb) {
                    case 1:
                        break;
                    case 2:
                        this.zzfq.zzb(this.zzfw);
                        break;
                    default:
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        break;
                }
                zzab();
                this.zzgb = 0;
                AppMethodBeat.o(60960);
                return;
            } else if (this.zzfy != null) {
                if (this.zzgb == 1) {
                    zzab();
                    AppMethodBeat.o(60960);
                    return;
                }
                zza(this.zzfy);
                this.zzfr.disconnect();
                AppMethodBeat.o(60960);
                return;
            }
        } else if (this.zzfx != null && zzb(this.zzfy)) {
            this.zzfs.disconnect();
            zza(this.zzfx);
            AppMethodBeat.o(60960);
            return;
        } else if (!(this.zzfx == null || this.zzfy == null)) {
            ConnectionResult connectionResult = this.zzfx;
            if (this.zzfs.zzje < this.zzfr.zzje) {
                connectionResult = this.zzfy;
            }
            zza(connectionResult);
        }
        AppMethodBeat.o(60960);
    }

    @GuardedBy("mLock")
    private final void zzab() {
        AppMethodBeat.i(60962);
        for (SignInConnectionListener onComplete : this.zzfu) {
            onComplete.onComplete();
        }
        this.zzfu.clear();
        AppMethodBeat.o(60962);
    }

    @GuardedBy("mLock")
    private final boolean zzac() {
        AppMethodBeat.i(60964);
        if (this.zzfy == null || this.zzfy.getErrorCode() != 4) {
            AppMethodBeat.o(60964);
            return false;
        }
        AppMethodBeat.o(60964);
        return true;
    }

    private final PendingIntent zzad() {
        AppMethodBeat.i(60966);
        if (this.zzfv == null) {
            AppMethodBeat.o(60966);
            return null;
        }
        PendingIntent activity = PendingIntent.getActivity(this.mContext, System.identityHashCode(this.zzfq), this.zzfv.getSignInIntent(), 134217728);
        AppMethodBeat.o(60966);
        return activity;
    }

    private static boolean zzb(ConnectionResult connectionResult) {
        AppMethodBeat.i(60968);
        if (connectionResult == null || !connectionResult.isSuccess()) {
            AppMethodBeat.o(60968);
            return false;
        }
        AppMethodBeat.o(60968);
        return true;
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect() {
        AppMethodBeat.i(60952);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(60952);
        throw unsupportedOperationException;
    }

    @GuardedBy("mLock")
    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        AppMethodBeat.i(60953);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(60953);
        throw unsupportedOperationException;
    }

    @GuardedBy("mLock")
    public final void connect() {
        AppMethodBeat.i(60951);
        this.zzgb = 2;
        this.zzfz = false;
        this.zzfy = null;
        this.zzfx = null;
        this.zzfr.connect();
        this.zzfs.connect();
        AppMethodBeat.o(60951);
    }

    @GuardedBy("mLock")
    public final void disconnect() {
        AppMethodBeat.i(60954);
        this.zzfy = null;
        this.zzfx = null;
        this.zzgb = 0;
        this.zzfr.disconnect();
        this.zzfs.disconnect();
        zzab();
        AppMethodBeat.o(60954);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(60969);
        printWriter.append(str).append("authClient").println(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        this.zzfs.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        this.zzfr.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        AppMethodBeat.o(60969);
    }

    @GuardedBy("mLock")
    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(60948);
        ApiMethodImpl enqueue;
        if (!zza((ApiMethodImpl) t)) {
            enqueue = this.zzfr.enqueue(t);
            AppMethodBeat.o(60948);
            return enqueue;
        } else if (zzac()) {
            t.setFailedResult(new Status(4, null, zzad()));
            AppMethodBeat.o(60948);
            return t;
        } else {
            enqueue = this.zzfs.enqueue(t);
            AppMethodBeat.o(60948);
            return enqueue;
        }
    }

    @GuardedBy("mLock")
    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(60949);
        ApiMethodImpl execute;
        if (!zza((ApiMethodImpl) t)) {
            execute = this.zzfr.execute(t);
            AppMethodBeat.o(60949);
            return execute;
        } else if (zzac()) {
            t.setFailedResult(new Status(4, null, zzad()));
            AppMethodBeat.o(60949);
            return t;
        } else {
            execute = this.zzfs.execute(t);
            AppMethodBeat.o(60949);
            return execute;
        }
    }

    @GuardedBy("mLock")
    public final ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.i(60950);
        ConnectionResult connectionResult;
        if (!((zzbd) this.zzft.get(api.getClientKey())).equals(this.zzfs)) {
            connectionResult = this.zzfr.getConnectionResult(api);
            AppMethodBeat.o(60950);
            return connectionResult;
        } else if (zzac()) {
            connectionResult = new ConnectionResult(4, zzad());
            AppMethodBeat.o(60950);
            return connectionResult;
        } else {
            connectionResult = this.zzfs.getConnectionResult(api);
            AppMethodBeat.o(60950);
            return connectionResult;
        }
    }

    public final boolean isConnected() {
        boolean z = true;
        AppMethodBeat.i(60955);
        this.zzga.lock();
        try {
            if (!(this.zzfr.isConnected() && (this.zzfs.isConnected() || zzac() || this.zzgb == 1))) {
                z = false;
            }
            this.zzga.unlock();
            AppMethodBeat.o(60955);
            return z;
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.o(60955);
        }
    }

    public final boolean isConnecting() {
        AppMethodBeat.i(60956);
        this.zzga.lock();
        try {
            boolean z = this.zzgb == 2;
            this.zzga.unlock();
            AppMethodBeat.o(60956);
            return z;
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.o(60956);
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        AppMethodBeat.i(60957);
        this.zzga.lock();
        try {
            if ((isConnecting() || isConnected()) && !this.zzfs.isConnected()) {
                this.zzfu.add(signInConnectionListener);
                if (this.zzgb == 0) {
                    this.zzgb = 1;
                }
                this.zzfy = null;
                this.zzfs.connect();
                return true;
            }
            this.zzga.unlock();
            AppMethodBeat.o(60957);
            return false;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.o(60957);
        }
    }

    public final void maybeSignOut() {
        AppMethodBeat.i(60959);
        this.zzga.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzfs.disconnect();
            this.zzfy = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzcn).post(new zzs(this));
            } else {
                zzab();
            }
            this.zzga.unlock();
            AppMethodBeat.o(60959);
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.o(60959);
        }
    }

    @GuardedBy("mLock")
    public final void zzz() {
        AppMethodBeat.i(60958);
        this.zzfr.zzz();
        this.zzfs.zzz();
        AppMethodBeat.o(60958);
    }
}
