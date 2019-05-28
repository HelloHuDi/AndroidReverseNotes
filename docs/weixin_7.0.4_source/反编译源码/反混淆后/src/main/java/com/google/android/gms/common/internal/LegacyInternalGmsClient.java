package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@Deprecated
public abstract class LegacyInternalGmsClient<T extends IInterface> extends GmsClient<T> {
    private final GmsClientEventManager zzie;

    public LegacyInternalGmsClient(Context context, int i, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, context.getMainLooper(), i, clientSettings);
        this.zzie = new GmsClientEventManager(context.getMainLooper(), this);
        this.zzie.registerConnectionCallbacks(connectionCallbacks);
        this.zzie.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void checkAvailabilityAndConnect() {
        this.zzie.enableCallbacks();
        super.checkAvailabilityAndConnect();
    }

    public void disconnect() {
        this.zzie.disableCallbacks();
        super.disconnect();
    }

    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        return this.zzie.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzie.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void onConnectedLocked(T t) {
        super.onConnectedLocked(t);
        this.zzie.onConnectionSuccess(getConnectionHint());
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzie.onConnectionFailure(connectionResult);
    }

    public void onConnectionSuspended(int i) {
        super.onConnectionSuspended(i);
        this.zzie.onUnintentionalDisconnection(i);
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.zzie.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.zzie.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.zzie.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.zzie.unregisterConnectionFailedListener(onConnectionFailedListener);
    }
}
