package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzjc<T extends Context & zzjg> {
    private final T zzabm;

    public zzjc(T t) {
        AppMethodBeat.i(69347);
        Preconditions.checkNotNull(t);
        this.zzabm = t;
        AppMethodBeat.o(69347);
    }

    public static boolean zza(Context context, boolean z) {
        AppMethodBeat.i(69348);
        Preconditions.checkNotNull(context);
        boolean zzc;
        if (VERSION.SDK_INT >= 24) {
            zzc = zzka.zzc(context, "com.google.android.gms.measurement.AppMeasurementJobService");
            AppMethodBeat.o(69348);
            return zzc;
        }
        zzc = zzka.zzc(context, "com.google.android.gms.measurement.AppMeasurementService");
        AppMethodBeat.o(69348);
        return zzc;
    }

    private final void zzb(Runnable runnable) {
        AppMethodBeat.i(69352);
        zzgl zzg = zzgl.zzg(this.zzabm);
        zzg.zzgd().zzc(new zzjf(this, zzg, runnable));
        AppMethodBeat.o(69352);
    }

    private final zzfg zzge() {
        AppMethodBeat.i(69357);
        zzfg zzge = zzgl.zzg(this.zzabm).zzge();
        AppMethodBeat.o(69357);
        return zzge;
    }

    public final IBinder onBind(Intent intent) {
        AppMethodBeat.i(69353);
        if (intent == null) {
            zzge().zzim().log("onBind called with null intent");
            AppMethodBeat.o(69353);
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            zzgn zzgn = new zzgn(zzgl.zzg(this.zzabm));
            AppMethodBeat.o(69353);
            return zzgn;
        }
        zzge().zzip().zzg("onBind received unknown action", action);
        AppMethodBeat.o(69353);
        return null;
    }

    public final void onCreate() {
        AppMethodBeat.i(69349);
        zzgl.zzg(this.zzabm).zzge().zzit().log("Local AppMeasurementService is starting up");
        AppMethodBeat.o(69349);
    }

    public final void onDestroy() {
        AppMethodBeat.i(69350);
        zzgl.zzg(this.zzabm).zzge().zzit().log("Local AppMeasurementService is shutting down");
        AppMethodBeat.o(69350);
    }

    public final void onRebind(Intent intent) {
        AppMethodBeat.i(69356);
        if (intent == null) {
            zzge().zzim().log("onRebind called with null intent");
            AppMethodBeat.o(69356);
            return;
        }
        zzge().zzit().zzg("onRebind called. action", intent.getAction());
        AppMethodBeat.o(69356);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(69351);
        zzfg zzge = zzgl.zzg(this.zzabm).zzge();
        if (intent == null) {
            zzge.zzip().log("AppMeasurementService started with null intent");
            AppMethodBeat.o(69351);
        } else {
            String action = intent.getAction();
            zzge.zzit().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzb(new zzjd(this, i2, zzge, intent));
            }
            AppMethodBeat.o(69351);
        }
        return 2;
    }

    @TargetApi(24)
    public final boolean onStartJob(JobParameters jobParameters) {
        AppMethodBeat.i(69355);
        zzfg zzge = zzgl.zzg(this.zzabm).zzge();
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        zzge.zzit().zzg("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            zzb(new zzje(this, zzge, jobParameters));
        }
        AppMethodBeat.o(69355);
        return true;
    }

    public final boolean onUnbind(Intent intent) {
        AppMethodBeat.i(69354);
        if (intent == null) {
            zzge().zzim().log("onUnbind called with null intent");
            AppMethodBeat.o(69354);
        } else {
            zzge().zzit().zzg("onUnbind called for intent. action", intent.getAction());
            AppMethodBeat.o(69354);
        }
        return true;
    }

    /* Access modifiers changed, original: final|synthetic */
    public final /* synthetic */ void zza(int i, zzfg zzfg, Intent intent) {
        AppMethodBeat.i(69359);
        if (((zzjg) this.zzabm).callServiceStopSelfResult(i)) {
            zzfg.zzit().zzg("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzge().zzit().log("Completed wakeful intent.");
            ((zzjg) this.zzabm).zzb(intent);
        }
        AppMethodBeat.o(69359);
    }
}
