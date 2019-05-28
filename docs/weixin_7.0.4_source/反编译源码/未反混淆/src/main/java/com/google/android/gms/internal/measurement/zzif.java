package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.f.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Map;

public final class zzif extends zzhh {
    @VisibleForTesting
    protected zzie zzaol;
    private volatile zzie zzaom;
    private zzie zzaon;
    private long zzaoo;
    private final Map<Activity, zzie> zzaop = new a();
    private zzie zzaoq;
    private String zzaor;

    public zzif(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(69240);
        AppMethodBeat.o(69240);
    }

    private final void zza(Activity activity, zzie zzie, boolean z) {
        AppMethodBeat.i(69243);
        zzie zzie2 = this.zzaom == null ? this.zzaon : this.zzaom;
        if (zzie.zzaoi == null) {
            zzie = new zzie(zzie.zzul, zzca(activity.getClass().getCanonicalName()), zzie.zzaoj);
        }
        this.zzaon = this.zzaom;
        this.zzaoo = zzbt().elapsedRealtime();
        this.zzaom = zzie;
        zzgd().zzc(new zzig(this, z, zzie2, zzie));
        AppMethodBeat.o(69243);
    }

    private final void zza(zzie zzie) {
        AppMethodBeat.i(69244);
        zzft().zzk(zzbt().elapsedRealtime());
        if (zzgc().zzl(zzie.zzaok)) {
            zzie.zzaok = false;
        }
        AppMethodBeat.o(69244);
    }

    public static void zza(zzie zzie, Bundle bundle, boolean z) {
        AppMethodBeat.i(69245);
        if (bundle == null || zzie == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && zzie == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
            }
            AppMethodBeat.o(69245);
            return;
        }
        if (zzie.zzul != null) {
            bundle.putString("_sn", zzie.zzul);
        } else {
            bundle.remove("_sn");
        }
        bundle.putString("_sc", zzie.zzaoi);
        bundle.putLong("_si", zzie.zzaoj);
        AppMethodBeat.o(69245);
    }

    @VisibleForTesting
    private static String zzca(String str) {
        AppMethodBeat.i(69247);
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        if (str2.length() > 100) {
            str2 = str2.substring(0, 100);
            AppMethodBeat.o(69247);
            return str2;
        }
        AppMethodBeat.o(69247);
        return str2;
    }

    private final zzie zze(Activity activity) {
        AppMethodBeat.i(69248);
        Preconditions.checkNotNull(activity);
        zzie zzie = (zzie) this.zzaop.get(activity);
        if (zzie == null) {
            zzie = new zzie(null, zzca(activity.getClass().getCanonicalName()), zzgb().zzlb());
            this.zzaop.put(activity, zzie);
        }
        AppMethodBeat.o(69248);
        return zzie;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(69264);
        Context context = super.getContext();
        AppMethodBeat.o(69264);
        return context;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69249);
        if (bundle == null) {
            AppMethodBeat.o(69249);
            return;
        }
        Bundle bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service");
        if (bundle2 == null) {
            AppMethodBeat.o(69249);
            return;
        }
        this.zzaop.put(activity, new zzie(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        AppMethodBeat.o(69249);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(69253);
        this.zzaop.remove(activity);
        AppMethodBeat.o(69253);
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.i(69251);
        zzie zze = zze(activity);
        this.zzaon = this.zzaom;
        this.zzaoo = zzbt().elapsedRealtime();
        this.zzaom = null;
        zzgd().zzc(new zzih(this, zze));
        AppMethodBeat.o(69251);
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(69250);
        zza(activity, zze(activity), false);
        zzdu zzft = zzft();
        zzft.zzgd().zzc(new zzdx(zzft, zzft.zzbt().elapsedRealtime()));
        AppMethodBeat.o(69250);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AppMethodBeat.i(69252);
        if (bundle == null) {
            AppMethodBeat.o(69252);
            return;
        }
        zzie zzie = (zzie) this.zzaop.get(activity);
        if (zzie == null) {
            AppMethodBeat.o(69252);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzie.zzaoj);
        bundle2.putString("name", zzie.zzul);
        bundle2.putString("referrer_name", zzie.zzaoi);
        bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
        AppMethodBeat.o(69252);
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        AppMethodBeat.i(69242);
        zzgd();
        if (!zzgg.isMainThread()) {
            zzge().zzip().log("setCurrentScreen must be called from the main thread");
            AppMethodBeat.o(69242);
        } else if (this.zzaom == null) {
            zzge().zzip().log("setCurrentScreen cannot be called while no activity active");
            AppMethodBeat.o(69242);
        } else if (this.zzaop.get(activity) == null) {
            zzge().zzip().log("setCurrentScreen must be called with an activity in the activity lifecycle");
            AppMethodBeat.o(69242);
        } else {
            Object str22;
            if (str22 == null) {
                str22 = zzca(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzaom.zzaoi.equals(str22);
            boolean zzs = zzka.zzs(this.zzaom.zzul, str);
            if (equals && zzs) {
                zzge().zziq().log("setCurrentScreen cannot be called with the same class and name");
                AppMethodBeat.o(69242);
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzge().zzip().zzg("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
                AppMethodBeat.o(69242);
            } else if (str22 == null || (str22.length() > 0 && str22.length() <= 100)) {
                Object obj;
                zzfi zzit = zzge().zzit();
                String str3 = "Setting current screen to name, class";
                if (str == null) {
                    obj = BuildConfig.COMMAND;
                } else {
                    String obj2 = str;
                }
                zzit.zze(str3, obj2, str22);
                zzie zzie = new zzie(str, str22, zzgb().zzlb());
                this.zzaop.put(activity, zzie);
                zza(activity, zzie, true);
                AppMethodBeat.o(69242);
            } else {
                zzge().zzip().zzg("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str22.length()));
                AppMethodBeat.o(69242);
            }
        }
    }

    public final void zza(String str, zzie zzie) {
        AppMethodBeat.i(69246);
        zzab();
        synchronized (this) {
            try {
                if (this.zzaor == null || this.zzaor.equals(str) || zzie != null) {
                    this.zzaor = str;
                    this.zzaoq = zzie;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(69246);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(69256);
        super.zzab();
        AppMethodBeat.o(69256);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(69263);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(69263);
        return zzbt;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(69254);
        super.zzfr();
        AppMethodBeat.o(69254);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(69255);
        super.zzfs();
        AppMethodBeat.o(69255);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(69257);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(69257);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(69258);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(69258);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(69259);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(69259);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(69260);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(69260);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(69261);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(69261);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(69262);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(69262);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(69265);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(69265);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(69266);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(69266);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(69267);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(69267);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(69268);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(69268);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(69269);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(69269);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(69270);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(69270);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(69271);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(69271);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(69272);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(69272);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    public final zzie zzkc() {
        AppMethodBeat.i(69241);
        zzch();
        zzab();
        zzie zzie = this.zzaol;
        AppMethodBeat.o(69241);
        return zzie;
    }

    public final zzie zzkd() {
        return this.zzaom;
    }
}
