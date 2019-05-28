package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.util.Locale;

final class zzfr extends zzhh {
    @VisibleForTesting
    static final Pair<String, Long> zzajs = new Pair("", Long.valueOf(0));
    private SharedPreferences zzabf;
    public zzfv zzajt;
    public final zzfu zzaju = new zzfu(this, "last_upload", 0);
    public final zzfu zzajv = new zzfu(this, "last_upload_attempt", 0);
    public final zzfu zzajw = new zzfu(this, "backoff", 0);
    public final zzfu zzajx = new zzfu(this, "last_delete_stale", 0);
    public final zzfu zzajy = new zzfu(this, "midnight_offset", 0);
    public final zzfu zzajz = new zzfu(this, "first_open_time", 0);
    public final zzfu zzaka = new zzfu(this, "app_install_time", 0);
    public final zzfw zzakb = new zzfw(this, "app_instance_id", null);
    private String zzakc;
    private boolean zzakd;
    private long zzake;
    private String zzakf;
    private long zzakg;
    private final Object zzakh = new Object();
    public final zzfu zzaki = new zzfu(this, "time_before_start", 10000);
    public final zzfu zzakj = new zzfu(this, "session_timeout", 1800000);
    public final zzft zzakk = new zzft(this, "start_new_session", true);
    public final zzfu zzakl = new zzfu(this, "last_pause_time", 0);
    public final zzfu zzakm = new zzfu(this, "time_active", 0);
    public boolean zzakn;

    static {
        AppMethodBeat.i(68959);
        AppMethodBeat.o(68959);
    }

    zzfr(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(68942);
        AppMethodBeat.o(68942);
    }

    static /* synthetic */ SharedPreferences zza(zzfr zzfr) {
        AppMethodBeat.i(68958);
        SharedPreferences zziy = zzfr.zziy();
        AppMethodBeat.o(68958);
        return zziy;
    }

    private final SharedPreferences zziy() {
        AppMethodBeat.i(68944);
        zzab();
        zzch();
        SharedPreferences sharedPreferences = this.zzabf;
        AppMethodBeat.o(68944);
        return sharedPreferences;
    }

