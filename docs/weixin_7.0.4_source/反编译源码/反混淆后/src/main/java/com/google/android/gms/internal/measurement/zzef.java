package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;

public final class zzef extends zzhg {
    private zzeh zzaet = zzeg.zzaeu;
    private Boolean zzxz;

    zzef(zzgl zzgl) {
        super(zzgl);
    }

    public static long zzhh() {
        AppMethodBeat.m2504i(68604);
        long longValue = ((Long) zzew.zzahl.get()).longValue();
        AppMethodBeat.m2505o(68604);
        return longValue;
    }

    public static long zzhi() {
        AppMethodBeat.m2504i(68605);
        long longValue = ((Long) zzew.zzagl.get()).longValue();
        AppMethodBeat.m2505o(68605);
        return longValue;
    }

    public static boolean zzhk() {
        AppMethodBeat.m2504i(68607);
        boolean booleanValue = ((Boolean) zzew.zzagh.get()).booleanValue();
        AppMethodBeat.m2505o(68607);
        return booleanValue;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(68628);
        Context context = super.getContext();
        AppMethodBeat.m2505o(68628);
        return context;
    }

    public final long zza(String str, zzex<Long> zzex) {
        AppMethodBeat.m2504i(68598);
        long longValue;
        if (str == null) {
            longValue = ((Long) zzex.get()).longValue();
            AppMethodBeat.m2505o(68598);
            return longValue;
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            longValue = ((Long) zzex.get()).longValue();
            AppMethodBeat.m2505o(68598);
            return longValue;
        }
        try {
            longValue = ((Long) zzex.get(Long.valueOf(Long.parseLong(zze)))).longValue();
            AppMethodBeat.m2505o(68598);
            return longValue;
        } catch (NumberFormatException e) {
            longValue = ((Long) zzex.get()).longValue();
            AppMethodBeat.m2505o(68598);
            return longValue;
        }
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzeh zzeh) {
        this.zzaet = zzeh;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(68620);
        super.zzab();
        AppMethodBeat.m2505o(68620);
    }

    public final int zzar(String str) {
        AppMethodBeat.m2504i(68596);
        int zzb = zzb(str, zzew.zzagw);
        AppMethodBeat.m2505o(68596);
        return zzb;
    }

