package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzeo extends zzhh {
    private long zzafm;
    private String zzafn;
    private Boolean zzafo;

    zzeo(zzgl zzgl) {
        super(zzgl);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(68712);
        Context context = super.getContext();
        AppMethodBeat.m2505o(68712);
        return context;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(68704);
        super.zzab();
        AppMethodBeat.m2505o(68704);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(68711);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(68711);
        return zzbt;
    }

    public final boolean zzf(Context context) {
        AppMethodBeat.m2504i(68701);
        if (this.zzafo == null) {
            this.zzafo = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.zzafo = Boolean.TRUE;
                }
            } catch (NameNotFoundException e) {
            }
        }
        boolean booleanValue = this.zzafo.booleanValue();
        AppMethodBeat.m2505o(68701);
        return booleanValue;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(68702);
        super.zzfr();
        AppMethodBeat.m2505o(68702);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(68703);
        super.zzfs();
        AppMethodBeat.m2505o(68703);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(68705);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(68705);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(68706);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(68706);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(68707);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(68707);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(68708);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(68708);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(68709);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(68709);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(68710);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(68710);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(68713);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(68713);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(68714);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(68714);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(68715);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(68715);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(68716);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(68716);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(68717);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(68717);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(68718);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(68718);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(68719);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(68719);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(68720);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(68720);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        AppMethodBeat.m2504i(68698);
        Calendar instance = Calendar.getInstance();
        this.zzafm = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String toLowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String toLowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        this.zzafn = new StringBuilder((String.valueOf(toLowerCase).length() + 1) + String.valueOf(toLowerCase2).length()).append(toLowerCase).append("-").append(toLowerCase2).toString();
        AppMethodBeat.m2505o(68698);
        return false;
    }

    public final long zzic() {
        AppMethodBeat.m2504i(68699);
        zzch();
        long j = this.zzafm;
        AppMethodBeat.m2505o(68699);
        return j;
    }

    public final String zzid() {
        AppMethodBeat.m2504i(68700);
        zzch();
        String str = this.zzafn;
        AppMethodBeat.m2505o(68700);
        return str;
    }
}
