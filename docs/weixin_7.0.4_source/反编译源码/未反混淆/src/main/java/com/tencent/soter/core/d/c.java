package com.tencent.soter.core.d;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.b.a;
import com.tencent.soter.core.c.b;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.e;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.UnrecoverableEntryException;

public class c extends b implements b {
    private static boolean AuF = false;
    protected String Avy = "SoterKeyStore";

    @SuppressLint({"PrivateApi"})
    public static void bLV() {
        AppMethodBeat.i(73053);
        try {
            Method method = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod("install", new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            d.i("Soter.SoterCoreBeforeTreble", "soter: no SoterProvider found", new Object[0]);
        } catch (NoSuchMethodException e2) {
            d.i("Soter.SoterCoreBeforeTreble", "soter: function not found", new Object[0]);
        } catch (IllegalAccessException e3) {
            d.i("Soter.SoterCoreBeforeTreble", "soter: cannot access", new Object[0]);
        } catch (InvocationTargetException e4) {
            d.i("Soter.SoterCoreBeforeTreble", "soter: InvocationTargetException", new Object[0]);
        } finally {
            AuF = true;
            AppMethodBeat.o(73053);
        }
    }

    public c(String str) {
        this.Avy = str;
    }

    public final boolean iV(Context context) {
        AppMethodBeat.i(73054);
        bLV();
        AppMethodBeat.o(73054);
        return true;
    }

    public final boolean dQN() {
        AppMethodBeat.i(73055);
        if (!AuF) {
            bLV();
        }
        if (h.dQY()) {
            d.w("Soter.SoterCoreBeforeTreble", "hy: the device has already triggered OOM. mark as not support", new Object[0]);
            AppMethodBeat.o(73055);
            return false;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: no provider supported", new Object[0]);
            AppMethodBeat.o(73055);
            return false;
        }
        int length = providers.length;
        int i = 0;
        while (i < length) {
            String name = providers[i].getName();
            if (name == null || !name.startsWith("SoterKeyStore")) {
                i++;
            } else {
                d.i("Soter.SoterCoreBeforeTreble", "soter: found soter provider", new Object[0]);
                AppMethodBeat.o(73055);
                return true;
            }
        }
        d.i("Soter.SoterCoreBeforeTreble", "soter: soter provider not found", new Object[0]);
        AppMethodBeat.o(73055);
        return false;
    }

    public f dQO() {
        AppMethodBeat.i(73056);
        d.i("Soter.SoterCoreBeforeTreble", "soter: start generate ask", new Object[0]);
        f fVar;
        if (dQN()) {
            try {
                KeyStore.getInstance(this.Avy).load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
                instance.initialize(a.eP(e.dQW().Avi + ".addcounter.auto_signed_when_get_pubkey_attk", 4).W(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM).X("PSS").dQU());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                long nC = g.nC(nanoTime);
                d.i("Soter.SoterCoreBeforeTreble", "soter: generate successfully. cost: %d ms", Long.valueOf(nC));
                fVar = new f(0);
                AppMethodBeat.o(73056);
                return fVar;
            } catch (Exception e) {
                Exception exception = e;
                d.e("Soter.SoterCoreBeforeTreble", "soter: generateAppGlobalSecureKey " + exception.toString(), new Object[0]);
                d.a("Soter.SoterCoreBeforeTreble", exception, "soter: generateAppGlobalSecureKey error");
                fVar = new f(4, exception.toString());
                AppMethodBeat.o(73056);
                return fVar;
            } catch (OutOfMemoryError e2) {
                d.a("Soter.SoterCoreBeforeTreble", e2, "soter: out of memory when generate ASK!! maybe no attk inside");
                h.dQX();
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            fVar = new f(2);
            AppMethodBeat.o(73056);
            return fVar;
        }
    }

    public final f dQP() {
        AppMethodBeat.i(73057);
        d.i("Soter.SoterCoreBeforeTreble", "soter: start remove app global secure key", new Object[0]);
        f fVar;
        if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                instance.deleteEntry(e.dQW().Avi);
                fVar = new f(0);
                AppMethodBeat.o(73057);
                return fVar;
            } catch (Exception e) {
                Exception exception = e;
                d.e("Soter.SoterCoreBeforeTreble", "soter: removeAppGlobalSecureKey " + exception.toString(), new Object[0]);
                fVar = new f(5, exception.toString());
                AppMethodBeat.o(73057);
                return fVar;
            }
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
        fVar = new f(2);
        AppMethodBeat.o(73057);
        return fVar;
    }

    public final boolean dQQ() {
        AppMethodBeat.i(73058);
        try {
            KeyStore instance = KeyStore.getInstance(this.Avy);
            instance.load(null);
            if (instance.getCertificate(e.dQW().Avi) != null) {
                AppMethodBeat.o(73058);
                return true;
            }
            AppMethodBeat.o(73058);
            return false;
        } catch (Exception e) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            AppMethodBeat.o(73058);
            return false;
        }
    }

