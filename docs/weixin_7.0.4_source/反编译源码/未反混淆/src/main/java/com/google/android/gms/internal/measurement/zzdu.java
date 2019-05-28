package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.f.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class zzdu extends zzhg {
    private final Map<String, Long> zzadf = new a();
    private final Map<String, Integer> zzadg = new a();
    private long zzadh;

    public zzdu(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(68491);
        AppMethodBeat.o(68491);
    }

    private final void zza(long j, zzie zzie) {
        AppMethodBeat.i(68496);
        if (zzie == null) {
            zzge().zzit().log("Not logging ad exposure. No active activity");
            AppMethodBeat.o(68496);
        } else if (j < 1000) {
            zzge().zzit().zzg("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            AppMethodBeat.o(68496);
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzif.zza(zzie, bundle, true);
            zzfu().logEvent("am", "_xa", bundle);
            AppMethodBeat.o(68496);
        }
    }

    private final void zza(String str, long j) {
        AppMethodBeat.i(68493);
        zzab();
        Preconditions.checkNotEmpty(str);
        if (this.zzadg.isEmpty()) {
            this.zzadh = j;
        }
        Integer num = (Integer) this.zzadg.get(str);
        if (num != null) {
            this.zzadg.put(str, Integer.valueOf(num.intValue() + 1));
            AppMethodBeat.o(68493);
        } else if (this.zzadg.size() >= 100) {
            zzge().zzip().log("Too many ads visible");
            AppMethodBeat.o(68493);
        } else {
            this.zzadg.put(str, Integer.valueOf(1));
            this.zzadf.put(str, Long.valueOf(j));
            AppMethodBeat.o(68493);
        }
    }

    private final void zza(String str, long j, zzie zzie) {
        AppMethodBeat.i(68497);
        if (zzie == null) {
            zzge().zzit().log("Not logging ad unit exposure. No active activity");
            AppMethodBeat.o(68497);
        } else if (j < 1000) {
            zzge().zzit().zzg("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            AppMethodBeat.o(68497);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzif.zza(zzie, bundle, true);
            zzfu().logEvent("am", "_xu", bundle);
            AppMethodBeat.o(68497);
        }
    }

    static /* synthetic */ void zzb(zzdu zzdu, String str, long j) {
        AppMethodBeat.i(68520);
        zzdu.zzb(str, j);
        AppMethodBeat.o(68520);
    }

    private final void zzb(String str, long j) {
        AppMethodBeat.i(68495);
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
                        AppMethodBeat.o(68495);
                        return;
                    }
                    zza(j - this.zzadh, zzkc);
                    this.zzadh = 0;
                }
                AppMethodBeat.o(68495);
                return;
            }
            this.zzadg.put(str, Integer.valueOf(intValue));
            AppMethodBeat.o(68495);
            return;
        }
        zzge().zzim().zzg("Call to endAdUnitExposure for unknown ad unit id", str);
        AppMethodBeat.o(68495);
    }

    private final void zzl(long j) {
        AppMethodBeat.i(68499);
        for (String put : this.zzadf.keySet()) {
            this.zzadf.put(put, Long.valueOf(j));
        }
        if (!this.zzadf.isEmpty()) {
            this.zzadh = j;
        }
        AppMethodBeat.o(68499);
    }

    public final void beginAdUnitExposure(String str) {
        AppMethodBeat.i(68492);
        if (str == null || str.length() == 0) {
            zzge().zzim().log("Ad unit id must be a non-empty string");
            AppMethodBeat.o(68492);
            return;
        }
        zzgd().zzc(new zzdv(this, str, zzbt().elapsedRealtime()));
        AppMethodBeat.o(68492);
    }

    public final void endAdUnitExposure(String str) {
        AppMethodBeat.i(68494);
        if (str == null || str.length() == 0) {
            zzge().zzim().log("Ad unit id must be a non-empty string");
            AppMethodBeat.o(68494);
            return;
        }
        zzgd().zzc(new zzdw(this, str, zzbt().elapsedRealtime()));
        AppMethodBeat.o(68494);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(68510);
        Context context = super.getContext();
        AppMethodBeat.o(68510);
        return context;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(68502);
        super.zzab();
        AppMethodBeat.o(68502);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(68509);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(68509);
        return zzbt;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(68500);
        super.zzfr();
        AppMethodBeat.o(68500);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(68501);
        super.zzfs();
        AppMethodBeat.o(68501);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(68503);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(68503);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(68504);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(68504);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(68505);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(68505);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(68506);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(68506);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(68507);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(68507);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(68508);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(68508);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(68511);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(68511);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(68512);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(68512);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(68513);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(68513);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(68514);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(68514);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(68515);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(68515);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(68516);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(68516);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(68517);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(68517);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(68518);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(68518);
        return zzgg;
    }

    public final void zzk(long j) {
        AppMethodBeat.i(68498);
        zzie zzkc = zzfy().zzkc();
        for (String str : this.zzadf.keySet()) {
            zza(str, j - ((Long) this.zzadf.get(str)).longValue(), zzkc);
        }
        if (!this.zzadf.isEmpty()) {
            zza(j - this.zzadh, zzkc);
        }
        zzl(j);
        AppMethodBeat.o(68498);
    }
}
