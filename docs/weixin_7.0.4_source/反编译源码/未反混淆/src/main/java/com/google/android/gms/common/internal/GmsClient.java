package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;

public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Client, GmsClientEventState {
    private final Set<Scope> mScopes;
    private final ClientSettings zzgf;
    private final Account zzs;

    @VisibleForTesting
    protected GmsClient(Context context, Handler handler, int i, ClientSettings clientSettings) {
        this(context, handler, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i, clientSettings, null, null);
    }

    @VisibleForTesting
    protected GmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, handler, gmsClientSupervisor, googleApiAvailability, i, zza(connectionCallbacks), zza(onConnectionFailedListener));
        this.zzgf = (ClientSettings) Preconditions.checkNotNull(clientSettings);
        this.zzs = clientSettings.getAccount();
        this.mScopes = zza(clientSettings.getAllRequestedScopes());
    }

    protected GmsClient(Context context, Looper looper, int i, ClientSettings clientSettings) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i, clientSettings, null, null);
    }

    protected GmsClient(Context context, Looper looper, int i, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailability.getInstance(), i, clientSettings, (ConnectionCallbacks) Preconditions.checkNotNull(connectionCallbacks), (OnConnectionFailedListener) Preconditions.checkNotNull(onConnectionFailedListener));
    }

    @VisibleForTesting
    protected GmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailability googleApiAvailability, int i, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, gmsClientSupervisor, googleApiAvailability, i, zza(connectionCallbacks), zza(onConnectionFailedListener), clientSettings.getRealClientClassName());
        this.zzgf = clientSettings;
        this.zzs = clientSettings.getAccount();
        this.mScopes = zza(clientSettings.getAllRequestedScopes());
    }

    private static BaseConnectionCallbacks zza(ConnectionCallbacks connectionCallbacks) {
        return connectionCallbacks == null ? null : new zzf(connectionCallbacks);
    }

    private static BaseOnConnectionFailedListener zza(OnConnectionFailedListener onConnectionFailedListener) {
        return onConnectionFailedListener == null ? null : new zzg(onConnectionFailedListener);
    }

    private final Set<Scope> zza(Set<Scope> set) {
        Set<Scope> validateScopes = validateScopes(set);
        for (Scope contains : validateScopes) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    public final Account getAccount() {
        return this.zzs;
    }

    /* Access modifiers changed, original: protected|final */
    public final ClientSettings getClientSettings() {
        return this.zzgf;
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    /* Access modifiers changed, original: protected|final */
    public final Set<Scope> getScopes() {
        return this.mScopes;
    }

    /* Access modifiers changed, original: protected */
    public Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }
}