    /* Access modifiers changed, original: final */
    public final void setMeasurementEnabled(boolean z) {
        AppMethodBeat.i(68952);
        zzab();
        zzge().zzit().zzg("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = zziy().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
        AppMethodBeat.o(68952);
    }

    /* Access modifiers changed, original: final */
    public final Pair<String, Boolean> zzbo(String str) {
        AppMethodBeat.i(68940);
        zzab();
        long elapsedRealtime = zzbt().elapsedRealtime();
        Pair pair;
        if (this.zzakc == null || elapsedRealtime >= this.zzake) {
            this.zzake = elapsedRealtime + zzgg().zza(str, zzew.zzagj);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            try {
                Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
                if (advertisingIdInfo != null) {
                    this.zzakc = advertisingIdInfo.getId();
                    this.zzakd = advertisingIdInfo.isLimitAdTrackingEnabled();
                }
                if (this.zzakc == null) {
                    this.zzakc = "";
                }
            } catch (Exception e) {
                zzge().zzis().zzg("Unable to get advertising id", e);
                this.zzakc = "";
            }
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            pair = new Pair(this.zzakc, Boolean.valueOf(this.zzakd));
            AppMethodBeat.o(68940);
            return pair;
        }
        pair = new Pair(this.zzakc, Boolean.valueOf(this.zzakd));
        AppMethodBeat.o(68940);
        return pair;
    }

    /* Access modifiers changed, original: final */
    public final String zzbp(String str) {
        AppMethodBeat.i(68941);
        zzab();
        String str2 = (String) zzbo(str).first;
        if (zzka.getMessageDigest("MD5") == null) {
            AppMethodBeat.o(68941);
            return null;
        }
        str2 = String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzka.getMessageDigest("MD5").digest(str2.getBytes()))});
        AppMethodBeat.o(68941);
        return str2;
    }

    /* Access modifiers changed, original: final */
    public final void zzbq(String str) {
        AppMethodBeat.i(68945);
        zzab();
        Editor edit = zziy().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
        AppMethodBeat.o(68945);
    }

    /* Access modifiers changed, original: final */
    public final void zzbr(String str) {
        AppMethodBeat.i(68947);
        synchronized (this.zzakh) {
            try {
                this.zzakf = str;
                this.zzakg = zzbt().elapsedRealtime();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(68947);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void zzf(boolean z) {
        AppMethodBeat.i(68950);
        zzab();
        zzge().zzit().zzg("Setting useService", Boolean.valueOf(z));
        Editor edit = zziy().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
        AppMethodBeat.o(68950);
    }

    /* Access modifiers changed, original: final */
    public final boolean zzg(boolean z) {
        AppMethodBeat.i(68953);
        zzab();
        boolean z2 = zziy().getBoolean("measurement_enabled", z);
        AppMethodBeat.o(68953);
        return z2;
    }

    /* Access modifiers changed, original: final */
    public final void zzh(boolean z) {
        AppMethodBeat.i(68955);
        zzab();
        zzge().zzit().zzg("Updating deferred analytics collection", Boolean.valueOf(z));
        Editor edit = zziy().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
        AppMethodBeat.o(68955);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzih() {
        AppMethodBeat.i(68943);
        this.zzabf = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzakn = this.zzabf.getBoolean("has_been_opened", false);
        if (!this.zzakn) {
            Editor edit = this.zzabf.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzajt = new zzfv(this, "health_monitor", Math.max(0, ((Long) zzew.zzagk.get()).longValue()), null);
        AppMethodBeat.o(68943);
    }

    /* Access modifiers changed, original: final */
    public final String zziz() {
        AppMethodBeat.i(68946);
        zzab();
        String string = zziy().getString("gmp_app_id", null);
        AppMethodBeat.o(68946);
        return string;
    }

    /* Access modifiers changed, original: final */
    public final String zzja() {
        String str;
        AppMethodBeat.i(68948);
        synchronized (this.zzakh) {
            try {
                if (Math.abs(zzbt().elapsedRealtime() - this.zzakg) < 1000) {
                    str = this.zzakf;
                } else {
                    str = null;
                    AppMethodBeat.o(68948);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(68948);
            }
        }
        return str;
    }

    /* Access modifiers changed, original: final */
    public final Boolean zzjb() {
        AppMethodBeat.i(68949);
        zzab();
        if (zziy().contains("use_service")) {
            Boolean valueOf = Boolean.valueOf(zziy().getBoolean("use_service", false));
            AppMethodBeat.o(68949);
            return valueOf;
        }
        AppMethodBeat.o(68949);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void zzjc() {
        boolean z = true;
        AppMethodBeat.i(68951);
        zzab();
        zzge().zzit().log("Clearing collection preferences.");
        boolean contains = zziy().contains("measurement_enabled");
        if (contains) {
            z = zzg(true);
        }
        Editor edit = zziy().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
        AppMethodBeat.o(68951);
    }

    /* Access modifiers changed, original: protected|final */
    public final String zzjd() {
        AppMethodBeat.i(68954);
        zzab();
        String string = zziy().getString("previous_os_version", null);
        zzfw().zzch();
        String str = VERSION.RELEASE;
        if (!(TextUtils.isEmpty(str) || str.equals(string))) {
            Editor edit = zziy().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        AppMethodBeat.o(68954);
        return string;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzje() {
        AppMethodBeat.i(68956);
        zzab();
        boolean z = zziy().getBoolean("deferred_analytics_collection", false);
        AppMethodBeat.o(68956);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final boolean zzjf() {
        AppMethodBeat.i(68957);
        boolean contains = this.zzabf.contains("deferred_analytics_collection");
        AppMethodBeat.o(68957);
        return contains;
    }
}
