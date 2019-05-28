package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.p057v4.content.C0380b;
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

/* renamed from: com.google.firebase.iid.af */
final class C41650af {
    C41650af() {
    }

    /* renamed from: a */
    private static C45073ag m73023a(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.m2504i(108808);
        String string = sharedPreferences.getString(C8748p.m15567o(str, "|P|"), null);
        String string2 = sharedPreferences.getString(C8748p.m15567o(str, "|K|"), null);
        if (string == null || string2 == null) {
            AppMethodBeat.m2505o(108808);
            return null;
        }
        C45073ag c45073ag = new C45073ag(C41650af.m73035r(string, string2), C41650af.m73028b(sharedPreferences, str));
        AppMethodBeat.m2505o(108808);
        return c45073ag;
    }

    /* renamed from: aq */
    static File m73027aq(Context context) {
        AppMethodBeat.m2504i(108805);
        File Q = C0380b.m646Q(context);
        if (Q == null || !Q.isDirectory()) {
            Q = context.getFilesDir();
            AppMethodBeat.m2505o(108805);
            return Q;
        }
        AppMethodBeat.m2505o(108805);
        return Q;
    }

    /* renamed from: b */
    private static long m73028b(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.m2504i(108810);
        String string = sharedPreferences.getString(C8748p.m15567o(str, "cre"), null);
        if (string != null) {
            try {
                long parseLong = Long.parseLong(string);
                AppMethodBeat.m2505o(108810);
                return parseLong;
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(108810);
        return 0;
    }

    /* renamed from: k */
    static C45073ag m73030k(Context context, String str) {
        AppMethodBeat.m2504i(108800);
        C45073ag c45073ag = new C45073ag(C32094a.m52220uN(), System.currentTimeMillis());
        try {
            C45073ag l = C41650af.m73031l(context, str);
            if (l != null) {
                Log.isLoggable("FirebaseInstanceId", 3);
                AppMethodBeat.m2505o(108800);
                return l;
            }
        } catch (C8747ah e) {
        }
        Log.isLoggable("FirebaseInstanceId", 3);
        C41650af.m73024a(context, str, c45073ag);
        C41650af.m73029b(context, str, c45073ag);
        AppMethodBeat.m2505o(108800);
        return c45073ag;
    }

    /* renamed from: l */
    static C45073ag m73031l(Context context, String str) {
        AppMethodBeat.m2504i(108801);
        C8747ah c8747ah;
        C8747ah e;
        try {
            C45073ag m = C41650af.m73032m(context, str);
            if (m != null) {
                C41650af.m73029b(context, str, m);
                AppMethodBeat.m2505o(108801);
                return m;
            }
            c8747ah = null;
            try {
                m = C41650af.m73023a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (m != null) {
                    C41650af.m73024a(context, str, m);
                    AppMethodBeat.m2505o(108801);
                    return m;
                }
                e = c8747ah;
                if (e != null) {
                    AppMethodBeat.m2505o(108801);
                    throw e;
                }
                AppMethodBeat.m2505o(108801);
                return null;
            } catch (C8747ah e2) {
                e = e2;
            }
        } catch (C8747ah e3) {
            c8747ah = e3;
        }
    }

    /* renamed from: m */
    private static C45073ag m73032m(Context context, String str) {
        String valueOf;
        AppMethodBeat.m2504i(108803);
        File n = C41650af.m73033n(context, str);
        if (n.exists()) {
            C45073ag q;
            try {
                q = C41650af.m73034q(n);
                AppMethodBeat.m2505o(108803);
                return q;
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    valueOf = String.valueOf(e);
                    new StringBuilder(String.valueOf(valueOf).length() + 40).append("Failed to read key from file, retrying: ").append(valueOf);
                }
                try {
                    q = C41650af.m73034q(n);
                    AppMethodBeat.m2505o(108803);
                    return q;
                } catch (IOException e2) {
                    valueOf = String.valueOf(e2);
                    new StringBuilder(String.valueOf(valueOf).length() + 45).append("IID file exists, but failed to read from it: ").append(valueOf);
                    C8747ah c8747ah = new C8747ah(e2);
                    AppMethodBeat.m2505o(108803);
                    throw c8747ah;
                }
            }
        }
        AppMethodBeat.m2505o(108803);
        return null;
    }

    /* renamed from: n */
    private static File m73033n(Context context, String str) {
        String str2;
        AppMethodBeat.m2504i(108806);
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                str2 = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                str2 = new StringBuilder(String.valueOf(str2).length() + 33).append("com.google.InstanceId_").append(str2).append(".properties").toString();
            } catch (UnsupportedEncodingException e) {
                AssertionError assertionError = new AssertionError(e);
                AppMethodBeat.m2505o(108806);
                throw assertionError;
            }
        }
        File file = new File(C41650af.m73027aq(context), str2);
        AppMethodBeat.m2505o(108806);
        return file;
    }

    /* renamed from: q */
    private static C45073ag m73034q(File file) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.m2504i(108807);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String property = properties.getProperty("pub");
            String property2 = properties.getProperty("pri");
            if (property == null || property2 == null) {
                C41650af.m73025a(null, fileInputStream);
                AppMethodBeat.m2505o(108807);
                return null;
            }
            C45073ag c45073ag = new C45073ag(C41650af.m73035r(property, property2), Long.parseLong(properties.getProperty("cre")));
            C41650af.m73025a(null, fileInputStream);
            AppMethodBeat.m2505o(108807);
            return c45073ag;
        } catch (NumberFormatException e) {
            C8747ah c8747ah = new C8747ah(e);
            AppMethodBeat.m2505o(108807);
            throw c8747ah;
        } catch (Throwable th3) {
            th = th3;
            th2 = null;
            C41650af.m73025a(th2, fileInputStream);
            AppMethodBeat.m2505o(108807);
            throw th;
        }
    }

    /* renamed from: r */
    private static KeyPair m73035r(String str, String str2) {
        C8747ah c8747ah;
        AppMethodBeat.m2504i(108802);
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                KeyPair keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
                AppMethodBeat.m2505o(108802);
                return keyPair;
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf);
                c8747ah = new C8747ah(e);
                AppMethodBeat.m2505o(108802);
                throw c8747ah;
            }
        } catch (IllegalArgumentException e2) {
            c8747ah = new C8747ah(e2);
            AppMethodBeat.m2505o(108802);
            throw c8747ah;
        }
    }

    /* renamed from: a */
    private static void m73024a(Context context, String str, C45073ag c45073ag) {
        Throwable th = null;
        AppMethodBeat.m2504i(108804);
        try {
            Log.isLoggable("FirebaseInstanceId", 3);
            File n = C41650af.m73033n(context, str);
            n.createNewFile();
            Properties properties = new Properties();
            properties.setProperty("pub", c45073ag.zzq());
            properties.setProperty("pri", c45073ag.mo72838uW());
            properties.setProperty("cre", String.valueOf(c45073ag.bwN));
            FileOutputStream fileOutputStream = new FileOutputStream(n);
            Throwable th2 = null;
            try {
                properties.store(fileOutputStream, null);
                C41650af.m73026a(th2, fileOutputStream);
                AppMethodBeat.m2505o(108804);
            } catch (Throwable th3) {
                C41650af.m73026a(th, fileOutputStream);
            } finally {
                while (true) {
                    int th22 = 108804;
                    AppMethodBeat.m2505o(108804);
                }
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e);
            new StringBuilder(String.valueOf(valueOf).length() + 21).append("Failed to write key: ").append(valueOf);
            AppMethodBeat.m2505o(108804);
        }
    }

    /* renamed from: b */
    private static void m73029b(Context context, String str, C45073ag c45073ag) {
        AppMethodBeat.m2504i(108809);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (c45073ag.equals(C41650af.m73023a(sharedPreferences, str))) {
                AppMethodBeat.m2505o(108809);
                return;
            }
        } catch (C8747ah e) {
        }
        Log.isLoggable("FirebaseInstanceId", 3);
        Editor edit = sharedPreferences.edit();
        edit.putString(C8748p.m15567o(str, "|P|"), c45073ag.zzq());
        edit.putString(C8748p.m15567o(str, "|K|"), c45073ag.mo72838uW());
        edit.putString(C8748p.m15567o(str, "cre"), String.valueOf(c45073ag.bwN));
        edit.commit();
        AppMethodBeat.m2505o(108809);
    }
}
