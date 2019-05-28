package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.p057v4.p065f.C0402b;
import android.support.p057v4.p065f.C6197a;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public class GoogleApiManager implements Callback {
    private static final Object lock = new Object();
    public static final Status zzjj = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zzjk = new Status(4, "The user must be signed in to make this API call.");
    @GuardedBy("lock")
    private static GoogleApiManager zzjo;
    private final Handler handler;
    private long zzjl = 5000;
    private long zzjm = 120000;
    private long zzjn = 10000;
    private final Context zzjp;
    private final GoogleApiAvailability zzjq;
    private final GoogleApiAvailabilityCache zzjr;
    private final AtomicInteger zzjs = new AtomicInteger(1);
    private final AtomicInteger zzjt = new AtomicInteger(0);
    private final Map<zzh<?>, zza<?>> zzju = new ConcurrentHashMap(5, 0.75f, 1);
    @GuardedBy("lock")
    private zzad zzjv = null;
    @GuardedBy("lock")
    private final Set<zzh<?>> zzjw = new C0402b();
    private final Set<zzh<?>> zzjx = new C0402b();

    static class zzb {
        private final Feature zzdr;
        private final zzh<?> zzkn;

        private zzb(zzh<?> zzh, Feature feature) {
            this.zzkn = zzh;
            this.zzdr = feature;
        }

        /* synthetic */ zzb(zzh zzh, Feature feature, zzbh zzbh) {
            this(zzh, feature);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(60606);
            if (obj == null || !(obj instanceof zzb)) {
                AppMethodBeat.m2505o(60606);
                return false;
            }
            zzb zzb = (zzb) obj;
            if (Objects.equal(this.zzkn, zzb.zzkn) && Objects.equal(this.zzdr, zzb.zzdr)) {
                AppMethodBeat.m2505o(60606);
                return true;
            }
            AppMethodBeat.m2505o(60606);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(60607);
            int hashCode = Objects.hashCode(this.zzkn, this.zzdr);
            AppMethodBeat.m2505o(60607);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(60608);
            String toStringHelper = Objects.toStringHelper(this).add("key", this.zzkn).add("feature", this.zzdr).toString();
            AppMethodBeat.m2505o(60608);
            return toStringHelper;
        }
    }

    class zzc implements zzcb, ConnectionProgressReportCallbacks {
        private final zzh<?> zzhc;
        private final Client zzka;
        private IAccountAccessor zzko = null;
        private Set<Scope> zzkp = null;
        private boolean zzkq = false;

        public zzc(Client client, zzh<?> zzh) {
            this.zzka = client;
            this.zzhc = zzh;
        }

        static /* synthetic */ void zzb(zzc zzc) {
            AppMethodBeat.m2504i(60613);
            zzc.zzbu();
            AppMethodBeat.m2505o(60613);
        }

        private final void zzbu() {
            AppMethodBeat.m2504i(60612);
            if (this.zzkq && this.zzko != null) {
                this.zzka.getRemoteService(this.zzko, this.zzkp);
            }
            AppMethodBeat.m2505o(60612);
        }

        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            AppMethodBeat.m2504i(60609);
            GoogleApiManager.this.handler.post(new zzbn(this, connectionResult));
            AppMethodBeat.m2505o(60609);
        }

        public final void zza(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            AppMethodBeat.m2504i(60611);
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                zzg(new ConnectionResult(4));
                AppMethodBeat.m2505o(60611);
                return;
            }
            this.zzko = iAccountAccessor;
            this.zzkp = set;
            zzbu();
            AppMethodBeat.m2505o(60611);
        }

        public final void zzg(ConnectionResult connectionResult) {
            AppMethodBeat.m2504i(60610);
            ((zza) GoogleApiManager.this.zzju.get(this.zzhc)).zzg(connectionResult);
            AppMethodBeat.m2505o(60610);
        }
    }

    public class zza<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener, zzq {
        private final zzh<O> zzhc;
        private final Queue<zzb> zzjz = new LinkedList();
        private final Client zzka;
        private final AnyClient zzkb;
        private final zzaa zzkc;
        private final Set<zzj> zzkd = new HashSet();
        private final Map<ListenerKey<?>, zzbv> zzke = new HashMap();
        private final int zzkf;
        private final zzby zzkg;
        private boolean zzkh;
        private final List<zzb> zzki = new ArrayList();
        private ConnectionResult zzkj = null;

        public zza(GoogleApi<O> googleApi) {
            AppMethodBeat.m2504i(60570);
            this.zzka = googleApi.zza(GoogleApiManager.this.handler.getLooper(), this);
            if (this.zzka instanceof SimpleClientAdapter) {
                this.zzkb = ((SimpleClientAdapter) this.zzka).getClient();
            } else {
                this.zzkb = this.zzka;
            }
            this.zzhc = googleApi.zzm();
            this.zzkc = new zzaa();
            this.zzkf = googleApi.getInstanceId();
            if (this.zzka.requiresSignIn()) {
                this.zzkg = googleApi.zza(GoogleApiManager.this.zzjp, GoogleApiManager.this.handler);
                AppMethodBeat.m2505o(60570);
                return;
            }
            this.zzkg = null;
            AppMethodBeat.m2505o(60570);
        }

        private final void zza(zzb zzb) {
            AppMethodBeat.m2504i(60599);
            if (this.zzki.contains(zzb)) {
                if (!this.zzkh) {
                    if (this.zzka.isConnected()) {
                        zzbl();
                    } else {
                        connect();
                        AppMethodBeat.m2505o(60599);
                        return;
                    }
                }
                AppMethodBeat.m2505o(60599);
                return;
            }
            AppMethodBeat.m2505o(60599);
        }

        static /* synthetic */ void zzb(zza zza, zzb zzb) {
            AppMethodBeat.m2504i(60603);
            zza.zzb(zzb);
            AppMethodBeat.m2505o(60603);
        }

        private final void zzb(zzb zzb) {
            AppMethodBeat.m2504i(60600);
            if (this.zzki.remove(zzb)) {
                GoogleApiManager.this.handler.removeMessages(15, zzb);
                GoogleApiManager.this.handler.removeMessages(16, zzb);
                Object zzd = zzb.zzdr;
                ArrayList arrayList = new ArrayList(this.zzjz.size());
                for (zzb zzb2 : this.zzjz) {
                    if (zzb2 instanceof zzf) {
                        Object[] requiredFeatures = ((zzf) zzb2).getRequiredFeatures();
                        if (requiredFeatures != null && ArrayUtils.contains(requiredFeatures, zzd)) {
                            arrayList.add(zzb2);
                        }
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzb zzb3 = (zzb) obj;
                    this.zzjz.remove(zzb3);
                    zzb3.zza(new UnsupportedApiCallException(zzd));
                }
            }
            AppMethodBeat.m2505o(60600);
        }

        private final boolean zzb(zzb zzb) {
            AppMethodBeat.m2504i(60584);
            if (zzb instanceof zzf) {
                zzf zzf = (zzf) zzb;
                Feature[] requiredFeatures = zzf.getRequiredFeatures();
                if (requiredFeatures == null || requiredFeatures.length == 0) {
                    zzc(zzb);
                    AppMethodBeat.m2505o(60584);
                    return true;
                }
                Feature[] availableFeatures = this.zzka.getAvailableFeatures();
                if (availableFeatures == null) {
                    availableFeatures = new Feature[0];
                }
                C6197a c6197a = new C6197a(availableFeatures.length);
                for (Feature feature : availableFeatures) {
                    c6197a.put(feature.getName(), Long.valueOf(feature.getVersion()));
                }
                for (Feature feature2 : requiredFeatures) {
                    if (!c6197a.containsKey(feature2.getName()) || ((Long) c6197a.get(feature2.getName())).longValue() < feature2.getVersion()) {
                        if (zzf.shouldAutoResolveMissingFeatures()) {
                            zzb zzb2 = new zzb(this.zzhc, feature2, null);
                            int indexOf = this.zzki.indexOf(zzb2);
                            if (indexOf >= 0) {
                                zzb2 = (zzb) this.zzki.get(indexOf);
                                GoogleApiManager.this.handler.removeMessages(15, zzb2);
                                GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 15, zzb2), GoogleApiManager.this.zzjl);
                            } else {
                                this.zzki.add(zzb2);
                                GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 15, zzb2), GoogleApiManager.this.zzjl);
                                GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 16, zzb2), GoogleApiManager.this.zzjm);
                                ConnectionResult connectionResult = new ConnectionResult(2, null);
                                if (!zzh(connectionResult)) {
                                    GoogleApiManager.this.zzc(connectionResult, this.zzkf);
                                }
                            }
                        } else {
                            zzf.zza(new UnsupportedApiCallException(feature2));
                        }
                        AppMethodBeat.m2505o(60584);
                        return false;
                    }
                    this.zzki.remove(new zzb(this.zzhc, feature2, null));
                }
                zzc(zzb);
                AppMethodBeat.m2505o(60584);
                return true;
            }
            zzc(zzb);
            AppMethodBeat.m2505o(60584);
            return true;
        }

        private final boolean zzb(boolean z) {
            AppMethodBeat.m2504i(60592);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zzka.isConnected() || this.zzke.size() != 0) {
                AppMethodBeat.m2505o(60592);
                return false;
            } else if (this.zzkc.zzaj()) {
                if (z) {
                    zzbr();
                }
                AppMethodBeat.m2505o(60592);
                return false;
            } else {
                this.zzka.disconnect();
                AppMethodBeat.m2505o(60592);
                return true;
            }
        }

        private final void zzbj() {
            AppMethodBeat.m2504i(60572);
            zzbo();
            zzi(ConnectionResult.RESULT_SUCCESS);
            zzbq();
            for (zzbv zzbv : this.zzke.values()) {
                try {
                    zzbv.zzlt.registerListener(this.zzkb, new TaskCompletionSource());
                } catch (DeadObjectException e) {
                    onConnectionSuspended(1);
                    this.zzka.disconnect();
                } catch (RemoteException e2) {
                }
            }
            zzbl();
            zzbr();
            AppMethodBeat.m2505o(60572);
        }

        private final void zzbk() {
            AppMethodBeat.m2504i(60574);
            zzbo();
            this.zzkh = true;
            this.zzkc.zzal();
            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 9, this.zzhc), GoogleApiManager.this.zzjl);
            GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 11, this.zzhc), GoogleApiManager.this.zzjm);
            GoogleApiManager.this.zzjr.flush();
            AppMethodBeat.m2505o(60574);
        }

        private final void zzbl() {
            AppMethodBeat.m2504i(60579);
            ArrayList arrayList = new ArrayList(this.zzjz);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zzb zzb = (zzb) obj;
                if (!this.zzka.isConnected()) {
                    break;
                } else if (zzb(zzb)) {
                    this.zzjz.remove(zzb);
                }
            }
            AppMethodBeat.m2505o(60579);
        }

        private final void zzbq() {
            AppMethodBeat.m2504i(60588);
            if (this.zzkh) {
                GoogleApiManager.this.handler.removeMessages(11, this.zzhc);
                GoogleApiManager.this.handler.removeMessages(9, this.zzhc);
                this.zzkh = false;
            }
            AppMethodBeat.m2505o(60588);
        }

        private final void zzbr() {
            AppMethodBeat.m2504i(60590);
            GoogleApiManager.this.handler.removeMessages(12, this.zzhc);
            GoogleApiManager.this.handler.sendMessageDelayed(GoogleApiManager.this.handler.obtainMessage(12, this.zzhc), GoogleApiManager.this.zzjn);
            AppMethodBeat.m2505o(60590);
        }

        private final void zzc(zzb zzb) {
            AppMethodBeat.m2504i(60585);
            zzb.zza(this.zzkc, requiresSignIn());
            try {
                zzb.zza(this);
                AppMethodBeat.m2505o(60585);
            } catch (DeadObjectException e) {
                onConnectionSuspended(1);
                this.zzka.disconnect();
                AppMethodBeat.m2505o(60585);
            }
        }

        static /* synthetic */ void zzd(zza zza) {
            AppMethodBeat.m2504i(60605);
            zza.zzbk();
            AppMethodBeat.m2505o(60605);
        }

        private final boolean zzh(ConnectionResult connectionResult) {
            boolean z;
            AppMethodBeat.m2504i(60576);
            synchronized (GoogleApiManager.lock) {
                try {
                    if (GoogleApiManager.this.zzjv == null || !GoogleApiManager.this.zzjw.contains(this.zzhc)) {
                        z = false;
                        AppMethodBeat.m2505o(60576);
                    } else {
                        GoogleApiManager.this.zzjv.zzb(connectionResult, this.zzkf);
                        z = true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(60576);
                }
            }
            return z;
        }

        private final void zzi(ConnectionResult connectionResult) {
            AppMethodBeat.m2504i(60595);
            for (zzj zzj : this.zzkd) {
                String str = null;
                if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.zzka.getEndpointPackageName();
                }
                zzj.zza(this.zzhc, connectionResult, str);
            }
            this.zzkd.clear();
            AppMethodBeat.m2505o(60595);
        }

        public final void connect() {
            AppMethodBeat.m2504i(60593);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zzka.isConnected() || this.zzka.isConnecting()) {
                AppMethodBeat.m2505o(60593);
                return;
            }
            int clientAvailability = GoogleApiManager.this.zzjr.getClientAvailability(GoogleApiManager.this.zzjp, this.zzka);
            if (clientAvailability != 0) {
                onConnectionFailed(new ConnectionResult(clientAvailability, null));
                AppMethodBeat.m2505o(60593);
                return;
            }
            zzcb zzc = new zzc(this.zzka, this.zzhc);
            if (this.zzka.requiresSignIn()) {
                this.zzkg.zza(zzc);
            }
            this.zzka.connect(zzc);
            AppMethodBeat.m2505o(60593);
        }

        public final int getInstanceId() {
            return this.zzkf;
        }

        /* Access modifiers changed, original: final */
        public final boolean isConnected() {
            AppMethodBeat.m2504i(60596);
            boolean isConnected = this.zzka.isConnected();
            AppMethodBeat.m2505o(60596);
            return isConnected;
        }

        public final void onConnected(Bundle bundle) {
            AppMethodBeat.m2504i(60571);
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                zzbj();
                AppMethodBeat.m2505o(60571);
                return;
            }
            GoogleApiManager.this.handler.post(new zzbi(this));
            AppMethodBeat.m2505o(60571);
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            AppMethodBeat.m2504i(60578);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zzkg != null) {
                this.zzkg.zzbz();
            }
            zzbo();
            GoogleApiManager.this.zzjr.flush();
            zzi(connectionResult);
            if (connectionResult.getErrorCode() == 4) {
                zzc(GoogleApiManager.zzjk);
                AppMethodBeat.m2505o(60578);
            } else if (this.zzjz.isEmpty()) {
                this.zzkj = connectionResult;
                AppMethodBeat.m2505o(60578);
            } else if (zzh(connectionResult)) {
                AppMethodBeat.m2505o(60578);
            } else {
                if (!GoogleApiManager.this.zzc(connectionResult, this.zzkf)) {
                    if (connectionResult.getErrorCode() == 18) {
                        this.zzkh = true;
                    }
                    if (this.zzkh) {
                        GoogleApiManager.this.handler.sendMessageDelayed(Message.obtain(GoogleApiManager.this.handler, 9, this.zzhc), GoogleApiManager.this.zzjl);
                        AppMethodBeat.m2505o(60578);
                        return;
                    }
                    String zzq = this.zzhc.zzq();
                    zzc(new Status(17, new StringBuilder(String.valueOf(zzq).length() + 38).append("API: ").append(zzq).append(" is not available on this device.").toString()));
                }
                AppMethodBeat.m2505o(60578);
            }
        }

        public final void onConnectionSuspended(int i) {
            AppMethodBeat.m2504i(60573);
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                zzbk();
                AppMethodBeat.m2505o(60573);
                return;
            }
            GoogleApiManager.this.handler.post(new zzbj(this));
            AppMethodBeat.m2505o(60573);
        }

        public final boolean requiresSignIn() {
            AppMethodBeat.m2504i(60597);
            boolean requiresSignIn = this.zzka.requiresSignIn();
            AppMethodBeat.m2505o(60597);
            return requiresSignIn;
        }

        public final void resume() {
            AppMethodBeat.m2504i(60587);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zzkh) {
                connect();
            }
            AppMethodBeat.m2505o(60587);
        }

        public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
            AppMethodBeat.m2504i(60577);
            if (Looper.myLooper() == GoogleApiManager.this.handler.getLooper()) {
                onConnectionFailed(connectionResult);
                AppMethodBeat.m2505o(60577);
                return;
            }
            GoogleApiManager.this.handler.post(new zzbk(this, connectionResult));
            AppMethodBeat.m2505o(60577);
        }

        public final void zza(zzb zzb) {
            AppMethodBeat.m2504i(60580);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (!this.zzka.isConnected()) {
                this.zzjz.add(zzb);
                if (this.zzkj == null || !this.zzkj.hasResolution()) {
                    connect();
                    AppMethodBeat.m2505o(60580);
                    return;
                }
                onConnectionFailed(this.zzkj);
                AppMethodBeat.m2505o(60580);
            } else if (zzb(zzb)) {
                zzbr();
                AppMethodBeat.m2505o(60580);
            } else {
                this.zzjz.add(zzb);
                AppMethodBeat.m2505o(60580);
            }
        }

        public final void zza(zzj zzj) {
            AppMethodBeat.m2504i(60594);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zzkd.add(zzj);
            AppMethodBeat.m2505o(60594);
        }

        public final Client zzae() {
            return this.zzka;
        }

        public final void zzay() {
            AppMethodBeat.m2504i(60589);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            if (this.zzkh) {
                zzbq();
                zzc(GoogleApiManager.this.zzjq.isGooglePlayServicesAvailable(GoogleApiManager.this.zzjp) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.zzka.disconnect();
            }
            AppMethodBeat.m2505o(60589);
        }

        public final void zzbm() {
            AppMethodBeat.m2504i(60581);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            zzc(GoogleApiManager.zzjj);
            this.zzkc.zzak();
            for (ListenerKey zzg : (ListenerKey[]) this.zzke.keySet().toArray(new ListenerKey[this.zzke.size()])) {
                zza(new zzg(zzg, new TaskCompletionSource()));
            }
            zzi(new ConnectionResult(4));
            if (this.zzka.isConnected()) {
                this.zzka.onUserSignOut(new zzbl(this));
            }
            AppMethodBeat.m2505o(60581);
        }

        public final Map<ListenerKey<?>, zzbv> zzbn() {
            return this.zzke;
        }

        public final void zzbo() {
            AppMethodBeat.m2504i(60582);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zzkj = null;
            AppMethodBeat.m2505o(60582);
        }

        public final ConnectionResult zzbp() {
            AppMethodBeat.m2504i(60583);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            ConnectionResult connectionResult = this.zzkj;
            AppMethodBeat.m2505o(60583);
            return connectionResult;
        }

        public final boolean zzbs() {
            AppMethodBeat.m2504i(60591);
            boolean zzb = zzb(true);
            AppMethodBeat.m2505o(60591);
            return zzb;
        }

        /* Access modifiers changed, original: final */
        public final SignInClient zzbt() {
            AppMethodBeat.m2504i(60598);
            if (this.zzkg == null) {
                AppMethodBeat.m2505o(60598);
                return null;
            }
            SignInClient zzbt = this.zzkg.zzbt();
            AppMethodBeat.m2505o(60598);
            return zzbt;
        }

        public final void zzc(Status status) {
            AppMethodBeat.m2504i(60586);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            for (zzb zza : this.zzjz) {
                zza.zza(status);
            }
            this.zzjz.clear();
            AppMethodBeat.m2505o(60586);
        }

        public final void zzg(ConnectionResult connectionResult) {
            AppMethodBeat.m2504i(60575);
            Preconditions.checkHandlerThread(GoogleApiManager.this.handler);
            this.zzka.disconnect();
            onConnectionFailed(connectionResult);
            AppMethodBeat.m2505o(60575);
        }
    }

    static {
        AppMethodBeat.m2504i(60635);
        AppMethodBeat.m2505o(60635);
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        AppMethodBeat.m2504i(60617);
        this.zzjp = context;
        this.handler = new Handler(looper, this);
        this.zzjq = googleApiAvailability;
        this.zzjr = new GoogleApiAvailabilityCache(googleApiAvailability);
        this.handler.sendMessage(this.handler.obtainMessage(6));
        AppMethodBeat.m2505o(60617);
    }

    @KeepForSdk
    public static void reportSignOut() {
        AppMethodBeat.m2504i(60616);
        synchronized (lock) {
            try {
                if (zzjo != null) {
                    GoogleApiManager googleApiManager = zzjo;
                    googleApiManager.zzjt.incrementAndGet();
                    googleApiManager.handler.sendMessageAtFrontOfQueue(googleApiManager.handler.obtainMessage(10));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(60616);
            }
        }
    }

    public static GoogleApiManager zzb(Context context) {
        GoogleApiManager googleApiManager;
        AppMethodBeat.m2504i(60614);
        synchronized (lock) {
            try {
                if (zzjo == null) {
                    HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                    handlerThread.start();
                    zzjo = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
                }
                googleApiManager = zzjo;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(60614);
            }
        }
        return googleApiManager;
    }

    private final void zzb(GoogleApi<?> googleApi) {
        AppMethodBeat.m2504i(60620);
        zzh zzm = googleApi.zzm();
        zza zza = (zza) this.zzju.get(zzm);
        if (zza == null) {
            zza = new zza(googleApi);
            this.zzju.put(zzm, zza);
        }
        if (zza.requiresSignIn()) {
            this.zzjx.add(zzm);
        }
        zza.connect();
        AppMethodBeat.m2505o(60620);
    }

    public static GoogleApiManager zzbf() {
        GoogleApiManager googleApiManager;
        AppMethodBeat.m2504i(60615);
        synchronized (lock) {
            try {
                Preconditions.checkNotNull(zzjo, "Must guarantee manager is non-null before using getInstance");
                googleApiManager = zzjo;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(60615);
            }
        }
        return googleApiManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(Message message) {
        AppMethodBeat.m2504i(60631);
        zzh zzm;
        zza zza;
        zzb zzb;
        switch (message.what) {
            case 1:
                this.zzjn = ((Boolean) message.obj).booleanValue() ? 10000 : 300000;
                this.handler.removeMessages(12);
                for (zzh obtainMessage : this.zzju.keySet()) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(12, obtainMessage), this.zzjn);
                }
                break;
            case 2:
                zzj zzj = (zzj) message.obj;
                for (zzh zzm2 : zzj.zzs()) {
                    zza zza2 = (zza) this.zzju.get(zzm2);
                    if (zza2 == null) {
                        zzj.zza(zzm2, new ConnectionResult(13), null);
                        break;
                    } else if (zza2.isConnected()) {
                        zzj.zza(zzm2, ConnectionResult.RESULT_SUCCESS, zza2.zzae().getEndpointPackageName());
                    } else if (zza2.zzbp() != null) {
                        zzj.zza(zzm2, zza2.zzbp(), null);
                    } else {
                        zza2.zza(zzj);
                    }
                }
                break;
            case 3:
                for (zza zza3 : this.zzju.values()) {
                    zza3.zzbo();
                    zza3.connect();
                }
                break;
            case 4:
            case 8:
            case 13:
                zzbu zzbu = (zzbu) message.obj;
                zza = (zza) this.zzju.get(zzbu.zzlr.zzm());
                if (zza == null) {
                    zzb(zzbu.zzlr);
                    zza = (zza) this.zzju.get(zzbu.zzlr.zzm());
                }
                if (zza.requiresSignIn() && this.zzjt.get() != zzbu.zzlq) {
                    zzbu.zzlp.zza(zzjj);
                    zza.zzbm();
                    break;
                }
                zza.zza(zzbu.zzlp);
                break;
                break;
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (zza zza4 : this.zzju.values()) {
                    if (zza4.getInstanceId() == i) {
                        if (zza4 != null) {
                            Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
                            break;
                        }
                        String errorString = this.zzjq.getErrorString(connectionResult.getErrorCode());
                        String errorMessage = connectionResult.getErrorMessage();
                        zza4.zzc(new Status(17, new StringBuilder((String.valueOf(errorString).length() + 69) + String.valueOf(errorMessage).length()).append("Error resolution was canceled by the user, original error message: ").append(errorString).append(": ").append(errorMessage).toString()));
                        break;
                    }
                }
                zza4 = null;
                if (zza4 != null) {
                }
            case 6:
                if (PlatformVersion.isAtLeastIceCreamSandwich() && (this.zzjp.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.initialize((Application) this.zzjp.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zzbh(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zzjn = 300000;
                        break;
                    }
                }
                break;
            case 7:
                zzb((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zzju.containsKey(message.obj)) {
                    ((zza) this.zzju.get(message.obj)).resume();
                    break;
                }
                break;
            case 10:
                for (zzh obtainMessage2 : this.zzjx) {
                    ((zza) this.zzju.remove(obtainMessage2)).zzbm();
                }
                this.zzjx.clear();
                break;
            case 11:
                if (this.zzju.containsKey(message.obj)) {
                    ((zza) this.zzju.get(message.obj)).zzay();
                    break;
                }
                break;
            case 12:
                if (this.zzju.containsKey(message.obj)) {
                    ((zza) this.zzju.get(message.obj)).zzbs();
                    break;
                }
                break;
            case 14:
                zzae zzae = (zzae) message.obj;
                zzm2 = zzae.zzm();
                if (!this.zzju.containsKey(zzm2)) {
                    zzae.zzao().setResult(Boolean.FALSE);
                    break;
                }
                zzae.zzao().setResult(Boolean.valueOf(zza.zza((zza) this.zzju.get(zzm2), false)));
                break;
            case 15:
                zzb = (zzb) message.obj;
                if (this.zzju.containsKey(zzb.zzkn)) {
                    zza.zza((zza) this.zzju.get(zzb.zzkn), zzb);
                    break;
                }
                break;
            case 16:
                zzb = (zzb) message.obj;
                if (this.zzju.containsKey(zzb.zzkn)) {
                    zza.zzb((zza) this.zzju.get(zzb.zzkn), zzb);
                    break;
                }
                break;
            default:
                new StringBuilder(31).append("Unknown message id: ").append(message.what);
                AppMethodBeat.m2505o(60631);
                return false;
        }
        AppMethodBeat.m2505o(60631);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void maybeSignOut() {
        AppMethodBeat.m2504i(60625);
        this.zzjt.incrementAndGet();
        this.handler.sendMessage(this.handler.obtainMessage(10));
        AppMethodBeat.m2505o(60625);
    }

    /* Access modifiers changed, original: final */
    public final PendingIntent zza(zzh<?> zzh, int i) {
        AppMethodBeat.m2504i(60632);
        zza zza = (zza) this.zzju.get(zzh);
        if (zza == null) {
            AppMethodBeat.m2505o(60632);
            return null;
        }
        SignInClient zzbt = zza.zzbt();
        if (zzbt == null) {
            AppMethodBeat.m2505o(60632);
            return null;
        }
        PendingIntent activity = PendingIntent.getActivity(this.zzjp, i, zzbt.getSignInIntent(), 134217728);
        AppMethodBeat.m2505o(60632);
        return activity;
    }

    public final <O extends ApiOptions> Task<Boolean> zza(GoogleApi<O> googleApi, ListenerKey<?> listenerKey) {
        AppMethodBeat.m2504i(60630);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.handler.sendMessage(this.handler.obtainMessage(13, new zzbu(new zzg(listenerKey, taskCompletionSource), this.zzjt.get(), googleApi)));
        Task task = taskCompletionSource.getTask();
        AppMethodBeat.m2505o(60630);
        return task;
    }

    public final <O extends ApiOptions> Task<Void> zza(GoogleApi<O> googleApi, RegisterListenerMethod<AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<AnyClient, ?> unregisterListenerMethod) {
        AppMethodBeat.m2504i(60629);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.handler.sendMessage(this.handler.obtainMessage(8, new zzbu(new zze(new zzbv(registerListenerMethod, unregisterListenerMethod), taskCompletionSource), this.zzjt.get(), googleApi)));
        Task task = taskCompletionSource.getTask();
        AppMethodBeat.m2505o(60629);
        return task;
    }

    public final Task<Map<zzh<?>, String>> zza(Iterable<? extends GoogleApi<?>> iterable) {
        AppMethodBeat.m2504i(60623);
        zzj zzj = new zzj(iterable);
        this.handler.sendMessage(this.handler.obtainMessage(2, zzj));
        Task task = zzj.getTask();
        AppMethodBeat.m2505o(60623);
        return task;
    }

    public final void zza(ConnectionResult connectionResult, int i) {
        AppMethodBeat.m2504i(60634);
        if (!zzc(connectionResult, i)) {
            this.handler.sendMessage(this.handler.obtainMessage(5, i, 0, connectionResult));
        }
        AppMethodBeat.m2505o(60634);
    }

    public final void zza(GoogleApi<?> googleApi) {
        AppMethodBeat.m2504i(60619);
        this.handler.sendMessage(this.handler.obtainMessage(7, googleApi));
        AppMethodBeat.m2505o(60619);
    }

    public final <O extends ApiOptions> void zza(GoogleApi<O> googleApi, int i, ApiMethodImpl<? extends Result, AnyClient> apiMethodImpl) {
        AppMethodBeat.m2504i(60627);
        this.handler.sendMessage(this.handler.obtainMessage(4, new zzbu(new zzd(i, apiMethodImpl), this.zzjt.get(), googleApi)));
        AppMethodBeat.m2505o(60627);
    }

    public final <O extends ApiOptions, ResultT> void zza(GoogleApi<O> googleApi, int i, TaskApiCall<AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        AppMethodBeat.m2504i(60628);
        this.handler.sendMessage(this.handler.obtainMessage(4, new zzbu(new zzf(i, taskApiCall, taskCompletionSource, statusExceptionMapper), this.zzjt.get(), googleApi)));
        AppMethodBeat.m2505o(60628);
    }

    public final void zza(zzad zzad) {
        AppMethodBeat.m2504i(60621);
        synchronized (lock) {
            try {
                if (this.zzjv != zzad) {
                    this.zzjv = zzad;
                    this.zzjw.clear();
                }
                this.zzjw.addAll(zzad.zzam());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(60621);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void zzb(zzad zzad) {
        AppMethodBeat.m2504i(60622);
        synchronized (lock) {
            try {
                if (this.zzjv == zzad) {
                    this.zzjv = null;
                    this.zzjw.clear();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(60622);
            }
        }
    }

    public final int zzbg() {
        AppMethodBeat.m2504i(60618);
        int andIncrement = this.zzjs.getAndIncrement();
        AppMethodBeat.m2505o(60618);
        return andIncrement;
    }

    public final Task<Boolean> zzc(GoogleApi<?> googleApi) {
        AppMethodBeat.m2504i(60626);
        zzae zzae = new zzae(googleApi.zzm());
        this.handler.sendMessage(this.handler.obtainMessage(14, zzae));
        Task task = zzae.zzao().getTask();
        AppMethodBeat.m2505o(60626);
        return task;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzc(ConnectionResult connectionResult, int i) {
        AppMethodBeat.m2504i(60633);
        boolean showWrappedErrorNotification = this.zzjq.showWrappedErrorNotification(this.zzjp, connectionResult, i);
        AppMethodBeat.m2505o(60633);
        return showWrappedErrorNotification;
    }

    public final void zzr() {
        AppMethodBeat.m2504i(60624);
        this.handler.sendMessage(this.handler.obtainMessage(3));
        AppMethodBeat.m2505o(60624);
    }
}
