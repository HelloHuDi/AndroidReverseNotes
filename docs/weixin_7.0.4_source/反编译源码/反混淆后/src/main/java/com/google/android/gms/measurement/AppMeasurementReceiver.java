package com.google.android.gms.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.support.p057v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzge;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzge {
    private zzgb zzadd;

    public final PendingResult doGoAsync() {
        AppMethodBeat.m2504i(77173);
        PendingResult goAsync = goAsync();
        AppMethodBeat.m2505o(77173);
        return goAsync;
    }

    public final void doStartService(Context context, Intent intent) {
        AppMethodBeat.m2504i(77172);
        WakefulBroadcastReceiver.startWakefulService(context, intent);
        AppMethodBeat.m2505o(77172);
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(77171);
        if (this.zzadd == null) {
            this.zzadd = new zzgb(this);
        }
        this.zzadd.onReceive(context, intent);
        AppMethodBeat.m2505o(77171);
    }
}
