package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzjh extends zzhh {
    private Handler handler;
    @VisibleForTesting
    private long zzapu = zzbt().elapsedRealtime();
    private final zzem zzapv = new zzji(this, this.zzacw);
    private final zzem zzapw = new zzjj(this, this.zzacw);

    zzjh(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.m2504i(69363);
        AppMethodBeat.m2505o(69363);
    }

    static /* synthetic */ void zza(zzjh zzjh) {
        AppMethodBeat.m2504i(69389);
        zzjh.zzkk();
        AppMethodBeat.m2505o(69389);
    }

    static /* synthetic */ void zza(zzjh zzjh, long j) {
        AppMethodBeat.m2504i(69390);
        zzjh.zzaf(j);
        AppMethodBeat.m2505o(69390);
    }

    private final void zzaf(long j) {
        AppMethodBeat.m2504i(69366);
        zzab();
        zzki();
        this.zzapv.cancel();
        this.zzapw.cancel();
        zzge().zzit().zzg("Activity resumed, time", Long.valueOf(j));
        this.zzapu = j;
        if (zzbt().currentTimeMillis() - zzgf().zzakj.get() > zzgf().zzakl.get()) {
            zzgf().zzakk.set(true);
            zzgf().zzakm.set(0);
        }
        if (zzgf().zzakk.get()) {
            this.zzapv.zzh(Math.max(0, zzgf().zzaki.get() - zzgf().zzakm.get()));
            AppMethodBeat.m2505o(69366);
            return;
        }
        this.zzapw.zzh(Math.max(0, 3600000 - zzgf().zzakm.get()));
        AppMethodBeat.m2505o(69366);
    }

    private final void zzag(long j) {
        AppMethodBeat.m2504i(69367);
        zzab();
        zzki();
        this.zzapv.cancel();
        this.zzapw.cancel();
        zzge().zzit().zzg("Activity paused, time", Long.valueOf(j));
        if (this.zzapu != 0) {
            zzgf().zzakm.set(zzgf().zzakm.get() + (j - this.zzapu));
        }
        AppMethodBeat.m2505o(69367);
    }

    static /* synthetic */ void zzb(zzjh zzjh, long j) {
        AppMethodBeat.m2504i(69391);
        zzjh.zzag(j);
        AppMethodBeat.m2505o(69391);
    }

    private final void zzki() {
        AppMethodBeat.m2504i(69364);
        synchronized (this) {
            try {
                if (this.handler == null) {
                    this.handler = new Handler(Looper.getMainLooper());
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(69364);
            }
        }
    }

    private final void zzkk() {
        AppMethodBeat.m2504i(69369);
        zzab();
        zzl(false);
        zzft().zzk(zzbt().elapsedRealtime());
        AppMethodBeat.m2505o(69369);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(69380);
        Context context = super.getContext();
        AppMethodBeat.m2505o(69380);
        return context;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(69372);
        super.zzab();
        AppMethodBeat.m2505o(69372);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(69379);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(69379);
        return zzbt;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(69370);
        super.zzfr();
        AppMethodBeat.m2505o(69370);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(69371);
        super.zzfs();
        AppMethodBeat.m2505o(69371);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(69373);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(69373);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(69374);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(69374);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(69375);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(69375);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(69376);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(69376);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(69377);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(69377);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(69378);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(69378);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(69381);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(69381);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(69382);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(69382);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(69383);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(69383);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(69384);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(69384);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(69385);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(69385);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(69386);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(69386);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(69387);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(69387);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(69388);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(69388);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void zzkj() {
        AppMethodBeat.m2504i(69365);
        this.zzapv.cancel();
        this.zzapw.cancel();
        this.zzapu = 0;
        AppMethodBeat.m2505o(69365);
    }

    public final boolean zzl(boolean z) {
        AppMethodBeat.m2504i(69368);
        zzab();
        zzch();
        long elapsedRealtime = zzbt().elapsedRealtime();
        zzgf().zzakl.set(zzbt().currentTimeMillis());
        long j = elapsedRealtime - this.zzapu;
        if (z || j >= 1000) {
            zzgf().zzakm.set(j);
            zzge().zzit().zzg("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzif.zza(zzfy().zzkc(), bundle, true);
            zzfu().logEvent("auto", "_e", bundle);
            this.zzapu = elapsedRealtime;
            this.zzapw.cancel();
            this.zzapw.zzh(Math.max(0, 3600000 - zzgf().zzakm.get()));
            AppMethodBeat.m2505o(69368);
            return true;
        }
        zzge().zzit().zzg("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        AppMethodBeat.m2505o(69368);
        return false;
    }
}
