package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.p057v4.p065f.C6197a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.firebase.analytics.FirebaseAnalytics.C8740a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Map;

public final class zzgf extends zzjq implements zzeh {
    @VisibleForTesting
    private static int zzalf = CdnLogic.kBizGeneric;
    @VisibleForTesting
    private static int zzalg = 2;
    private final Map<String, Map<String, String>> zzalh = new C6197a();
    private final Map<String, Map<String, Boolean>> zzali = new C6197a();
    private final Map<String, Map<String, Boolean>> zzalj = new C6197a();
    private final Map<String, zzkk> zzalk = new C6197a();
    private final Map<String, Map<String, Integer>> zzall = new C6197a();
    private final Map<String, String> zzalm = new C6197a();

    zzgf(zzjr zzjr) {
        super(zzjr);
        AppMethodBeat.m2504i(68986);
        AppMethodBeat.m2505o(68986);
    }

    private final zzkk zza(String str, byte[] bArr) {
        AppMethodBeat.m2504i(68999);
        zzkk zzkk;
        if (bArr == null) {
            zzkk = new zzkk();
            AppMethodBeat.m2505o(68999);
            return zzkk;
        }
        zzabv zza = zzabv.zza(bArr, 0, bArr.length);
        zzkk = new zzkk();
        try {
            zzkk.zzb(zza);
            zzge().zzit().zze("Parsed config. version, gmp_app_id", zzkk.zzasp, zzkk.zzadm);
            AppMethodBeat.m2505o(68999);
            return zzkk;
        } catch (IOException e) {
            zzge().zzip().zze("Unable to merge remote config. appId", zzfg.zzbm(str), e);
            zzkk = new zzkk();
            AppMethodBeat.m2505o(68999);
            return zzkk;
        }
    }

    private static Map<String, String> zza(zzkk zzkk) {
        AppMethodBeat.m2504i(68993);
        C6197a c6197a = new C6197a();
        if (!(zzkk == null || zzkk.zzasr == null)) {
            for (zzkl zzkl : zzkk.zzasr) {
                if (zzkl != null) {
                    c6197a.put(zzkl.zzny, zzkl.value);
                }
            }
        }
        AppMethodBeat.m2505o(68993);
        return c6197a;
    }

    private final void zza(String str, zzkk zzkk) {
        AppMethodBeat.m2504i(68994);
        C6197a c6197a = new C6197a();
        C6197a c6197a2 = new C6197a();
        C6197a c6197a3 = new C6197a();
        if (!(zzkk == null || zzkk.zzass == null)) {
            for (zzkj zzkj : zzkk.zzass) {
                if (TextUtils.isEmpty(zzkj.name)) {
                    zzge().zzip().log("EventConfig contained null event name");
                } else {
                    String zzak = Event.zzak(zzkj.name);
                    if (!TextUtils.isEmpty(zzak)) {
                        zzkj.name = zzak;
                    }
                    c6197a.put(zzkj.name, zzkj.zzasm);
                    c6197a2.put(zzkj.name, zzkj.zzasn);
                    if (zzkj.zzaso != null) {
                        if (zzkj.zzaso.intValue() < zzalg || zzkj.zzaso.intValue() > zzalf) {
                            zzge().zzip().zze("Invalid sampling rate. Event name, sample rate", zzkj.name, zzkj.zzaso);
                        } else {
                            c6197a3.put(zzkj.name, zzkj.zzaso);
                        }
                    }
                }
            }
        }
        this.zzali.put(str, c6197a);
        this.zzalj.put(str, c6197a2);
        this.zzall.put(str, c6197a3);
        AppMethodBeat.m2505o(68994);
    }

