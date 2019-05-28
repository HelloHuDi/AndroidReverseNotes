package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.p057v4.p065f.C6197a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class zzdu extends zzhg {
    private final Map<String, Long> zzadf = new C6197a();
    private final Map<String, Integer> zzadg = new C6197a();
    private long zzadh;

    public zzdu(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.m2504i(68491);
        AppMethodBeat.m2505o(68491);
    }

    private final void zza(long j, zzie zzie) {
        AppMethodBeat.m2504i(68496);
        if (zzie == null) {
            zzge().zzit().log("Not logging ad exposure. No active activity");
            AppMethodBeat.m2505o(68496);
        } else if (j < 1000) {
            zzge().zzit().zzg("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            AppMethodBeat.m2505o(68496);
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzif.zza(zzie, bundle, true);
            zzfu().logEvent("am", "_xa", bundle);
            AppMethodBeat.m2505o(68496);
        }
    }

    private final void zza(String str, long j) {
        AppMethodBeat.m2504i(68493);
        zzab();
        Preconditions.checkNotEmpty(str);
        if (this.zzadg.isEmpty()) {
            this.zzadh = j;
        }
        Integer num = (Integer) this.zzadg.get(str);
        if (num != null) {
            this.zzadg.put(str, Integer.valueOf(num.intValue() + 1));
            AppMethodBeat.m2505o(68493);
        } else if (this.zzadg.size() >= 100) {
            zzge().zzip().log("Too many ads visible");
            AppMethodBeat.m2505o(68493);
        } else {
            this.zzadg.put(str, Integer.valueOf(1));
            this.zzadf.put(str, Long.valueOf(j));
            AppMethodBeat.m2505o(68493);
        }
    }

    private final void zza(String str, long j, zzie zzie) {
        AppMethodBeat.m2504i(68497);
        if (zzie == null) {
            zzge().zzit().log("Not logging ad unit exposure. No active activity");
            AppMethodBeat.m2505o(68497);
        } else if (j < 1000) {
            zzge().zzit().zzg("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            AppMethodBeat.m2505o(68497);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzif.zza(zzie, bundle, true);
            zzfu().logEvent("am", "_xu", bundle);
            AppMethodBeat.m2505o(68497);
        }
    }

    static /* synthetic */ void zzb(zzdu zzdu, String str, long j) {
        AppMethodBeat.m2504i(68520);
        zzdu.zzb(str, j);
        AppMethodBeat.m2505o(68520);
    }

    private final void zzb(String str, long j) {
        AppMethodBeat.m2504i(68495);
        zzab();
        Preconditions.checkNotEmpty(str);
        Integer num = (Integer) this.zzadg.get(str);
        if (num != null) {
            zzie zzkc = zzfy().zzkc();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zzadg.remove(str);
                Long l = (Long) this.zzadf.get(str);
                if (l == null) {
                    zzge().zzim().log("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.zzadf.remove(str);
                    zza(str, longValue, zzkc);
                }
                if (this.zzadg.isEmpty()) {
                    if (this.zzadh == 0) {
                        zzge().zzim().log("First ad exposure time was never set");
                        AppMethodBeat.m2505o(68495);
                        return;
                    }
                    zza(j - this.zzadh, zzkc);
                    this.zzadh = 0;
                }
                AppMethodBeat.m2505o(68495);
                return;
            }
            this.zzadg.put(str, Integer.valueOf(intValue));
            AppMethodBeat.m2505o(68495);
            return;
        }
        zzge().zzim().zzg("Call to endAdUnitExposure for unknown ad unit id", str);
        AppMethodBeat.m2505o(68495);
    }

    private final void zzl(long j) {
        AppMethodBeat.m2504i(68499);
        for (String put : this.zzadf.keySet()) {
            this.zzadf.put(put, Long.valueOf(j));
        }
        if (!this.zzadf.isEmpty()) {
            this.zzadh = j;
        }
        AppMethodBeat.m2505o(68499);
    }

    public final void beginAdUnitExposure(String str) {
        AppMethodBeat.m2504i(68492);
        if (str == null || str.length() == 0) {
            zzge().zzim().log("Ad unit id must be a non-empty string");
            AppMethodBeat.m2505o(68492);
            return;
        }
        zzgd().zzc(new zzdv(this, str, zzbt().elapsedRealtime()));
        AppMethodBeat.m2505o(68492);
    }

    public final void endAdUnitExposure(String str) {
        AppMethodBeat.m2504i(68494);
        if (str == null || str.length() == 0) {
            zzge().zzim().log("Ad unit id must be a non-empty string");
            AppMethodBeat.m2505o(68494);
            return;
        }
        zzgd().zzc(new zzdw(this, str, zzbt().elapsedRealtime()));
        AppMethodBeat.m2505o(68494);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(68510);
        Context context = super.getContext();
        AppMethodBeat.m2505o(68510);
        return context;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(68502);
        super.zzab();
        AppMethodBeat.m2505o(68502);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(68509);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(68509);
        return zzbt;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(68500);
        super.zzfr();
        AppMethodBeat.m2505o(68500);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(68501);
        super.zzfs();
        AppMethodBeat.m2505o(68501);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(68503);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(68503);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(68504);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(68504);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(68505);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(68505);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(68506);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(68506);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(68507);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(68507);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(68508);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(68508);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(68511);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(68511);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(68512);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(68512);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(68513);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(68513);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(68514);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(68514);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(68515);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(68515);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(68516);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(68516);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(68517);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(68517);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(68518);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(68518);
        return zzgg;
    }

    public final void zzk(long j) {
        AppMethodBeat.m2504i(68498);
        zzie zzkc = zzfy().zzkc();
        for (String str : this.zzadf.keySet()) {
            zza(str, j - ((Long) this.zzadf.get(str)).longValue(), zzkc);
        }
        if (!this.zzadf.isEmpty()) {
            zza(j - this.zzadh, zzkc);
        }
        zzl(j);
        AppMethodBeat.m2505o(68498);
    }
}
