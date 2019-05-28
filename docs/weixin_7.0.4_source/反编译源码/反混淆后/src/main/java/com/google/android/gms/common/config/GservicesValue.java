package com.google.android.gms.common.config;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.stable.zzg;
import com.google.android.gms.internal.stable.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public abstract class GservicesValue<T> {
    private static final Object sLock = new Object();
    private static zza zzmu = null;
    private static int zzmv = 0;
    private static Context zzmw;
    private static String zzmx = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    @GuardedBy("sLock")
    private static HashSet<String> zzmy;
    protected final T mDefaultValue;
    protected final String mKey;
    private T zzmz = null;

    @Deprecated
    static class zzc implements zza {
        private final Map<String, ?> values;

        public zzc(Map<String, ?> map) {
            this.values = map;
        }

        private final <T> T zza(String str, T t) {
            AppMethodBeat.m2504i(89528);
            if (this.values.containsKey(str)) {
                Object obj = this.values.get(str);
                AppMethodBeat.m2505o(89528);
                return obj;
            }
            AppMethodBeat.m2505o(89528);
            return t;
        }

        public final Long getLong(String str, Long l) {
            AppMethodBeat.m2504i(89525);
            Long l2 = (Long) zza(str, (Object) l);
            AppMethodBeat.m2505o(89525);
            return l2;
        }

        public final String getString(String str, String str2) {
            AppMethodBeat.m2504i(89526);
            String str3 = (String) zza(str, (Object) str2);
            AppMethodBeat.m2505o(89526);
            return str3;
        }

        public final Boolean zza(String str, Boolean bool) {
            AppMethodBeat.m2504i(89521);
            Boolean bool2 = (Boolean) zza(str, (Object) bool);
            AppMethodBeat.m2505o(89521);
            return bool2;
        }

        public final Double zza(String str, Double d) {
            AppMethodBeat.m2504i(89523);
            Double d2 = (Double) zza(str, (Object) d);
            AppMethodBeat.m2505o(89523);
            return d2;
        }

        public final Float zza(String str, Float f) {
            AppMethodBeat.m2504i(89524);
            Float f2 = (Float) zza(str, (Object) f);
            AppMethodBeat.m2505o(89524);
            return f2;
        }

        public final Integer zza(String str, Integer num) {
            AppMethodBeat.m2504i(89522);
            Integer num2 = (Integer) zza(str, (Object) num);
            AppMethodBeat.m2505o(89522);
            return num2;
        }

        public final String zzb(String str, String str2) {
            AppMethodBeat.m2504i(89527);
            String str3 = (String) zza(str, (Object) str2);
            AppMethodBeat.m2505o(89527);
            return str3;
        }
    }

    static class zzd implements zza {
        private final ContentResolver mContentResolver;

        public zzd(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
        }

        public final Long getLong(String str, Long l) {
            AppMethodBeat.m2504i(89533);
            Long valueOf = Long.valueOf(zzi.getLong(this.mContentResolver, str, l.longValue()));
            AppMethodBeat.m2505o(89533);
            return valueOf;
        }

        public final String getString(String str, String str2) {
            AppMethodBeat.m2504i(89534);
            String zza = zzi.zza(this.mContentResolver, str, str2);
            AppMethodBeat.m2505o(89534);
            return zza;
        }

        public final Boolean zza(String str, Boolean bool) {
            AppMethodBeat.m2504i(89529);
            Boolean valueOf = Boolean.valueOf(zzi.zza(this.mContentResolver, str, bool.booleanValue()));
            AppMethodBeat.m2505o(89529);
            return valueOf;
        }

        public final Double zza(String str, Double d) {
            AppMethodBeat.m2504i(89531);
            String zza = zzi.zza(this.mContentResolver, str, null);
            if (zza != null) {
                try {
                    d = Double.valueOf(Double.parseDouble(zza));
                    AppMethodBeat.m2505o(89531);
                } catch (NumberFormatException e) {
                }
                return d;
            }
            AppMethodBeat.m2505o(89531);
            return d;
        }

        public final Float zza(String str, Float f) {
            AppMethodBeat.m2504i(89532);
            String zza = zzi.zza(this.mContentResolver, str, null);
            if (zza != null) {
                try {
                    f = Float.valueOf(Float.parseFloat(zza));
                    AppMethodBeat.m2505o(89532);
                } catch (NumberFormatException e) {
                }
                return f;
            }
            AppMethodBeat.m2505o(89532);
            return f;
        }

        public final Integer zza(String str, Integer num) {
            AppMethodBeat.m2504i(89530);
            Integer valueOf = Integer.valueOf(zzi.getInt(this.mContentResolver, str, num.intValue()));
            AppMethodBeat.m2505o(89530);
            return valueOf;
        }

        public final String zzb(String str, String str2) {
            AppMethodBeat.m2504i(89535);
            String zza = zzg.zza(this.mContentResolver, str, str2);
            AppMethodBeat.m2505o(89535);
            return zza;
        }
    }

    static class zzb implements zza {
        private static final Collection<GservicesValue<?>> zzna = new HashSet();

        static {
            AppMethodBeat.m2504i(89520);
            AppMethodBeat.m2505o(89520);
        }

        private zzb() {
        }

        /* synthetic */ zzb(zza zza) {
            this();
        }

        public final Long getLong(String str, Long l) {
            return l;
        }

        public final String getString(String str, String str2) {
            return str2;
        }

        public final Boolean zza(String str, Boolean bool) {
            return bool;
        }

        public final Double zza(String str, Double d) {
            return d;
        }

        public final Float zza(String str, Float f) {
            return f;
        }

        public final Integer zza(String str, Integer num) {
            return num;
        }

        public final String zzb(String str, String str2) {
            return str2;
        }
    }

    interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Double zza(String str, Double d);

        Float zza(String str, Float f);

        Integer zza(String str, Integer num);

        String zzb(String str, String str2);
    }

    protected GservicesValue(String str, T t) {
        this.mKey = str;
        this.mDefaultValue = t;
    }

    @Deprecated
    @VisibleForTesting
    public static void forceInit(Context context) {
        forceInit(context, new HashSet());
    }

    @VisibleForTesting
    public static void forceInit(Context context, HashSet<String> hashSet) {
        zza(context, new zzd(context.getContentResolver()), hashSet);
    }

    @TargetApi(24)
    public static SharedPreferences getDirectBootCache(Context context) {
        return context.getApplicationContext().createDeviceProtectedStorageContext().getSharedPreferences("gservices-direboot-cache", 0);
    }

    public static int getSharedUserId() {
        return zzmv;
    }

    @Deprecated
    public static void init(Context context) {
        init(context, zzd(context) ? new HashSet() : null);
    }

    public static void init(Context context, HashSet<String> hashSet) {
        synchronized (sLock) {
            if (zzmu == null) {
                zza(context, new zzd(context.getContentResolver()), hashSet);
            }
            if (zzmv == 0) {
                try {
                    zzmv = context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).uid;
                } catch (NameNotFoundException e) {
                }
            }
        }
    }

    @Deprecated
    @VisibleForTesting
    public static void initForTests() {
        zza(null, new zzb(), new HashSet());
    }

    @VisibleForTesting
    public static void initForTests(Context context, HashSet<String> hashSet) {
        zza(context, new zzb(), hashSet);
    }

    @Deprecated
    @VisibleForTesting
    public static void initForTests(String str, Object obj) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(str, obj);
        initForTests(hashMap);
    }

    @Deprecated
    @VisibleForTesting
    public static void initForTests(Map<String, ?> map) {
        synchronized (sLock) {
            zzmu = new zzc(map);
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (sLock) {
            z = zzmu != null;
        }
        return z;
    }

    public static GservicesValue<String> partnerSetting(String str, String str2) {
        return new zzg(str, str2);
    }

    @VisibleForTesting
    public static void resetAllOverrides() {
        synchronized (sLock) {
            if (zzcg()) {
                for (GservicesValue resetOverride : zzb.zzna) {
                    resetOverride.resetOverride();
                }
                zzb.zzna.clear();
            }
        }
    }

    public static GservicesValue<Double> value(String str, Double d) {
        return new zzd(str, d);
    }

    public static GservicesValue<Float> value(String str, Float f) {
        return new zze(str, f);
    }

    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzc(str, num);
    }

    public static GservicesValue<Long> value(String str, Long l) {
        return new zzb(str, l);
    }

    public static GservicesValue<String> value(String str, String str2) {
        return new zzf(str, str2);
    }

    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new zza(str, Boolean.valueOf(z));
    }

    @TargetApi(24)
    private static void zza(Context context, zza zza, HashSet<String> hashSet) {
        synchronized (sLock) {
            zzmu = zza;
            zzmy = null;
            zzmw = null;
            if (context != null && zzd(context)) {
                zzmy = hashSet;
                zzmw = context.getApplicationContext().createDeviceProtectedStorageContext();
            }
        }
    }

    private static boolean zzcg() {
        boolean z;
        synchronized (sLock) {
            z = (zzmu instanceof zzb) || (zzmu instanceof zzc);
        }
        return z;
    }

    @TargetApi(24)
    private static boolean zzd(Context context) {
        if (!PlatformVersion.isAtLeastN()) {
            return false;
        }
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        return userManager.isUserUnlocked() ? false : !userManager.isUserRunning(Process.myUserHandle());
    }

    public final T get() {
        long clearCallingIdentity;
        if (this.zzmz != null) {
            return this.zzmz;
        }
        Object obj;
        HashSet hashSet;
        Context context;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        synchronized (sLock) {
            obj = (zzmw == null || !zzd(zzmw)) ? null : 1;
            hashSet = zzmy;
            context = zzmw;
        }
        if (obj != null) {
            String str;
            String valueOf;
            if (Log.isLoggable("GservicesValue", 3)) {
                str = "Gservice value accessed during directboot: ";
                valueOf = String.valueOf(this.mKey);
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    valueOf = new String(str);
                }
            }
            if (hashSet == null || hashSet.contains(this.mKey)) {
                return retrieveFromDirectBootCache(context, this.mKey, this.mDefaultValue);
            }
            str = "Gservices key not whitelisted for directboot access: ";
            valueOf = String.valueOf(this.mKey);
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                valueOf = new String(str);
            }
            return this.mDefaultValue;
        }
        synchronized (sLock) {
            zzmy = null;
            zzmw = null;
        }
        try {
            obj = retrieve(this.mKey);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return obj;
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            obj = retrieve(this.mKey);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return obj;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public String getKey() {
        return this.mKey;
    }

    @VisibleForTesting
    public void override(T t) {
        this.zzmz = t;
        synchronized (sLock) {
            if (zzcg()) {
                zzb.zzna.add(this);
            }
        }
    }

    @VisibleForTesting
    public void resetOverride() {
        this.zzmz = null;
    }

    public abstract T retrieve(String str);

    /* Access modifiers changed, original: protected */
    @TargetApi(24)
    public T retrieveFromDirectBootCache(Context context, String str, T t) {
        throw new UnsupportedOperationException("The Gservices classes used does not support direct-boot");
    }
}