    private final void zzbt(String str) {
        AppMethodBeat.m2504i(68987);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        if (this.zzalk.get(str) == null) {
            byte[] zzbe = zzix().zzbe(str);
            if (zzbe == null) {
                this.zzalh.put(str, null);
                this.zzali.put(str, null);
                this.zzalj.put(str, null);
                this.zzalk.put(str, null);
                this.zzalm.put(str, null);
                this.zzall.put(str, null);
                AppMethodBeat.m2505o(68987);
                return;
            }
            zzkk zza = zza(str, zzbe);
            this.zzalh.put(str, zza(zza));
            zza(str, zza);
            this.zzalk.put(str, zza);
            this.zzalm.put(str, null);
        }
        AppMethodBeat.m2505o(68987);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.m2504i(69014);
        Context context = super.getContext();
        AppMethodBeat.m2505o(69014);
        return context;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zza(String str, byte[] bArr, String str2) {
        AppMethodBeat.m2504i(68995);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        zzkk zza = zza(str, bArr);
        if (zza == null) {
            AppMethodBeat.m2505o(68995);
            return false;
        }
        zza(str, zza);
        this.zzalk.put(str, zza);
        this.zzalm.put(str, str2);
        this.zzalh.put(str, zza(zza));
        zzeb zziw = zziw();
        zzkd[] zzkdArr = zza.zzast;
        Preconditions.checkNotNull(zzkdArr);
        for (zzkd zzkd : zzkdArr) {
            for (zzke zzke : zzkd.zzarn) {
                String zzak = Event.zzak(zzke.zzarq);
                if (zzak != null) {
                    zzke.zzarq = zzak;
                }
                for (zzkf zzkf : zzke.zzarr) {
                    String zzak2 = Param.zzak(zzkf.zzary);
                    if (zzak2 != null) {
                        zzkf.zzary = zzak2;
                    }
                }
            }
            for (zzkh zzkh : zzkd.zzarm) {
                String zzak3 = UserProperty.zzak(zzkh.zzasf);
                if (zzak3 != null) {
                    zzkh.zzasf = zzak3;
                }
            }
        }
        zziw.zzix().zza(str, zzkdArr);
        try {
            zza.zzast = null;
            byte[] bArr2 = new byte[zza.zzvm()];
            zza.zza(zzabw.zzb(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e) {
            zzge().zzip().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzfg.zzbm(str), e);
        }
        zzei zzix = zzix();
        Preconditions.checkNotEmpty(str);
        zzix.zzab();
        zzix.zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzix.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzix.zzge().zzim().zzg("Failed to update remote config (got 0). appId", zzfg.zzbm(str));
            }
        } catch (SQLiteException e2) {
            zzix.zzge().zzim().zze("Error storing remote config. appId", zzfg.zzbm(str), e2);
        }
        AppMethodBeat.m2505o(68995);
        return true;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.m2504i(69006);
        super.zzab();
        AppMethodBeat.m2505o(69006);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.m2504i(69013);
        Clock zzbt = super.zzbt();
        AppMethodBeat.m2505o(69013);
        return zzbt;
    }

    /* Access modifiers changed, original: protected|final */
    public final zzkk zzbu(String str) {
        AppMethodBeat.m2504i(68988);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        zzbt(str);
        zzkk zzkk = (zzkk) this.zzalk.get(str);
        AppMethodBeat.m2505o(68988);
        return zzkk;
    }

