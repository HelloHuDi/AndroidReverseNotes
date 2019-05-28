package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

final class zzh extends GmsClientSupervisor implements Callback {
    private final Handler mHandler;
    private final Context zzau;
    @GuardedBy("mConnectionStatus")
    private final HashMap<ConnectionStatusConfig, zzi> zztr = new HashMap();
    private final ConnectionTracker zzts;
    private final long zztt;
    private final long zztu;

    zzh(Context context) {
        AppMethodBeat.i(89865);
        this.zzau = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzts = ConnectionTracker.getInstance();
        this.zztt = 5000;
        this.zztu = 300000;
        AppMethodBeat.o(89865);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bindService(ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        AppMethodBeat.i(89866);
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zztr) {
            try {
                zzi zzi = (zzi) this.zztr.get(connectionStatusConfig);
                if (zzi != null) {
                    this.mHandler.removeMessages(0, connectionStatusConfig);
                    if (!zzi.zza(serviceConnection)) {
                        zzi.zza(serviceConnection, str);
                        switch (zzi.getState()) {
                            case 1:
                                serviceConnection.onServiceConnected(zzi.getComponentName(), zzi.getBinder());
                                break;
                            case 2:
                                zzi.zzj(str);
                                break;
                            default:
                                break;
                        }
                    }
                    String valueOf = String.valueOf(connectionStatusConfig);
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
                    AppMethodBeat.o(89866);
                    throw illegalStateException;
                }
                zzi = new zzi(this, connectionStatusConfig);
                zzi.zza(serviceConnection, str);
                zzi.zzj(str);
                this.zztr.put(connectionStatusConfig, zzi);
                isBound = zzi.isBound();
            } finally {
                AppMethodBeat.o(89866);
            }
        }
        return isBound;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(89868);
        ConnectionStatusConfig connectionStatusConfig;
        zzi zzi;
        switch (message.what) {
            case 0:
                synchronized (this.zztr) {
                    try {
                        connectionStatusConfig = (ConnectionStatusConfig) message.obj;
                        zzi = (zzi) this.zztr.get(connectionStatusConfig);
                        if (zzi != null && zzi.zzcv()) {
                            if (zzi.isBound()) {
                                zzi.zzk("GmsClientSupervisor");
                            }
                            this.zztr.remove(connectionStatusConfig);
                        }
                    } finally {
                        while (true) {
                            AppMethodBeat.o(89868);
                            break;
                        }
                    }
                }
                return true;
            case 1:
                synchronized (this.zztr) {
                    try {
                        connectionStatusConfig = (ConnectionStatusConfig) message.obj;
                        zzi = (zzi) this.zztr.get(connectionStatusConfig);
                        if (zzi != null && zzi.getState() == 3) {
                            String valueOf = String.valueOf(connectionStatusConfig);
                            Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                            ComponentName componentName = zzi.getComponentName();
                            if (componentName == null) {
                                componentName = connectionStatusConfig.getComponentName();
                            }
                            zzi.onServiceDisconnected(componentName == null ? new ComponentName(connectionStatusConfig.getPackage(), "unknown") : componentName);
                        }
                    } finally {
                        while (true) {
                            AppMethodBeat.o(89868);
                            break;
                        }
                    }
                }
                return true;
            default:
                AppMethodBeat.o(89868);
                return false;
        }
    }

    @VisibleForTesting
    public final void resetForTesting() {
        AppMethodBeat.i(89869);
        synchronized (this.zztr) {
            try {
                for (zzi zzi : this.zztr.values()) {
                    this.mHandler.removeMessages(0, zzi.zztx);
                    if (zzi.isBound()) {
                        zzi.zzk("GmsClientSupervisor");
                    }
                }
                this.zztr.clear();
            } finally {
                AppMethodBeat.o(89869);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void unbindService(ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(89867);
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zztr) {
            try {
                zzi zzi = (zzi) this.zztr.get(connectionStatusConfig);
                String valueOf;
                if (zzi == null) {
                    valueOf = String.valueOf(connectionStatusConfig);
                    Object illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
                    throw illegalStateException;
                } else if (zzi.zza(serviceConnection)) {
                    zzi.zzb(serviceConnection, str);
                    if (zzi.zzcv()) {
                        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, connectionStatusConfig), this.zztt);
                    }
                } else {
                    valueOf = String.valueOf(connectionStatusConfig);
                    IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf).toString());
                    AppMethodBeat.o(89867);
                    throw illegalStateException2;
                }
            } finally {
                AppMethodBeat.o(89867);
            }
        }
        AppMethodBeat.o(89867);
    }
}
