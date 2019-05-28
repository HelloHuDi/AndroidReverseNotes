package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager implements Callback {
    private final Handler mHandler;
    private final Object mLock = new Object();
    private final GmsClientEventState zztf;
    private final ArrayList<ConnectionCallbacks> zztg = new ArrayList();
    @VisibleForTesting
    private final ArrayList<ConnectionCallbacks> zzth = new ArrayList();
    private final ArrayList<OnConnectionFailedListener> zzti = new ArrayList();
    private volatile boolean zztj = false;
    private final AtomicInteger zztk = new AtomicInteger(0);
    private boolean zztl = false;

    @VisibleForTesting
    public interface GmsClientEventState {
        Bundle getConnectionHint();

        boolean isConnected();
    }

    public GmsClientEventManager(Looper looper, GmsClientEventState gmsClientEventState) {
        AppMethodBeat.i(61334);
        this.zztf = gmsClientEventState;
        this.mHandler = new Handler(looper, this);
        AppMethodBeat.o(61334);
    }

    public final boolean areCallbacksEnabled() {
        return this.zztj;
    }

    public final void disableCallbacks() {
        AppMethodBeat.i(61335);
        this.zztj = false;
        this.zztk.incrementAndGet();
        AppMethodBeat.o(61335);
    }

    public final void enableCallbacks() {
        this.zztj = true;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(61346);
        if (message.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.mLock) {
                try {
                    if (this.zztj && this.zztf.isConnected() && this.zztg.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(this.zztf.getConnectionHint());
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(61346);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        AppMethodBeat.o(61346);
        return false;
    }

    public final boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        AppMethodBeat.i(61341);
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            try {
                contains = this.zztg.contains(connectionCallbacks);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(61341);
            }
        }
        return contains;
    }

    public final boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        AppMethodBeat.i(61344);
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            try {
                contains = this.zzti.contains(onConnectionFailedListener);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(61344);
            }
        }
        return contains;
    }

    @VisibleForTesting
    public final void onConnectionFailure(ConnectionResult connectionResult) {
        int i = 0;
        AppMethodBeat.i(61339);
        Preconditions.checkState(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.mLock) {
            try {
                ArrayList arrayList = new ArrayList(this.zzti);
                int i2 = this.zztk.get();
                arrayList = arrayList;
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) obj;
                    if (!this.zztj || this.zztk.get() != i2) {
                    } else if (this.zzti.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                }
                AppMethodBeat.o(61339);
            } finally {
                AppMethodBeat.o(61339);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    @VisibleForTesting
    public final void onConnectionSuccess() {
        AppMethodBeat.i(61336);
        synchronized (this.mLock) {
            try {
                onConnectionSuccess(this.zztf.getConnectionHint());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(61336);
            }
        }
    }

    @VisibleForTesting
    public final void onConnectionSuccess(Bundle bundle) {
        boolean z = true;
        int i = 0;
        AppMethodBeat.i(61337);
        Preconditions.checkState(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.mLock) {
            try {
                Preconditions.checkState(!this.zztl);
                this.mHandler.removeMessages(1);
                this.zztl = true;
                if (this.zzth.size() != 0) {
                    z = false;
                }
                Preconditions.checkState(z);
                ArrayList arrayList = new ArrayList(this.zztg);
                int i2 = this.zztk.get();
                arrayList = arrayList;
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                    if (this.zztj && this.zztf.isConnected() && this.zztk.get() == i2) {
                        if (!this.zzth.contains(connectionCallbacks)) {
                            connectionCallbacks.onConnected(bundle);
                        }
                    }
                }
                this.zzth.clear();
                this.zztl = false;
            } finally {
                AppMethodBeat.o(61337);
            }
        }
    }

    @VisibleForTesting
    public final void onUnintentionalDisconnection(int i) {
        int i2 = 0;
        AppMethodBeat.i(61338);
        Preconditions.checkState(Looper.myLooper() == this.mHandler.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.mLock) {
            try {
                this.zztl = true;
                ArrayList arrayList = new ArrayList(this.zztg);
                int i3 = this.zztk.get();
                arrayList = arrayList;
                int size = arrayList.size();
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) obj;
                    if (this.zztj && this.zztk.get() == i3) {
                        if (this.zztg.contains(connectionCallbacks)) {
                            connectionCallbacks.onConnectionSuspended(i);
                        }
                    }
                }
                this.zzth.clear();
                this.zztl = false;
            } finally {
                AppMethodBeat.o(61338);
            }
        }
    }

    public final void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(61340);
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            try {
                if (this.zztg.contains(connectionCallbacks)) {
                    String valueOf = String.valueOf(connectionCallbacks);
                    new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered");
                } else {
                    this.zztg.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(61340);
            }
        }
        if (this.zztf.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
        AppMethodBeat.o(61340);
    }

    public final void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(61343);
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            try {
                if (this.zzti.contains(onConnectionFailedListener)) {
                    String valueOf = String.valueOf(onConnectionFailedListener);
                    new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered");
                } else {
                    this.zzti.add(onConnectionFailedListener);
                }
            } finally {
                AppMethodBeat.o(61343);
            }
        }
    }

    public final void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(61342);
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            try {
                if (!this.zztg.remove(connectionCallbacks)) {
                    String valueOf = String.valueOf(connectionCallbacks);
                    new StringBuilder(String.valueOf(valueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(valueOf).append(" not found");
                } else if (this.zztl) {
                    this.zzth.add(connectionCallbacks);
                }
            } finally {
                AppMethodBeat.o(61342);
            }
        }
    }

    public final void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(61345);
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            try {
                if (!this.zzti.remove(onConnectionFailedListener)) {
                    String valueOf = String.valueOf(onConnectionFailedListener);
                    new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found");
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(61345);
            }
        }
    }
}