    /* Access modifiers changed, original: protected|final */
    public final String zzbv(String str) {
        AppMethodBeat.m2504i(68989);
        zzab();
        String str2 = (String) this.zzalm.get(str);
        AppMethodBeat.m2505o(68989);
        return str2;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzbw(String str) {
        AppMethodBeat.m2504i(68990);
        zzab();
        this.zzalm.put(str, null);
        AppMethodBeat.m2505o(68990);
    }

    /* Access modifiers changed, original: final */
    public final void zzbx(String str) {
        AppMethodBeat.m2504i(68991);
        zzab();
        this.zzalk.remove(str);
        AppMethodBeat.m2505o(68991);
    }

    /* Access modifiers changed, original: final */
    public final boolean zzby(String str) {
        AppMethodBeat.m2504i(69000);
        boolean equals = "1".equals(zze(str, "measurement.upload.blacklist_internal"));
        AppMethodBeat.m2505o(69000);
        return equals;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzbz(String str) {
        AppMethodBeat.m2504i(69001);
        boolean equals = "1".equals(zze(str, "measurement.upload.blacklist_public"));
        AppMethodBeat.m2505o(69001);
        return equals;
    }

    public final String zze(String str, String str2) {
        AppMethodBeat.m2504i(68992);
        zzab();
        zzbt(str);
        Map map = (Map) this.zzalh.get(str);
        if (map != null) {
            String str3 = (String) map.get(str2);
            AppMethodBeat.m2505o(68992);
            return str3;
        }
        AppMethodBeat.m2505o(68992);
        return null;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.m2504i(69004);
        super.zzfr();
        AppMethodBeat.m2505o(69004);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.m2504i(69005);
        super.zzfs();
        AppMethodBeat.m2505o(69005);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.m2504i(69007);
        zzdu zzft = super.zzft();
        AppMethodBeat.m2505o(69007);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.m2504i(69008);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.m2505o(69008);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.m2504i(69009);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.m2505o(69009);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.m2504i(69010);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.m2505o(69010);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.m2504i(69011);
        zzii zzfx = super.zzfx();
        AppMethodBeat.m2505o(69011);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.m2504i(69012);
        zzif zzfy = super.zzfy();
        AppMethodBeat.m2505o(69012);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.m2504i(69015);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.m2505o(69015);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.m2504i(69016);
        zzfe zzga = super.zzga();
        AppMethodBeat.m2505o(69016);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.m2504i(69017);
        zzka zzgb = super.zzgb();
        AppMethodBeat.m2505o(69017);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.m2504i(69018);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.m2505o(69018);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.m2504i(69019);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.m2505o(69019);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.m2504i(69020);
        zzfg zzge = super.zzge();
        AppMethodBeat.m2505o(69020);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.m2504i(69021);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.m2505o(69021);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.m2504i(69022);
        zzef zzgg = super.zzgg();
        AppMethodBeat.m2505o(69022);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    public final /* bridge */ /* synthetic */ zzeb zziw() {
        AppMethodBeat.m2504i(69002);
        zzeb zziw = super.zziw();
        AppMethodBeat.m2505o(69002);
        return zziw;
    }

    public final /* bridge */ /* synthetic */ zzei zzix() {
        AppMethodBeat.m2504i(69003);
        zzei zzix = super.zzix();
        AppMethodBeat.m2505o(69003);
        return zzix;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzn(String str, String str2) {
        AppMethodBeat.m2504i(68996);
        zzab();
        zzbt(str);
        if (zzby(str) && zzka.zzci(str2)) {
            AppMethodBeat.m2505o(68996);
            return true;
        } else if (zzbz(str) && zzka.zzcc(str2)) {
            AppMethodBeat.m2505o(68996);
            return true;
        } else {
            Map map = (Map) this.zzali.get(str);
            if (map != null) {
                Boolean bool = (Boolean) map.get(str2);
                if (bool == null) {
                    AppMethodBeat.m2505o(68996);
                    return false;
                }
                boolean booleanValue = bool.booleanValue();
                AppMethodBeat.m2505o(68996);
                return booleanValue;
            }
            AppMethodBeat.m2505o(68996);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean zzo(String str, String str2) {
        AppMethodBeat.m2504i(68997);
        zzab();
        zzbt(str);
        if (C8740a.ECOMMERCE_PURCHASE.equals(str2)) {
            AppMethodBeat.m2505o(68997);
            return true;
        }
        Map map = (Map) this.zzalj.get(str);
        if (map != null) {
            Boolean bool = (Boolean) map.get(str2);
            if (bool == null) {
                AppMethodBeat.m2505o(68997);
                return false;
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.m2505o(68997);
            return booleanValue;
        }
        AppMethodBeat.m2505o(68997);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final int zzp(String str, String str2) {
        AppMethodBeat.m2504i(68998);
        zzab();
        zzbt(str);
        Map map = (Map) this.zzall.get(str);
        if (map != null) {
            Integer num = (Integer) map.get(str2);
            if (num == null) {
                AppMethodBeat.m2505o(68998);
                return 1;
            }
            int intValue = num.intValue();
            AppMethodBeat.m2505o(68998);
            return intValue;
        }
        AppMethodBeat.m2505o(68998);
        return 1;
    }
}
