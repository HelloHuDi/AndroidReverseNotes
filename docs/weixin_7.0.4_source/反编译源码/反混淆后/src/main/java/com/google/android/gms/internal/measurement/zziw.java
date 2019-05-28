package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public final class zziw implements ServiceConnection, BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    final /* synthetic */ zzii zzape;
    private volatile boolean zzapk;
    private volatile zzff zzapl;

    protected zziw(zzii zzii) {
        this.zzape = zzii;
    }

    public final void onConnected(Bundle bundle) {
        AppMethodBeat.m2504i(69339);
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                zzey zzey = (zzey) this.zzapl.getService();
                this.zzapl = null;
                this.zzape.zzgd().zzc(new zziz(this, zzey));
            } catch (DeadObjectException | IllegalStateException e) {
                this.zzapl = null;
                this.zzapk = false;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(69339);
            }
        }
        AppMethodBeat.m2505o(69339);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        AppMethodBeat.m2504i(69341);
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzfg zzjo = this.zzape.zzacw.zzjo();
        if (zzjo != null) {
            zzjo.zzip().zzg("Service connection failed", connectionResult);
        }
        synchronized (this) {
            try {
                this.zzapk = false;
                this.zzapl = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69341);
            }
        }
        this.zzape.zzgd().zzc(new zzjb(this));
    }

    public final void onConnectionSuspended(int i) {
        AppMethodBeat.m2504i(69340);
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zzape.zzge().zzis().log("Service connection suspended");
        this.zzape.zzgd().zzc(new zzja(this));
        AppMethodBeat.m2505o(69340);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4 A:{SYNTHETIC, Splitter:B:37:0x00a4} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4 A:{SYNTHETIC, Splitter:B:37:0x00a4} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzey zzey;
        AppMethodBeat.m2504i(69336);
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzapk = false;
                this.zzape.zzge().zzim().log("Service connected with null binder");
            } else {
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        if (iBinder == null) {
                            zzey = null;
                        } else {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                            zzey = queryLocalInterface instanceof zzey ? (zzey) queryLocalInterface : new zzfa(iBinder);
                        }
                        try {
                            this.zzape.zzge().zzit().log("Bound to IMeasurementService interface");
                        } catch (RemoteException e) {
                            try {
                                this.zzape.zzge().zzim().log("Service connect failed to get IMeasurementService");
                                if (zzey == null) {
                                }
                                AppMethodBeat.m2505o(69336);
                            } finally {
                                AppMethodBeat.m2505o(69336);
                            }
                        }
                        if (zzey == null) {
                            this.zzapk = false;
                            try {
                                ConnectionTracker.getInstance().unbindService(this.zzape.getContext(), this.zzape.zzaox);
                            } catch (IllegalArgumentException e2) {
                            }
                        } else {
                            this.zzape.zzgd().zzc(new zzix(this, zzey));
                        }
                        AppMethodBeat.m2505o(69336);
                    }
                    this.zzape.zzge().zzim().zzg("Got binder with a wrong descriptor", interfaceDescriptor);
                    zzey = null;
                    if (zzey == null) {
                    }
                    AppMethodBeat.m2505o(69336);
                } catch (RemoteException e3) {
                    zzey = null;
                }
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.m2504i(69337);
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zzape.zzge().zzis().log("Service disconnected");
        this.zzape.zzgd().zzc(new zziy(this, componentName));
        AppMethodBeat.m2505o(69337);
    }

    public final void zzc(Intent intent) {
        AppMethodBeat.m2504i(69335);
        this.zzape.zzab();
        Context context = this.zzape.getContext();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            try {
                if (this.zzapk) {
                    this.zzape.zzge().zzit().log("Connection attempt already in progress");
                } else {
                    this.zzape.zzge().zzit().log("Using local app measurement service");
                    this.zzapk = true;
                    instance.bindService(context, intent, this.zzape.zzaox, GmsClientSupervisor.DEFAULT_BIND_FLAGS);
                    AppMethodBeat.m2505o(69335);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69335);
            }
        }
    }

    public final void zzkh() {
        AppMethodBeat.m2504i(69338);
        this.zzape.zzab();
        Context context = this.zzape.getContext();
        synchronized (this) {
            try {
                if (this.zzapk) {
                    this.zzape.zzge().zzit().log("Connection attempt already in progress");
                } else if (this.zzapl != null) {
                    this.zzape.zzge().zzit().log("Already awaiting connection attempt");
                    AppMethodBeat.m2505o(69338);
                } else {
                    this.zzapl = new zzff(context, Looper.getMainLooper(), this, this);
                    this.zzape.zzge().zzit().log("Connecting to remote service");
                    this.zzapk = true;
                    this.zzapl.checkAvailabilityAndConnect();
                    AppMethodBeat.m2505o(69338);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69338);
            }
        }
    }
}
