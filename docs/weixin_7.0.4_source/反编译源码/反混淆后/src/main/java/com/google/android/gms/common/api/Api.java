package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {
    private final String mName;
    private final AbstractClientBuilder<?, O> zzby;
    private final zza<?, O> zzbz = null;
    private final ClientKey<?> zzca;
    private final zzb<?> zzcb;

    @KeepForSdk
    public interface AnyClient {
    }

    @KeepForSdk
    public static class AnyClientKey<C extends AnyClient> {
    }

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account getAccount();
        }

        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount getGoogleSignInAccount();
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    @KeepForSdk
    @VisibleForTesting
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        @KeepForSdk
        public static final int API_PRIORITY_GAMES = 1;
        @KeepForSdk
        public static final int API_PRIORITY_OTHER = Integer.MAX_VALUE;
        @KeepForSdk
        public static final int API_PRIORITY_PLUS = 2;

        @KeepForSdk
        public List<Scope> getImpliedScopes(O o) {
            AppMethodBeat.m2504i(60477);
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(60477);
            return emptyList;
        }

        @KeepForSdk
        public int getPriority() {
            return API_PRIORITY_OTHER;
        }
    }

    @KeepForSdk
    @VisibleForTesting
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @KeepForSdk
        public abstract T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);
    }

    @KeepForSdk
    public interface Client extends AnyClient {
        void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        Feature[] getAvailableFeatures();

        String getEndpointPackageName();

        int getMinApkVersion();

        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        IBinder getServiceBrokerBinder();

        Intent getSignInIntent();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(SignOutCallbacks signOutCallbacks);

        boolean providesSignIn();

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    @KeepForSdk
    @VisibleForTesting
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    public interface SimpleClient<T extends IInterface> extends AnyClient {
        T createServiceInterface(IBinder iBinder);

        String getServiceDescriptor();

        String getStartServiceAction();

        void setState(int i, T t);
    }

    @VisibleForTesting
    public static abstract class zza<T extends SimpleClient, O> extends BaseClientBuilder<T, O> {
    }

    @VisibleForTesting
    public static final class zzb<C extends SimpleClient> extends AnyClientKey<C> {
    }

    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        AppMethodBeat.m2504i(60478);
        Preconditions.checkNotNull(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(clientKey, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.zzby = abstractClientBuilder;
        this.zzca = clientKey;
        this.zzcb = null;
        AppMethodBeat.m2505o(60478);
    }

    public final AnyClientKey<?> getClientKey() {
        AppMethodBeat.m2504i(60480);
        if (this.zzca != null) {
            ClientKey clientKey = this.zzca;
            AppMethodBeat.m2505o(60480);
            return clientKey;
        }
        IllegalStateException illegalStateException = new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
        AppMethodBeat.m2505o(60480);
        throw illegalStateException;
    }

    public final String getName() {
        return this.mName;
    }

    public final BaseClientBuilder<?, O> zzj() {
        return this.zzby;
    }

    public final AbstractClientBuilder<?, O> zzk() {
        AppMethodBeat.m2504i(60479);
        Preconditions.checkState(this.zzby != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        AbstractClientBuilder abstractClientBuilder = this.zzby;
        AppMethodBeat.m2505o(60479);
        return abstractClientBuilder;
    }
}
