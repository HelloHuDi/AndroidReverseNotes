package com.tencent.soter.core.p1425d;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1350b.C24316a;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C24322h;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.core.p1351c.C44474b;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p1351c.C44478f;
import com.tencent.soter.core.p1351c.C46745e;
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

/* renamed from: com.tencent.soter.core.d.c */
public class C46746c extends C40999b implements C44474b {
    private static boolean AuF = false;
    protected String Avy = "SoterKeyStore";

    @SuppressLint({"PrivateApi"})
    public static void bLV() {
        AppMethodBeat.m2504i(73053);
        try {
            Method method = Class.forName("android.security.keystore.SoterKeyStoreProvider").getMethod("install", new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: no SoterProvider found", new Object[0]);
        } catch (NoSuchMethodException e2) {
            C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: function not found", new Object[0]);
        } catch (IllegalAccessException e3) {
            C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: cannot access", new Object[0]);
        } catch (InvocationTargetException e4) {
            C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: InvocationTargetException", new Object[0]);
        } finally {
            AuF = true;
            AppMethodBeat.m2505o(73053);
        }
    }

    public C46746c(String str) {
        this.Avy = str;
    }

    /* renamed from: iV */
    public final boolean mo64960iV(Context context) {
        AppMethodBeat.m2504i(73054);
        C46746c.bLV();
        AppMethodBeat.m2505o(73054);
        return true;
    }

    public final boolean dQN() {
        AppMethodBeat.m2504i(73055);
        if (!AuF) {
            C46746c.bLV();
        }
        if (C24322h.dQY()) {
            C44476d.m80486w("Soter.SoterCoreBeforeTreble", "hy: the device has already triggered OOM. mark as not support", new Object[0]);
            AppMethodBeat.m2505o(73055);
            return false;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: no provider supported", new Object[0]);
            AppMethodBeat.m2505o(73055);
            return false;
        }
        int length = providers.length;
        int i = 0;
        while (i < length) {
            String name = providers[i].getName();
            if (name == null || !name.startsWith("SoterKeyStore")) {
                i++;
            } else {
                C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: found soter provider", new Object[0]);
                AppMethodBeat.m2505o(73055);
                return true;
            }
        }
        C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: soter provider not found", new Object[0]);
        AppMethodBeat.m2505o(73055);
        return false;
    }

    public C44478f dQO() {
        AppMethodBeat.m2504i(73056);
        C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: start generate ask", new Object[0]);
        C44478f c44478f;
        if (dQN()) {
            try {
                KeyStore.getInstance(this.Avy).load(null);
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "SoterKeyStore");
                instance.initialize(C24316a.m37479eP(C46745e.dQW().Avi + ".addcounter.auto_signed_when_get_pubkey_attk", 4).mo40403W(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM).mo40404X("PSS").dQU());
                long nanoTime = System.nanoTime();
                instance.generateKeyPair();
                long nC = C24321g.m37491nC(nanoTime);
                C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: generate successfully. cost: %d ms", Long.valueOf(nC));
                c44478f = new C44478f(0);
                AppMethodBeat.m2505o(73056);
                return c44478f;
            } catch (Exception e) {
                Exception exception = e;
                C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: generateAppGlobalSecureKey " + exception.toString(), new Object[0]);
                C44476d.m80481a("Soter.SoterCoreBeforeTreble", exception, "soter: generateAppGlobalSecureKey error");
                c44478f = new C44478f(4, exception.toString());
                AppMethodBeat.m2505o(73056);
                return c44478f;
            } catch (OutOfMemoryError e2) {
                C44476d.m80481a("Soter.SoterCoreBeforeTreble", e2, "soter: out of memory when generate ASK!! maybe no attk inside");
                C24322h.dQX();
            }
        } else {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            c44478f = new C44478f(2);
            AppMethodBeat.m2505o(73056);
            return c44478f;
        }
    }