    public final boolean dQR() {
        AppMethodBeat.i(73059);
        if (!dQQ() || dQS() == null) {
            AppMethodBeat.o(73059);
            return false;
        }
        AppMethodBeat.o(73059);
        return true;
    }

    public i dQS() {
        i iVar = null;
        AppMethodBeat.i(73060);
        d.i("Soter.SoterCoreBeforeTreble", "soter: start get app global secure key pub", new Object[0]);
        if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                try {
                    Key key = instance.getKey(e.dQW().Avi, "from_soter_ui".toCharArray());
                    if (key != null) {
                        iVar = b.cp(key.getEncoded());
                        AppMethodBeat.o(73060);
                    } else {
                        d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.o(73060);
                    }
                } catch (ClassCastException e) {
                    d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + e.toString(), new Object[0]);
                    AppMethodBeat.o(73060);
                }
            } catch (Exception e2) {
                d.a("Soter.SoterCoreBeforeTreble", e2, "soter: error when get ask");
            } catch (OutOfMemoryError e3) {
                d.a("Soter.SoterCoreBeforeTreble", e3, "soter: out of memory when getting ask!! maybe no attk inside");
                h.dQX();
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            AppMethodBeat.o(73060);
        }
        return iVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0123 A:{Splitter:B:5:0x002c, ExcHandler: OutOfMemoryError (r0_19 'e' java.lang.OutOfMemoryError)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x00c9, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:16:0x00ca, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            com.tencent.soter.core.c.d.e("Soter.SoterCoreBeforeTreble", "soter: cause exception. maybe reflection exception: " + r1.toString(), new java.lang.Object[0]);
            r0 = new com.tencent.soter.core.c.f(5, r1.toString());
     */
    /* JADX WARNING: Missing block: B:19:0x00f2, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(73061);
     */
    /* JADX WARNING: Missing block: B:22:0x0123, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0124, code skipped:
            com.tencent.soter.core.c.d.a("Soter.SoterCoreBeforeTreble", r0, "soter: out of memory when generate AuthKey!! maybe no attk inside");
            com.tencent.soter.core.c.h.dQX();
     */
    /* JADX WARNING: Missing block: B:29:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final f atZ(String str) {
        AppMethodBeat.i(73061);
        f fVar;
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            fVar = new f(1, "no authKeyName");
            AppMethodBeat.o(73061);
            return fVar;
        } else if (dQN()) {
            try {
                if (dQQ()) {
                    KeyStore.getInstance(this.Avy).load(null);
                    KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", this.Avy);
                    instance.initialize(a.eP(str + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", new Object[]{e.dQW().Avi}), 4).W(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM).dQV().X("PSS").dQU());
                    long nanoTime = System.nanoTime();
                    instance.generateKeyPair();
                    long nC = g.nC(nanoTime);
                    d.i("Soter.SoterCoreBeforeTreble", "soter: generate successfully, cost: %d ms", Long.valueOf(nC));
                    fVar = new f(0);
                    AppMethodBeat.o(73061);
                    return fVar;
                }
                fVar = new f(3, "app secure key not exist");
                AppMethodBeat.o(73061);
                return fVar;
            } catch (Exception e) {
                Exception exception = e;
                d.e("Soter.SoterCoreBeforeTreble", "soter: generate auth key failed: " + exception.toString(), new Object[0]);
                fVar = new f(5, exception.toString());
                AppMethodBeat.o(73061);
                return fVar;
            } catch (OutOfMemoryError e2) {
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            fVar = new f(2);
            AppMethodBeat.o(73061);
            return fVar;
        }
    }

    public final f cn(String str, boolean z) {
        AppMethodBeat.i(73062);
        f fVar;
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            fVar = new f(1, "no authKeyName");
            AppMethodBeat.o(73062);
            return fVar;
        }
        d.i("Soter.SoterCoreBeforeTreble", "soter: start remove key: ".concat(String.valueOf(str)), new Object[0]);
        if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                instance.deleteEntry(str);
                if (z) {
                    d.i("Soter.SoterCoreBeforeTreble", "soter: auto delete ask", new Object[0]);
                    if (dQQ()) {
                        dQP();
                    }
                }
                fVar = new f(0);
                AppMethodBeat.o(73062);
                return fVar;
            } catch (Exception e) {
                Exception exception = e;
                d.e("Soter.SoterCoreBeforeTreble", "soter: removeAuthKey " + exception.toString(), new Object[0]);
                fVar = new f(6, exception.toString());
                AppMethodBeat.o(73062);
                return fVar;
            }
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
        fVar = new f(2);
        AppMethodBeat.o(73062);
        return fVar;
    }

    public final boolean aua(String str) {
        AppMethodBeat.i(73063);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: authkey name not correct", new Object[0]);
            AppMethodBeat.o(73063);
            return false;
        }
        try {
            KeyStore instance = KeyStore.getInstance(this.Avy);
            instance.load(null);
            if (instance.getCertificate(str) != null) {
                AppMethodBeat.o(73063);
                return true;
            }
            AppMethodBeat.o(73063);
            return false;
        } catch (Exception e) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            AppMethodBeat.o(73063);
            return false;
        }
    }

    public final SoterSessionResult iC(String str, String str2) {
        return null;
    }

    public final byte[] nB(long j) {
        return new byte[0];
    }

    public final boolean aub(String str) {
        AppMethodBeat.i(73064);
        d.i("Soter.SoterCoreBeforeTreble", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", new Object[]{str, Boolean.TRUE}), new Object[0]);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: checking key valid: authkey name not correct", new Object[0]);
            AppMethodBeat.o(73064);
            return false;
        }
        try {
            auf(str);
            d.i("Soter.SoterCoreBeforeTreble", "soter: key valid", new Object[0]);
            AppMethodBeat.o(73064);
            return true;
        } catch (InvalidKeyException | UnrecoverableEntryException e) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid.", new Object[0]);
            cn(str, false);
            AppMethodBeat.o(73064);
            return false;
        } catch (Exception e2) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: occurs other exceptions: %s", e2.toString());
            d.a("Soter.SoterCoreBeforeTreble", e2, "soter: occurs other exceptions");
            AppMethodBeat.o(73064);
            return false;
        } catch (OutOfMemoryError e3) {
            d.a("Soter.SoterCoreBeforeTreble", e3, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
            h.dQX();
            AppMethodBeat.o(73064);
            return false;
        }
    }

    public final i auc(String str) {
        i iVar = null;
        AppMethodBeat.i(73065);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.o(73065);
        } else if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                try {
                    Key key = instance.getKey(str, "from_soter_ui".toCharArray());
                    if (key != null) {
                        iVar = b.cp(key.getEncoded());
                        AppMethodBeat.o(73065);
                    } else {
                        d.e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.o(73065);
                    }
                } catch (ClassCastException e) {
                    d.e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + e.toString(), new Object[0]);
                    AppMethodBeat.o(73065);
                }
            } catch (Exception e2) {
                d.a("Soter.SoterCoreBeforeTreble", e2, "soter: error in get auth key model");
            } catch (OutOfMemoryError e3) {
                d.a("Soter.SoterCoreBeforeTreble", e3, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
                h.dQX();
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter " + this.Avy, new Object[0]);
            AppMethodBeat.o(73065);
        }
        return iVar;
    }

    public final Signature aud(String str) {
        Signature signature = null;
        AppMethodBeat.i(73066);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.o(73066);
        } else if (dQN()) {
            try {
                signature = auf(str);
                AppMethodBeat.o(73066);
            } catch (InvalidKeyException | UnrecoverableEntryException e) {
                d.e("Soter.SoterCoreBeforeTreble", "soter: key invalid. Advice remove the key", new Object[0]);
                AppMethodBeat.o(73066);
            } catch (Exception e2) {
                d.e("Soter.SoterCoreBeforeTreble", "soter: exception when getSignatureResult: " + e2.toString(), new Object[0]);
                d.a("Soter.SoterCoreBeforeTreble", e2, "soter: exception when getSignatureResult");
                AppMethodBeat.o(73066);
            } catch (OutOfMemoryError e3) {
                d.a("Soter.SoterCoreBeforeTreble", e3, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
                h.dQX();
                AppMethodBeat.o(73066);
            }
        } else {
            d.e("Soter.SoterCoreBeforeTreble", "soter: not support soter" + this.Avy, new Object[0]);
            AppMethodBeat.o(73066);
        }
        return signature;
    }

    public Signature auf(String str) {
        AppMethodBeat.i(73067);
        if (g.isNullOrNil(str)) {
            d.e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.o(73067);
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
        KeyStore instance2 = KeyStore.getInstance(this.Avy);
        instance2.load(null);
        PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) instance2.getEntry(str, null);
        if (privateKeyEntry != null) {
            instance.initSign(privateKeyEntry.getPrivateKey());
            AppMethodBeat.o(73067);
            return instance;
        }
        d.e("Soter.SoterCoreBeforeTreble", "soter: entry not exists", new Object[0]);
        AppMethodBeat.o(73067);
        return null;
    }
}
