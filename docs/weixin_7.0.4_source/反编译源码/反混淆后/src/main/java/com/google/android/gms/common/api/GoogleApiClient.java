package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.p065f.C6197a;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zzav;
import com.google.android.gms.common.api.internal.zzch;
import com.google.android.gms.common.api.internal.zzi;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignIn;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GoogleApiClient {
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    @GuardedBy("sAllClients")
    private static final Set<GoogleApiClient> zzcu = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    public static final class Builder {
        private final Context mContext;
        private Looper zzcn;
        private final Set<Scope> zzcv;
        private final Set<Scope> zzcw;
        private int zzcx;
        private View zzcy;
        private String zzcz;
        private String zzda;
        private final Map<Api<?>, OptionalApiSettings> zzdb;
        private final Map<Api<?>, ApiOptions> zzdc;
        private LifecycleActivity zzdd;
        private int zzde;
        private OnConnectionFailedListener zzdf;
        private GoogleApiAvailability zzdg;
        private AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
        private final ArrayList<ConnectionCallbacks> zzdi;
        private final ArrayList<OnConnectionFailedListener> zzdj;
        private boolean zzdk;
        private Account zzs;

        @KeepForSdk
        public Builder(Context context) {
            AppMethodBeat.m2504i(60534);
            this.zzcv = new HashSet();
            this.zzcw = new HashSet();
            this.zzdb = new C6197a();
            this.zzdc = new C6197a();
            this.zzde = -1;
            this.zzdg = GoogleApiAvailability.getInstance();
            this.zzdh = SignIn.CLIENT_BUILDER;
            this.zzdi = new ArrayList();
            this.zzdj = new ArrayList();
            this.zzdk = false;
            this.mContext = context;
            this.zzcn = context.getMainLooper();
            this.zzcz = context.getPackageName();
            this.zzda = context.getClass().getName();
            AppMethodBeat.m2505o(60534);
        }

        @KeepForSdk
        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            AppMethodBeat.m2504i(60535);
            Preconditions.checkNotNull(connectionCallbacks, "Must provide a connected listener");
            this.zzdi.add(connectionCallbacks);
            Preconditions.checkNotNull(onConnectionFailedListener, "Must provide a connection failed listener");
            this.zzdj.add(onConnectionFailedListener);
            AppMethodBeat.m2505o(60535);
        }

        private final <O extends ApiOptions> void zza(Api<O> api, O o, Scope... scopeArr) {
            AppMethodBeat.m2504i(60552);
            HashSet hashSet = new HashSet(api.zzj().getImpliedScopes(o));
            for (Object add : scopeArr) {
                hashSet.add(add);
            }
            this.zzdb.put(api, new OptionalApiSettings(hashSet));
            AppMethodBeat.m2505o(60552);
        }

        public final Builder addApi(Api<? extends NotRequiredOptions> api) {
            AppMethodBeat.m2504i(60542);
            Preconditions.checkNotNull(api, "Api must not be null");
            this.zzdc.put(api, null);
            List impliedScopes = api.zzj().getImpliedScopes(null);
            this.zzcw.addAll(impliedScopes);
            this.zzcv.addAll(impliedScopes);
            AppMethodBeat.m2505o(60542);
            return this;
        }

        public final <O extends HasOptions> Builder addApi(Api<O> api, O o) {
            AppMethodBeat.m2504i(60544);
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.zzdc.put(api, o);
            List impliedScopes = api.zzj().getImpliedScopes(o);
            this.zzcw.addAll(impliedScopes);
            this.zzcv.addAll(impliedScopes);
            AppMethodBeat.m2505o(60544);
            return this;
        }

        public final <O extends HasOptions> Builder addApiIfAvailable(Api<O> api, O o, Scope... scopeArr) {
            AppMethodBeat.m2504i(60545);
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o, "Null options are not permitted for this Api");
            this.zzdc.put(api, o);
            zza(api, o, scopeArr);
            AppMethodBeat.m2505o(60545);
            return this;
        }

        public final Builder addApiIfAvailable(Api<? extends NotRequiredOptions> api, Scope... scopeArr) {
            AppMethodBeat.m2504i(60543);
            Preconditions.checkNotNull(api, "Api must not be null");
            this.zzdc.put(api, null);
            zza(api, null, scopeArr);
            AppMethodBeat.m2505o(60543);
            return this;
        }

        public final Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            AppMethodBeat.m2504i(60537);
            Preconditions.checkNotNull(connectionCallbacks, "Listener must not be null");
            this.zzdi.add(connectionCallbacks);
            AppMethodBeat.m2505o(60537);
            return this;
        }

        public final Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            AppMethodBeat.m2504i(60538);
            Preconditions.checkNotNull(onConnectionFailedListener, "Listener must not be null");
            this.zzdj.add(onConnectionFailedListener);
            AppMethodBeat.m2505o(60538);
            return this;
        }

        public final Builder addScope(Scope scope) {
            AppMethodBeat.m2504i(60540);
            Preconditions.checkNotNull(scope, "Scope must not be null");
            this.zzcv.add(scope);
            AppMethodBeat.m2505o(60540);
            return this;
        }

        @KeepForSdk
        public final Builder addScopeNames(String[] strArr) {
            AppMethodBeat.m2504i(60541);
            for (String scope : strArr) {
                this.zzcv.add(new Scope(scope));
            }
            AppMethodBeat.m2505o(60541);
            return this;
        }

        public final GoogleApiClient build() {
            String name;
            IllegalStateException illegalStateException;
            AppMethodBeat.m2504i(60551);
            Preconditions.checkArgument(!this.zzdc.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings buildClientSettings = buildClientSettings();
            Api api = null;
            Map optionalApiSettings = buildClientSettings.getOptionalApiSettings();
            C6197a c6197a = new C6197a();
            C6197a c6197a2 = new C6197a();
            ArrayList arrayList = new ArrayList();
            Object obj = null;
            for (Api api2 : this.zzdc.keySet()) {
                Api api22;
                Object obj2 = this.zzdc.get(api22);
                boolean z = optionalApiSettings.get(api22) != null;
                c6197a.put(api22, Boolean.valueOf(z));
                zzp zzp = new zzp(api22, z);
                arrayList.add(zzp);
                AbstractClientBuilder zzk = api22.zzk();
                Client buildClient = zzk.buildClient(this.mContext, this.zzcn, buildClientSettings, obj2, zzp, zzp);
                c6197a2.put(api22.getClientKey(), buildClient);
                Object obj3 = zzk.getPriority() == 1 ? obj2 != null ? 1 : null : obj;
                if (!buildClient.providesSignIn()) {
                    api22 = api;
                } else if (api != null) {
                    name = api22.getName();
                    String name2 = api.getName();
                    illegalStateException = new IllegalStateException(new StringBuilder((String.valueOf(name).length() + 21) + String.valueOf(name2).length()).append(name).append(" cannot be used with ").append(name2).toString());
                    AppMethodBeat.m2505o(60551);
                    throw illegalStateException;
                }
                obj = obj3;
                api = api22;
            }
            if (api != null) {
                if (obj != null) {
                    name = api.getName();
                    illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(name).length() + 82).append("With using ").append(name).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder").toString());
                    AppMethodBeat.m2505o(60551);
                    throw illegalStateException;
                }
                Preconditions.checkState(this.zzs == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.getName());
                Preconditions.checkState(this.zzcv.equals(this.zzcw), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.getName());
            }
            zzav zzav = new zzav(this.mContext, new ReentrantLock(), this.zzcn, buildClientSettings, this.zzdg, this.zzdh, c6197a, this.zzdi, this.zzdj, c6197a2, this.zzde, zzav.zza(c6197a2.values(), true), arrayList, false);
            synchronized (GoogleApiClient.zzcu) {
                try {
                    GoogleApiClient.zzcu.add(zzav);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(60551);
                    }
                }
            }
            if (this.zzde >= 0) {
                zzi.zza(this.zzdd).zza(this.zzde, zzav, this.zzdf);
            }
            AppMethodBeat.m2505o(60551);
            return zzav;
        }

        @KeepForSdk
        @VisibleForTesting
        public final ClientSettings buildClientSettings() {
            AppMethodBeat.m2504i(60550);
            SignInOptions signInOptions = SignInOptions.DEFAULT;
            if (this.zzdc.containsKey(SignIn.API)) {
                signInOptions = (SignInOptions) this.zzdc.get(SignIn.API);
            }
            ClientSettings clientSettings = new ClientSettings(this.zzs, this.zzcv, this.zzdb, this.zzcx, this.zzcy, this.zzcz, this.zzda, signInOptions);
            AppMethodBeat.m2505o(60550);
            return clientSettings;
        }

        public final Builder enableAutoManage(FragmentActivity fragmentActivity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            AppMethodBeat.m2504i(60548);
            LifecycleActivity lifecycleActivity = new LifecycleActivity(fragmentActivity);
            Preconditions.checkArgument(i >= 0, "clientId must be non-negative");
            this.zzde = i;
            this.zzdf = onConnectionFailedListener;
            this.zzdd = lifecycleActivity;
            AppMethodBeat.m2505o(60548);
            return this;
        }

        public final Builder enableAutoManage(FragmentActivity fragmentActivity, OnConnectionFailedListener onConnectionFailedListener) {
            AppMethodBeat.m2504i(60549);
            Builder enableAutoManage = enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
            AppMethodBeat.m2505o(60549);
            return enableAutoManage;
        }

        public final Builder setAccountName(String str) {
            AppMethodBeat.m2504i(60546);
            this.zzs = str == null ? null : new Account(str, "com.google");
            AppMethodBeat.m2505o(60546);
            return this;
        }

        public final Builder setGravityForPopups(int i) {
            this.zzcx = i;
            return this;
        }

        public final Builder setHandler(Handler handler) {
            AppMethodBeat.m2504i(60536);
            Preconditions.checkNotNull(handler, "Handler must not be null");
            this.zzcn = handler.getLooper();
            AppMethodBeat.m2505o(60536);
            return this;
        }

        public final Builder setViewForPopups(View view) {
            AppMethodBeat.m2504i(60539);
            Preconditions.checkNotNull(view, "View must not be null");
            this.zzcy = view;
            AppMethodBeat.m2505o(60539);
            return this;
        }

        public final Builder useDefaultAccount() {
            AppMethodBeat.m2504i(60547);
            Builder accountName = setAccountName("<<default account>>");
            AppMethodBeat.m2505o(60547);
            return accountName;
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (zzcu) {
            String concat = String.valueOf(str).concat("  ");
            int i = 0;
            for (GoogleApiClient googleApiClient : zzcu) {
                int i2 = i + 1;
                printWriter.append(str).append("GoogleApiClient#").println(i);
                googleApiClient.dump(concat, fileDescriptor, printWriter, strArr);
                i = i2;
            }
        }
    }

    @KeepForSdk
    public static Set<GoogleApiClient> getAllClients() {
        Set set;
        synchronized (zzcu) {
            set = zzcu;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @KeepForSdk
    public <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public <C extends Client> C getClient(AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    @KeepForSdk
    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean hasApi(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(L l) {
        throw new UnsupportedOperationException();
    }

    public abstract void stopAutoManage(FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public void zza(zzch zzch) {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzch zzch) {
        throw new UnsupportedOperationException();
    }
}
