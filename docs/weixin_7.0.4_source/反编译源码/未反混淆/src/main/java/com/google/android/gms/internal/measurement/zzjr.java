package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v4.widget.j;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics.a;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wxmm.v2helper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzjr implements zzec {
    private zzgl zzacw;
    zzgf zzaqa;
    zzfk zzaqb;
    private zzei zzaqc;
    private zzfp zzaqd;
    private zzjn zzaqe;
    private zzeb zzaqf;
    private boolean zzaqg;
    @VisibleForTesting
    private long zzaqh;
    private List<Runnable> zzaqi;
    private int zzaqj;
    private int zzaqk;
    private boolean zzaql;
    private boolean zzaqm;
    private boolean zzaqn;
    private FileLock zzaqo;
    private FileChannel zzaqp;
    private List<Long> zzaqq;
    private List<Long> zzaqr;
    long zzaqs;
    private boolean zzvo = false;

    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        int i = 0;
        AppMethodBeat.i(69469);
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().zzim().log("Bad channel to read from");
            AppMethodBeat.o(69469);
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read != 4) {
                    if (read != -1) {
                        zzge().zzip().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                    }
                    AppMethodBeat.o(69469);
                } else {
                    allocate.flip();
                    i = allocate.getInt();
                    AppMethodBeat.o(69469);
                }
            } catch (IOException e) {
                zzge().zzim().zzg("Failed to read from channel", e);
            }
        }
        return i;
    }

    private final zzdz zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j) {
        Object charSequence;
        AppMethodBeat.i(69474);
        String str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String str4 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i = j.INVALID_ID;
        String str5 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            zzge().zzim().log("PackageManager is null, can not log app install information");
            AppMethodBeat.o(69474);
            return null;
        }
        try {
            str3 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException e) {
            zzge().zzim().zzg("Error retrieving installer package name. appId", zzfg.zzbm(str));
        }
        if (str3 == null) {
            str3 = "manual_install";
        } else if ("com.android.vending".equals(str3)) {
            str3 = "";
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str);
                if (TextUtils.isEmpty(applicationLabel)) {
                    String charSequence2 = str5;
                } else {
                    charSequence2 = applicationLabel.toString();
                }
                try {
                    str4 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                } catch (NameNotFoundException e2) {
                    zzge().zzim().zze("Error retrieving newly installed package info. appId, appName", zzfg.zzbm(str), charSequence2);
                    AppMethodBeat.o(69474);
                    return null;
                }
            }
            long j2 = 0;
            if (zzgg().zzba(str)) {
                j2 = j;
            }
            zzdz zzdz = new zzdz(str, str2, str4, (long) i, str3, 12451, zzgb().zzd(context, str), null, z, false, "", 0, j2, 0, z2, z3, false);
            AppMethodBeat.o(69474);
            return zzdz;
        } catch (NameNotFoundException e3) {
            charSequence2 = str5;
            zzge().zzim().zze("Error retrieving newly installed package info. appId, appName", zzfg.zzbm(str), charSequence2);
            AppMethodBeat.o(69474);
            return null;
        }
    }

    private static void zza(zzjq zzjq) {
        AppMethodBeat.i(69450);
        IllegalStateException illegalStateException;
        if (zzjq == null) {
            illegalStateException = new IllegalStateException("Upload component not created");
            AppMethodBeat.o(69450);
            throw illegalStateException;
        } else if (zzjq.isInitialized()) {
            AppMethodBeat.o(69450);
        } else {
            String valueOf = String.valueOf(zzjq.getClass());
            illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Component not initialized: ").append(valueOf).toString());
            AppMethodBeat.o(69450);
            throw illegalStateException;
        }
    }

    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        AppMethodBeat.i(69470);
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().zzim().log("Bad channel to read from");
            AppMethodBeat.o(69470);
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                zzge().zzim().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            AppMethodBeat.o(69470);
            return true;
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to write to channel", e);
            AppMethodBeat.o(69470);
            return false;
        }
    }

    private final boolean zza(String str, zzeu zzeu) {
        long round;
        AppMethodBeat.i(69456);
        String string = zzeu.zzafq.getString(b.CURRENCY);
        if (a.ECOMMERCE_PURCHASE.equals(zzeu.name)) {
            double doubleValue = zzeu.zzafq.zzbh("value").doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) zzeu.zzafq.getLong("value").longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                zzge().zzip().zze("Data lost. Currency value is too big. appId", zzfg.zzbm(str), Double.valueOf(doubleValue));
                AppMethodBeat.o(69456);
                return false;
            }
            round = Math.round(doubleValue);
        } else {
            round = zzeu.zzafq.getLong("value").longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String toUpperCase = string.toUpperCase(Locale.US);
            if (toUpperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                toUpperCase = String.valueOf(toUpperCase);
                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                zzjz zzh = zzix().zzh(str, concat);
                if (zzh == null || !(zzh.value instanceof Long)) {
                    zzei zzix = zzix();
                    int zzb = zzgg().zzb(str, zzew.zzahm) - 1;
                    Preconditions.checkNotEmpty(str);
                    zzix.zzab();
                    zzix.zzch();
                    try {
                        zzix.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                    } catch (SQLiteException e) {
                        zzix.zzge().zzim().zze("Error pruning currencies. appId", zzfg.zzbm(str), e);
                    }
                    zzh = new zzjz(str, zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(round));
                } else {
                    zzh = new zzjz(str, zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(round + ((Long) zzh.value).longValue()));
                }
                if (!zzix().zza(zzh)) {
                    zzge().zzim().zzd("Too many unique user properties are set. Ignoring user property. appId", zzfg.zzbm(str), zzga().zzbl(zzh.name), zzh.value);
                    zzgb().zza(str, 9, null, null, 0);
                }
            }
        }
        AppMethodBeat.o(69456);
        return true;
    }

    private final zzkm[] zza(String str, zzks[] zzksArr, zzkn[] zzknArr) {
        AppMethodBeat.i(69459);
        Preconditions.checkNotEmpty(str);
        zzkm[] zza = zziw().zza(str, zzknArr, zzksArr);
        AppMethodBeat.o(69459);
        return zza;
    }

    private final void zzb(zzdy zzdy) {
        AppMethodBeat.i(69462);
        zzab();
        if (TextUtils.isEmpty(zzdy.getGmpAppId())) {
            zzb(zzdy.zzah(), 204, null, null, null);
            AppMethodBeat.o(69462);
            return;
        }
        String gmpAppId = zzdy.getGmpAppId();
        String appInstanceId = zzdy.getAppInstanceId();
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) zzew.zzagm.get()).encodedAuthority((String) zzew.zzagn.get());
        String str = "config/app/";
        String valueOf = String.valueOf(gmpAppId);
        encodedAuthority.path(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).appendQueryParameter("app_instance_id", appInstanceId).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "12451");
        String uri = builder.build().toString();
        try {
            Map map;
            URL url = new URL(uri);
            zzge().zzit().zzg("Fetching remote configuration", zzdy.zzah());
            zzkk zzbu = zzkm().zzbu(zzdy.zzah());
            gmpAppId = zzkm().zzbv(zzdy.zzah());
            if (zzbu == null || TextUtils.isEmpty(gmpAppId)) {
                map = null;
            } else {
                android.support.v4.f.a aVar = new android.support.v4.f.a();
                aVar.put("If-Modified-Since", gmpAppId);
                map = aVar;
            }
            this.zzaql = true;
            zzfk zzkn = zzkn();
            appInstanceId = zzdy.zzah();
            zzjt zzjt = new zzjt(this);
            zzkn.zzab();
            zzkn.zzch();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzjt);
            zzkn.zzgd().zzd(new zzfo(zzkn, appInstanceId, url, null, map, zzjt));
            AppMethodBeat.o(69462);
        } catch (MalformedURLException e) {
            zzge().zzim().zze("Failed to parse config URL. Not fetching. appId", zzfg.zzbm(zzdy.zzah()), uri);
            AppMethodBeat.o(69462);
        }
    }

    private final Boolean zzc(zzdy zzdy) {
        AppMethodBeat.i(69467);
        try {
            Boolean bool;
            if (zzdy.zzgm() != -2147483648L) {
                if (zzdy.zzgm() == ((long) Wrappers.packageManager(getContext()).getPackageInfo(zzdy.zzah(), 0).versionCode)) {
                    bool = Boolean.TRUE;
                    AppMethodBeat.o(69467);
                    return bool;
                }
            }
            String str = Wrappers.packageManager(getContext()).getPackageInfo(zzdy.zzah(), 0).versionName;
            if (zzdy.zzag() != null && zzdy.zzag().equals(str)) {
                bool = Boolean.TRUE;
                AppMethodBeat.o(69467);
                return bool;
            }
            bool = Boolean.FALSE;
            AppMethodBeat.o(69467);
            return bool;
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(69467);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x0626 A:{Catch:{ IOException -> 0x0686, all -> 0x05ca }} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x063e A:{Catch:{ IOException -> 0x0686, all -> 0x05ca }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(zzeu zzeu, zzdz zzdz) {
        AppMethodBeat.i(69455);
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        long nanoTime = System.nanoTime();
        zzab();
        zzkq();
        String str = zzdz.packageName;
        zzgb();
        if (!zzka.zzd(zzeu, zzdz)) {
            AppMethodBeat.o(69455);
        } else if (!zzdz.zzadw) {
            zzg(zzdz);
            AppMethodBeat.o(69455);
        } else if (zzkm().zzn(str, zzeu.name)) {
            zzge().zzip().zze("Dropping blacklisted event. appId", zzfg.zzbm(str), zzga().zzbj(zzeu.name));
            Object obj = (zzkm().zzby(str) || zzkm().zzbz(str)) ? 1 : null;
            if (obj == null && !"_err".equals(zzeu.name)) {
                zzgb().zza(str, 11, "_ev", zzeu.name, 0);
            }
            if (obj != null) {
                zzdy zzbc = zzix().zzbc(str);
                if (zzbc != null) {
                    if (Math.abs(zzbt().currentTimeMillis() - Math.max(zzbc.zzgs(), zzbc.zzgr())) > ((Long) zzew.zzahh.get()).longValue()) {
                        zzge().zzis().log("Fetching config for blacklisted app");
                        zzb(zzbc);
                    }
                }
            }
            AppMethodBeat.o(69455);
        } else {
            if (zzge().isLoggable(2)) {
                zzge().zzit().zzg("Logging event", zzga().zzb(zzeu));
            }
            zzix().beginTransaction();
            zzg(zzdz);
            if (("_iap".equals(zzeu.name) || a.ECOMMERCE_PURCHASE.equals(zzeu.name)) && !zza(str, zzeu)) {
                zzix().setTransactionSuccessful();
                zzix().endTransaction();
                AppMethodBeat.o(69455);
                return;
            }
            zzkq zzkq;
            try {
                boolean zzcc = zzka.zzcc(zzeu.name);
                boolean equals = "_err".equals(zzeu.name);
                zzej zza = zzix().zza(zzkr(), str, true, zzcc, false, equals, false);
                long intValue = zza.zzafe - ((long) ((Integer) zzew.zzags.get()).intValue());
                if (intValue > 0) {
                    if (intValue % 1000 == 1) {
                        zzge().zzim().zze("Data loss. Too many events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafe));
                    }
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    AppMethodBeat.o(69455);
                    return;
                }
                zzeq zzac;
                zzep zzep;
                boolean z;
                if (zzcc) {
                    intValue = zza.zzafd - ((long) ((Integer) zzew.zzagu.get()).intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            zzge().zzim().zze("Data loss. Too many public events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafd));
                        }
                        zzgb().zza(str, 16, "_ev", zzeu.name, 0);
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        AppMethodBeat.o(69455);
                        return;
                    }
                }
                if (equals) {
                    intValue = zza.zzafg - ((long) Math.max(0, Math.min(1000000, zzgg().zzb(zzdz.packageName, zzew.zzagt))));
                    if (intValue > 0) {
                        if (intValue == 1) {
                            zzge().zzim().zze("Too many error events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafg));
                        }
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        AppMethodBeat.o(69455);
                        return;
                    }
                }
                Bundle zzif = zzeu.zzafq.zzif();
                zzgb().zza(zzif, "_o", zzeu.origin);
                if (zzgb().zzcj(str)) {
                    zzgb().zza(zzif, "_dbg", Long.valueOf(1));
                    zzgb().zza(zzif, "_r", Long.valueOf(1));
                }
                long zzbd = zzix().zzbd(str);
                if (zzbd > 0) {
                    zzge().zzip().zze("Data lost. Too many events stored on disk, deleted. appId", zzfg.zzbm(str), Long.valueOf(zzbd));
                }
                zzep zzep2 = new zzep(this.zzacw, zzeu.origin, str, zzeu.name, zzeu.zzagb, 0, zzif);
                zzeq zzf = zzix().zzf(str, zzep2.name);
                if (zzf != null) {
                    zzep2 = zzep2.zza(this.zzacw, zzf.zzaft);
                    zzac = zzf.zzac(zzep2.timestamp);
                    zzep = zzep2;
                } else if (zzix().zzbg(str) < 500 || !zzcc) {
                    zzac = new zzeq(str, zzep2.name, 0, 0, zzep2.timestamp, 0, null, null, null);
                    zzep = zzep2;
                } else {
                    zzge().zzim().zzd("Too many event names used, ignoring event. appId, name, supported count", zzfg.zzbm(str), zzga().zzbj(zzep2.name), Integer.valueOf(500));
                    zzgb().zza(str, 8, null, null, 0);
                    zzix().endTransaction();
                    AppMethodBeat.o(69455);
                    return;
                }
                zzix().zza(zzac);
                zzab();
                zzkq();
                Preconditions.checkNotNull(zzep);
                Preconditions.checkNotNull(zzdz);
                Preconditions.checkNotEmpty(zzep.zzti);
                Preconditions.checkArgument(zzep.zzti.equals(zzdz.packageName));
                zzkq = new zzkq();
                zzkq.zzath = Integer.valueOf(1);
                zzkq.zzatp = "android";
                zzkq.zzti = zzdz.packageName;
                zzkq.zzadt = zzdz.zzadt;
                zzkq.zzth = zzdz.zzth;
                zzkq.zzaub = zzdz.zzads == -2147483648L ? null : Integer.valueOf((int) zzdz.zzads);
                zzkq.zzatt = Long.valueOf(zzdz.zzadu);
                zzkq.zzadm = zzdz.zzadm;
                zzkq.zzatx = zzdz.zzadv == 0 ? null : Long.valueOf(zzdz.zzadv);
                Pair zzbo = zzgf().zzbo(zzdz.packageName);
                if (zzbo == null || TextUtils.isEmpty((CharSequence) zzbo.first)) {
                    if (!zzfw().zzf(getContext()) && zzdz.zzadz) {
                        String string = Secure.getString(getContext().getContentResolver(), "android_id");
                        if (string == null) {
                            zzge().zzip().zzg("null secure ID. appId", zzfg.zzbm(zzkq.zzti));
                            string = BuildConfig.COMMAND;
                        } else if (string.isEmpty()) {
                            zzge().zzip().zzg("empty secure ID. appId", zzfg.zzbm(zzkq.zzti));
                        }
                        zzkq.zzaue = string;
                    }
                } else if (zzdz.zzady) {
                    zzkq.zzatv = (String) zzbo.first;
                    zzkq.zzatw = (Boolean) zzbo.second;
                }
                zzfw().zzch();
                zzkq.zzatr = Build.MODEL;
                zzfw().zzch();
                zzkq.zzatq = VERSION.RELEASE;
                zzkq.zzats = Integer.valueOf((int) zzfw().zzic());
                zzkq.zzafn = zzfw().zzid();
                zzkq.zzatu = null;
                zzkq.zzatk = null;
                zzkq.zzatl = null;
                zzkq.zzatm = null;
                zzkq.zzaug = Long.valueOf(zzdz.zzadx);
                if (this.zzacw.isEnabled() && zzef.zzhk()) {
                    zzkq.zzauh = null;
                }
                zzdy zzbc2 = zzix().zzbc(zzdz.packageName);
                if (zzbc2 == null) {
                    zzbc2 = new zzdy(this.zzacw, zzdz.packageName);
                    zzbc2.zzal(this.zzacw.zzfv().zzii());
                    zzbc2.zzao(zzdz.zzado);
                    zzbc2.zzam(zzdz.zzadm);
                    zzbc2.zzan(zzgf().zzbp(zzdz.packageName));
                    zzbc2.zzr(0);
                    zzbc2.zzm(0);
                    zzbc2.zzn(0);
                    zzbc2.setAppVersion(zzdz.zzth);
                    zzbc2.zzo(zzdz.zzads);
                    zzbc2.zzap(zzdz.zzadt);
                    zzbc2.zzp(zzdz.zzadu);
                    zzbc2.zzq(zzdz.zzadv);
                    zzbc2.setMeasurementEnabled(zzdz.zzadw);
                    zzbc2.zzaa(zzdz.zzadx);
                    zzix().zza(zzbc2);
                }
                zzkq.zzadl = zzbc2.getAppInstanceId();
                zzkq.zzado = zzbc2.zzgj();
                List zzbb = zzix().zzbb(zzdz.packageName);
                zzkq.zzatj = new zzks[zzbb.size()];
                for (int i = 0; i < zzbb.size(); i++) {
                    zzks zzks = new zzks();
                    zzkq.zzatj[i] = zzks;
                    zzks.name = ((zzjz) zzbb.get(i)).name;
                    zzks.zzaun = Long.valueOf(((zzjz) zzbb.get(i)).zzaqz);
                    zzgb().zza(zzks, ((zzjz) zzbb.get(i)).value);
                }
                long zza2 = zzix().zza(zzkq);
                zzei zzix = zzix();
                if (zzep.zzafq != null) {
                    Iterator it = zzep.zzafq.iterator();
                    while (it.hasNext()) {
                        if ("_r".equals((String) it.next())) {
                            z = true;
                            break;
                        }
                    }
                    z = zzkm().zzo(zzep.zzti, zzep.name);
                    zzej zza3 = zzix().zza(zzkr(), zzep.zzti, false, false, false, false, false);
                    if (z && zza3.zzafh < ((long) zzgg().zzar(zzep.zzti))) {
                        z = true;
                        if (zzix.zza(zzep, zza2, z)) {
                            this.zzaqh = 0;
                        }
                        zzix().setTransactionSuccessful();
                        if (zzge().isLoggable(2)) {
                            zzge().zzit().zzg("Event recorded", zzga().zza(zzep));
                        }
                        zzix().endTransaction();
                        zzku();
                        zzge().zzit().zzg("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                        AppMethodBeat.o(69455);
                    }
                }
                z = false;
                if (zzix.zza(zzep, zza2, z)) {
                }
                zzix().setTransactionSuccessful();
                if (zzge().isLoggable(2)) {
                }
                zzix().endTransaction();
                zzku();
                zzge().zzit().zzg("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                AppMethodBeat.o(69455);
            } catch (IOException e) {
                zzge().zzim().zze("Data loss. Failed to insert raw event metadata. appId", zzfg.zzbm(zzkq.zzti), e);
            } catch (Throwable th) {
                zzix().endTransaction();
                AppMethodBeat.o(69455);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:190:0x055f A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0beb A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0beb A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0beb A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0beb A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0beb A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092 A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0beb A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x037a A:{Catch:{ IOException -> 0x02db, all -> 0x01cb }} */
    /* JADX WARNING: Missing block: B:140:0x03a5, code skipped:
            if (com.google.android.gms.internal.measurement.zzka.zzcl(r12.name) != false) goto L_0x03a7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(String str, long j) {
        Throwable th;
        AppMethodBeat.i(69458);
        zzix().beginTransaction();
        zzjv zzjv = new zzjv(this, null);
        zzei zzix = zzix();
        String str2 = null;
        long j2 = this.zzaqs;
        Preconditions.checkNotNull(zzjv);
        zzix.zzab();
        zzix.zzch();
        Cursor cursor = null;
        Object obj;
        try {
            String[] strArr;
            String string;
            Cursor cursor2;
            String str3;
            String str4;
            long zzgk;
            SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
            Object obj2;
            if (TextUtils.isEmpty(null)) {
                strArr = j2 != -1 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)};
                obj2 = j2 != -1 ? "rowid <= ? and " : "";
                cursor = writableDatabase.rawQuery(new StringBuilder(String.valueOf(obj2).length() + 148).append("select app_id, metadata_fingerprint from raw_events where ").append(obj2).append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;").toString(), strArr);
                if (cursor.moveToFirst()) {
                    str2 = cursor.getString(0);
                    string = cursor.getString(1);
                    cursor.close();
                    cursor2 = cursor;
                    str3 = str2;
                    str4 = string;
                } else {
                    if (cursor != null) {
                        cursor.close();
                    }
                    obj = (zzjv.zzaqx != null || zzjv.zzaqx.isEmpty()) ? 1 : null;
                    if (obj == null) {
                        long j3;
                        Object obj3;
                        zzko[] zzkoArr;
                        int length;
                        int i;
                        Long l;
                        int i2;
                        boolean z = false;
                        zzkq zzkq = zzjv.zzaqv;
                        zzkq.zzati = new zzkn[zzjv.zzaqx.size()];
                        int i3 = 0;
                        long j4 = 0;
                        boolean zzav = zzgg().zzav(zzkq.zzti);
                        int i4 = 0;
                        while (i4 < zzjv.zzaqx.size()) {
                            int i5;
                            boolean z2;
                            zzkn zzkn = (zzkn) zzjv.zzaqx.get(i4);
                            if (zzkm().zzn(zzjv.zzaqv.zzti, zzkn.name)) {
                                zzge().zzip().zze("Dropping blacklisted raw event. appId", zzfg.zzbm(zzjv.zzaqv.zzti), zzga().zzbj(zzkn.name));
                                obj = (zzkm().zzby(zzjv.zzaqv.zzti) || zzkm().zzbz(zzjv.zzaqv.zzti)) ? 1 : null;
                                if (obj != null || "_err".equals(zzkn.name)) {
                                    j3 = j4;
                                    i5 = i3;
                                    z2 = z;
                                } else {
                                    zzgb().zza(zzjv.zzaqv.zzti, 11, "_ev", zzkn.name, 0);
                                    j3 = j4;
                                    i5 = i3;
                                    z2 = z;
                                }
                            } else {
                                zzko[] zzkoArr2;
                                zzko zzko;
                                zzko zzko2;
                                boolean zzo = zzkm().zzo(zzjv.zzaqv.zzti, zzkn.name);
                                if (!zzo) {
                                    zzgb();
                                }
                                Object obj4 = null;
                                obj3 = null;
                                if (zzkn.zzata == null) {
                                    zzkn.zzata = new zzko[0];
                                }
                                zzkoArr = zzkn.zzata;
                                length = zzkoArr.length;
                                int i6 = 0;
                                while (i6 < length) {
                                    zzko zzko3 = zzkoArr[i6];
                                    if ("_c".equals(zzko3.name)) {
                                        zzko3.zzate = Long.valueOf(1);
                                        obj4 = 1;
                                        obj = obj3;
                                    } else if ("_r".equals(zzko3.name)) {
                                        zzko3.zzate = Long.valueOf(1);
                                        obj = 1;
                                    } else {
                                        obj = obj3;
                                    }
                                    i6++;
                                    obj3 = obj;
                                }
                                if (obj4 == null && zzo) {
                                    zzge().zzit().zzg("Marking event as conversion", zzga().zzbj(zzkn.name));
                                    zzkoArr2 = (zzko[]) Arrays.copyOf(zzkn.zzata, zzkn.zzata.length + 1);
                                    zzko = new zzko();
                                    zzko.name = "_c";
                                    zzko.zzate = Long.valueOf(1);
                                    zzkoArr2[zzkoArr2.length - 1] = zzko;
                                    zzkn.zzata = zzkoArr2;
                                }
                                if (obj3 == null) {
                                    zzge().zzit().zzg("Marking event as real-time", zzga().zzbj(zzkn.name));
                                    zzkoArr2 = (zzko[]) Arrays.copyOf(zzkn.zzata, zzkn.zzata.length + 1);
                                    zzko2 = new zzko();
                                    zzko2.name = "_r";
                                    zzko2.zzate = Long.valueOf(1);
                                    zzkoArr2[zzkoArr2.length - 1] = zzko2;
                                    zzkn.zzata = zzkoArr2;
                                }
                                if (zzix().zza(zzkr(), zzjv.zzaqv.zzti, false, false, false, false, true).zzafh > ((long) zzgg().zzar(zzjv.zzaqv.zzti))) {
                                    i = 0;
                                    while (i < zzkn.zzata.length) {
                                        if ("_r".equals(zzkn.zzata[i].name)) {
                                            zzko[] zzkoArr3 = new zzko[(zzkn.zzata.length - 1)];
                                            if (i > 0) {
                                                System.arraycopy(zzkn.zzata, 0, zzkoArr3, 0, i);
                                            }
                                            if (i < zzkoArr3.length) {
                                                System.arraycopy(zzkn.zzata, i + 1, zzkoArr3, i, zzkoArr3.length - i);
                                            }
                                            zzkn.zzata = zzkoArr3;
                                        } else {
                                            i++;
                                        }
                                    }
                                } else {
                                    z = true;
                                }
                                if (zzka.zzcc(zzkn.name) && zzo && zzix().zza(zzkr(), zzjv.zzaqv.zzti, false, false, true, false, false).zzaff > ((long) zzgg().zzb(zzjv.zzaqv.zzti, zzew.zzagv))) {
                                    zzge().zzip().zzg("Too many conversions. Not logging as conversion. appId", zzfg.zzbm(zzjv.zzaqv.zzti));
                                    obj = null;
                                    zzko = null;
                                    zzkoArr = zzkn.zzata;
                                    length = zzkoArr.length;
                                    i6 = 0;
                                    while (i6 < length) {
                                        zzko2 = zzkoArr[i6];
                                        if (!"_c".equals(zzko2.name)) {
                                            if ("_err".equals(zzko2.name)) {
                                                obj = 1;
                                                zzko2 = zzko;
                                            } else {
                                                zzko2 = zzko;
                                            }
                                        }
                                        i6++;
                                        zzko = zzko2;
                                    }
                                    if (obj != null && zzko != null) {
                                        zzkn.zzata = (zzko[]) ArrayUtils.removeAll(zzkn.zzata, zzko);
                                        z2 = z;
                                        if (zzav) {
                                        }
                                        j3 = j4;
                                        i5 = i3 + 1;
                                        zzkq.zzati[i3] = zzkn;
                                    } else if (zzko != null) {
                                        zzko.name = "_err";
                                        zzko.zzate = Long.valueOf(10);
                                        z2 = z;
                                        if (zzav || !"_e".equals(zzkn.name)) {
                                            j3 = j4;
                                        } else if (zzkn.zzata == null || zzkn.zzata.length == 0) {
                                            zzge().zzip().zzg("Engagement event does not contain any parameters. appId", zzfg.zzbm(zzjv.zzaqv.zzti));
                                            j3 = j4;
                                        } else {
                                            zzgb();
                                            l = (Long) zzka.zzb(zzkn, "_et");
                                            if (l == null) {
                                                zzge().zzip().zzg("Engagement event does not include duration. appId", zzfg.zzbm(zzjv.zzaqv.zzti));
                                                j3 = j4;
                                            } else {
                                                j3 = j4 + l.longValue();
                                            }
                                        }
                                        i5 = i3 + 1;
                                        zzkq.zzati[i3] = zzkn;
                                    } else {
                                        zzge().zzim().zzg("Did not find conversion parameter. appId", zzfg.zzbm(zzjv.zzaqv.zzti));
                                    }
                                }
                                z2 = z;
                                if (zzav) {
                                }
                                j3 = j4;
                                i5 = i3 + 1;
                                zzkq.zzati[i3] = zzkn;
                            }
                            j4 = j3;
                            i4++;
                            i3 = i5;
                            z = z2;
                        }
                        if (i3 < zzjv.zzaqx.size()) {
                            zzkq.zzati = (zzkn[]) Arrays.copyOf(zzkq.zzati, i3);
                        }
                        if (zzav) {
                            zzjz zzh = zzix().zzh(zzkq.zzti, "_lte");
                            zzjz zzjz = (zzh == null || zzh.value == null) ? new zzjz(zzkq.zzti, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(j4)) : new zzjz(zzkq.zzti, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(((Long) zzh.value).longValue() + j4));
                            zzks zzks = new zzks();
                            zzks.name = "_lte";
                            zzks.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                            zzks.zzate = (Long) zzjz.value;
                            obj = null;
                            for (i2 = 0; i2 < zzkq.zzatj.length; i2++) {
                                if ("_lte".equals(zzkq.zzatj[i2].name)) {
                                    zzkq.zzatj[i2] = zzks;
                                    obj = 1;
                                    break;
                                }
                            }
                            if (obj == null) {
                                zzkq.zzatj = (zzks[]) Arrays.copyOf(zzkq.zzatj, zzkq.zzatj.length + 1);
                                zzkq.zzatj[zzjv.zzaqv.zzatj.length - 1] = zzks;
                            }
                            if (j4 > 0) {
                                zzix().zza(zzjz);
                                zzge().zzis().zzg("Updated lifetime engagement user property with value. Value", zzjz.value);
                            }
                        }
                        zzkq.zzaua = zza(zzkq.zzti, zzkq.zzatj, zzkq.zzati);
                        if (zzgg().zzau(zzjv.zzaqv.zzti)) {
                            HashMap hashMap = new HashMap();
                            zzkn[] zzknArr = new zzkn[zzkq.zzati.length];
                            int i7 = 0;
                            SecureRandom zzlc = zzgb().zzlc();
                            zzkn[] zzknArr2 = zzkq.zzati;
                            int length2 = zzknArr2.length;
                            int i8 = 0;
                            while (i8 < length2) {
                                zzkn zzkn2 = zzknArr2[i8];
                                zzeq zzeq;
                                if (zzkn2.name.equals("_ep")) {
                                    zzgb();
                                    String str5 = (String) zzka.zzb(zzkn2, "_en");
                                    zzeq = (zzeq) hashMap.get(str5);
                                    if (zzeq == null) {
                                        zzeq = zzix().zzf(zzjv.zzaqv.zzti, str5);
                                        hashMap.put(str5, zzeq);
                                    }
                                    if (zzeq.zzafv == null) {
                                        if (zzeq.zzafw.longValue() > 1) {
                                            zzgb();
                                            zzkn2.zzata = zzka.zza(zzkn2.zzata, "_sr", zzeq.zzafw);
                                        }
                                        if (zzeq.zzafx != null && zzeq.zzafx.booleanValue()) {
                                            zzgb();
                                            zzkn2.zzata = zzka.zza(zzkn2.zzata, "_efs", Long.valueOf(1));
                                        }
                                        i = i7 + 1;
                                        zzknArr[i7] = zzkn2;
                                    }
                                    i = i7;
                                } else {
                                    str2 = "_dbg";
                                    Long valueOf = Long.valueOf(1);
                                    if (TextUtils.isEmpty(str2) || valueOf == null) {
                                        obj3 = null;
                                    } else {
                                        zzkoArr = zzkn2.zzata;
                                        length = zzkoArr.length;
                                        i2 = 0;
                                        while (i2 < length) {
                                            zzko zzko4 = zzkoArr[i2];
                                            if (str2.equals(zzko4.name)) {
                                                obj3 = ((valueOf instanceof Long) && valueOf.equals(zzko4.zzate)) ? 1 : null;
                                            } else {
                                                i2++;
                                            }
                                        }
                                        obj3 = null;
                                    }
                                    int zzp = obj3 == null ? zzkm().zzp(zzjv.zzaqv.zzti, zzkn2.name) : 1;
                                    if (zzp <= 0) {
                                        zzge().zzip().zze("Sample rate must be positive. event, rate", zzkn2.name, Integer.valueOf(zzp));
                                        i = i7 + 1;
                                        zzknArr[i7] = zzkn2;
                                    } else {
                                        zzeq zzeq2 = (zzeq) hashMap.get(zzkn2.name);
                                        if (zzeq2 == null) {
                                            zzeq = zzix().zzf(zzjv.zzaqv.zzti, zzkn2.name);
                                            if (zzeq == null) {
                                                zzge().zzip().zze("Event being bundled has no eventAggregate. appId, eventName", zzjv.zzaqv.zzti, zzkn2.name);
                                                zzeq = new zzeq(zzjv.zzaqv.zzti, zzkn2.name, 1, 1, zzkn2.zzatb.longValue(), 0, null, null, null);
                                            }
                                        } else {
                                            zzeq = zzeq2;
                                        }
                                        zzgb();
                                        l = (Long) zzka.zzb(zzkn2, "_eid");
                                        Boolean valueOf2 = Boolean.valueOf(l != null);
                                        if (zzp == 1) {
                                            i = i7 + 1;
                                            zzknArr[i7] = zzkn2;
                                            if (valueOf2.booleanValue() && !(zzeq.zzafv == null && zzeq.zzafw == null && zzeq.zzafx == null)) {
                                                hashMap.put(zzkn2.name, zzeq.zza(null, null, null));
                                            }
                                        } else if (zzlc.nextInt(zzp) == 0) {
                                            zzgb();
                                            zzkn2.zzata = zzka.zza(zzkn2.zzata, "_sr", Long.valueOf((long) zzp));
                                            i = i7 + 1;
                                            zzknArr[i7] = zzkn2;
                                            if (valueOf2.booleanValue()) {
                                                zzeq = zzeq.zza(null, Long.valueOf((long) zzp), null);
                                            }
                                            hashMap.put(zzkn2.name, zzeq.zzad(zzkn2.zzatb.longValue()));
                                        } else {
                                            if (Math.abs(zzkn2.zzatb.longValue() - zzeq.zzafu) >= 86400000) {
                                                zzgb();
                                                zzkn2.zzata = zzka.zza(zzkn2.zzata, "_efs", Long.valueOf(1));
                                                zzgb();
                                                zzkn2.zzata = zzka.zza(zzkn2.zzata, "_sr", Long.valueOf((long) zzp));
                                                i = i7 + 1;
                                                zzknArr[i7] = zzkn2;
                                                if (valueOf2.booleanValue()) {
                                                    zzeq = zzeq.zza(null, Long.valueOf((long) zzp), Boolean.TRUE);
                                                }
                                                hashMap.put(zzkn2.name, zzeq.zzad(zzkn2.zzatb.longValue()));
                                            } else {
                                                if (valueOf2.booleanValue()) {
                                                    hashMap.put(zzkn2.name, zzeq.zza(l, null, null));
                                                }
                                                i = i7;
                                            }
                                        }
                                    }
                                }
                                i8++;
                                i7 = i;
                            }
                            if (i7 < zzkq.zzati.length) {
                                zzkq.zzati = (zzkn[]) Arrays.copyOf(zzknArr, i7);
                            }
                            for (Entry value : hashMap.entrySet()) {
                                zzix().zza((zzeq) value.getValue());
                            }
                        }
                        zzkq.zzatl = Long.valueOf(Long.MAX_VALUE);
                        zzkq.zzatm = Long.valueOf(Long.MIN_VALUE);
                        for (zzkn zzkn3 : zzkq.zzati) {
                            if (zzkn3.zzatb.longValue() < zzkq.zzatl.longValue()) {
                                zzkq.zzatl = zzkn3.zzatb;
                            }
                            if (zzkn3.zzatb.longValue() > zzkq.zzatm.longValue()) {
                                zzkq.zzatm = zzkn3.zzatb;
                            }
                        }
                        String str6 = zzjv.zzaqv.zzti;
                        zzdy zzbc = zzix().zzbc(str6);
                        if (zzbc == null) {
                            zzge().zzim().zzg("Bundling raw events w/o app info. appId", zzfg.zzbm(zzjv.zzaqv.zzti));
                        } else if (zzkq.zzati.length > 0) {
                            j3 = zzbc.zzgl();
                            zzkq.zzato = j3 != 0 ? Long.valueOf(j3) : null;
                            zzgk = zzbc.zzgk();
                            if (zzgk != 0) {
                                j3 = zzgk;
                            }
                            zzkq.zzatn = j3 != 0 ? Long.valueOf(j3) : null;
                            zzbc.zzgt();
                            zzkq.zzaty = Integer.valueOf((int) zzbc.zzgq());
                            zzbc.zzm(zzkq.zzatl.longValue());
                            zzbc.zzn(zzkq.zzatm.longValue());
                            zzkq.zzaek = zzbc.zzhb();
                            zzix().zza(zzbc);
                        }
                        if (zzkq.zzati.length > 0) {
                            zzkk zzbu = zzkm().zzbu(zzjv.zzaqv.zzti);
                            if (zzbu != null && zzbu.zzasp != null) {
                                zzkq.zzauf = zzbu.zzasp;
                            } else if (TextUtils.isEmpty(zzjv.zzaqv.zzadm)) {
                                zzkq.zzauf = Long.valueOf(-1);
                            } else {
                                zzge().zzip().zzg("Did not find measurement config or missing version info. appId", zzfg.zzbm(zzjv.zzaqv.zzti));
                            }
                            zzix().zza(zzkq, z);
                        }
                        zzei zzix2 = zzix();
                        List list = zzjv.zzaqw;
                        Preconditions.checkNotNull(list);
                        zzix2.zzab();
                        zzix2.zzch();
                        StringBuilder stringBuilder = new StringBuilder("rowid in (");
                        for (i2 = 0; i2 < list.size(); i2++) {
                            if (i2 != 0) {
                                stringBuilder.append(",");
                            }
                            stringBuilder.append(((Long) list.get(i2)).longValue());
                        }
                        stringBuilder.append(")");
                        i = zzix2.getWritableDatabase().delete("raw_events", stringBuilder.toString(), null);
                        if (i != list.size()) {
                            zzix2.zzge().zzim().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(i), Integer.valueOf(list.size()));
                        }
                        zzei zzix3 = zzix();
                        try {
                            zzix3.getWritableDatabase().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str6, str6});
                        } catch (SQLiteException e) {
                            zzix3.zzge().zzim().zze("Failed to remove unused event metadata. appId", zzfg.zzbm(str6), e);
                        }
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        AppMethodBeat.o(69458);
                        return true;
                    }
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    AppMethodBeat.o(69458);
                    return false;
                }
            }
            strArr = j2 != -1 ? new String[]{null, String.valueOf(j2)} : new String[]{null};
            obj2 = j2 != -1 ? " and rowid <= ?" : "";
            cursor = writableDatabase.rawQuery(new StringBuilder(String.valueOf(obj2).length() + 84).append("select metadata_fingerprint from raw_events where app_id = ?").append(obj2).append(" order by rowid limit 1;").toString(), strArr);
            if (cursor.moveToFirst()) {
                string = cursor.getString(0);
                cursor.close();
                cursor2 = cursor;
                str3 = null;
                str4 = string;
            } else {
                if (cursor != null) {
                    cursor.close();
                }
                if (zzjv.zzaqx != null) {
                }
                if (obj == null) {
                }
            }
            try {
                cursor2 = writableDatabase.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str3, str4}, null, null, "rowid", "2");
                if (cursor2.moveToFirst()) {
                    byte[] blob = cursor2.getBlob(0);
                    zzabv zza = zzabv.zza(blob, 0, blob.length);
                    zzkq zzkq2 = new zzkq();
                    try {
                        zzkq2.zzb(zza);
                        if (cursor2.moveToNext()) {
                            zzix.zzge().zzip().zzg("Get multiple raw event metadata records, expected one. appId", zzfg.zzbm(str3));
                        }
                        cursor2.close();
                        zzjv.zzb(zzkq2);
                        if (j2 != -1) {
                            string = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                            strArr = new String[]{str3, str4, String.valueOf(j2)};
                        } else {
                            string = "app_id = ? and metadata_fingerprint = ?";
                            strArr = new String[]{str3, str4};
                        }
                        cursor = writableDatabase.query("raw_events", new String[]{"rowid", "name", Param.TIMESTAMP, "data"}, string, strArr, null, null, "rowid", null);
                        try {
                            if (cursor.moveToFirst()) {
                                do {
                                    zzgk = cursor.getLong(0);
                                    byte[] blob2 = cursor.getBlob(3);
                                    zzabv zza2 = zzabv.zza(blob2, 0, blob2.length);
                                    zzkn zzkn4 = new zzkn();
                                    try {
                                        zzkn4.zzb(zza2);
                                        zzkn4.name = cursor.getString(1);
                                        zzkn4.zzatb = Long.valueOf(cursor.getLong(2));
                                        if (!zzjv.zza(zzgk, zzkn4)) {
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (zzjv.zzaqx != null) {
                                            }
                                            if (obj == null) {
                                            }
                                        }
                                    } catch (IOException e2) {
                                        zzix.zzge().zzim().zze("Data loss. Failed to merge raw event. appId", zzfg.zzbm(str3), e2);
                                    }
                                } while (cursor.moveToNext());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (zzjv.zzaqx != null) {
                                }
                                if (obj == null) {
                                }
                            } else {
                                zzix.zzge().zzip().zzg("Raw event data disappeared while in transaction. appId", zzfg.zzbm(str3));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (zzjv.zzaqx != null) {
                                }
                                if (obj == null) {
                                }
                            }
                        } catch (SQLiteException e3) {
                            obj = e3;
                            str2 = str3;
                        }
                    } catch (IOException e22) {
                        zzix.zzge().zzim().zze("Data loss. Failed to merge raw event metadata. appId", zzfg.zzbm(str3), e22);
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                    } catch (Throwable th2) {
                        zzix().endTransaction();
                        AppMethodBeat.o(69458);
                    }
                } else {
                    zzix.zzge().zzim().zzg("Raw event metadata record is missing. appId", zzfg.zzbm(str3));
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (zzjv.zzaqx != null) {
                    }
                    if (obj == null) {
                    }
                }
            } catch (SQLiteException e4) {
                obj = e4;
                cursor = cursor2;
                str2 = str3;
            } catch (Throwable th3) {
                th = th3;
                cursor = cursor2;
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(69458);
                throw th;
            }
        } catch (SQLiteException e5) {
            obj = e5;
            try {
                zzix.zzge().zzim().zze("Data loss. Error selecting raw event. appId", zzfg.zzbm(str2), obj);
                if (cursor != null) {
                    cursor.close();
                }
                if (zzjv.zzaqx != null) {
                }
                if (obj == null) {
                }
            } catch (Throwable th4) {
                th = th4;
                if (cursor != null) {
                }
                AppMethodBeat.o(69458);
                throw th;
            }
        }
    }

    private final zzdy zzg(zzdz zzdz) {
        Object obj = 1;
        AppMethodBeat.i(69481);
        zzab();
        zzkq();
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzdy zzbc = zzix().zzbc(zzdz.packageName);
        String zzbp = zzgf().zzbp(zzdz.packageName);
        Object obj2 = null;
        if (zzbc == null) {
            zzbc = new zzdy(this.zzacw, zzdz.packageName);
            zzbc.zzal(this.zzacw.zzfv().zzii());
            zzbc.zzan(zzbp);
            obj2 = 1;
        } else if (!zzbp.equals(zzbc.zzgi())) {
            zzbc.zzan(zzbp);
            zzbc.zzal(this.zzacw.zzfv().zzii());
            int obj22 = 1;
        }
        if (!(TextUtils.isEmpty(zzdz.zzadm) || zzdz.zzadm.equals(zzbc.getGmpAppId()))) {
            zzbc.zzam(zzdz.zzadm);
            obj22 = 1;
        }
        if (!(TextUtils.isEmpty(zzdz.zzado) || zzdz.zzado.equals(zzbc.zzgj()))) {
            zzbc.zzao(zzdz.zzado);
            obj22 = 1;
        }
        if (!(zzdz.zzadu == 0 || zzdz.zzadu == zzbc.zzgo())) {
            zzbc.zzp(zzdz.zzadu);
            obj22 = 1;
        }
        if (!(TextUtils.isEmpty(zzdz.zzth) || zzdz.zzth.equals(zzbc.zzag()))) {
            zzbc.setAppVersion(zzdz.zzth);
            obj22 = 1;
        }
        if (zzdz.zzads != zzbc.zzgm()) {
            zzbc.zzo(zzdz.zzads);
            obj22 = 1;
        }
        if (!(zzdz.zzadt == null || zzdz.zzadt.equals(zzbc.zzgn()))) {
            zzbc.zzap(zzdz.zzadt);
            obj22 = 1;
        }
        if (zzdz.zzadv != zzbc.zzgp()) {
            zzbc.zzq(zzdz.zzadv);
            obj22 = 1;
        }
        if (zzdz.zzadw != zzbc.isMeasurementEnabled()) {
            zzbc.setMeasurementEnabled(zzdz.zzadw);
            obj22 = 1;
        }
        if (!(TextUtils.isEmpty(zzdz.zzaek) || zzdz.zzaek.equals(zzbc.zzha()))) {
            zzbc.zzaq(zzdz.zzaek);
            obj22 = 1;
        }
        if (zzdz.zzadx != zzbc.zzhc()) {
            zzbc.zzaa(zzdz.zzadx);
            obj22 = 1;
        }
        if (zzdz.zzady != zzbc.zzhd()) {
            zzbc.zzd(zzdz.zzady);
            obj22 = 1;
        }
        if (zzdz.zzadz != zzbc.zzhe()) {
            zzbc.zze(zzdz.zzadz);
        } else {
            obj = obj22;
        }
        if (obj != null) {
            zzix().zza(zzbc);
        }
        AppMethodBeat.o(69481);
        return zzbc;
    }

    private final zzgf zzkm() {
        AppMethodBeat.i(69437);
        zza(this.zzaqa);
        zzgf zzgf = this.zzaqa;
        AppMethodBeat.o(69437);
        return zzgf;
    }

    private final zzfp zzko() {
        AppMethodBeat.i(69440);
        if (this.zzaqd == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Network broadcast receiver not created");
            AppMethodBeat.o(69440);
            throw illegalStateException;
        }
        zzfp zzfp = this.zzaqd;
        AppMethodBeat.o(69440);
        return zzfp;
    }

    private final zzjn zzkp() {
        AppMethodBeat.i(69441);
        zza(this.zzaqe);
        zzjn zzjn = this.zzaqe;
        AppMethodBeat.o(69441);
        return zzjn;
    }

    private final long zzkr() {
        AppMethodBeat.i(69452);
        long currentTimeMillis = zzbt().currentTimeMillis();
        zzfr zzgf = zzgf();
        zzgf.zzch();
        zzgf.zzab();
        long j = zzgf.zzajy.get();
        if (j == 0) {
            j = 1 + ((long) zzgf.zzgb().zzlc().nextInt(Downloads.MAX_RETYR_AFTER));
            zzgf.zzajy.set(j);
        }
        j = ((((j + currentTimeMillis) / 1000) / 60) / 60) / 24;
        AppMethodBeat.o(69452);
        return j;
    }

    private final boolean zzkt() {
        AppMethodBeat.i(69461);
        zzab();
        zzkq();
        if (zzix().zzhs() || !TextUtils.isEmpty(zzix().zzhn())) {
            AppMethodBeat.o(69461);
            return true;
        }
        AppMethodBeat.o(69461);
        return false;
    }

    private final void zzku() {
        AppMethodBeat.i(69464);
        zzab();
        zzkq();
        if (zzky()) {
            long abs;
            if (this.zzaqh > 0) {
                abs = 3600000 - Math.abs(zzbt().elapsedRealtime() - this.zzaqh);
                if (abs > 0) {
                    zzge().zzit().zzg("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzko().unregister();
                    zzkp().cancel();
                    AppMethodBeat.o(69464);
                    return;
                }
                this.zzaqh = 0;
            }
            if (this.zzacw.zzjv() && zzkt()) {
                long currentTimeMillis = zzbt().currentTimeMillis();
                long max = Math.max(0, ((Long) zzew.zzahi.get()).longValue());
                Object obj = (zzix().zzht() || zzix().zzho()) ? 1 : null;
                if (obj != null) {
                    String zzhj = zzgg().zzhj();
                    abs = (TextUtils.isEmpty(zzhj) || ".none.".equals(zzhj)) ? Math.max(0, ((Long) zzew.zzahc.get()).longValue()) : Math.max(0, ((Long) zzew.zzahd.get()).longValue());
                } else {
                    abs = Math.max(0, ((Long) zzew.zzahb.get()).longValue());
                }
                long j = zzgf().zzaju.get();
                long j2 = zzgf().zzajv.get();
                long max2 = Math.max(zzix().zzhq(), zzix().zzhr());
                if (max2 != 0) {
                    max2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
                    j2 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
                    j = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), j2);
                    currentTimeMillis = max2 + max;
                    if (obj != null && j > 0) {
                        currentTimeMillis = Math.min(max2, j) + abs;
                    }
                    abs = !zzgb().zza(j, abs) ? abs + j : currentTimeMillis;
                    if (j2 != 0 && j2 >= max2) {
                        int i = 0;
                        while (true) {
                            currentTimeMillis = abs;
                            if (i >= Math.min(20, Math.max(0, ((Integer) zzew.zzahk.get()).intValue()))) {
                                currentTimeMillis = 0;
                                break;
                            }
                            abs = (Math.max(0, ((Long) zzew.zzahj.get()).longValue()) * (1 << i)) + currentTimeMillis;
                            if (abs > j2) {
                                currentTimeMillis = abs;
                                break;
                            }
                            i++;
                        }
                    } else {
                        currentTimeMillis = abs;
                    }
                } else {
                    currentTimeMillis = 0;
                }
                if (currentTimeMillis == 0) {
                    zzge().zzit().log("Next upload time is 0");
                    zzko().unregister();
                    zzkp().cancel();
                    AppMethodBeat.o(69464);
                    return;
                } else if (zzkn().zzex()) {
                    long j3 = zzgf().zzajw.get();
                    abs = Math.max(0, ((Long) zzew.zzagz.get()).longValue());
                    abs = !zzgb().zza(j3, abs) ? Math.max(currentTimeMillis, abs + j3) : currentTimeMillis;
                    zzko().unregister();
                    abs -= zzbt().currentTimeMillis();
                    if (abs <= 0) {
                        abs = Math.max(0, ((Long) zzew.zzahe.get()).longValue());
                        zzgf().zzaju.set(zzbt().currentTimeMillis());
                    }
                    zzge().zzit().zzg("Upload scheduled in approximately ms", Long.valueOf(abs));
                    zzkp().zzh(abs);
                    AppMethodBeat.o(69464);
                    return;
                } else {
                    zzge().zzit().log("No network");
                    zzko().zzeu();
                    zzkp().cancel();
                    AppMethodBeat.o(69464);
                    return;
                }
            }
            zzge().zzit().log("Nothing to upload or uploading impossible");
            zzko().unregister();
            zzkp().cancel();
            AppMethodBeat.o(69464);
            return;
        }
        AppMethodBeat.o(69464);
    }

    private final void zzkv() {
        AppMethodBeat.i(69466);
        zzab();
        if (this.zzaql || this.zzaqm || this.zzaqn) {
            zzge().zzit().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzaql), Boolean.valueOf(this.zzaqm), Boolean.valueOf(this.zzaqn));
            AppMethodBeat.o(69466);
            return;
        }
        zzge().zzit().log("Stopping uploading service(s)");
        if (this.zzaqi == null) {
            AppMethodBeat.o(69466);
            return;
        }
        for (Runnable run : this.zzaqi) {
            run.run();
        }
        this.zzaqi.clear();
        AppMethodBeat.o(69466);
    }

    @VisibleForTesting
    private final boolean zzkw() {
        AppMethodBeat.i(69468);
        zzab();
        try {
            this.zzaqp = new RandomAccessFile(new File(getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzaqo = this.zzaqp.tryLock();
            if (this.zzaqo != null) {
                zzge().zzit().log("Storage concurrent access okay");
                AppMethodBeat.o(69468);
                return true;
            }
            zzge().zzim().log("Storage concurrent data access panic");
            AppMethodBeat.o(69468);
            return false;
        } catch (FileNotFoundException e) {
            zzge().zzim().zzg("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzge().zzim().zzg("Failed to access storage lock file", e2);
        }
    }

    private final boolean zzky() {
        AppMethodBeat.i(69472);
        zzab();
        zzkq();
        if (this.zzaqg) {
            AppMethodBeat.o(69472);
            return true;
        }
        AppMethodBeat.o(69472);
        return false;
    }

    public Context getContext() {
        AppMethodBeat.i(69444);
        Context context = this.zzacw.getContext();
        AppMethodBeat.o(69444);
        return context;
    }

    /* Access modifiers changed, original: protected */
    public void start() {
        AppMethodBeat.i(69432);
        zzab();
        zzix().zzhp();
        if (zzgf().zzaju.get() == 0) {
            zzgf().zzaju.set(zzbt().currentTimeMillis());
        }
        zzku();
        AppMethodBeat.o(69432);
    }

    /* Access modifiers changed, original: protected|final */
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        AppMethodBeat.i(69460);
        zzab();
        zzkq();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaqm = false;
                zzkv();
                AppMethodBeat.o(69460);
            }
        }
        List<Long> list = this.zzaqq;
        this.zzaqq = null;
        if ((i == 200 || i == 204) && th == null) {
            try {
                zzgf().zzaju.set(zzbt().currentTimeMillis());
                zzgf().zzajv.set(0);
                zzku();
                zzge().zzit().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzix().beginTransaction();
                try {
                    for (Long l : list) {
                        zzei zzix;
                        SQLiteException sQLiteException;
                        try {
                            zzix = zzix();
                            long longValue = l.longValue();
                            zzix.zzab();
                            zzix.zzch();
                            if (zzix.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                sQLiteException = new SQLiteException("Deleted fewer rows from queue than expected");
                                AppMethodBeat.o(69460);
                                throw sQLiteException;
                            }
                        } catch (SQLiteException sQLiteException2) {
                            zzix.zzge().zzim().zzg("Failed to delete a bundle in a queue table", sQLiteException2);
                            AppMethodBeat.o(69460);
                            throw sQLiteException2;
                        } catch (SQLiteException sQLiteException22) {
                            if (this.zzaqr == null || !this.zzaqr.contains(l)) {
                                AppMethodBeat.o(69460);
                                throw sQLiteException22;
                            }
                        }
                    }
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    this.zzaqr = null;
                    if (zzkn().zzex() && zzkt()) {
                        zzks();
                    } else {
                        this.zzaqs = -1;
                        zzku();
                    }
                    this.zzaqh = 0;
                } catch (Throwable th3) {
                    zzix().endTransaction();
                    AppMethodBeat.o(69460);
                }
            } catch (SQLiteException e) {
                zzge().zzim().zzg("Database error while trying to delete uploaded bundles", e);
                this.zzaqh = zzbt().elapsedRealtime();
                zzge().zzit().zzg("Disable upload, time", Long.valueOf(this.zzaqh));
            }
        } else {
            zzge().zzit().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzgf().zzajv.set(zzbt().currentTimeMillis());
            boolean z = i == ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS || i == v2helper.EMethodSetIosMicAbCheckOff;
            if (z) {
                zzgf().zzajw.set(zzbt().currentTimeMillis());
            }
            if (zzgg().zzax(str)) {
                zzix().zzc(list);
            }
            zzku();
        }
        this.zzaqm = false;
        zzkv();
        AppMethodBeat.o(69460);
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzgl zzgl) {
        this.zzacw = zzgl;
    }

    /* Access modifiers changed, original: final */
    public final void zza(zzjw zzjw) {
        AppMethodBeat.i(69431);
        zzab();
        zzei zzei = new zzei(this.zzacw);
        zzei.zzm();
        this.zzaqc = zzei;
        zzgg().zza(this.zzaqa);
        zzeb zzeb = new zzeb(this.zzacw);
        zzeb.zzm();
        this.zzaqf = zzeb;
        zzjn zzjn = new zzjn(this.zzacw);
        zzjn.zzm();
        this.zzaqe = zzjn;
        this.zzaqd = new zzfp(this.zzacw);
        if (this.zzaqj != this.zzaqk) {
            zzge().zzim().zze("Not all upload components initialized", Integer.valueOf(this.zzaqj), Integer.valueOf(this.zzaqk));
        }
        this.zzvo = true;
        AppMethodBeat.o(69431);
    }

    public final byte[] zza(zzeu zzeu, String str) {
        AppMethodBeat.i(69482);
        zzkq();
        zzab();
        zzgl.zzfr();
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotEmpty(str);
        zzace zzkp = new zzkp();
        zzix().beginTransaction();
        try {
            zzdy zzbc = zzix().zzbc(str);
            byte[] bArr;
            if (zzbc == null) {
                zzge().zzis().zzg("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (zzbc.isMeasurementEnabled()) {
                zzks zzks;
                long j;
                if (("_iap".equals(zzeu.name) || a.ECOMMERCE_PURCHASE.equals(zzeu.name)) && !zza(str, zzeu)) {
                    zzge().zzip().zzg("Failed to handle purchase event at single event bundle creation. appId", zzfg.zzbm(str));
                }
                boolean zzav = zzgg().zzav(str);
                Long valueOf = Long.valueOf(0);
                if (zzav && "_e".equals(zzeu.name)) {
                    if (zzeu.zzafq == null || zzeu.zzafq.size() == 0) {
                        zzge().zzip().zzg("The engagement event does not contain any parameters. appId", zzfg.zzbm(str));
                    } else if (zzeu.zzafq.getLong("_et") == null) {
                        zzge().zzip().zzg("The engagement event does not include duration. appId", zzfg.zzbm(str));
                    } else {
                        valueOf = zzeu.zzafq.getLong("_et");
                    }
                }
                zzkq zzkq = new zzkq();
                zzkp.zzatf = new zzkq[]{zzkq};
                zzkq.zzath = Integer.valueOf(1);
                zzkq.zzatp = "android";
                zzkq.zzti = zzbc.zzah();
                zzkq.zzadt = zzbc.zzgn();
                zzkq.zzth = zzbc.zzag();
                long zzgm = zzbc.zzgm();
                zzkq.zzaub = zzgm == -2147483648L ? null : Integer.valueOf((int) zzgm);
                zzkq.zzatt = Long.valueOf(zzbc.zzgo());
                zzkq.zzadm = zzbc.getGmpAppId();
                zzkq.zzatx = Long.valueOf(zzbc.zzgp());
                if (this.zzacw.isEnabled() && zzef.zzhk() && zzgg().zzat(zzkq.zzti)) {
                    zzkq.zzauh = null;
                }
                Pair zzbo = zzgf().zzbo(zzbc.zzah());
                if (!(!zzbc.zzhd() || zzbo == null || TextUtils.isEmpty((CharSequence) zzbo.first))) {
                    zzkq.zzatv = (String) zzbo.first;
                    zzkq.zzatw = (Boolean) zzbo.second;
                }
                zzfw().zzch();
                zzkq.zzatr = Build.MODEL;
                zzfw().zzch();
                zzkq.zzatq = VERSION.RELEASE;
                zzkq.zzats = Integer.valueOf((int) zzfw().zzic());
                zzkq.zzafn = zzfw().zzid();
                zzkq.zzadl = zzbc.getAppInstanceId();
                zzkq.zzado = zzbc.zzgj();
                List zzbb = zzix().zzbb(zzbc.zzah());
                zzkq.zzatj = new zzks[zzbb.size()];
                zzjz zzjz = null;
                if (zzav) {
                    zzjz zzh = zzix().zzh(zzkq.zzti, "_lte");
                    zzjz = (zzh == null || zzh.value == null) ? new zzjz(zzkq.zzti, "auto", "_lte", zzbt().currentTimeMillis(), valueOf) : valueOf.longValue() > 0 ? new zzjz(zzkq.zzti, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(((Long) zzh.value).longValue() + valueOf.longValue())) : zzh;
                }
                zzks zzks2 = null;
                int i = 0;
                while (i < zzbb.size()) {
                    zzks zzks3;
                    zzks = new zzks();
                    zzkq.zzatj[i] = zzks;
                    zzks.name = ((zzjz) zzbb.get(i)).name;
                    zzks.zzaun = Long.valueOf(((zzjz) zzbb.get(i)).zzaqz);
                    zzgb().zza(zzks, ((zzjz) zzbb.get(i)).value);
                    if (zzav && "_lte".equals(zzks.name)) {
                        zzks.zzate = (Long) zzjz.value;
                        zzks.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                        zzks3 = zzks;
                    } else {
                        zzks3 = zzks2;
                    }
                    i++;
                    zzks2 = zzks3;
                }
                if (zzav && zzks2 == null) {
                    zzks = new zzks();
                    zzks.name = "_lte";
                    zzks.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                    zzks.zzate = (Long) zzjz.value;
                    zzkq.zzatj = (zzks[]) Arrays.copyOf(zzkq.zzatj, zzkq.zzatj.length + 1);
                    zzkq.zzatj[zzkq.zzatj.length - 1] = zzks;
                }
                if (valueOf.longValue() > 0) {
                    zzix().zza(zzjz);
                }
                Bundle zzif = zzeu.zzafq.zzif();
                if ("_iap".equals(zzeu.name)) {
                    zzif.putLong("_c", 1);
                    zzge().zzis().log("Marking in-app purchase as real-time");
                    zzif.putLong("_r", 1);
                }
                zzif.putString("_o", zzeu.origin);
                if (zzgb().zzcj(zzkq.zzti)) {
                    zzgb().zza(zzif, "_dbg", Long.valueOf(1));
                    zzgb().zza(zzif, "_r", Long.valueOf(1));
                }
                zzeq zzf = zzix().zzf(str, zzeu.name);
                if (zzf == null) {
                    zzix().zza(new zzeq(str, zzeu.name, 1, 0, zzeu.zzagb, 0, null, null, null));
                    j = 0;
                } else {
                    j = zzf.zzaft;
                    zzix().zza(zzf.zzac(zzeu.zzagb).zzie());
                }
                zzep zzep = new zzep(this.zzacw, zzeu.origin, str, zzeu.name, zzeu.zzagb, j, zzif);
                zzkn zzkn = new zzkn();
                zzkq.zzati = new zzkn[]{zzkn};
                zzkn.zzatb = Long.valueOf(zzep.timestamp);
                zzkn.name = zzep.name;
                zzkn.zzatc = Long.valueOf(zzep.zzafp);
                zzkn.zzata = new zzko[zzep.zzafq.size()];
                Iterator it = zzep.zzafq.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    zzko zzko = new zzko();
                    i = i2 + 1;
                    zzkn.zzata[i2] = zzko;
                    zzko.name = str2;
                    zzgb().zza(zzko, zzep.zzafq.get(str2));
                    i2 = i;
                }
                zzkq.zzaua = zza(zzbc.zzah(), zzkq.zzatj, zzkq.zzati);
                zzkq.zzatl = zzkn.zzatb;
                zzkq.zzatm = zzkn.zzatb;
                zzgm = zzbc.zzgl();
                zzkq.zzato = zzgm != 0 ? Long.valueOf(zzgm) : null;
                long zzgk = zzbc.zzgk();
                if (zzgk != 0) {
                    zzgm = zzgk;
                }
                zzkq.zzatn = zzgm != 0 ? Long.valueOf(zzgm) : null;
                zzbc.zzgt();
                zzkq.zzaty = Integer.valueOf((int) zzbc.zzgq());
                zzkq.zzatu = Long.valueOf(12451);
                zzkq.zzatk = Long.valueOf(zzbt().currentTimeMillis());
                zzkq.zzatz = Boolean.TRUE;
                zzbc.zzm(zzkq.zzatl.longValue());
                zzbc.zzn(zzkq.zzatm.longValue());
                zzix().zza(zzbc);
                zzix().setTransactionSuccessful();
                zzix().endTransaction();
                try {
                    bArr = new byte[zzkp.zzvm()];
                    zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
                    zzkp.zza(zzb);
                    zzb.zzve();
                    bArr = zzgb().zza(bArr);
                    AppMethodBeat.o(69482);
                    return bArr;
                } catch (IOException e) {
                    zzge().zzim().zze("Data loss. Failed to bundle and serialize. appId", zzfg.zzbm(str), e);
                    AppMethodBeat.o(69482);
                    return null;
                }
            } else {
                zzge().zzis().zzg("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                zzix().endTransaction();
                AppMethodBeat.o(69482);
                return bArr;
            }
        } finally {
            zzix().endTransaction();
            AppMethodBeat.o(69482);
        }
    }

    public void zzab() {
        AppMethodBeat.i(69448);
        zzgd().zzab();
        AppMethodBeat.o(69448);
    }

    /* Access modifiers changed, original: final */
    public final void zzb(zzed zzed, zzdz zzdz) {
        boolean z = true;
        AppMethodBeat.i(69479);
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotEmpty(zzed.packageName);
        Preconditions.checkNotNull(zzed.origin);
        Preconditions.checkNotNull(zzed.zzaep);
        Preconditions.checkNotEmpty(zzed.zzaep.name);
        zzab();
        zzkq();
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(69479);
        } else if (zzdz.zzadw) {
            zzed zzed2 = new zzed(zzed);
            zzed2.active = false;
            zzix().beginTransaction();
            try {
                zzed zzi = zzix().zzi(zzed2.packageName, zzed2.zzaep.name);
                if (!(zzi == null || zzi.origin.equals(zzed2.origin))) {
                    zzge().zzip().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzga().zzbl(zzed2.zzaep.name), zzed2.origin, zzi.origin);
                }
                if (zzi != null && zzi.active) {
                    zzed2.origin = zzi.origin;
                    zzed2.creationTimestamp = zzi.creationTimestamp;
                    zzed2.triggerTimeout = zzi.triggerTimeout;
                    zzed2.triggerEventName = zzi.triggerEventName;
                    zzed2.zzaer = zzi.zzaer;
                    zzed2.active = zzi.active;
                    zzed2.zzaep = new zzjx(zzed2.zzaep.name, zzi.zzaep.zzaqz, zzed2.zzaep.getValue(), zzi.zzaep.origin);
                    z = false;
                } else if (TextUtils.isEmpty(zzed2.triggerEventName)) {
                    zzed2.zzaep = new zzjx(zzed2.zzaep.name, zzed2.creationTimestamp, zzed2.zzaep.getValue(), zzed2.zzaep.origin);
                    zzed2.active = true;
                } else {
                    z = false;
                }
                if (zzed2.active) {
                    zzjx zzjx = zzed2.zzaep;
                    zzjz zzjz = new zzjz(zzed2.packageName, zzed2.origin, zzjx.name, zzjx.zzaqz, zzjx.getValue());
                    if (zzix().zza(zzjz)) {
                        zzge().zzis().zzd("User property updated immediately", zzed2.packageName, zzga().zzbl(zzjz.name), zzjz.value);
                    } else {
                        zzge().zzim().zzd("(2)Too many active user properties, ignoring", zzfg.zzbm(zzed2.packageName), zzga().zzbl(zzjz.name), zzjz.value);
                    }
                    if (z && zzed2.zzaer != null) {
                        zzc(new zzeu(zzed2.zzaer, zzed2.creationTimestamp), zzdz);
                    }
                }
                if (zzix().zza(zzed2)) {
                    zzge().zzis().zzd("Conditional property added", zzed2.packageName, zzga().zzbl(zzed2.zzaep.name), zzed2.zzaep.getValue());
                } else {
                    zzge().zzim().zzd("Too many conditional properties, ignoring", zzfg.zzbm(zzed2.packageName), zzga().zzbl(zzed2.zzaep.name), zzed2.zzaep.getValue());
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(69479);
            }
        } else {
            zzg(zzdz);
            AppMethodBeat.o(69479);
        }
    }

    /* Access modifiers changed, original: final */
    public final void zzb(zzeu zzeu, zzdz zzdz) {
        AppMethodBeat.i(69454);
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzab();
        zzkq();
        String str = zzdz.packageName;
        long j = zzeu.zzagb;
        zzgb();
        if (!zzka.zzd(zzeu, zzdz)) {
            AppMethodBeat.o(69454);
        } else if (zzdz.zzadw) {
            zzix().beginTransaction();
            try {
                List emptyList;
                Object obj;
                zzei zzix = zzix();
                Preconditions.checkNotEmpty(str);
                zzix.zzab();
                zzix.zzch();
                if (j < 0) {
                    zzix.zzge().zzip().zze("Invalid time querying timed out conditional properties", zzfg.zzbm(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzix.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzed zzed : emptyList) {
                    if (zzed != null) {
                        zzge().zzis().zzd("User property timed out", zzed.packageName, zzga().zzbl(zzed.zzaep.name), zzed.zzaep.getValue());
                        if (zzed.zzaeq != null) {
                            zzc(new zzeu(zzed.zzaeq, j), zzdz);
                        }
                        zzix().zzj(str, zzed.zzaep.name);
                    }
                }
                zzix = zzix();
                Preconditions.checkNotEmpty(str);
                zzix.zzab();
                zzix.zzch();
                if (j < 0) {
                    zzix.zzge().zzip().zze("Invalid time querying expired conditional properties", zzfg.zzbm(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzix.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(r2.size());
                for (zzed zzed2 : r2) {
                    if (zzed2 != null) {
                        zzge().zzis().zzd("User property expired", zzed2.packageName, zzga().zzbl(zzed2.zzaep.name), zzed2.zzaep.getValue());
                        zzix().zzg(str, zzed2.zzaep.name);
                        if (zzed2.zzaes != null) {
                            arrayList.add(zzed2.zzaes);
                        }
                        zzix().zzj(str, zzed2.zzaep.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    obj = arrayList2.get(i);
                    i++;
                    zzc(new zzeu((zzeu) obj, j), zzdz);
                }
                zzix = zzix();
                String str2 = zzeu.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzix.zzab();
                zzix.zzch();
                if (j < 0) {
                    zzix.zzge().zzip().zzd("Invalid time querying triggered conditional properties", zzfg.zzbm(str), zzix.zzga().zzbj(str2), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzix.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(r2.size());
                for (zzed zzed3 : r2) {
                    if (zzed3 != null) {
                        zzjx zzjx = zzed3.zzaep;
                        zzjz zzjz = new zzjz(zzed3.packageName, zzed3.origin, zzjx.name, j, zzjx.getValue());
                        if (zzix().zza(zzjz)) {
                            zzge().zzis().zzd("User property triggered", zzed3.packageName, zzga().zzbl(zzjz.name), zzjz.value);
                        } else {
                            zzge().zzim().zzd("Too many active user properties, ignoring", zzfg.zzbm(zzed3.packageName), zzga().zzbl(zzjz.name), zzjz.value);
                        }
                        if (zzed3.zzaer != null) {
                            arrayList3.add(zzed3.zzaer);
                        }
                        zzed3.zzaep = new zzjx(zzjz);
                        zzed3.active = true;
                        zzix().zza(zzed3);
                    }
                }
                zzc(zzeu, zzdz);
                arrayList2 = arrayList3;
                int size2 = arrayList2.size();
                i = 0;
                while (i < size2) {
                    obj = arrayList2.get(i);
                    i++;
                    zzc(new zzeu((zzeu) obj, j), zzdz);
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(69454);
            }
        } else {
            zzg(zzdz);
            AppMethodBeat.o(69454);
        }
    }

    /* Access modifiers changed, original: final */
    public final void zzb(zzjq zzjq) {
        this.zzaqj++;
    }

    /* Access modifiers changed, original: final */
    public final void zzb(zzjx zzjx, zzdz zzdz) {
        int i = 0;
        AppMethodBeat.i(69475);
        zzab();
        zzkq();
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(69475);
        } else if (zzdz.zzadw) {
            int zzcf = zzgb().zzcf(zzjx.name);
            String zza;
            if (zzcf != 0) {
                zzgb();
                zza = zzka.zza(zzjx.name, 24, true);
                if (zzjx.name != null) {
                    i = zzjx.name.length();
                }
                zzgb().zza(zzdz.packageName, zzcf, "_ev", zza, i);
                AppMethodBeat.o(69475);
                return;
            }
            zzcf = zzgb().zzi(zzjx.name, zzjx.getValue());
            if (zzcf != 0) {
                zzgb();
                zza = zzka.zza(zzjx.name, 24, true);
                Object value = zzjx.getValue();
                if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                    i = String.valueOf(value).length();
                }
                zzgb().zza(zzdz.packageName, zzcf, "_ev", zza, i);
                AppMethodBeat.o(69475);
                return;
            }
            Object zzj = zzgb().zzj(zzjx.name, zzjx.getValue());
            if (zzj == null) {
                AppMethodBeat.o(69475);
                return;
            }
            zzjz zzjz = new zzjz(zzdz.packageName, zzjx.origin, zzjx.name, zzjx.zzaqz, zzj);
            zzge().zzis().zze("Setting user property", zzga().zzbl(zzjz.name), zzj);
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                boolean zza2 = zzix().zza(zzjz);
                zzix().setTransactionSuccessful();
                if (zza2) {
                    zzge().zzis().zze("User property set", zzga().zzbl(zzjz.name), zzjz.value);
                } else {
                    zzge().zzim().zze("Too many unique user properties are set. Ignoring user property", zzga().zzbl(zzjz.name), zzjz.value);
                    zzgb().zza(zzdz.packageName, 9, null, null, 0);
                }
                zzix().endTransaction();
                AppMethodBeat.o(69475);
            } catch (Throwable th) {
                zzix().endTransaction();
                AppMethodBeat.o(69475);
            }
        } else {
            zzg(zzdz);
            AppMethodBeat.o(69475);
        }
    }

    /* Access modifiers changed, original: final */
    @VisibleForTesting
    public final void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = true;
        AppMethodBeat.i(69463);
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaql = false;
                zzkv();
                AppMethodBeat.o(69463);
            }
        }
        zzge().zzit().zzg("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzix().beginTransaction();
        zzdy zzbc = zzix().zzbc(str);
        boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
        if (zzbc == null) {
            zzge().zzip().zzg("App does not exist in onConfigFetched. appId", zzfg.zzbm(str));
        } else if (z2 || i == 404) {
            List list = map != null ? (List) map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i == 404 || i == 304) {
                if (zzkm().zzbu(str) == null && !zzkm().zza(str, null, null)) {
                    zzix().endTransaction();
                    this.zzaql = false;
                    zzkv();
                    AppMethodBeat.o(69463);
                    return;
                }
            } else if (!zzkm().zza(str, bArr, str2)) {
                zzix().endTransaction();
                this.zzaql = false;
                zzkv();
                AppMethodBeat.o(69463);
                return;
            }
            zzbc.zzs(zzbt().currentTimeMillis());
            zzix().zza(zzbc);
            if (i == 404) {
                zzge().zziq().zzg("Config not found. Using empty config. appId", str);
            } else {
                zzge().zzit().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            }
            if (zzkn().zzex() && zzkt()) {
                zzks();
            } else {
                zzku();
            }
        } else {
            zzbc.zzt(zzbt().currentTimeMillis());
            zzix().zza(zzbc);
            zzge().zzit().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
            zzkm().zzbw(str);
            zzgf().zzajv.set(zzbt().currentTimeMillis());
            if (!(i == ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS || i == v2helper.EMethodSetIosMicAbCheckOff)) {
                z = false;
            }
            if (z) {
                zzgf().zzajw.set(zzbt().currentTimeMillis());
            }
            zzku();
        }
        zzix().setTransactionSuccessful();
        zzix().endTransaction();
        this.zzaql = false;
        zzkv();
        AppMethodBeat.o(69463);
    }

    public Clock zzbt() {
        AppMethodBeat.i(69445);
        Clock zzbt = this.zzacw.zzbt();
        AppMethodBeat.o(69445);
        return zzbt;
    }

    /* Access modifiers changed, original: final */
    public final void zzc(zzed zzed, zzdz zzdz) {
        AppMethodBeat.i(69480);
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotEmpty(zzed.packageName);
        Preconditions.checkNotNull(zzed.zzaep);
        Preconditions.checkNotEmpty(zzed.zzaep.name);
        zzab();
        zzkq();
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(69480);
        } else if (zzdz.zzadw) {
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                zzed zzi = zzix().zzi(zzed.packageName, zzed.zzaep.name);
                if (zzi != null) {
                    zzge().zzis().zze("Removing conditional user property", zzed.packageName, zzga().zzbl(zzed.zzaep.name));
                    zzix().zzj(zzed.packageName, zzed.zzaep.name);
                    if (zzi.active) {
                        zzix().zzg(zzed.packageName, zzed.zzaep.name);
                    }
                    if (zzed.zzaes != null) {
                        Bundle bundle = null;
                        if (zzed.zzaes.zzafq != null) {
                            bundle = zzed.zzaes.zzafq.zzif();
                        }
                        zzc(zzgb().zza(zzed.zzaes.name, bundle, zzi.origin, zzed.zzaes.zzagb, true, false), zzdz);
                    }
                } else {
                    zzge().zzip().zze("Conditional user property doesn't exist", zzfg.zzbm(zzed.packageName), zzga().zzbl(zzed.zzaep.name));
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(69480);
            }
        } else {
            zzg(zzdz);
            AppMethodBeat.o(69480);
        }
    }

    /* Access modifiers changed, original: final */
    public final void zzc(zzeu zzeu, String str) {
        AppMethodBeat.i(69453);
        zzdy zzbc = zzix().zzbc(str);
        if (zzbc == null || TextUtils.isEmpty(zzbc.zzag())) {
            zzge().zzis().zzg("No app data available; dropping event", str);
            AppMethodBeat.o(69453);
            return;
        }
        Boolean zzc = zzc(zzbc);
        if (zzc == null) {
            if (!"_ui".equals(zzeu.name)) {
                zzge().zzip().zzg("Could not find package. appId", zzfg.zzbm(str));
            }
        } else if (!zzc.booleanValue()) {
            zzge().zzim().zzg("App version does not match; dropping event. appId", zzfg.zzbm(str));
            AppMethodBeat.o(69453);
            return;
        }
        zzeu zzeu2 = zzeu;
        zzb(zzeu2, new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), null, zzbc.isMeasurementEnabled(), false, zzbc.zzgj(), zzbc.zzhc(), 0, 0, zzbc.zzhd(), zzbc.zzhe(), false));
        AppMethodBeat.o(69453);
    }

    /* Access modifiers changed, original: final */
    public final void zzc(zzjx zzjx, zzdz zzdz) {
        AppMethodBeat.i(69476);
        zzab();
        zzkq();
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(69476);
        } else if (zzdz.zzadw) {
            zzge().zzis().zzg("Removing user property", zzga().zzbl(zzjx.name));
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                zzix().zzg(zzdz.packageName, zzjx.name);
                zzix().setTransactionSuccessful();
                zzge().zzis().zzg("User property removed", zzga().zzbl(zzjx.name));
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(69476);
            }
        } else {
            zzg(zzdz);
            AppMethodBeat.o(69476);
        }
    }

    /* Access modifiers changed, original: final */
    public final zzdz zzcb(String str) {
        AppMethodBeat.i(69478);
        zzdy zzbc = zzix().zzbc(str);
        if (zzbc == null || TextUtils.isEmpty(zzbc.zzag())) {
            zzge().zzis().zzg("No app data available; dropping", str);
            AppMethodBeat.o(69478);
            return null;
        }
        Boolean zzc = zzc(zzbc);
        if (zzc == null || zzc.booleanValue()) {
            zzdz zzdz = new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), null, zzbc.isMeasurementEnabled(), false, zzbc.zzgj(), zzbc.zzhc(), 0, 0, zzbc.zzhd(), zzbc.zzhe(), false);
            AppMethodBeat.o(69478);
            return zzdz;
        }
        zzge().zzim().zzg("App version does not match; dropping. appId", zzfg.zzbm(str));
        AppMethodBeat.o(69478);
        return null;
    }

    /* Access modifiers changed, original: final */
    @VisibleForTesting
    public final void zzd(zzdz zzdz) {
        AppMethodBeat.i(69473);
        if (this.zzaqq != null) {
            this.zzaqr = new ArrayList();
            this.zzaqr.addAll(this.zzaqq);
        }
        zzei zzix = zzix();
        String str = zzdz.packageName;
        Preconditions.checkNotEmpty(str);
        zzix.zzab();
        zzix.zzch();
        try {
            SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
            String[] strArr = new String[]{str};
            int delete = writableDatabase.delete("main_event_params", "app_id=?", strArr) + ((((((((writableDatabase.delete("apps", "app_id=?", strArr) + 0) + writableDatabase.delete("events", "app_id=?", strArr)) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("queue", "app_id=?", strArr)) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr));
            if (delete > 0) {
                zzix.zzge().zzit().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzix.zzge().zzim().zze("Error resetting analytics data. appId, error", zzfg.zzbm(str), e);
        }
        zzdz zza = zza(getContext(), zzdz.packageName, zzdz.zzadm, zzdz.zzadw, zzdz.zzady, zzdz.zzadz, zzdz.zzaem);
        if (!zzgg().zzaz(zzdz.packageName) || zzdz.zzadw) {
            zzf(zza);
        }
        AppMethodBeat.o(69473);
    }

    /* Access modifiers changed, original: final */
    public final void zze(zzdz zzdz) {
        AppMethodBeat.i(69451);
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzg(zzdz);
        AppMethodBeat.o(69451);
    }

    public final void zzf(zzdz zzdz) {
        AppMethodBeat.i(69477);
        zzab();
        zzkq();
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(69477);
            return;
        }
        zzdy zzbc = zzix().zzbc(zzdz.packageName);
        if (!(zzbc == null || !TextUtils.isEmpty(zzbc.getGmpAppId()) || TextUtils.isEmpty(zzdz.zzadm))) {
            zzbc.zzs(0);
            zzix().zza(zzbc);
            zzkm().zzbx(zzdz.packageName);
        }
        if (zzdz.zzadw) {
            int i;
            Bundle bundle;
            long j = zzdz.zzaem;
            if (j == 0) {
                j = zzbt().currentTimeMillis();
            }
            int i2 = zzdz.zzaen;
            if (i2 == 0 || i2 == 1) {
                i = i2;
            } else {
                zzge().zzip().zze("Incorrect app type, assuming installed app. appId, appType", zzfg.zzbm(zzdz.packageName), Integer.valueOf(i2));
                i = 0;
            }
            zzix().beginTransaction();
            zzei zzix;
            String zzah;
            try {
                zzbc = zzix().zzbc(zzdz.packageName);
                if (!(zzbc == null || zzbc.getGmpAppId() == null || zzbc.getGmpAppId().equals(zzdz.zzadm))) {
                    zzge().zzip().zzg("New GMP App Id passed in. Removing cached database data. appId", zzfg.zzbm(zzbc.zzah()));
                    zzix = zzix();
                    zzah = zzbc.zzah();
                    zzix.zzch();
                    zzix.zzab();
                    Preconditions.checkNotEmpty(zzah);
                    SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
                    String[] strArr = new String[]{zzah};
                    i2 = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + ((((((((writableDatabase.delete("events", "app_id=?", strArr) + 0) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("apps", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("event_filters", "app_id=?", strArr)) + writableDatabase.delete("property_filters", "app_id=?", strArr));
                    if (i2 > 0) {
                        zzix.zzge().zzit().zze("Deleted application data. app, records", zzah, Integer.valueOf(i2));
                    }
                    zzbc = null;
                }
            } catch (SQLiteException e) {
                zzix.zzge().zzim().zze("Error deleting application data. appId, error", zzfg.zzbm(zzah), e);
            } catch (Throwable th) {
                zzix().endTransaction();
                AppMethodBeat.o(69477);
            }
            if (zzbc != null) {
                if (zzbc.zzgm() != -2147483648L) {
                    if (zzbc.zzgm() != zzdz.zzads) {
                        bundle = new Bundle();
                        bundle.putString("_pv", zzbc.zzag());
                        zzb(new zzeu("_au", new zzer(bundle), "auto", j), zzdz);
                    }
                } else if (!(zzbc.zzag() == null || zzbc.zzag().equals(zzdz.zzth))) {
                    bundle = new Bundle();
                    bundle.putString("_pv", zzbc.zzag());
                    zzb(new zzeu("_au", new zzer(bundle), "auto", j), zzdz);
                }
            }
            zzg(zzdz);
            zzeq zzeq = null;
            if (i == 0) {
                zzeq = zzix().zzf(zzdz.packageName, "_f");
            } else if (i == 1) {
                zzeq = zzix().zzf(zzdz.packageName, "_v");
            }
            if (zzeq == null) {
                long j2 = (1 + (j / 3600000)) * 3600000;
                if (i == 0) {
                    zzb(new zzjx("_fot", j, Long.valueOf(j2), "auto"), zzdz);
                    zzab();
                    zzkq();
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("_c", 1);
                    bundle2.putLong("_r", 1);
                    bundle2.putLong("_uwa", 0);
                    bundle2.putLong("_pfo", 0);
                    bundle2.putLong("_sys", 0);
                    bundle2.putLong("_sysu", 0);
                    if (zzgg().zzaz(zzdz.packageName) && zzdz.zzaeo) {
                        bundle2.putLong("_dac", 1);
                    }
                    if (getContext().getPackageManager() == null) {
                        zzge().zzim().zzg("PackageManager is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz.packageName));
                    } else {
                        ApplicationInfo applicationInfo;
                        PackageInfo packageInfo = null;
                        try {
                            packageInfo = Wrappers.packageManager(getContext()).getPackageInfo(zzdz.packageName, 0);
                        } catch (NameNotFoundException e2) {
                            zzge().zzim().zze("Package info is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz.packageName), e2);
                        }
                        if (packageInfo != null) {
                            if (packageInfo.firstInstallTime != 0) {
                                Object obj = null;
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    bundle2.putLong("_uwa", 1);
                                } else {
                                    obj = 1;
                                }
                                zzb(new zzjx("_fi", j, Long.valueOf(obj != null ? 1 : 0), "auto"), zzdz);
                            }
                        }
                        try {
                            applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(zzdz.packageName, 0);
                        } catch (NameNotFoundException e22) {
                            zzge().zzim().zze("Application info is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz.packageName), e22);
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle2.putLong("_sys", 1);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle2.putLong("_sysu", 1);
                            }
                        }
                    }
                    zzei zzix2 = zzix();
                    String str = zzdz.packageName;
                    Preconditions.checkNotEmpty(str);
                    zzix2.zzab();
                    zzix2.zzch();
                    j2 = zzix2.zzm(str, "first_open_count");
                    if (j2 >= 0) {
                        bundle2.putLong("_pfo", j2);
                    }
                    zzb(new zzeu("_f", new zzer(bundle2), "auto", j), zzdz);
                } else if (i == 1) {
                    zzb(new zzjx("_fvt", j, Long.valueOf(j2), "auto"), zzdz);
                    zzab();
                    zzkq();
                    bundle = new Bundle();
                    bundle.putLong("_c", 1);
                    bundle.putLong("_r", 1);
                    if (zzgg().zzaz(zzdz.packageName) && zzdz.zzaeo) {
                        bundle.putLong("_dac", 1);
                    }
                    zzb(new zzeu("_v", new zzer(bundle), "auto", j), zzdz);
                }
                bundle = new Bundle();
                bundle.putLong("_et", 1);
                zzb(new zzeu("_e", new zzer(bundle), "auto", j), zzdz);
            } else if (zzdz.zzael) {
                zzb(new zzeu("_cd", new zzer(new Bundle()), "auto", j), zzdz);
            }
            zzix().setTransactionSuccessful();
            zzix().endTransaction();
            AppMethodBeat.o(69477);
            return;
        }
        zzg(zzdz);
        AppMethodBeat.o(69477);
    }

    public zzeo zzfw() {
        AppMethodBeat.i(69447);
        zzeo zzfw = this.zzacw.zzfw();
        AppMethodBeat.o(69447);
        return zzfw;
    }

    /* Access modifiers changed, original: final */
    public final void zzg(Runnable runnable) {
        AppMethodBeat.i(69465);
        zzab();
        if (this.zzaqi == null) {
            this.zzaqi = new ArrayList();
        }
        this.zzaqi.add(runnable);
        AppMethodBeat.o(69465);
    }

    public zzfe zzga() {
        AppMethodBeat.i(69443);
        zzfe zzga = this.zzacw.zzga();
        AppMethodBeat.o(69443);
        return zzga;
    }

    public zzka zzgb() {
        AppMethodBeat.i(69446);
        zzka zzgb = this.zzacw.zzgb();
        AppMethodBeat.o(69446);
        return zzgb;
    }

    public zzgg zzgd() {
        AppMethodBeat.i(69436);
        zzgg zzgd = this.zzacw.zzgd();
        AppMethodBeat.o(69436);
        return zzgd;
    }

    public zzfg zzge() {
        AppMethodBeat.i(69435);
        zzfg zzge = this.zzacw.zzge();
        AppMethodBeat.o(69435);
        return zzge;
    }

    public zzfr zzgf() {
        AppMethodBeat.i(69434);
        zzfr zzgf = this.zzacw.zzgf();
        AppMethodBeat.o(69434);
        return zzgf;
    }

    public zzef zzgg() {
        AppMethodBeat.i(69433);
        zzef zzgg = this.zzacw.zzgg();
        AppMethodBeat.o(69433);
        return zzgg;
    }

    public final String zzh(zzdz zzdz) {
        AppMethodBeat.i(69483);
        try {
            String str = (String) zzgd().zzb(new zzju(this, zzdz)).get(30000, TimeUnit.MILLISECONDS);
            AppMethodBeat.o(69483);
            return str;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzge().zzim().zze("Failed to get app instance id. appId", zzfg.zzbm(zzdz.packageName), e);
            AppMethodBeat.o(69483);
            return null;
        }
    }

    public final zzeb zziw() {
        AppMethodBeat.i(69442);
        zza(this.zzaqf);
        zzeb zzeb = this.zzaqf;
        AppMethodBeat.o(69442);
        return zzeb;
    }

    public final zzei zzix() {
        AppMethodBeat.i(69439);
        zza(this.zzaqc);
        zzei zzei = this.zzaqc;
        AppMethodBeat.o(69439);
        return zzei;
    }

    public final zzfk zzkn() {
        AppMethodBeat.i(69438);
        zza(this.zzaqb);
        zzfk zzfk = this.zzaqb;
        AppMethodBeat.o(69438);
        return zzfk;
    }

    /* Access modifiers changed, original: final */
    public final void zzkq() {
        AppMethodBeat.i(69449);
        if (this.zzvo) {
            AppMethodBeat.o(69449);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("UploadController is not initialized");
        AppMethodBeat.o(69449);
        throw illegalStateException;
    }

    public final void zzks() {
        AppMethodBeat.i(69457);
        zzab();
        zzkq();
        this.zzaqn = true;
        String zzhn;
        String str;
        try {
            Boolean zzkf = this.zzacw.zzfx().zzkf();
            if (zzkf == null) {
                zzge().zzip().log("Upload data called on the client side before use of service was decided");
                this.zzaqn = false;
                zzkv();
                AppMethodBeat.o(69457);
            } else if (zzkf.booleanValue()) {
                zzge().zzim().log("Upload called in the client side when service should be used");
                this.zzaqn = false;
                zzkv();
                AppMethodBeat.o(69457);
            } else if (this.zzaqh > 0) {
                zzku();
                this.zzaqn = false;
                zzkv();
                AppMethodBeat.o(69457);
            } else {
                zzab();
                if ((this.zzaqq != null ? 1 : null) != null) {
                    zzge().zzit().log("Uploading requested multiple times");
                    this.zzaqn = false;
                    zzkv();
                    AppMethodBeat.o(69457);
                } else if (zzkn().zzex()) {
                    long currentTimeMillis = zzbt().currentTimeMillis();
                    zzd(null, currentTimeMillis - zzef.zzhi());
                    long j = zzgf().zzaju.get();
                    if (j != 0) {
                        zzge().zzis().zzg("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                    }
                    zzhn = zzix().zzhn();
                    if (TextUtils.isEmpty(zzhn)) {
                        this.zzaqs = -1;
                        String zzab = zzix().zzab(currentTimeMillis - zzef.zzhi());
                        if (!TextUtils.isEmpty(zzab)) {
                            zzdy zzbc = zzix().zzbc(zzab);
                            if (zzbc != null) {
                                zzb(zzbc);
                            }
                        }
                    } else {
                        if (this.zzaqs == -1) {
                            this.zzaqs = zzix().zzhu();
                        }
                        List<Pair> zzb = zzix().zzb(zzhn, zzgg().zzb(zzhn, zzew.zzago), Math.max(0, zzgg().zzb(zzhn, zzew.zzagp)));
                        if (!zzb.isEmpty()) {
                            zzkq zzkq;
                            Object obj;
                            int i;
                            List subList;
                            for (Pair pair : zzb) {
                                zzkq = (zzkq) pair.first;
                                if (!TextUtils.isEmpty(zzkq.zzatv)) {
                                    obj = zzkq.zzatv;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                for (i = 0; i < zzb.size(); i++) {
                                    zzkq = (zzkq) ((Pair) zzb.get(i)).first;
                                    if (!TextUtils.isEmpty(zzkq.zzatv) && !zzkq.zzatv.equals(obj)) {
                                        subList = zzb.subList(0, i);
                                        break;
                                    }
                                }
                            }
                            subList = zzb;
                            zzkp zzkp = new zzkp();
                            zzkp.zzatf = new zzkq[subList.size()];
                            ArrayList arrayList = new ArrayList(subList.size());
                            Object obj2 = (zzef.zzhk() && zzgg().zzat(zzhn)) ? 1 : null;
                            for (i = 0; i < zzkp.zzatf.length; i++) {
                                zzkp.zzatf[i] = (zzkq) ((Pair) subList.get(i)).first;
                                arrayList.add((Long) ((Pair) subList.get(i)).second);
                                zzkp.zzatf[i].zzatu = Long.valueOf(12451);
                                zzkp.zzatf[i].zzatk = Long.valueOf(currentTimeMillis);
                                zzkp.zzatf[i].zzatz = Boolean.FALSE;
                                if (obj2 == null) {
                                    zzkp.zzatf[i].zzauh = null;
                                }
                            }
                            obj2 = zzge().isLoggable(2) ? zzga().zza(zzkp) : null;
                            byte[] zzb2 = zzgb().zzb(zzkp);
                            str = (String) zzew.zzagy.get();
                            URL url = new URL(str);
                            Preconditions.checkArgument(!arrayList.isEmpty());
                            if (this.zzaqq != null) {
                                zzge().zzim().log("Set uploading progress before finishing the previous upload");
                            } else {
                                this.zzaqq = new ArrayList(arrayList);
                            }
                            zzgf().zzajv.set(currentTimeMillis);
                            Object obj3 = "?";
                            if (zzkp.zzatf.length > 0) {
                                obj3 = zzkp.zzatf[0].zzti;
                            }
                            zzge().zzit().zzd("Uploading data. app, uncompressed size, data", obj3, Integer.valueOf(zzb2.length), obj2);
                            this.zzaqm = true;
                            zzfk zzkn = zzkn();
                            zzjs zzjs = new zzjs(this, zzhn);
                            zzkn.zzab();
                            zzkn.zzch();
                            Preconditions.checkNotNull(url);
                            Preconditions.checkNotNull(zzb2);
                            Preconditions.checkNotNull(zzjs);
                            zzkn.zzgd().zzd(new zzfo(zzkn, zzhn, url, zzb2, null, zzjs));
                        }
                    }
                    this.zzaqn = false;
                    zzkv();
                    AppMethodBeat.o(69457);
                } else {
                    zzge().zzit().log("Network not connected, ignoring upload request");
                    zzku();
                    this.zzaqn = false;
                    zzkv();
                    AppMethodBeat.o(69457);
                }
            }
        } catch (MalformedURLException e) {
            zzge().zzim().zze("Failed to parse upload URL. Not uploading. appId", zzfg.zzbm(zzhn), str);
        } catch (Throwable th) {
            this.zzaqn = false;
            zzkv();
            AppMethodBeat.o(69457);
        }
    }

    /* Access modifiers changed, original: final */
    public final void zzkx() {
        AppMethodBeat.i(69471);
        zzab();
        zzkq();
        if (!this.zzaqg) {
            zzge().zzir().log("This instance being marked as an uploader");
            zzab();
            zzkq();
            if (zzky() && zzkw()) {
                int zza = zza(this.zzaqp);
                int zzij = this.zzacw.zzfv().zzij();
                zzab();
                if (zza > zzij) {
                    zzge().zzim().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzij));
                } else if (zza < zzij) {
                    if (zza(zzij, this.zzaqp)) {
                        zzge().zzit().zze("Storage version upgraded. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzij));
                    } else {
                        zzge().zzim().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzij));
                    }
                }
            }
            this.zzaqg = true;
            zzku();
        }
        AppMethodBeat.o(69471);
    }

    /* Access modifiers changed, original: final */
    public final void zzkz() {
        this.zzaqk++;
    }

    /* Access modifiers changed, original: final */
    public final zzgl zzla() {
        return this.zzacw;
    }

    public final void zzm(boolean z) {
        AppMethodBeat.i(69484);
        zzku();
        AppMethodBeat.o(69484);
    }
}
