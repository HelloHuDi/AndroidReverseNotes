package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.p057v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzav extends GoogleApiClient implements zzbq {
    private final Context mContext;
    private final Looper zzcn;
    private final int zzde;
    private final GoogleApiAvailability zzdg;
    private final AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    private boolean zzdk;
    private final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    @VisibleForTesting
    final Queue<ApiMethodImpl<?, ?>> zzgo = new LinkedList();
    private final GmsClientEventManager zzie;
    private zzbp zzif = null;
    private volatile boolean zzig;
    private long zzih = 120000;
    private long zzii = 5000;
    private final zzba zzij;
    @VisibleForTesting
    private GooglePlayServicesUpdatedReceiver zzik;
    final Map<AnyClientKey<?>, Client> zzil;
    Set<Scope> zzim = new HashSet();
    private final ListenerHolders zzin = new ListenerHolders();
    private final ArrayList<zzp> zzio;
    private Integer zzip = null;
    Set<zzch> zziq = null;
    final zzck zzir;
    private final GmsClientEventState zzis = new zzaw(this);

    public zzav(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<AnyClientKey<?>, Client> map2, int i, int i2, ArrayList<zzp> arrayList, boolean z) {
        AppMethodBeat.m2504i(60765);
        this.mContext = context;
        this.zzga = lock;
        this.zzdk = false;
        this.zzie = new GmsClientEventManager(looper, this.zzis);
        this.zzcn = looper;
        this.zzij = new zzba(this, looper);
        this.zzdg = googleApiAvailability;
        this.zzde = i;
        if (this.zzde >= 0) {
            this.zzip = Integer.valueOf(i2);
        }
        this.zzgi = map;
        this.zzil = map2;
        this.zzio = arrayList;
        this.zzir = new zzck(this.zzil);
        for (ConnectionCallbacks registerConnectionCallbacks : list) {
            this.zzie.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.zzie.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zzgf = clientSettings;
        this.zzdh = abstractClientBuilder;
        AppMethodBeat.m2505o(60765);
    }

    private final void resume() {
        AppMethodBeat.m2504i(60786);
        this.zzga.lock();
        try {
            if (this.zzig) {
                zzax();
            }
            this.zzga.unlock();
            AppMethodBeat.m2505o(60786);
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60786);
        }
    }

    public static int zza(Iterable<Client> iterable, boolean z) {
        AppMethodBeat.m2504i(60805);
        int i = 0;
        int i2 = 0;
        for (Client client : iterable) {
            if (client.requiresSignIn()) {
                i2 = 1;
            }
            i = client.providesSignIn() ? 1 : i;
        }
        if (i2 == 0) {
            AppMethodBeat.m2505o(60805);
            return 3;
        } else if (i == 0 || !z) {
            AppMethodBeat.m2505o(60805);
            return 1;
        } else {
            AppMethodBeat.m2505o(60805);
            return 2;
        }
    }

    private final void zza(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        AppMethodBeat.m2504i(60780);
        Common.CommonApi.clearDefaultAccount(googleApiClient).setResultCallback(new zzaz(this, statusPendingResult, z, googleApiClient));
        AppMethodBeat.m2505o(60780);
    }

    static /* synthetic */ void zza(zzav zzav, GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        AppMethodBeat.m2504i(60808);
        zzav.zza(googleApiClient, statusPendingResult, true);
        AppMethodBeat.m2505o(60808);
    }

    @GuardedBy("mLock")
    private final void zzax() {
        AppMethodBeat.m2504i(60785);
        this.zzie.enableCallbacks();
        this.zzif.connect();
        AppMethodBeat.m2505o(60785);
    }

    private final void zzay() {
        AppMethodBeat.m2504i(60787);
        this.zzga.lock();
        try {
            if (zzaz()) {
                zzax();
            }
            this.zzga.unlock();
            AppMethodBeat.m2505o(60787);
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60787);
        }
    }

    private final void zzg(int i) {
        IllegalStateException illegalStateException;
        AppMethodBeat.m2504i(60784);
        if (this.zzip == null) {
            this.zzip = Integer.valueOf(i);
        } else if (this.zzip.intValue() != i) {
            String zzh = zzh(i);
            String zzh2 = zzh(this.zzip.intValue());
            illegalStateException = new IllegalStateException(new StringBuilder((String.valueOf(zzh).length() + 51) + String.valueOf(zzh2).length()).append("Cannot use sign-in mode: ").append(zzh).append(". Mode was already set to ").append(zzh2).toString());
            AppMethodBeat.m2505o(60784);
            throw illegalStateException;
        }
        if (this.zzif != null) {
            AppMethodBeat.m2505o(60784);
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Client client : this.zzil.values()) {
            if (client.requiresSignIn()) {
                z2 = true;
            }
            z = client.providesSignIn() ? true : z;
        }
        switch (this.zzip.intValue()) {
            case 1:
                if (!z2) {
                    illegalStateException = new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    AppMethodBeat.m2505o(60784);
                    throw illegalStateException;
                } else if (z) {
                    illegalStateException = new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    AppMethodBeat.m2505o(60784);
                    throw illegalStateException;
                }
                break;
            case 2:
                if (z2) {
                    if (this.zzdk) {
                        this.zzif = new zzw(this.mContext, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this, true);
                        AppMethodBeat.m2505o(60784);
                        return;
                    }
                    this.zzif = zzr.zza(this.mContext, this, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio);
                    AppMethodBeat.m2505o(60784);
                    return;
                }
                break;
        }
        if (!this.zzdk || z) {
            this.zzif = new zzbd(this.mContext, this, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this);
            AppMethodBeat.m2505o(60784);
            return;
        }
        this.zzif = new zzw(this.mContext, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this, false);
        AppMethodBeat.m2505o(60784);
    }

    private static String zzh(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    public final ConnectionResult blockingConnect() {
        boolean z = true;
        AppMethodBeat.m2504i(60775);
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzga.lock();
        try {
            if (this.zzde >= 0) {
                if (this.zzip == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzip == null) {
                this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
            } else if (this.zzip.intValue() == 2) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                AppMethodBeat.m2505o(60775);
                throw illegalStateException;
            }
            zzg(this.zzip.intValue());
            this.zzie.enableCallbacks();
            ConnectionResult blockingConnect = this.zzif.blockingConnect();
            return blockingConnect;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60775);
        }
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        boolean z = false;
        AppMethodBeat.m2504i(60776);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        Preconditions.checkState(z, "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zzga.lock();
        try {
            if (this.zzip == null) {
                this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
            } else if (this.zzip.intValue() == 2) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                AppMethodBeat.m2505o(60776);
                throw illegalStateException;
            }
            zzg(this.zzip.intValue());
            this.zzie.enableCallbacks();
            ConnectionResult blockingConnect = this.zzif.blockingConnect(j, timeUnit);
            return blockingConnect;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60776);
        }
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        AppMethodBeat.m2504i(60779);
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Preconditions.checkState(this.zzip.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult((GoogleApiClient) this);
        if (this.zzil.containsKey(Common.CLIENT_KEY)) {
            zza(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new Builder(this.mContext).addApi(Common.API).addConnectionCallbacks(new zzax(this, atomicReference, statusPendingResult)).addOnConnectionFailedListener(new zzay(this, statusPendingResult)).setHandler(this.zzij).build();
            atomicReference.set(build);
            build.connect();
        }
        AppMethodBeat.m2505o(60779);
        return statusPendingResult;
    }

    public final void connect() {
        boolean z = false;
        AppMethodBeat.m2504i(60773);
        this.zzga.lock();
        try {
            if (this.zzde >= 0) {
                if (this.zzip != null) {
                    z = true;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzip == null) {
                this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
            } else if (this.zzip.intValue() == 2) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                AppMethodBeat.m2505o(60773);
                throw illegalStateException;
            }
            connect(this.zzip.intValue());
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60773);
        }
    }

    public final void connect(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(60774);
        this.zzga.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            Preconditions.checkArgument(z, "Illegal sign-in mode: " + i);
            zzg(i);
            zzax();
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60774);
        }
    }

    public final void disconnect() {
        AppMethodBeat.m2504i(60777);
        this.zzga.lock();
        try {
            this.zzir.release();
            if (this.zzif != null) {
                this.zzif.disconnect();
            }
            this.zzin.release();
            for (ApiMethodImpl apiMethodImpl : this.zzgo) {
                apiMethodImpl.zza(null);
                apiMethodImpl.cancel();
            }
            this.zzgo.clear();
            if (this.zzif != null) {
                zzaz();
                this.zzie.disableCallbacks();
                this.zzga.unlock();
                AppMethodBeat.m2505o(60777);
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60777);
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.m2504i(60804);
        printWriter.append(str).append("mContext=").println(this.mContext);
        printWriter.append(str).append("mResuming=").print(this.zzig);
        printWriter.append(" mWorkQueue.size()=").print(this.zzgo.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzir.zzmo.size());
        if (this.zzif != null) {
            this.zzif.dump(str, fileDescriptor, printWriter, strArr);
        }
        AppMethodBeat.m2505o(60804);
    }

    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.m2504i(60766);
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.zzil.containsKey(t.getClientKey());
        Object name = t.getApi() != null ? t.getApi().getName() : "the API";
        Preconditions.checkArgument(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzga.lock();
        try {
            if (this.zzif == null) {
                this.zzgo.add(t);
            } else {
                t = this.zzif.enqueue(t);
                this.zzga.unlock();
                AppMethodBeat.m2505o(60766);
            }
            return t;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60766);
        }
    }

    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.m2504i(60767);
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.zzil.containsKey(t.getClientKey());
        Object name = t.getApi() != null ? t.getApi().getName() : "the API";
        Preconditions.checkArgument(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzga.lock();
        try {
            if (this.zzif == null) {
                IllegalStateException illegalStateException = new IllegalStateException("GoogleApiClient is not connected yet.");
                AppMethodBeat.m2505o(60767);
                throw illegalStateException;
            }
            if (this.zzig) {
                this.zzgo.add(t);
                while (!this.zzgo.isEmpty()) {
                    ApiMethodImpl apiMethodImpl = (ApiMethodImpl) this.zzgo.remove();
                    this.zzir.zzb(apiMethodImpl);
                    apiMethodImpl.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
            } else {
                t = this.zzif.execute(t);
                this.zzga.unlock();
                AppMethodBeat.m2505o(60767);
            }
            return t;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60767);
        }
    }

    public final <C extends Client> C getClient(AnyClientKey<C> anyClientKey) {
        AppMethodBeat.m2504i(60769);
        Client client = (Client) this.zzil.get(anyClientKey);
        Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
        AppMethodBeat.m2505o(60769);
        return client;
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.m2504i(60772);
        this.zzga.lock();
        try {
            if (!isConnected() && !this.zzig) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
                AppMethodBeat.m2505o(60772);
                throw illegalStateException;
            } else if (this.zzil.containsKey(api.getClientKey())) {
                ConnectionResult connectionResult = this.zzif.getConnectionResult(api);
                if (connectionResult != null) {
                    this.zzga.unlock();
                    AppMethodBeat.m2505o(60772);
                } else if (this.zzig) {
                    connectionResult = ConnectionResult.RESULT_SUCCESS;
                } else {
                    zzbb();
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    connectionResult = new ConnectionResult(8, null);
                    this.zzga.unlock();
                    AppMethodBeat.m2505o(60772);
                }
                return connectionResult;
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
                AppMethodBeat.m2505o(60772);
                throw illegalArgumentException;
            }
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60772);
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzcn;
    }

    public final boolean hasApi(Api<?> api) {
        AppMethodBeat.m2504i(60770);
        boolean containsKey = this.zzil.containsKey(api.getClientKey());
        AppMethodBeat.m2505o(60770);
        return containsKey;
    }

    public final boolean hasConnectedApi(Api<?> api) {
        AppMethodBeat.m2504i(60771);
        if (isConnected()) {
            Client client = (Client) this.zzil.get(api.getClientKey());
            if (client == null || !client.isConnected()) {
                AppMethodBeat.m2505o(60771);
                return false;
            }
            AppMethodBeat.m2505o(60771);
            return true;
        }
        AppMethodBeat.m2505o(60771);
        return false;
    }

    public final boolean isConnected() {
        AppMethodBeat.m2504i(60782);
        if (this.zzif == null || !this.zzif.isConnected()) {
            AppMethodBeat.m2505o(60782);
            return false;
        }
        AppMethodBeat.m2505o(60782);
        return true;
    }

    public final boolean isConnecting() {
        AppMethodBeat.m2504i(60783);
        if (this.zzif == null || !this.zzif.isConnecting()) {
            AppMethodBeat.m2505o(60783);
            return false;
        }
        AppMethodBeat.m2505o(60783);
        return true;
    }

    public final boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.m2504i(60790);
        boolean isConnectionCallbacksRegistered = this.zzie.isConnectionCallbacksRegistered(connectionCallbacks);
        AppMethodBeat.m2505o(60790);
        return isConnectionCallbacksRegistered;
    }

    public final boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(60793);
        boolean isConnectionFailedListenerRegistered = this.zzie.isConnectionFailedListenerRegistered(onConnectionFailedListener);
        AppMethodBeat.m2505o(60793);
        return isConnectionFailedListenerRegistered;
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        AppMethodBeat.m2504i(60798);
        if (this.zzif == null || !this.zzif.maybeSignIn(signInConnectionListener)) {
            AppMethodBeat.m2505o(60798);
            return false;
        }
        AppMethodBeat.m2505o(60798);
        return true;
    }

    public final void maybeSignOut() {
        AppMethodBeat.m2504i(60799);
        if (this.zzif != null) {
            this.zzif.maybeSignOut();
        }
        AppMethodBeat.m2505o(60799);
    }

    public final void reconnect() {
        AppMethodBeat.m2504i(60778);
        disconnect();
        connect();
        AppMethodBeat.m2505o(60778);
    }

    public final void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.m2504i(60789);
        this.zzie.registerConnectionCallbacks(connectionCallbacks);
        AppMethodBeat.m2505o(60789);
    }

    public final void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(60792);
        this.zzie.registerConnectionFailedListener(onConnectionFailedListener);
        AppMethodBeat.m2505o(60792);
    }

    public final <L> ListenerHolder<L> registerListener(L l) {
        AppMethodBeat.m2504i(60768);
        this.zzga.lock();
        try {
            ListenerHolder<L> zza = this.zzin.zza(l, this.zzcn, "NO_TYPE");
            return zza;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60768);
        }
    }

    public final void stopAutoManage(FragmentActivity fragmentActivity) {
        AppMethodBeat.m2504i(60781);
        LifecycleActivity lifecycleActivity = new LifecycleActivity(fragmentActivity);
        if (this.zzde >= 0) {
            zzi.zza(lifecycleActivity).zzc(this.zzde);
            AppMethodBeat.m2505o(60781);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        AppMethodBeat.m2505o(60781);
        throw illegalStateException;
    }

    public final void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.m2504i(60791);
        this.zzie.unregisterConnectionCallbacks(connectionCallbacks);
        AppMethodBeat.m2505o(60791);
    }

    public final void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(60794);
        this.zzie.unregisterConnectionFailedListener(onConnectionFailedListener);
        AppMethodBeat.m2505o(60794);
    }

    public final void zza(zzch zzch) {
        AppMethodBeat.m2504i(60800);
        this.zzga.lock();
        try {
            if (this.zziq == null) {
                this.zziq = new HashSet();
            }
            this.zziq.add(zzch);
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60800);
        }
    }

    /* Access modifiers changed, original: final */
    @GuardedBy("mLock")
    public final boolean zzaz() {
        AppMethodBeat.m2504i(60788);
        if (this.zzig) {
            this.zzig = false;
            this.zzij.removeMessages(2);
            this.zzij.removeMessages(1);
            if (this.zzik != null) {
                this.zzik.unregister();
                this.zzik = null;
            }
            AppMethodBeat.m2505o(60788);
            return true;
        }
        AppMethodBeat.m2505o(60788);
        return false;
    }

    @GuardedBy("mLock")
    public final void zzb(int i, boolean z) {
        AppMethodBeat.m2504i(60797);
        if (!(i != 1 || z || this.zzig)) {
            this.zzig = true;
            if (this.zzik == null) {
                this.zzik = this.zzdg.registerCallbackOnUpdate(this.mContext.getApplicationContext(), new zzbb(this));
            }
            this.zzij.sendMessageDelayed(this.zzij.obtainMessage(1), this.zzih);
            this.zzij.sendMessageDelayed(this.zzij.obtainMessage(2), this.zzii);
        }
        this.zzir.zzce();
        this.zzie.onUnintentionalDisconnection(i);
        this.zzie.disableCallbacks();
        if (i == 2) {
            zzax();
        }
        AppMethodBeat.m2505o(60797);
    }

    @GuardedBy("mLock")
    public final void zzb(Bundle bundle) {
        AppMethodBeat.m2504i(60795);
        while (!this.zzgo.isEmpty()) {
            execute((ApiMethodImpl) this.zzgo.remove());
        }
        this.zzie.onConnectionSuccess(bundle);
        AppMethodBeat.m2505o(60795);
    }

    public final void zzb(zzch zzch) {
        AppMethodBeat.m2504i(60801);
        this.zzga.lock();
        try {
            if (this.zziq == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zziq.remove(zzch)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzba()) {
                this.zzif.zzz();
            }
            this.zzga.unlock();
            AppMethodBeat.m2505o(60801);
        } catch (Throwable th) {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60801);
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean zzba() {
        boolean z = false;
        AppMethodBeat.m2504i(60802);
        this.zzga.lock();
        try {
            if (this.zziq != null) {
                if (!this.zziq.isEmpty()) {
                    z = true;
                }
                this.zzga.unlock();
                AppMethodBeat.m2505o(60802);
            }
            return z;
        } finally {
            this.zzga.unlock();
            AppMethodBeat.m2505o(60802);
        }
    }

    /* Access modifiers changed, original: final */
    public final String zzbb() {
        AppMethodBeat.m2504i(60803);
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.m2505o(60803);
        return stringWriter2;
    }

    @GuardedBy("mLock")
    public final void zzc(ConnectionResult connectionResult) {
        AppMethodBeat.m2504i(60796);
        if (!this.zzdg.isPlayServicesPossiblyUpdating(this.mContext, connectionResult.getErrorCode())) {
            zzaz();
        }
        if (!this.zzig) {
            this.zzie.onConnectionFailure(connectionResult);
            this.zzie.disableCallbacks();
        }
        AppMethodBeat.m2505o(60796);
    }
}
