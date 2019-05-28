package com.google.android.gms.internal.measurement;

import android.app.job.JobParameters;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzje implements Runnable {
    private final JobParameters zzabs;
    private final zzjc zzapp;
    private final zzfg zzaps;

    zzje(zzjc zzjc, zzfg zzfg, JobParameters jobParameters) {
        this.zzapp = zzjc;
        this.zzaps = zzfg;
        this.zzabs = jobParameters;
    }

    public final void run() {
        AppMethodBeat.m2504i(69361);
        this.zzapp.zza(this.zzaps, this.zzabs);
        AppMethodBeat.m2505o(69361);
    }
}
