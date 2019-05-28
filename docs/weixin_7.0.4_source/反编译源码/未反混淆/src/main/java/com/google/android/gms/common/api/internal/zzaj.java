package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.SignInResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzaj implements zzbc {
    private final Context mContext;
    private final AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    private final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    private final GoogleApiAvailabilityLight zzgk;
    private ConnectionResult zzgt;
    private final zzbd zzhf;
    private int zzhi;
    private int zzhj = 0;
    private int zzhk;
    private final Bundle zzhl = new Bundle();
    private final Set<AnyClientKey> zzhm = new HashSet();
    private SignInClient zzhn;
    private boolean zzho;
    private boolean zzhp;
    private boolean zzhq;
    private IAccountAccessor zzhr;
    private boolean zzhs;
    private boolean zzht;
    private ArrayList<Future<?>> zzhu = new ArrayList();

    public zzaj(zzbd zzbd, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        AppMethodBeat.i(60720);
        this.zzhf = zzbd;
        this.zzgf = clientSettings;
        this.zzgi = map;
        this.zzgk = googleApiAvailabilityLight;
        this.zzdh = abstractClientBuilder;
        this.zzga = lock;
        this.mContext = context;
        AppMethodBeat.o(60720);
    }

    static /* synthetic */ void zza(zzaj zzaj, ConnectionResult connectionResult, Api api, boolean z) {
        AppMethodBeat.i(60746);
        zzaj.zzb(connectionResult, api, z);
        AppMethodBeat.o(60746);
    }

    @GuardedBy("mLock")
    private final void zza(SignInResponse signInResponse) {
        AppMethodBeat.i(60723);
        if (zze(0)) {
            ConnectionResult connectionResult = signInResponse.getConnectionResult();
            if (connectionResult.isSuccess()) {
                ResolveAccountResponse resolveAccountResponse = signInResponse.getResolveAccountResponse();
                ConnectionResult connectionResult2 = resolveAccountResponse.getConnectionResult();
                if (connectionResult2.isSuccess()) {
                    this.zzhq = true;
                    this.zzhr = resolveAccountResponse.getAccountAccessor();
                    this.zzhs = resolveAccountResponse.getSaveDefaultAccount();
                    this.zzht = resolveAccountResponse.isFromCrossClientAuth();
                    zzas();
                    AppMethodBeat.o(60723);
                    return;
                }
                String valueOf = String.valueOf(connectionResult2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                zze(connectionResult2);
                AppMethodBeat.o(60723);
                return;
            } else if (zzd(connectionResult)) {
                zzau();
                zzas();
                AppMethodBeat.o(60723);
                return;
            } else {
                zze(connectionResult);
                AppMethodBeat.o(60723);
                return;
            }
        }
        AppMethodBeat.o(60723);
    }

    private final void zza(boolean z) {
        AppMethodBeat.i(60736);
        if (this.zzhn != null) {
            if (this.zzhn.isConnected() && z) {
                this.zzhn.clearAccountFromSessionStore();
            }
            this.zzhn.disconnect();
            this.zzhr = null;
        }
        AppMethodBeat.o(60736);
    }

    @GuardedBy("mLock")
    private final boolean zzar() {
        AppMethodBeat.i(60722);
        this.zzhk--;
        if (this.zzhk > 0) {
            AppMethodBeat.o(60722);
            return false;
        } else if (this.zzhk < 0) {
            this.zzhf.zzfq.zzbb();
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zze(new ConnectionResult(8, null));
            AppMethodBeat.o(60722);
            return false;
        } else if (this.zzgt != null) {
            this.zzhf.zzje = this.zzhi;
            zze(this.zzgt);
            AppMethodBeat.o(60722);
            return false;
        } else {
            AppMethodBeat.o(60722);
            return true;
        }
    }

    @GuardedBy("mLock")
    private final void zzas() {
        AppMethodBeat.i(60724);
        if (this.zzhk != 0) {
            AppMethodBeat.o(60724);
            return;
        }
        if (!this.zzhp || this.zzhq) {
            ArrayList arrayList = new ArrayList();
            this.zzhj = 1;
            this.zzhk = this.zzhf.zzil.size();
            for (AnyClientKey anyClientKey : this.zzhf.zzil.keySet()) {
                if (!this.zzhf.zzjb.containsKey(anyClientKey)) {
                    arrayList.add((Client) this.zzhf.zzil.get(anyClientKey));
                } else if (zzar()) {
                    zzat();
                }
            }
            if (!arrayList.isEmpty()) {
                this.zzhu.add(zzbg.zzbe().submit(new zzap(this, arrayList)));
            }
        }
        AppMethodBeat.o(60724);
    }

    @GuardedBy("mLock")
    private final void zzat() {
        AppMethodBeat.i(60727);
        this.zzhf.zzbd();
        zzbg.zzbe().execute(new zzak(this));
        if (this.zzhn != null) {
            if (this.zzhs) {
                this.zzhn.saveDefaultAccount(this.zzhr, this.zzht);
            }
            zza(false);
        }
        for (AnyClientKey anyClientKey : this.zzhf.zzjb.keySet()) {
            ((Client) this.zzhf.zzil.get(anyClientKey)).disconnect();
        }
        this.zzhf.zzjf.zzb(this.zzhl.isEmpty() ? null : this.zzhl);
        AppMethodBeat.o(60727);
    }

    @GuardedBy("mLock")
    private final void zzau() {
        AppMethodBeat.i(60733);
        this.zzhp = false;
        this.zzhf.zzfq.zzim = Collections.emptySet();
        for (AnyClientKey anyClientKey : this.zzhm) {
            if (!this.zzhf.zzjb.containsKey(anyClientKey)) {
                this.zzhf.zzjb.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
        AppMethodBeat.o(60733);
    }

    private final void zzav() {
        AppMethodBeat.i(60737);
        ArrayList arrayList = this.zzhu;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.zzhu.clear();
        AppMethodBeat.o(60737);
    }

    private final Set<Scope> zzaw() {
        AppMethodBeat.i(60738);
        if (this.zzgf == null) {
            Set emptySet = Collections.emptySet();
            AppMethodBeat.o(60738);
            return emptySet;
        }
        HashSet hashSet = new HashSet(this.zzgf.getRequiredScopes());
        Map optionalApiSettings = this.zzgf.getOptionalApiSettings();
        for (Api api : optionalApiSettings.keySet()) {
            if (!this.zzhf.zzjb.containsKey(api.getClientKey())) {
                hashSet.addAll(((OptionalApiSettings) optionalApiSettings.get(api)).mScopes);
            }
        }
        AppMethodBeat.o(60738);
        return hashSet;
    }

    /* JADX WARNING: Missing block: B:5:0x0019, code skipped:
            if (r2 != null) goto L_0x001b;
     */
    /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            if (r3 >= r6.zzhi) goto L_0x0048;
     */
    /* JADX WARNING: Missing block: B:18:0x0048, code skipped:
            r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @GuardedBy("mLock")
    private final void zzb(ConnectionResult connectionResult, Api<?> api, boolean z) {
        Object obj = 1;
        AppMethodBeat.i(60732);
        int priority = api.zzj().getPriority();
        if (z) {
            Object obj2;
            if (connectionResult.hasResolution()) {
                obj2 = 1;
            } else if (this.zzgk.getErrorResolutionIntent(connectionResult.getErrorCode()) != null) {
                int obj22 = 1;
            } else {
                obj22 = null;
            }
        }
        if (this.zzgt != null) {
        }
        if (obj != null) {
            this.zzgt = connectionResult;
            this.zzhi = priority;
        }
        this.zzhf.zzjb.put(api.getClientKey(), connectionResult);
        AppMethodBeat.o(60732);
    }

    static /* synthetic */ boolean zzb(zzaj zzaj, ConnectionResult connectionResult) {
        AppMethodBeat.i(60742);
        boolean zzd = zzaj.zzd(connectionResult);
        AppMethodBeat.o(60742);
        return zzd;
    }

    @GuardedBy("mLock")
    private final boolean zzd(ConnectionResult connectionResult) {
        AppMethodBeat.i(60734);
        if (!this.zzho || connectionResult.hasResolution()) {
            AppMethodBeat.o(60734);
            return false;
        }
        AppMethodBeat.o(60734);
        return true;
    }

    @GuardedBy("mLock")
    private final void zze(ConnectionResult connectionResult) {
        AppMethodBeat.i(60735);
        zzav();
        zza(!connectionResult.hasResolution());
        this.zzhf.zzf(connectionResult);
        this.zzhf.zzjf.zzc(connectionResult);
        AppMethodBeat.o(60735);
    }

    @GuardedBy("mLock")
    private final boolean zze(int i) {
        AppMethodBeat.i(60739);
        if (this.zzhj != i) {
            this.zzhf.zzfq.zzbb();
            String valueOf = String.valueOf(this);
            new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf);
            new StringBuilder(33).append("mRemainingConnections=").append(this.zzhk);
            String zzf = zzf(this.zzhj);
            String zzf2 = zzf(i);
            Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(zzf).length() + 70) + String.valueOf(zzf2).length()).append("GoogleApiClient connecting is in step ").append(zzf).append(" but received callback for step ").append(zzf2).toString(), new Exception());
            zze(new ConnectionResult(8, null));
            AppMethodBeat.o(60739);
            return false;
        }
        AppMethodBeat.o(60739);
        return true;
    }

    private static String zzf(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    static /* synthetic */ Set zzg(zzaj zzaj) {
        AppMethodBeat.i(60741);
        Set zzaw = zzaj.zzaw();
        AppMethodBeat.o(60741);
        return zzaw;
    }

    static /* synthetic */ void zzi(zzaj zzaj) {
        AppMethodBeat.i(60743);
        zzaj.zzau();
        AppMethodBeat.o(60743);
    }

    static /* synthetic */ void zzj(zzaj zzaj) {
        AppMethodBeat.i(60744);
        zzaj.zzas();
        AppMethodBeat.o(60744);
    }

    static /* synthetic */ boolean zzk(zzaj zzaj) {
        AppMethodBeat.i(60747);
        boolean zzar = zzaj.zzar();
        AppMethodBeat.o(60747);
        return zzar;
    }

    public final void begin() {
        AppMethodBeat.i(60721);
        this.zzhf.zzjb.clear();
        this.zzhp = false;
        this.zzgt = null;
        this.zzhj = 0;
        this.zzho = true;
        this.zzhq = false;
        this.zzhs = false;
        HashMap hashMap = new HashMap();
        int i = 0;
        for (Api api : this.zzgi.keySet()) {
            Client client = (Client) this.zzhf.zzil.get(api.getClientKey());
            int i2 = (api.zzj().getPriority() == 1 ? 1 : 0) | i;
            boolean booleanValue = ((Boolean) this.zzgi.get(api)).booleanValue();
            if (client.requiresSignIn()) {
                this.zzhp = true;
                if (booleanValue) {
                    this.zzhm.add(api.getClientKey());
                } else {
                    this.zzho = false;
                }
            }
            hashMap.put(client, new zzal(this, api, booleanValue));
            i = i2;
        }
        if (i != 0) {
            this.zzhp = false;
        }
        if (this.zzhp) {
            this.zzgf.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zzhf.zzfq)));
            zzas zzas = new zzas(this, null);
            this.zzhn = (SignInClient) this.zzdh.buildClient(this.mContext, this.zzhf.zzfq.getLooper(), this.zzgf, this.zzgf.getSignInOptions(), zzas, zzas);
        }
        this.zzhk = this.zzhf.zzil.size();
        this.zzhu.add(zzbg.zzbe().submit(new zzam(this, hashMap)));
        AppMethodBeat.o(60721);
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        AppMethodBeat.i(60730);
        zzav();
        zza(true);
        this.zzhf.zzf(null);
        AppMethodBeat.o(60730);
        return true;
    }

    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.i(60728);
        this.zzhf.zzfq.zzgo.add(t);
        AppMethodBeat.o(60728);
        return t;
    }

    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.i(60729);
        IllegalStateException illegalStateException = new IllegalStateException("GoogleApiClient is not connected yet.");
        AppMethodBeat.o(60729);
        throw illegalStateException;
    }

    @GuardedBy("mLock")
    public final void onConnected(Bundle bundle) {
        AppMethodBeat.i(60725);
        if (zze(1)) {
            if (bundle != null) {
                this.zzhl.putAll(bundle);
            }
            if (zzar()) {
                zzat();
            }
            AppMethodBeat.o(60725);
            return;
        }
        AppMethodBeat.o(60725);
    }

    @GuardedBy("mLock")
    public final void onConnectionSuspended(int i) {
        AppMethodBeat.i(60731);
        zze(new ConnectionResult(8, null));
        AppMethodBeat.o(60731);
    }

    @GuardedBy("mLock")
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        AppMethodBeat.i(60726);
        if (zze(1)) {
            zzb(connectionResult, api, z);
            if (zzar()) {
                zzat();
            }
            AppMethodBeat.o(60726);
            return;
        }
        AppMethodBeat.o(60726);
    }
}
