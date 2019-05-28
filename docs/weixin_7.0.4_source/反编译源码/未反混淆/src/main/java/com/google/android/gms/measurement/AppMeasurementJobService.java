package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzjg;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzjg {
    private zzjc<AppMeasurementJobService> zzade;

    private final zzjc<AppMeasurementJobService> zzfq() {
        AppMethodBeat.i(77163);
        if (this.zzade == null) {
            this.zzade = new zzjc(this);
        }
        zzjc zzjc = this.zzade;
        AppMethodBeat.o(77163);
        return zzjc;
    }

    public final boolean callServiceStopSelfResult(int i) {
        AppMethodBeat.i(77169);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(77169);
        throw unsupportedOperationException;
    }

    public final void onCreate() {
        AppMethodBeat.i(77164);
        super.onCreate();
        zzfq().onCreate();
        AppMethodBeat.o(77164);
    }

    public final void onDestroy() {
        AppMethodBeat.i(77165);
        zzfq().onDestroy();
        super.onDestroy();
        AppMethodBeat.o(77165);
    }

    public final void onRebind(Intent intent) {
        AppMethodBeat.i(77168);
        zzfq().onRebind(intent);
        AppMethodBeat.o(77168);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        AppMethodBeat.i(77166);
        boolean onStartJob = zzfq().onStartJob(jobParameters);
        AppMethodBeat.o(77166);
        return onStartJob;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        AppMethodBeat.i(77167);
        boolean onUnbind = zzfq().onUnbind(intent);
        AppMethodBeat.o(77167);
        return onUnbind;
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        AppMethodBeat.i(77170);
        jobFinished(jobParameters, false);
        AppMethodBeat.o(77170);
    }

    public final void zzb(Intent intent) {
    }
}