    /* Access modifiers changed, original: final */
    @VisibleForTesting
    public final Boolean zzas(String str) {
        Boolean bool = null;
        AppMethodBeat.m2504i(68602);
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzge().zzim().log("Failed to load metadata: PackageManager is null");
                AppMethodBeat.m2505o(68602);
            } else {
                ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
                if (applicationInfo == null) {
                    zzge().zzim().log("Failed to load metadata: ApplicationInfo is null");
                    AppMethodBeat.m2505o(68602);
                } else if (applicationInfo.metaData == null) {
                    zzge().zzim().log("Failed to load metadata: Metadata bundle is null");
                    AppMethodBeat.m2505o(68602);
                } else if (applicationInfo.metaData.containsKey(str)) {
                    bool = Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                    AppMethodBeat.m2505o(68602);
                } else {
                    AppMethodBeat.m2505o(68602);
                }
            }
        } catch (NameNotFoundException e) {
            zzge().zzim().zzg("Failed to load metadata: Package name not found", e);
            AppMethodBeat.m2505o(68602);
        }
        return bool;
    }

    public final boolean zzat(String str) {
        AppMethodBeat.m2504i(68608);
        boolean equals = "1".equals(this.zzaet.zze(str, "gaia_collection_enabled"));
        AppMethodBeat.m2505o(68608);
        return equals;
    }

    public final boolean zzau(String str) {
        AppMethodBeat.m2504i(68609);
        boolean equals = "1".equals(this.zzaet.zze(str, "measurement.event_sampling_enabled"));
        AppMethodBeat.m2505o(68609);
        return equals;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzav(String str) {
        AppMethodBeat.m2504i(68610);
        boolean zzd = zzd(str, zzew.zzahu);
        AppMethodBeat.m2505o(68610);
        return zzd;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzaw(String str) {
        AppMethodBeat.m2504i(68611);
        boolean zzd = zzd(str, zzew.zzahw);
        AppMethodBeat.m2505o(68611);
        return zzd;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzax(String str) {
        AppMethodBeat.m2504i(68612);
        boolean zzd = zzd(str, zzew.zzahx);
        AppMethodBeat.m2505o(68612);
        return zzd;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzay(String str) {
        AppMethodBeat.m2504i(68615);
        boolean zzd = zzd(str, zzew.zzahy);
        AppMethodBeat.m2505o(68615);
        return zzd;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzaz(String str) {
        AppMethodBeat.m2504i(68616);
        boolean zzd = zzd(str, zzew.zzahz);
        AppMethodBeat.m2505o(68616);
        return zzd;
    }

    public final int zzb(String str, zzex<Integer> zzex) {
        AppMethodBeat.m2504i(68599);
        int intValue;
        if (str == null) {
            intValue = ((Integer) zzex.get()).intValue();
            AppMethodBeat.m2505o(68599);
            return intValue;
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            intValue = ((Integer) zzex.get()).intValue();
            AppMethodBeat.m2505o(68599);
            return intValue;
        }
        try {
            intValue = ((Integer) zzex.get(Integer.valueOf(Integer.parseInt(zze)))).intValue();
            AppMethodBeat.m2505o(68599);
            return intValue;
        } catch (NumberFormatException e) {
            intValue = ((Integer) zzex.get()).intValue();
            AppMethodBeat.m2505o(68599);
            return intValue;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean zzba(String str) {
        AppMethodBeat.m2504i(68617);
        boolean zzd = zzd(str, zzew.zzaic);
        AppMethodBeat.m2505o(68617);
        return zzd;
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(68627);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(68627);
        return zzbt;
    }

    public final double zzc(String str, zzex<Double> zzex) {
        AppMethodBeat.m2504i(68600);
        double doubleValue;
        if (str == null) {
            doubleValue = ((Double) zzex.get()).doubleValue();
            AppMethodBeat.m2505o(68600);
            return doubleValue;
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            doubleValue = ((Double) zzex.get()).doubleValue();
            AppMethodBeat.m2505o(68600);
            return doubleValue;
        }
        try {
            doubleValue = ((Double) zzex.get(Double.valueOf(Double.parseDouble(zze)))).doubleValue();
            AppMethodBeat.m2505o(68600);
            return doubleValue;
        } catch (NumberFormatException e) {
            doubleValue = ((Double) zzex.get()).doubleValue();
            AppMethodBeat.m2505o(68600);
            return doubleValue;
        }
    }

    public final boolean zzd(String str, zzex<Boolean> zzex) {
        AppMethodBeat.m2504i(68601);
        boolean booleanValue;
        if (str == null) {
            booleanValue = ((Boolean) zzex.get()).booleanValue();
            AppMethodBeat.m2505o(68601);
            return booleanValue;
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            booleanValue = ((Boolean) zzex.get()).booleanValue();
            AppMethodBeat.m2505o(68601);
            return booleanValue;
        }
        booleanValue = ((Boolean) zzex.get(Boolean.valueOf(Boolean.parseBoolean(zze)))).booleanValue();
        AppMethodBeat.m2505o(68601);
        return booleanValue;
    }

    public final boolean zzds() {
        boolean z;
        AppMethodBeat.m2504i(68597);
        if (this.zzxz == null) {
            synchronized (this) {
                try {
                    if (this.zzxz == null) {
                        ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                        String myProcessName = ProcessUtils.getMyProcessName();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            z = str != null && str.equals(myProcessName);
                            this.zzxz = Boolean.valueOf(z);
                        }
                        if (this.zzxz == null) {
                            this.zzxz = Boolean.TRUE;
                            zzge().zzim().log("My process not in the list of running processes");
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(68597);
                    }
                }
            }
        }
        z = this.zzxz.booleanValue();
        AppMethodBeat.m2505o(68597);
        return z;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(68618);
        super.zzfr();
        AppMethodBeat.m2505o(68618);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(68619);
        super.zzfs();
        AppMethodBeat.m2505o(68619);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(68621);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(68621);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(68622);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(68622);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(68623);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(68623);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(68624);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(68624);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(68625);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(68625);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(68626);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(68626);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(68629);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(68629);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(68630);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(68630);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(68631);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(68631);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(68632);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(68632);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(68633);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(68633);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(68634);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(68634);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(68635);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(68635);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(68636);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(68636);
        return zzgg;
    }

    public final boolean zzhg() {
        AppMethodBeat.m2504i(68603);
        Boolean zzas = zzas("firebase_analytics_collection_deactivated");
        if (zzas == null || !zzas.booleanValue()) {
            AppMethodBeat.m2505o(68603);
            return false;
        }
        AppMethodBeat.m2505o(68603);
        return true;
    }

    public final String zzhj() {
        AppMethodBeat.m2504i(68606);
        String str;
        try {
            str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", ""});
            AppMethodBeat.m2505o(68606);
            return str;
        } catch (ClassNotFoundException e) {
            zzge().zzim().zzg("Could not find SystemProperties class", e);
            str = "";
            AppMethodBeat.m2505o(68606);
            return str;
        } catch (NoSuchMethodException e2) {
            zzge().zzim().zzg("Could not find SystemProperties.get() method", e2);
            str = "";
            AppMethodBeat.m2505o(68606);
            return str;
        } catch (IllegalAccessException e3) {
            zzge().zzim().zzg("Could not access SystemProperties.get()", e3);
            str = "";
            AppMethodBeat.m2505o(68606);
            return str;
        } catch (InvocationTargetException e4) {
            zzge().zzim().zzg("SystemProperties.get() threw an exception", e4);
            str = "";
            AppMethodBeat.m2505o(68606);
            return str;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean zzhl() {
        AppMethodBeat.m2504i(68613);
        boolean zzd = zzd(zzfv().zzah(), zzew.zzahp);
        AppMethodBeat.m2505o(68613);
        return zzd;
    }

    /* Access modifiers changed, original: final */
    public final String zzhm() {
        AppMethodBeat.m2504i(68614);
        String zzah = zzfv().zzah();
        zzex zzex = zzew.zzahq;
        if (zzah == null) {
            zzah = (String) zzex.get();
            AppMethodBeat.m2505o(68614);
            return zzah;
        }
        zzah = (String) zzex.get(this.zzaet.zze(zzah, zzex.getKey()));
        AppMethodBeat.m2505o(68614);
        return zzah;
    }
}
