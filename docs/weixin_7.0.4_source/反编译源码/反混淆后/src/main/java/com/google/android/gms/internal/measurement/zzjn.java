package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzjn extends zzjq {
    private final zzem zzapy;
    private final AlarmManager zzyi = ((AlarmManager) getContext().getSystemService("alarm"));
    private Integer zzyj;

    protected zzjn(zzjr zzjr) {
        super(zzjr);
        AppMethodBeat.m2504i(69399);
        this.zzapy = new zzjo(this, zzjr.zzla(), zzjr);
        AppMethodBeat.m2505o(69399);
    }

    private final int getJobId() {
        AppMethodBeat.m2504i(69403);
        if (this.zzyj == null) {
            String str = "measurement";
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzyj = Integer.valueOf((valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).hashCode());
        }
        int intValue = this.zzyj.intValue();
        AppMethodBeat.m2505o(69403);
        return intValue;
    }

    private final PendingIntent zzek() {
        AppMethodBeat.m2504i(69405);
        Intent className = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        PendingIntent broadcast = PendingIntent.getBroadcast(getContext(), 0, className, 0);
        AppMethodBeat.m2505o(69405);
        return broadcast;
    }

    @TargetApi(24)
    private final void zzkl() {
        AppMethodBeat.m2504i(69401);
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        zzge().zzit().zzg("Cancelling job. JobID", Integer.valueOf(getJobId()));
        jobScheduler.cancel(getJobId());
        AppMethodBeat.m2505o(69401);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(69404);
        zzch();
        this.zzyi.cancel(zzek());
        this.zzapy.cancel();
        if (VERSION.SDK_INT >= 24) {
            zzkl();
        }
        AppMethodBeat.m2505o(69404);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(69418);
        Context context = super.getContext();
        AppMethodBeat.m2505o(69418);
        return context;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(69410);
        super.zzab();
        AppMethodBeat.m2505o(69410);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(69417);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(69417);
        return zzbt;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(69408);
        super.zzfr();
        AppMethodBeat.m2505o(69408);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(69409);
        super.zzfs();
        AppMethodBeat.m2505o(69409);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(69411);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(69411);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(69412);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(69412);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(69413);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(69413);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(69414);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(69414);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(69415);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(69415);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(69416);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(69416);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(69419);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(69419);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(69420);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(69420);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(69421);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(69421);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(69422);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(69422);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(69423);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(69423);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(69424);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(69424);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(69425);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(69425);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(69426);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(69426);
        return zzgg;
    }

    public final void zzh(long j) {
        AppMethodBeat.m2504i(69402);
        zzch();
        if (!zzgb.zza(getContext())) {
            zzge().zzis().log("Receiver not registered/enabled");
        }
        if (!zzjc.zza(getContext(), false)) {
            zzge().zzis().log("Service not registered/enabled");
        }
        cancel();
        long elapsedRealtime = zzbt().elapsedRealtime() + j;
        if (j < Math.max(0, ((Long) zzew.zzahf.get()).longValue()) && !this.zzapy.zzef()) {
            zzge().zzit().log("Scheduling upload with DelayedRunnable");
            this.zzapy.zzh(j);
        }
        if (VERSION.SDK_INT >= 24) {
            zzge().zzit().log("Scheduling upload with JobScheduler");
            JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
            Builder builder = new Builder(getJobId(), new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            zzge().zzit().zzg("Scheduling job. JobID", Integer.valueOf(getJobId()));
            jobScheduler.schedule(build);
            AppMethodBeat.m2505o(69402);
            return;
        }
        zzge().zzit().log("Scheduling upload with AlarmManager");
        this.zzyi.setInexactRepeating(2, elapsedRealtime, Math.max(((Long) zzew.zzaha.get()).longValue(), j), zzek());
        AppMethodBeat.m2505o(69402);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        AppMethodBeat.m2504i(69400);
        this.zzyi.cancel(zzek());
        if (VERSION.SDK_INT >= 24) {
            zzkl();
        }
        AppMethodBeat.m2505o(69400);
        return false;
    }

    public final /* bridge */ /* synthetic */ zzeb zziw() {
        AppMethodBeat.m2504i(69406);
        zzeb zziw = super.zziw();
        AppMethodBeat.m2505o(69406);
        return zziw;
    }

    public final /* bridge */ /* synthetic */ zzei zzix() {
        AppMethodBeat.m2504i(69407);
        zzei zzix = super.zzix();
        AppMethodBeat.m2505o(69407);
        return zzix;
    }
}
