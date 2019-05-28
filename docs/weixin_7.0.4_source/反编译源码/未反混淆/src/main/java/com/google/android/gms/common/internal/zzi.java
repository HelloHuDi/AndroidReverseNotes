package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

final class zzi implements ServiceConnection {
    private ComponentName mComponentName;
    private int mState = 2;
    private IBinder zzry;
    private final Set<ServiceConnection> zztv = new HashSet();
    private boolean zztw;
    private final ConnectionStatusConfig zztx;
    private final /* synthetic */ zzh zzty;

    public zzi(zzh zzh, ConnectionStatusConfig connectionStatusConfig) {
        this.zzty = zzh;
        AppMethodBeat.i(89870);
        this.zztx = connectionStatusConfig;
        AppMethodBeat.o(89870);
    }

    public final IBinder getBinder() {
        return this.zzry;
    }

    public final ComponentName getComponentName() {
        return this.mComponentName;
    }

    public final int getState() {
        return this.mState;
    }

    public final boolean isBound() {
        return this.zztw;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AppMethodBeat.i(89871);
        synchronized (this.zzty.zztr) {
            try {
                this.zzty.mHandler.removeMessages(1, this.zztx);
                this.zzry = iBinder;
                this.mComponentName = componentName;
                for (ServiceConnection onServiceConnected : this.zztv) {
                    onServiceConnected.onServiceConnected(componentName, iBinder);
                }
                this.mState = 1;
            } finally {
                AppMethodBeat.o(89871);
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(89872);
        synchronized (this.zzty.zztr) {
            try {
                this.zzty.mHandler.removeMessages(1, this.zztx);
                this.zzry = null;
                this.mComponentName = componentName;
                for (ServiceConnection onServiceDisconnected : this.zztv) {
                    onServiceDisconnected.onServiceDisconnected(componentName);
                }
                this.mState = 2;
            } finally {
                AppMethodBeat.o(89872);
            }
        }
    }

    public final void zza(ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(89875);
        this.zzty.zzts.logConnectService(this.zzty.zzau, serviceConnection, str, this.zztx.getStartServiceIntent(this.zzty.zzau));
        this.zztv.add(serviceConnection);
        AppMethodBeat.o(89875);
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        AppMethodBeat.i(89877);
        boolean contains = this.zztv.contains(serviceConnection);
        AppMethodBeat.o(89877);
        return contains;
    }

    public final void zzb(ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(89876);
        this.zzty.zzts.logDisconnectService(this.zzty.zzau, serviceConnection);
        this.zztv.remove(serviceConnection);
        AppMethodBeat.o(89876);
    }

    public final boolean zzcv() {
        AppMethodBeat.i(89878);
        boolean isEmpty = this.zztv.isEmpty();
        AppMethodBeat.o(89878);
        return isEmpty;
    }

    public final void zzj(String str) {
        AppMethodBeat.i(89873);
        this.mState = 3;
        this.zztw = this.zzty.zzts.bindService(this.zzty.zzau, str, this.zztx.getStartServiceIntent(this.zzty.zzau), this, this.zztx.getBindFlags());
        if (this.zztw) {
            this.zzty.mHandler.sendMessageDelayed(this.zzty.mHandler.obtainMessage(1, this.zztx), this.zzty.zztu);
            AppMethodBeat.o(89873);
            return;
        }
        this.mState = 2;
        try {
            this.zzty.zzts.unbindService(this.zzty.zzau, this);
            AppMethodBeat.o(89873);
        } catch (IllegalArgumentException e) {
            AppMethodBeat.o(89873);
        }
    }

    public final void zzk(String str) {
        AppMethodBeat.i(89874);
        this.zzty.mHandler.removeMessages(1, this.zztx);
        this.zzty.zzts.unbindService(this.zzty.zzau, this);
        this.zztw = false;
        this.mState = 2;
        AppMethodBeat.o(89874);
    }
}
