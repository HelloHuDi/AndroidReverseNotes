package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public class ConnectionTracker {
    private static final Object zztm = new Object();
    private static volatile ConnectionTracker zzyg;
    @VisibleForTesting
    private static boolean zzyh = false;
    private final List<String> zzyi = Collections.EMPTY_LIST;
    private final List<String> zzyj = Collections.EMPTY_LIST;
    private final List<String> zzyk = Collections.EMPTY_LIST;
    private final List<String> zzyl = Collections.EMPTY_LIST;

    static {
        AppMethodBeat.i(89959);
        AppMethodBeat.o(89959);
    }

    private ConnectionTracker() {
    }

    public static ConnectionTracker getInstance() {
        AppMethodBeat.i(89953);
        if (zzyg == null) {
            synchronized (zztm) {
                try {
                    if (zzyg == null) {
                        zzyg = new ConnectionTracker();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(89953);
                    }
                }
            }
        }
        ConnectionTracker connectionTracker = zzyg;
        AppMethodBeat.o(89953);
        return connectionTracker;
    }

    @SuppressLint({"UntrackedBindService"})
    private static boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z) {
        AppMethodBeat.i(89956);
        if (z) {
            ComponentName component = intent.getComponent();
            if (component == null ? false : ClientLibraryUtils.isPackageStopped(context, component.getPackageName())) {
                AppMethodBeat.o(89956);
                return false;
            }
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        AppMethodBeat.o(89956);
        return bindService;
    }

    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        AppMethodBeat.i(89957);
        boolean bindService = bindService(context, context.getClass().getName(), intent, serviceConnection, i);
        AppMethodBeat.o(89957);
        return bindService;
    }

    public boolean bindService(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        AppMethodBeat.i(89954);
        boolean zza = zza(context, str, intent, serviceConnection, i, true);
        AppMethodBeat.o(89954);
        return zza;
    }

    public boolean bindServiceAllowStoppedPackages(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        AppMethodBeat.i(89955);
        boolean zza = zza(context, str, intent, serviceConnection, i, false);
        AppMethodBeat.o(89955);
        return zza;
    }

    public void logConnectService(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
    }

    public void logDisconnectService(Context context, ServiceConnection serviceConnection) {
    }

    public void logStartService(Service service, int i) {
    }

    public void logStopService(Service service, int i) {
    }

    @SuppressLint({"UntrackedBindService"})
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        AppMethodBeat.i(89958);
        context.unbindService(serviceConnection);
        AppMethodBeat.o(89958);
    }
}
