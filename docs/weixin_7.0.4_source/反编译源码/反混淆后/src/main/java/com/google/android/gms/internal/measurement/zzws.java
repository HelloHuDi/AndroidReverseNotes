package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build.VERSION;
import android.support.p057v4.content.C0384f;
import javax.annotation.Nullable;

public abstract class zzws<T> {
    private static final Object zzbnc = new Object();
    private static boolean zzbnd = false;
    private static volatile Boolean zzbne = null;
    private static volatile Boolean zzbnf = null;
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzqx = null;
    private final zzxc zzbng;
    final String zzbnh;
    private final String zzbni;
    private final T zzbnj;
    private T zzbnk;
    private volatile zzwp zzbnl;
    private volatile SharedPreferences zzbnm;

    private zzws(zzxc zzxc, String str, T t) {
        this.zzbnk = null;
        this.zzbnl = null;
        this.zzbnm = null;
        if (zzxc.zzbns == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzbng = zzxc;
        String valueOf = String.valueOf(zzxc.zzbnt);
        String valueOf2 = String.valueOf(str);
        this.zzbni = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        valueOf = String.valueOf(zzxc.zzbnu);
        valueOf2 = String.valueOf(str);
        this.zzbnh = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        this.zzbnj = t;
    }

    /* synthetic */ zzws(zzxc zzxc, String str, Object obj, zzww zzww) {
        this(zzxc, str, obj);
    }

    public static void init(Context context) {
        synchronized (zzbnc) {
            if (VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
            }
            if (zzqx != context) {
                zzbne = null;
            }
            zzqx = context;
        }
        zzbnd = false;
    }

    private static zzws<Double> zza(zzxc zzxc, String str, double d) {
        return new zzwz(zzxc, str, Double.valueOf(d));
    }

    private static zzws<Integer> zza(zzxc zzxc, String str, int i) {
        return new zzwx(zzxc, str, Integer.valueOf(i));
    }

    private static zzws<Long> zza(zzxc zzxc, String str, long j) {
        return new zzww(zzxc, str, Long.valueOf(j));
    }

    private static zzws<String> zza(zzxc zzxc, String str, String str2) {
        return new zzxa(zzxc, str, str2);
    }

    private static zzws<Boolean> zza(zzxc zzxc, String str, boolean z) {
        return new zzwy(zzxc, str, Boolean.valueOf(z));
    }

    private static <V> V zza(zzxb<V> zzxb) {
        long clearCallingIdentity;
        try {
            return zzxb.zzsc();
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzsc = zzxb.zzsc();
            return zzsc;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    static boolean zzd(String str, boolean z) {
        try {
            return zzsa() ? ((Boolean) zza(new zzwv(str, false))).booleanValue() : false;
        } catch (SecurityException e) {
            return false;
        }
    }

    @TargetApi(24)
    @Nullable
    private final T zzry() {
        String str;
        if (zzd("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            str = "Bypass reading Phenotype values for flag: ";
            String valueOf = String.valueOf(this.zzbnh);
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                valueOf = new String(str);
            }
        } else if (this.zzbng.zzbns != null) {
            if (this.zzbnl == null) {
                this.zzbnl = zzwp.zza(zzqx.getContentResolver(), this.zzbng.zzbns);
            }
            str = (String) zza(new zzwt(this, this.zzbnl));
            if (str != null) {
                return zzey(str);
            }
        }
        return null;
    }

    @Nullable
    private final T zzrz() {
        if (zzsa()) {
            String str;
            try {
                str = (String) zza(new zzwu(this));
                if (str != null) {
                    return zzey(str);
                }
            } catch (SecurityException e) {
                str = "Unable to read GServices for flag: ";
                String valueOf = String.valueOf(this.zzbnh);
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    valueOf = new String(str);
                }
            }
        }
        return null;
    }

    private static boolean zzsa() {
        boolean z = false;
        if (zzbne == null) {
            if (zzqx == null) {
                return false;
            }
            if (C0384f.m655f(zzqx, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            zzbne = Boolean.valueOf(z);
        }
        return zzbne.booleanValue();
    }

    public final T get() {
        if (zzqx == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        Object zzry = zzry();
        if (zzry != null) {
            return zzry;
        }
        zzry = zzrz();
        return zzry == null ? this.zzbnj : zzry;
    }

    public abstract T zzey(String str);

    /* Access modifiers changed, original: final|synthetic */
    public final /* synthetic */ String zzsb() {
        return zzwn.zza(zzqx.getContentResolver(), this.zzbni, null);
    }
}
