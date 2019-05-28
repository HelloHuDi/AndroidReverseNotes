package com.google.android.gms.common.api.internal;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzaf extends GoogleApiClient {
    private final String zzhe;

    public zzaf(String str) {
        this.zzhe = str;
    }

    public ConnectionResult blockingConnect() {
        AppMethodBeat.i(60697);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60697);
        throw unsupportedOperationException;
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        AppMethodBeat.i(60698);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60698);
        throw unsupportedOperationException;
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        AppMethodBeat.i(60701);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60701);
        throw unsupportedOperationException;
    }

    public void connect() {
        AppMethodBeat.i(60696);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60696);
        throw unsupportedOperationException;
    }

    public void disconnect() {
        AppMethodBeat.i(60699);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60699);
        throw unsupportedOperationException;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(60711);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60711);
        throw unsupportedOperationException;
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.i(60695);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60695);
        throw unsupportedOperationException;
    }

    public boolean hasConnectedApi(Api<?> api) {
        AppMethodBeat.i(60694);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60694);
        throw unsupportedOperationException;
    }

    public boolean isConnected() {
        AppMethodBeat.i(60703);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60703);
        throw unsupportedOperationException;
    }

    public boolean isConnecting() {
        AppMethodBeat.i(60704);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60704);
        throw unsupportedOperationException;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(60706);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60706);
        throw unsupportedOperationException;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(60709);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60709);
        throw unsupportedOperationException;
    }

    public void reconnect() {
        AppMethodBeat.i(60700);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60700);
        throw unsupportedOperationException;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(60705);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60705);
        throw unsupportedOperationException;
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(60708);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60708);
        throw unsupportedOperationException;
    }

    public void stopAutoManage(FragmentActivity fragmentActivity) {
        AppMethodBeat.i(60702);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60702);
        throw unsupportedOperationException;
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(60707);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60707);
        throw unsupportedOperationException;
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(60710);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(60710);
        throw unsupportedOperationException;
    }
}
