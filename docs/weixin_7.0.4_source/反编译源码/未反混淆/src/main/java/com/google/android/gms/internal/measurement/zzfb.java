package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.widget.j;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.util.Locale;

public final class zzfb extends zzhh {
    private String zzadm;
    private String zzadt;
    private long zzadx;
    private int zzaen;
    private int zzaie;
    private long zzaif;
    private String zztg;
    private String zzth;
    private String zzti;

    zzfb(zzgl zzgl) {
        super(zzgl);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(68793);
        Context context = super.getContext();
        AppMethodBeat.o(68793);
        return context;
    }

    /* Access modifiers changed, original: final */
    public final String getGmpAppId() {
        AppMethodBeat.i(68780);
        zzch();
        String str = this.zzadm;
        AppMethodBeat.o(68780);
        return str;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(68785);
        super.zzab();
        AppMethodBeat.o(68785);
    }

    /* Access modifiers changed, original: final */
    public final String zzah() {
        AppMethodBeat.i(68779);
        zzch();
        String str = this.zzti;
        AppMethodBeat.o(68779);
        return str;
    }

    /* Access modifiers changed, original: final */
    public final zzdz zzbi(String str) {
        AppMethodBeat.i(68776);
        zzab();
        String zzah = zzah();
        String gmpAppId = getGmpAppId();
        zzch();
        String str2 = this.zzth;
        long zzij = (long) zzij();
        zzch();
        String str3 = this.zzadt;
        zzch();
        zzab();
        if (this.zzaif == 0) {
            this.zzaif = this.zzacw.zzgb().zzd(getContext(), getContext().getPackageName());
        }
        long j = this.zzaif;
        boolean isEnabled = this.zzacw.isEnabled();
        boolean z = !zzgf().zzakn;
        String zzgj = zzgj();
        zzch();
        long zzjt = this.zzacw.zzjt();
        int zzik = zzik();
        Boolean zzas = zzgg().zzas("google_analytics_adid_collection_enabled");
        boolean z2 = zzas == null || zzas.booleanValue();
        zzas = zzgg().zzas("google_analytics_ssaid_collection_enabled");
        boolean z3 = zzas == null || zzas.booleanValue();
        zzdz zzdz = new zzdz(zzah, gmpAppId, str2, zzij, str3, 12451, j, str, isEnabled, z, zzgj, 0, zzjt, zzik, z2, z3, zzgf().zzje());
        AppMethodBeat.o(68776);
        return zzdz;
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(68792);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(68792);
        return zzbt;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(68783);
        super.zzfr();
        AppMethodBeat.o(68783);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(68784);
        super.zzfs();
        AppMethodBeat.o(68784);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(68786);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(68786);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(68787);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(68787);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(68788);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(68788);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(68789);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(68789);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(68790);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(68790);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(68791);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(68791);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(68794);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(68794);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(68795);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(68795);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(68796);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(68796);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(68797);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(68797);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(68798);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(68798);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(68799);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(68799);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(68800);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(68800);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(68801);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(68801);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzih() {
        int i = 1;
        AppMethodBeat.i(68775);
        String str = "unknown";
        String str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i2 = j.INVALID_ID;
        String str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String packageName = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager == null) {
            zzge().zzim().zzg("PackageManager is null, app identity information might be inaccurate. appId", zzfg.zzbm(packageName));
        } else {
            try {
                str = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                zzge().zzim().zzg("Error retrieving app installer package name. appId", zzfg.zzbm(packageName));
            }
            if (str == null) {
                str = "manual_install";
            } else if ("com.android.vending".equals(str)) {
                str = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str3 = applicationLabel.toString();
                    }
                    str2 = packageInfo.versionName;
                    i2 = packageInfo.versionCode;
                }
            } catch (NameNotFoundException e2) {
                zzge().zzim().zze("Error retrieving package info. appId, appName", zzfg.zzbm(packageName), str3);
            }
        }
        this.zzti = packageName;
        this.zzadt = str;
        this.zzth = str2;
        this.zzaie = i2;
        this.zztg = str3;
        this.zzaif = 0;
        Status initialize = GoogleServices.initialize(getContext());
        int i3 = (initialize == null || !initialize.isSuccess()) ? 0 : 1;
        if (i3 == 0) {
            if (initialize == null) {
                zzge().zzim().log("GoogleService failed to initialize (no status)");
            } else {
                zzge().zzim().zze("GoogleService failed to initialize, status", Integer.valueOf(initialize.getStatusCode()), initialize.getStatusMessage());
            }
        }
        if (i3 != 0) {
            Boolean zzas = zzgg().zzas("firebase_analytics_collection_enabled");
            if (zzgg().zzhg()) {
                zzge().zzir().log("Collection disabled with firebase_analytics_collection_deactivated=1");
                i3 = 0;
            } else if (zzas != null && !zzas.booleanValue()) {
                zzge().zzir().log("Collection disabled with firebase_analytics_collection_enabled=0");
                i3 = 0;
            } else if (zzas == null && GoogleServices.isMeasurementExplicitlyDisabled()) {
                zzge().zzir().log("Collection disabled with google_app_measurement_enable=0");
                i3 = 0;
            } else {
                zzge().zzit().log("Collection enabled");
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        this.zzadm = "";
        this.zzadx = 0;
        try {
            String googleAppId = GoogleServices.getGoogleAppId();
            if (TextUtils.isEmpty(googleAppId)) {
                googleAppId = "";
            }
            this.zzadm = googleAppId;
            if (i3 != 0) {
                zzge().zzit().zze("App package, google app id", this.zzti, this.zzadm);
            }
        } catch (IllegalStateException e3) {
            zzge().zzim().zze("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzfg.zzbm(packageName), e3);
        }
        if (VERSION.SDK_INT >= 16) {
            if (!InstantApps.isInstantApp(getContext())) {
                i = 0;
            }
            this.zzaen = i;
            AppMethodBeat.o(68775);
            return;
        }
        this.zzaen = 0;
        AppMethodBeat.o(68775);
    }

    /* Access modifiers changed, original: final */
    public final String zzii() {
        AppMethodBeat.i(68777);
        zzgb().zzlc().nextBytes(new byte[16]);
        String format = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
        AppMethodBeat.o(68777);
        return format;
    }

    /* Access modifiers changed, original: final */
    public final int zzij() {
        AppMethodBeat.i(68781);
        zzch();
        int i = this.zzaie;
        AppMethodBeat.o(68781);
        return i;
    }

    /* Access modifiers changed, original: final */
    public final int zzik() {
        AppMethodBeat.i(68782);
        zzch();
        int i = this.zzaen;
        AppMethodBeat.o(68782);
        return i;
    }

    private final String zzgj() {
        String str = null;
        AppMethodBeat.i(68778);
        zzab();
        if (!zzgg().zzay(this.zzti) || this.zzacw.isEnabled()) {
            try {
                FirebaseInstanceId.uD().uE();
                str = FirebaseInstanceId.zzf();
                AppMethodBeat.o(68778);
            } catch (IllegalStateException e) {
                zzge().zzip().log("Failed to retrieve Firebase Instance Id");
                AppMethodBeat.o(68778);
            }
        } else {
            AppMethodBeat.o(68778);
        }
        return str;
    }
}
