package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class zzn {
    zzn() {
    }

    private static zzo zzd(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.i(57587);
        String string = sharedPreferences.getString(zzak.zzh(str, "|P|"), null);
        String string2 = sharedPreferences.getString(zzak.zzh(str, "|K|"), null);
        if (string == null || string2 == null) {
            AppMethodBeat.o(57587);
            return null;
        }
        zzo zzo = new zzo(zzg(string, string2), zze(sharedPreferences, str));
        AppMethodBeat.o(57587);
        return zzo;
    }

    private static zzo zzd(File file) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(57586);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String property = properties.getProperty("pub");
            String property2 = properties.getProperty("pri");
            if (property == null || property2 == null) {
                zzd(null, fileInputStream);
                AppMethodBeat.o(57586);
                return null;
            }
            zzo zzo = new zzo(zzg(property, property2), Long.parseLong(properties.getProperty("cre")));
            zzd(null, fileInputStream);
            AppMethodBeat.o(57586);
            return zzo;
        } catch (NumberFormatException e) {
            zzp zzp = new zzp(e);
            AppMethodBeat.o(57586);
            throw zzp;
        } catch (Throwable th3) {
            th = th3;
            th2 = null;
            zzd(th2, fileInputStream);
            AppMethodBeat.o(57586);
            throw th;
        }
    }

    private static void zzd(Context context, String str, zzo zzo) {
        Throwable th = null;
        AppMethodBeat.i(57583);
        try {
            Log.isLoggable("InstanceID", 3);
            File zzj = zzj(context, str);
            zzj.createNewFile();
            Properties properties = new Properties();
            properties.setProperty("pub", zzo.zzd(zzo));
            properties.setProperty("pri", zzo.zze(zzo));
            properties.setProperty("cre", String.valueOf(zzo.zzbx));
            FileOutputStream fileOutputStream = new FileOutputStream(zzj);
            Throwable th2 = null;
            try {
                properties.store(fileOutputStream, null);
                zzd(th2, fileOutputStream);
                AppMethodBeat.o(57583);
            } catch (Throwable th3) {
                zzd(th, fileOutputStream);
            } finally {
                while (true) {
                    int th22 = 57583;
                    AppMethodBeat.o(57583);
                }
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e);
            new StringBuilder(String.valueOf(valueOf).length() + 21).append("Failed to write key: ").append(valueOf);
            AppMethodBeat.o(57583);
        }
    }

    private static long zze(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.i(57589);
        String string = sharedPreferences.getString(zzak.zzh(str, "cre"), null);
        if (string != null) {
            try {
                long parseLong = Long.parseLong(string);
                AppMethodBeat.o(57589);
                return parseLong;
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.o(57589);
        return 0;
    }

    private final void zze(Context context, String str, zzo zzo) {
        AppMethodBeat.i(57588);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzo.equals(zzd(sharedPreferences, str))) {
                AppMethodBeat.o(57588);
                return;
            }
        } catch (zzp e) {
        }
        Log.isLoggable("InstanceID", 3);
        Editor edit = sharedPreferences.edit();
        edit.putString(zzak.zzh(str, "|P|"), zzo.zzd(zzo));
        edit.putString(zzak.zzh(str, "|K|"), zzo.zze(zzo));
        edit.putString(zzak.zzh(str, "cre"), String.valueOf(zzo.zzbx));
        edit.commit();
        AppMethodBeat.o(57588);
    }

    private static KeyPair zzg(String str, String str2) {
        zzp zzp;
        AppMethodBeat.i(57581);
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                KeyPair keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
                AppMethodBeat.o(57581);
                return keyPair;
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf);
                zzp = new zzp(e);
                AppMethodBeat.o(57581);
                throw zzp;
            }
        } catch (IllegalArgumentException e2) {
            zzp = new zzp(e2);
            AppMethodBeat.o(57581);
            throw zzp;
        }
    }

    static void zzg(Context context, String str) {
        AppMethodBeat.i(57578);
        File zzj = zzj(context, str);
        if (zzj.exists()) {
            zzj.delete();
        }
        AppMethodBeat.o(57578);
    }

    private final zzo zzh(Context context, String str) {
        AppMethodBeat.i(57580);
        zzp zzp;
        zzp e;
        try {
            zzo zzi = zzi(context, str);
            if (zzi != null) {
                zze(context, str, zzi);
                AppMethodBeat.o(57580);
                return zzi;
            }
            zzp = null;
            try {
                zzi = zzd(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zzi != null) {
                    zzd(context, str, zzi);
                    AppMethodBeat.o(57580);
                    return zzi;
                }
                e = zzp;
                if (e != null) {
                    AppMethodBeat.o(57580);
                    throw e;
                }
                AppMethodBeat.o(57580);
                return null;
            } catch (zzp e2) {
                e = e2;
            }
        } catch (zzp e3) {
            zzp = e3;
        }
    }

    private final zzo zzi(Context context, String str) {
        String valueOf;
        AppMethodBeat.i(57582);
        File zzj = zzj(context, str);
        if (zzj.exists()) {
            zzo zzd;
            try {
                zzd = zzd(zzj);
                AppMethodBeat.o(57582);
                return zzd;
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID", 3)) {
                    valueOf = String.valueOf(e);
                    new StringBuilder(String.valueOf(valueOf).length() + 40).append("Failed to read key from file, retrying: ").append(valueOf);
                }
                try {
                    zzd = zzd(zzj);
                    AppMethodBeat.o(57582);
                    return zzd;
                } catch (IOException e2) {
                    valueOf = String.valueOf(e2);
                    new StringBuilder(String.valueOf(valueOf).length() + 45).append("IID file exists, but failed to read from it: ").append(valueOf);
                    zzp zzp = new zzp(e2);
                    AppMethodBeat.o(57582);
                    throw zzp;
                }
            }
        }
        AppMethodBeat.o(57582);
        return null;
    }

    static void zzi(Context context) {
        AppMethodBeat.i(57579);
        for (File file : zzj(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
        AppMethodBeat.o(57579);
    }

    private static File zzj(Context context) {
        AppMethodBeat.i(57584);
        File Q = b.Q(context);
        if (Q == null || !Q.isDirectory()) {
            Q = context.getFilesDir();
            AppMethodBeat.o(57584);
            return Q;
        }
        AppMethodBeat.o(57584);
        return Q;
    }

    private static File zzj(Context context, String str) {
        String str2;
        AppMethodBeat.i(57585);
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                str2 = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                str2 = new StringBuilder(String.valueOf(str2).length() + 33).append("com.google.InstanceId_").append(str2).append(".properties").toString();
            } catch (UnsupportedEncodingException e) {
                AssertionError assertionError = new AssertionError(e);
                AppMethodBeat.o(57585);
                throw assertionError;
            }
        }
        File file = new File(zzj(context), str2);
        AppMethodBeat.o(57585);
        return file;
    }

    /* Access modifiers changed, original: final */
    public final zzo zze(Context context, String str) {
        AppMethodBeat.i(57576);
        zzo zzh = zzh(context, str);
        if (zzh != null) {
            AppMethodBeat.o(57576);
            return zzh;
        }
        zzh = zzf(context, str);
        AppMethodBeat.o(57576);
        return zzh;
    }

    /* Access modifiers changed, original: final */
    public final zzo zzf(Context context, String str) {
        AppMethodBeat.i(57577);
        zzo zzo = new zzo(zzd.zzk(), System.currentTimeMillis());
        try {
            zzo zzh = zzh(context, str);
            if (zzh != null) {
                Log.isLoggable("InstanceID", 3);
                AppMethodBeat.o(57577);
                return zzh;
            }
        } catch (zzp e) {
        }
        Log.isLoggable("InstanceID", 3);
        zzd(context, str, zzo);
        zze(context, str, zzo);
        AppMethodBeat.o(57577);
        return zzo;
    }
}