    public final C44478f dQP() {
        AppMethodBeat.m2504i(73057);
        C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: start remove app global secure key", new Object[0]);
        C44478f c44478f;
        if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                instance.deleteEntry(C46745e.dQW().Avi);
                c44478f = new C44478f(0);
                AppMethodBeat.m2505o(73057);
                return c44478f;
            } catch (Exception e) {
                Exception exception = e;
                C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: removeAppGlobalSecureKey " + exception.toString(), new Object[0]);
                c44478f = new C44478f(5, exception.toString());
                AppMethodBeat.m2505o(73057);
                return c44478f;
            }
        }
        C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
        c44478f = new C44478f(2);
        AppMethodBeat.m2505o(73057);
        return c44478f;
    }

    public final boolean dQQ() {
        AppMethodBeat.m2504i(73058);
        try {
            KeyStore instance = KeyStore.getInstance(this.Avy);
            instance.load(null);
            if (instance.getCertificate(C46745e.dQW().Avi) != null) {
                AppMethodBeat.m2505o(73058);
                return true;
            }
            AppMethodBeat.m2505o(73058);
            return false;
        } catch (Exception e) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            AppMethodBeat.m2505o(73058);
            return false;
        }
    }

    public final boolean dQR() {
        AppMethodBeat.m2504i(73059);
        if (!dQQ() || dQS() == null) {
            AppMethodBeat.m2505o(73059);
            return false;
        }
        AppMethodBeat.m2505o(73059);
        return true;
    }

    public C30972i dQS() {
        C30972i c30972i = null;
        AppMethodBeat.m2504i(73060);
        C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: start get app global secure key pub", new Object[0]);
        if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                try {
                    Key key = instance.getKey(C46745e.dQW().Avi, "from_soter_ui".toCharArray());
                    if (key != null) {
                        c30972i = C40999b.m71103cp(key.getEncoded());
                        AppMethodBeat.m2505o(73060);
                    } else {
                        C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.m2505o(73060);
                    }
                } catch (ClassCastException e) {
                    C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + e.toString(), new Object[0]);
                    AppMethodBeat.m2505o(73060);
                }
            } catch (Exception e2) {
                C44476d.m80481a("Soter.SoterCoreBeforeTreble", e2, "soter: error when get ask");
            } catch (OutOfMemoryError e3) {
                C44476d.m80481a("Soter.SoterCoreBeforeTreble", e3, "soter: out of memory when getting ask!! maybe no attk inside");
                C24322h.dQX();
            }
        } else {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            AppMethodBeat.m2505o(73060);
        }
        return c30972i;
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
            com.tencent.soter.core.p1351c.C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: cause exception. maybe reflection exception: " + r1.toString(), new java.lang.Object[0]);
            r0 = new com.tencent.soter.core.p1351c.C44478f(5, r1.toString());
     */
    /* JADX WARNING: Missing block: B:19:0x00f2, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(73061);
     */
    /* JADX WARNING: Missing block: B:22:0x0123, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0124, code skipped:
            com.tencent.soter.core.p1351c.C44476d.m80481a("Soter.SoterCoreBeforeTreble", r0, "soter: out of memory when generate AuthKey!! maybe no attk inside");
            com.tencent.soter.core.p1351c.C24322h.dQX();
     */
    /* JADX WARNING: Missing block: B:29:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final C44478f atZ(String str) {
        AppMethodBeat.m2504i(73061);
        C44478f c44478f;
        if (C24321g.isNullOrNil(str)) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            c44478f = new C44478f(1, "no authKeyName");
            AppMethodBeat.m2505o(73061);
            return c44478f;
        } else if (dQN()) {
            try {
                if (dQQ()) {
                    KeyStore.getInstance(this.Avy).load(null);
                    KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", this.Avy);
                    instance.initialize(C24316a.m37479eP(str + String.format(".addcounter.auto_signed_when_get_pubkey(%s).secmsg_and_counter_signed_when_sign", new Object[]{C46745e.dQW().Avi}), 4).mo40403W(XWalkAppVersion.XWALK_APK_HASH_ALGORITHM).dQV().mo40404X("PSS").dQU());
                    long nanoTime = System.nanoTime();
                    instance.generateKeyPair();
                    long nC = C24321g.m37491nC(nanoTime);
                    C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: generate successfully, cost: %d ms", Long.valueOf(nC));
                    c44478f = new C44478f(0);
                    AppMethodBeat.m2505o(73061);
                    return c44478f;
                }
                c44478f = new C44478f(3, "app secure key not exist");
                AppMethodBeat.m2505o(73061);
                return c44478f;
            } catch (Exception e) {
                Exception exception = e;
                C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: generate auth key failed: " + exception.toString(), new Object[0]);
                c44478f = new C44478f(5, exception.toString());
                AppMethodBeat.m2505o(73061);
                return c44478f;
            } catch (OutOfMemoryError e2) {
            }
        } else {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
            c44478f = new C44478f(2);
            AppMethodBeat.m2505o(73061);
            return c44478f;
        }
    }

    /* renamed from: cn */
    public final C44478f mo64954cn(String str, boolean z) {
        AppMethodBeat.m2504i(73062);
        C44478f c44478f;
        if (C24321g.isNullOrNil(str)) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            c44478f = new C44478f(1, "no authKeyName");
            AppMethodBeat.m2505o(73062);
            return c44478f;
        }
        C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: start remove key: ".concat(String.valueOf(str)), new Object[0]);
        if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                instance.deleteEntry(str);
                if (z) {
                    C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: auto delete ask", new Object[0]);
                    if (dQQ()) {
                        dQP();
                    }
                }
                c44478f = new C44478f(0);
                AppMethodBeat.m2505o(73062);
                return c44478f;
            } catch (Exception e) {
                Exception exception = e;
                C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: removeAuthKey " + exception.toString(), new Object[0]);
                c44478f = new C44478f(6, exception.toString());
                AppMethodBeat.m2505o(73062);
                return c44478f;
            }
        }
        C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: not support soter", new Object[0]);
        c44478f = new C44478f(2);
        AppMethodBeat.m2505o(73062);
        return c44478f;
    }

    public final boolean aua(String str) {
        AppMethodBeat.m2504i(73063);
        if (C24321g.isNullOrNil(str)) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: authkey name not correct", new Object[0]);
            AppMethodBeat.m2505o(73063);
            return false;
        }
        try {
            KeyStore instance = KeyStore.getInstance(this.Avy);
            instance.load(null);
            if (instance.getCertificate(str) != null) {
                AppMethodBeat.m2505o(73063);
                return true;
            }
            AppMethodBeat.m2505o(73063);
            return false;
        } catch (Exception e) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: hasAppGlobalSecureKey exception: " + e.toString(), new Object[0]);
            AppMethodBeat.m2505o(73063);
            return false;
        }
    }

    /* renamed from: iC */
    public final SoterSessionResult mo64959iC(String str, String str2) {
        return null;
    }

    /* renamed from: nB */
    public final byte[] mo64961nB(long j) {
        return new byte[0];
    }

    public final boolean aub(String str) {
        AppMethodBeat.m2504i(73064);
        C44476d.m80484i("Soter.SoterCoreBeforeTreble", String.format("soter: checking key valid: auth key name: %s, autoDelIfNotValid: %b ", new Object[]{str, Boolean.TRUE}), new Object[0]);
        if (C24321g.isNullOrNil(str)) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: checking key valid: authkey name not correct", new Object[0]);
            AppMethodBeat.m2505o(73064);
            return false;
        }
        try {
            auf(str);
            C44476d.m80484i("Soter.SoterCoreBeforeTreble", "soter: key valid", new Object[0]);
            AppMethodBeat.m2505o(73064);
            return true;
        } catch (InvalidKeyException | UnrecoverableEntryException e) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: key invalid.", new Object[0]);
            mo64954cn(str, false);
            AppMethodBeat.m2505o(73064);
            return false;
        } catch (Exception e2) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: occurs other exceptions: %s", e2.toString());
            C44476d.m80481a("Soter.SoterCoreBeforeTreble", e2, "soter: occurs other exceptions");
            AppMethodBeat.m2505o(73064);
            return false;
        } catch (OutOfMemoryError e3) {
            C44476d.m80481a("Soter.SoterCoreBeforeTreble", e3, "soter: out of memory when isAuthKeyValid!! maybe no attk inside");
            C24322h.dQX();
            AppMethodBeat.m2505o(73064);
            return false;
        }
    }

    public final C30972i auc(String str) {
        C30972i c30972i = null;
        AppMethodBeat.m2504i(73065);
        if (C24321g.isNullOrNil(str)) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.m2505o(73065);
        } else if (dQN()) {
            try {
                KeyStore instance = KeyStore.getInstance(this.Avy);
                instance.load(null);
                try {
                    Key key = instance.getKey(str, "from_soter_ui".toCharArray());
                    if (key != null) {
                        c30972i = C40999b.m71103cp(key.getEncoded());
                        AppMethodBeat.m2505o(73065);
                    } else {
                        C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: key can not be retrieved", new Object[0]);
                        AppMethodBeat.m2505o(73065);
                    }
                } catch (ClassCastException e) {
                    C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: cast error: " + e.toString(), new Object[0]);
                    AppMethodBeat.m2505o(73065);
                }
            } catch (Exception e2) {
                C44476d.m80481a("Soter.SoterCoreBeforeTreble", e2, "soter: error in get auth key model");
            } catch (OutOfMemoryError e3) {
                C44476d.m80481a("Soter.SoterCoreBeforeTreble", e3, "soter: out of memory when getAuthKeyModel!! maybe no attk inside");
                C24322h.dQX();
            }
        } else {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: not support soter " + this.Avy, new Object[0]);
            AppMethodBeat.m2505o(73065);
        }
        return c30972i;
    }

    public final Signature aud(String str) {
        Signature signature = null;
        AppMethodBeat.m2504i(73066);
        if (C24321g.isNullOrNil(str)) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.m2505o(73066);
        } else if (dQN()) {
            try {
                signature = auf(str);
                AppMethodBeat.m2505o(73066);
            } catch (InvalidKeyException | UnrecoverableEntryException e) {
                C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: key invalid. Advice remove the key", new Object[0]);
                AppMethodBeat.m2505o(73066);
            } catch (Exception e2) {
                C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: exception when getSignatureResult: " + e2.toString(), new Object[0]);
                C44476d.m80481a("Soter.SoterCoreBeforeTreble", e2, "soter: exception when getSignatureResult");
                AppMethodBeat.m2505o(73066);
            } catch (OutOfMemoryError e3) {
                C44476d.m80481a("Soter.SoterCoreBeforeTreble", e3, "soter: out of memory when getAuthInitAndSign!! maybe no attk inside");
                C24322h.dQX();
                AppMethodBeat.m2505o(73066);
            }
        } else {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: not support soter" + this.Avy, new Object[0]);
            AppMethodBeat.m2505o(73066);
        }
        return signature;
    }

    public Signature auf(String str) {
        AppMethodBeat.m2504i(73067);
        if (C24321g.isNullOrNil(str)) {
            C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: auth key name is null or nil. abort.", new Object[0]);
            AppMethodBeat.m2505o(73067);
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withRSA/PSS", "AndroidKeyStoreBCWorkaround");
        KeyStore instance2 = KeyStore.getInstance(this.Avy);
        instance2.load(null);
        PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) instance2.getEntry(str, null);
        if (privateKeyEntry != null) {
            instance.initSign(privateKeyEntry.getPrivateKey());
            AppMethodBeat.m2505o(73067);
            return instance;
        }
        C44476d.m80483e("Soter.SoterCoreBeforeTreble", "soter: entry not exists", new Object[0]);
        AppMethodBeat.m2505o(73067);
        return null;
    }
}
