package com.google.firebase.iid;

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

final class af {
    af() {
    }

    private static ag a(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.i(108808);
        String string = sharedPreferences.getString(p.o(str, "|P|"), null);
        String string2 = sharedPreferences.getString(p.o(str, "|K|"), null);
        if (string == null || string2 == null) {
            AppMethodBeat.o(108808);
            return null;
        }
        ag agVar = new ag(r(string, string2), b(sharedPreferences, str));
        AppMethodBeat.o(108808);
        return agVar;
    }

    static File aq(Context context) {
        AppMethodBeat.i(108805);
        File Q = b.Q(context);
        if (Q == null || !Q.isDirectory()) {
            Q = context.getFilesDir();
            AppMethodBeat.o(108805);
            return Q;
        }
        AppMethodBeat.o(108805);
        return Q;
    }

    private static long b(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.i(108810);
        String string = sharedPreferences.getString(p.o(str, "cre"), null);
        if (string != null) {
            try {
                long parseLong = Long.parseLong(string);
                AppMethodBeat.o(108810);
                return parseLong;
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.o(108810);
        return 0;
    }

    static ag k(Context context, String str) {
        AppMethodBeat.i(108800);
        ag agVar = new ag(a.uN(), System.currentTimeMillis());
        try {
            ag l = l(context, str);
            if (l != null) {
                Log.isLoggable("FirebaseInstanceId", 3);
                AppMethodBeat.o(108800);
                return l;
            }
        } catch (ah e) {
        }
        Log.isLoggable("FirebaseInstanceId", 3);
        a(context, str, agVar);
        b(context, str, agVar);
        AppMethodBeat.o(108800);
        return agVar;
    }

    static ag l(Context context, String str) {
        AppMethodBeat.i(108801);
        ah ahVar;
        ah e;
        try {
            ag m = m(context, str);
            if (m != null) {
                b(context, str, m);
                AppMethodBeat.o(108801);
                return m;
            }
            ahVar = null;
            try {
                m = a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (m != null) {
                    a(context, str, m);
                    AppMethodBeat.o(108801);
                    return m;
                }
                e = ahVar;
                if (e != null) {
                    AppMethodBeat.o(108801);
                    throw e;
                }
                AppMethodBeat.o(108801);
                return null;
            } catch (ah e2) {
                e = e2;
            }
        } catch (ah e3) {
            ahVar = e3;
        }
    }

    private static ag m(Context context, String str) {
        String valueOf;
        AppMethodBeat.i(108803);
        File n = n(context, str);
        if (n.exists()) {
            ag q;
            try {
                q = q(n);
                AppMethodBeat.o(108803);
                return q;
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    valueOf = String.valueOf(e);
                    new StringBuilder(String.valueOf(valueOf).length() + 40).append("Failed to read key from file, retrying: ").append(valueOf);
                }
                try {
                    q = q(n);
                    AppMethodBeat.o(108803);
                    return q;
                } catch (IOException e2) {
                    valueOf = String.valueOf(e2);
                    new StringBuilder(String.valueOf(valueOf).length() + 45).append("IID file exists, but failed to read from it: ").append(valueOf);
                    ah ahVar = new ah(e2);
                    AppMethodBeat.o(108803);
                    throw ahVar;
                }
            }
        }
        AppMethodBeat.o(108803);
        return null;
    }

    private static File n(Context context, String str) {
        String str2;
        AppMethodBeat.i(108806);
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                str2 = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                str2 = new StringBuilder(String.valueOf(str2).length() + 33).append("com.google.InstanceId_").append(str2).append(".properties").toString();
            } catch (UnsupportedEncodingException e) {
                AssertionError assertionError = new AssertionError(e);
                AppMethodBeat.o(108806);
                throw assertionError;
            }
        }
        File file = new File(aq(context), str2);
        AppMethodBeat.o(108806);
        return file;
    }

    private static ag q(File file) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(108807);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String property = properties.getProperty("pub");
            String property2 = properties.getProperty("pri");
            if (property == null || property2 == null) {
                a(null, fileInputStream);
                AppMethodBeat.o(108807);
                return null;
            }
            ag agVar = new ag(r(property, property2), Long.parseLong(properties.getProperty("cre")));
            a(null, fileInputStream);
            AppMethodBeat.o(108807);
            return agVar;
        } catch (NumberFormatException e) {
            ah ahVar = new ah(e);
            AppMethodBeat.o(108807);
            throw ahVar;
        } catch (Throwable th3) {
            th = th3;
            th2 = null;
            a(th2, fileInputStream);
            AppMethodBeat.o(108807);
            throw th;
        }
    }

    private static KeyPair r(String str, String str2) {
        ah ahVar;
        AppMethodBeat.i(108802);
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                KeyPair keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
                AppMethodBeat.o(108802);
                return keyPair;
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf);
                ahVar = new ah(e);
                AppMethodBeat.o(108802);
                throw ahVar;
            }
        } catch (IllegalArgumentException e2) {
            ahVar = new ah(e2);
            AppMethodBeat.o(108802);
            throw ahVar;
        }
    }

    private static void a(Context context, String str, ag agVar) {
        Throwable th = null;
        AppMethodBeat.i(108804);
        try {
            Log.isLoggable("FirebaseInstanceId", 3);
            File n = n(context, str);
            n.createNewFile();
            Properties properties = new Properties();
            properties.setProperty("pub", agVar.zzq());
            properties.setProperty("pri", agVar.uW());
            properties.setProperty("cre", String.valueOf(agVar.bwN));
            FileOutputStream fileOutputStream = new FileOutputStream(n);
            Throwable th2 = null;
            try {
                properties.store(fileOutputStream, null);
                a(th2, fileOutputStream);
                AppMethodBeat.o(108804);
            } catch (Throwable th3) {
                a(th, fileOutputStream);
            } finally {
                while (true) {
                    int th22 = 108804;
                    AppMethodBeat.o(108804);
                }
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e);
            new StringBuilder(String.valueOf(valueOf).length() + 21).append("Failed to write key: ").append(valueOf);
            AppMethodBeat.o(108804);
        }
    }

    private static void b(Context context, String str, ag agVar) {
        AppMethodBeat.i(108809);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (agVar.equals(a(sharedPreferences, str))) {
                AppMethodBeat.o(108809);
                return;
            }
        } catch (ah e) {
        }
        Log.isLoggable("FirebaseInstanceId", 3);
        Editor edit = sharedPreferences.edit();
        edit.putString(p.o(str, "|P|"), agVar.zzq());
        edit.putString(p.o(str, "|K|"), agVar.uW());
        edit.putString(p.o(str, "cre"), String.valueOf(agVar.bwN));
        edit.commit();
        AppMethodBeat.o(108809);
    }
}
