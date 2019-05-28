package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzge;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzge {
    private zzgb zzadd;

    public final PendingResult doGoAsync() {
        AppMethodBeat.i(77162);
        PendingResult goAsync = goAsync();
        AppMethodBeat.o(77162);
        return goAsync;
    }

    public final void doStartService(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(77161);
        if (this.zzadd == null) {
            this.zzadd = new zzgb(this);
        }
        this.zzadd.onReceive(context, intent);
        AppMethodBeat.o(77161);
    }
}
