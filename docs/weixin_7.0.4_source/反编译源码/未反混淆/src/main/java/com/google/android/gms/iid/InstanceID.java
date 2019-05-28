package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.f.a;
import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Deprecated
public class InstanceID {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    private static Map<String, InstanceID> zzbq = new a();
    private static long zzbr = TimeUnit.DAYS.toSeconds(7);
    private static zzak zzbs;
    private static zzaf zzbt;
    private static String zzbu;
    private String zzbv = "";
    private Context zzk;

    static {
        AppMethodBeat.i(57518);
        AppMethodBeat.o(57518);
    }

    private InstanceID(Context context, String str) {
        AppMethodBeat.i(57502);
        this.zzk = context.getApplicationContext();
        this.zzbv = str;
        AppMethodBeat.o(57502);
    }

    @Deprecated
    public static InstanceID getInstance(Context context) {
        AppMethodBeat.i(57505);
        InstanceID instance = getInstance(context, null);
        AppMethodBeat.o(57505);
        return instance;
    }

    @KeepForSdk
    public static synchronized InstanceID getInstance(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            Object obj;
            AppMethodBeat.i(57506);
            String string = bundle == null ? "" : bundle.getString("subtype");
            if (string == null) {
                obj = "";
            } else {
                String obj2 = string;
            }
            Context applicationContext = context.getApplicationContext();
            if (zzbs == null) {
                string = applicationContext.getPackageName();
                new StringBuilder(String.valueOf(string).length() + 73).append("Instance ID SDK is deprecated, ").append(string).append(" should update to use Firebase Instance ID");
                zzbs = new zzak(applicationContext);
                zzbt = new zzaf(applicationContext);
            }
            zzbu = Integer.toString(zzg(applicationContext));
            instanceID = (InstanceID) zzbq.get(obj2);
            if (instanceID == null) {
                instanceID = new InstanceID(applicationContext, obj2);
                zzbq.put(obj2, instanceID);
            }
            AppMethodBeat.o(57506);
        }
        return instanceID;
    }

    private final KeyPair getKeyPair() {
        AppMethodBeat.i(57507);
        KeyPair keyPair = zzbs.zzj(this.zzbv).getKeyPair();
        AppMethodBeat.o(57507);
        return keyPair;
    }

    static String zzd(KeyPair keyPair) {
        AppMethodBeat.i(57509);
        try {
            byte[] digest = MessageDigest.getInstance(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1).digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            String encodeToString = Base64.encodeToString(digest, 0, 8, 11);
            AppMethodBeat.o(57509);
            return encodeToString;
        } catch (NoSuchAlgorithmException e) {
            AppMethodBeat.o(57509);
            return null;
        }
    }

    static int zzg(Context context) {
        int i = 0;
        AppMethodBeat.i(57503);
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            AppMethodBeat.o(57503);
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf);
            AppMethodBeat.o(57503);
        }
        return i;
    }

    static String zzh(Context context) {
        AppMethodBeat.i(57504);
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            AppMethodBeat.o(57504);
            return str;
        } catch (NameNotFoundException e) {
            str = String.valueOf(e);
            new StringBuilder(String.valueOf(str).length() + 38).append("Never happens: can't find own package ").append(str);
            AppMethodBeat.o(57504);
            return null;
        }
    }

    public static zzak zzn() {
        return zzbs;
    }

    @Deprecated
    public void deleteInstanceID() {
        AppMethodBeat.i(57511);
        zzd("*", "*", null);
        zzm();
        AppMethodBeat.o(57511);
    }

    @Deprecated
    public void deleteToken(String str, String str2) {
        AppMethodBeat.i(57513);
        zzd(str, str2, null);
        AppMethodBeat.o(57513);
    }

    @Deprecated
    public long getCreationTime() {
        AppMethodBeat.i(57510);
        long creationTime = zzbs.zzj(this.zzbv).getCreationTime();
        AppMethodBeat.o(57510);
        return creationTime;
    }

    @Deprecated
    public String getId() {
        AppMethodBeat.i(57508);
        String zzd = zzd(getKeyPair());
        AppMethodBeat.o(57508);
        return zzd;
    }

    @KeepForSdk
    public String getSubtype() {
        return this.zzbv;
    }

    @Deprecated
    public String getToken(String str, String str2) {
        AppMethodBeat.i(57515);
        String token = getToken(str, str2, null);
        AppMethodBeat.o(57515);
        return token;
    }

    @Deprecated
    public String getToken(String str, String str2, Bundle bundle) {
        Object obj = 1;
        AppMethodBeat.i(57516);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            IOException iOException = new IOException("MAIN_THREAD");
            AppMethodBeat.o(57516);
            throw iOException;
        }
        String str3 = null;
        String str4 = zzbs.get("appVersion");
        if (str4 != null && str4.equals(zzbu)) {
            str4 = zzbs.get("lastToken");
            if (str4 != null) {
                if ((System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str4)).longValue() <= zzbr) {
                    obj = null;
                }
            }
        }
        if (obj == null) {
            str3 = zzbs.zze(this.zzbv, str, str2);
        }
        if (str3 == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            str3 = zze(str, str2, bundle);
            if (str3 != null) {
                zzbs.zzd(this.zzbv, str, str2, str3, zzbu);
            }
        }
        AppMethodBeat.o(57516);
        return str3;
    }

    public final void zzd(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(57514);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            IOException iOException = new IOException("MAIN_THREAD");
            AppMethodBeat.o(57514);
            throw iOException;
        }
        zzbs.zzf(this.zzbv, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.zzbv) ? str : this.zzbv);
        String str3 = "X-subtype";
        if (!"".equals(this.zzbv)) {
            str = this.zzbv;
        }
        bundle.putString(str3, str);
        zzaf.zzi(zzbt.zzd(bundle, getKeyPair()));
        AppMethodBeat.o(57514);
    }

    public final String zze(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(57517);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.zzbv) ? str : this.zzbv;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        str3 = zzaf.zzi(zzbt.zzd(bundle, getKeyPair()));
        if ("RST".equals(str3) || str3.startsWith("RST|")) {
            InstanceIDListenerService.zzd(this.zzk, zzbs);
            IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(57517);
            throw iOException;
        }
        AppMethodBeat.o(57517);
        return str3;
    }

    /* Access modifiers changed, original: final */
    public final void zzm() {
        AppMethodBeat.i(57512);
        zzbs.zzk(this.zzbv);
        AppMethodBeat.o(57512);
    }
}
