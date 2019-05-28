package com.tencent.mars.cdn;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String OID_ANY_EKU = "2.5.29.37.0";
    private static final String OID_SERVER_GATED_MICROSOFT = "1.3.6.1.4.1.311.10.3.3";
    private static final String OID_SERVER_GATED_NETSCAPE = "2.16.840.1.113730.4.1";
    private static final String OID_TLS_SERVER_AUTH = "1.3.6.1.5.5.7.3.1";
    public static final int STATE_APPBRAND = 1;
    public static final int STATE_CDN = 0;
    private static final String TAG = "X509Util";
    private static CertificateFactory sCertificateFactory;
    private static X509TrustManagerImplementation sDefaultTrustManager;
    private static boolean sLoadedSystemKeyStore;
    private static final Object sLock = new Object();
    private static File sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerImplementation sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;

    public static final class CertVerifyStatusAndroid {
        public static final int EXPIRED = -3;
        public static final int FAILED = -1;
        public static final int INCORRECT_KEY_USAGE = -6;
        public static final int NOT_YET_VALID = -4;
        public static final int NO_TRUSTED_ROOT = -2;
        public static final int OK = 0;
        public static final int UNABLE_TO_PARSE = -5;
    }

    static final class X509TrustManagerJellyBean implements X509TrustManagerImplementation {
        private final X509TrustManagerExtensions mTrustManagerExtensions;

        @SuppressLint({"NewApi"})
        public X509TrustManagerJellyBean(X509TrustManager x509TrustManager) {
            this.mTrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        }

        @SuppressLint({"NewApi"})
        public final List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            return this.mTrustManagerExtensions.checkServerTrusted(x509CertificateArr, str, str2);
        }
    }

    static final class TrustStorageListener extends BroadcastReceiver {
        private TrustStorageListener() {
        }

        /* synthetic */ TrustStorageListener(AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            boolean equals;
            if (VERSION.SDK_INT < 26) {
                equals = "android.security.STORAGE_CHANGED".equals(intent.getAction());
            } else if ("android.security.action.KEYCHAIN_CHANGED".equals(intent.getAction()) || "android.security.action.TRUST_STORE_CHANGED".equals(intent.getAction())) {
                equals = true;
            } else if (!"android.security.action.KEY_ACCESS_CHANGED".equals(intent.getAction()) || intent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false)) {
                equals = false;
            } else {
                equals = true;
            }
            if (equals) {
                try {
                    X509Util.reloadDefaultTrustManager();
                } catch (CertificateException e) {
                    ab.e(X509Util.TAG, "Unable to reload the default TrustManager", e);
                } catch (KeyStoreException e2) {
                    ab.e(X509Util.TAG, "Unable to reload the default TrustManager", e2);
                } catch (NoSuchAlgorithmException e3) {
                    ab.e(X509Util.TAG, "Unable to reload the default TrustManager", e3);
                }
            }
        }
    }

    static final class X509TrustManagerIceCreamSandwich implements X509TrustManagerImplementation {
        private final X509TrustManager mTrustManager;

        public X509TrustManagerIceCreamSandwich(X509TrustManager x509TrustManager) {
            this.mTrustManager = x509TrustManager;
        }

        public final List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            this.mTrustManager.checkServerTrusted(x509CertificateArr, str);
            return Collections.emptyList();
        }
    }

    interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2);
    }

    static {
        boolean z;
        if (X509Util.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    private static void ensureInitialized() {
        synchronized (sLock) {
            ensureInitializedLocked();
        }
    }

    private static void ensureInitializedLocked() {
        if ($assertionsDisabled || Thread.holdsLock(sLock)) {
            if (sCertificateFactory == null) {
                sCertificateFactory = CertificateFactory.getInstance("X.509");
            }
            if (sDefaultTrustManager == null) {
                sDefaultTrustManager = createTrustManager(null);
            }
            if (!sLoadedSystemKeyStore) {
                try {
                    sSystemKeyStore = KeyStore.getInstance("AndroidCAStore");
                    try {
                        sSystemKeyStore.load(null);
                    } catch (IOException e) {
                    }
                    sSystemCertificateDirectory = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");
                } catch (KeyStoreException e2) {
                }
                sLoadedSystemKeyStore = true;
            }
            if (sSystemTrustAnchorCache == null) {
                sSystemTrustAnchorCache = new HashSet();
            }
            if (sTestKeyStore == null) {
                sTestKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                try {
                    sTestKeyStore.load(null);
                } catch (IOException e3) {
                }
            }
            if (sTestTrustManager == null) {
                sTestTrustManager = createTrustManager(sTestKeyStore);
            }
            if (sTrustStorageListener == null) {
                sTrustStorageListener = new TrustStorageListener();
                IntentFilter intentFilter = new IntentFilter();
                if (VERSION.SDK_INT >= 26) {
                    intentFilter.addAction("android.security.action.KEYCHAIN_CHANGED");
                    intentFilter.addAction("android.security.action.KEY_ACCESS_CHANGED");
                    intentFilter.addAction("android.security.action.TRUST_STORE_CHANGED");
                } else {
                    intentFilter.addAction("android.security.STORAGE_CHANGED");
                }
                ah.getContext().registerReceiver(sTrustStorageListener, intentFilter);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private static X509TrustManagerImplementation createTrustManager(KeyStore keyStore) {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(keyStore);
        TrustManager[] trustManagers = instance.getTrustManagers();
        int length = trustManagers.length;
        int i = 0;
        while (i < length) {
            Object obj = trustManagers[i];
            if (obj instanceof X509TrustManager) {
                try {
                    if (VERSION.SDK_INT >= 17) {
                        return new X509TrustManagerJellyBean((X509TrustManager) obj);
                    }
                    return new X509TrustManagerIceCreamSandwich((X509TrustManager) obj);
                } catch (IllegalArgumentException e) {
                    ab.e(TAG, "Error creating trust manager (" + obj.getClass().getName() + "): " + e);
                }
            } else {
                i++;
            }
        }
        ab.e(TAG, "Could not find suitable trust manager");
        return null;
    }

    private static void reloadTestTrustManager() {
        if ($assertionsDisabled || Thread.holdsLock(sLock)) {
            sTestTrustManager = createTrustManager(sTestKeyStore);
            return;
        }
        throw new AssertionError();
    }

    private static void reloadDefaultTrustManager() {
        synchronized (sLock) {
            sDefaultTrustManager = null;
            sSystemTrustAnchorCache = null;
            ensureInitializedLocked();
        }
    }

    public static X509Certificate createCertificateFromBytes(byte[] bArr) {
        ensureInitialized();
        return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
    }

    public static void addTestRootCertificate(byte[] bArr) {
        ensureInitialized();
        X509Certificate createCertificateFromBytes = createCertificateFromBytes(bArr);
        synchronized (sLock) {
            sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), createCertificateFromBytes);
            reloadTestTrustManager();
        }
    }

    public static void clearTestRootCertificates() {
        ensureInitialized();
        synchronized (sLock) {
            try {
                sTestKeyStore.load(null);
                reloadTestTrustManager();
            } catch (IOException e) {
            }
        }
    }

    private static String hashPrincipal(X500Principal x500Principal) {
        byte[] digest = MessageDigest.getInstance("MD5").digest(x500Principal.getEncoded());
        char[] cArr = new char[8];
        for (int i = 0; i < 4; i++) {
            cArr[i * 2] = HEX_DIGITS[(digest[3 - i] >> 4) & 15];
            cArr[(i * 2) + 1] = HEX_DIGITS[digest[3 - i] & 15];
        }
        return new String(cArr);
    }

    private static boolean isKnownRoot(X509Certificate x509Certificate) {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        } else if (sSystemKeyStore == null) {
            return false;
        } else {
            Pair pair = new Pair(x509Certificate.getSubjectX500Principal(), x509Certificate.getPublicKey());
            if (sSystemTrustAnchorCache.contains(pair)) {
                return true;
            }
            String hashPrincipal = hashPrincipal(x509Certificate.getSubjectX500Principal());
            int i = 0;
            while (true) {
                String str = hashPrincipal + '.' + i;
                if (!new File(sSystemCertificateDirectory, str).exists()) {
                    return false;
                }
                Certificate certificate = sSystemKeyStore.getCertificate("system:".concat(String.valueOf(str)));
                if (certificate != null) {
                    if (certificate instanceof X509Certificate) {
                        X509Certificate x509Certificate2 = (X509Certificate) certificate;
                        if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getSubjectX500Principal()) && x509Certificate.getPublicKey().equals(x509Certificate2.getPublicKey())) {
                            sSystemTrustAnchorCache.add(pair);
                            return true;
                        }
                    }
                    ab.e(TAG, "Anchor " + str + " not an X509Certificate: " + certificate.getClass().getName());
                }
                i++;
            }
        }
    }

    static boolean verifyKeyUsage(X509Certificate x509Certificate) {
        try {
            List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
            if (extendedKeyUsage == null) {
                return true;
            }
            for (String str : extendedKeyUsage) {
                if (str.equals(OID_TLS_SERVER_AUTH) || str.equals(OID_ANY_EKU) || str.equals(OID_SERVER_GATED_NETSCAPE)) {
                    return true;
                }
                if (str.equals(OID_SERVER_GATED_MICROSOFT)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    private static List<String> getSubjectAlternativeNames(X509Certificate x509Certificate) {
        Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
        if (subjectAlternativeNames == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (List list : subjectAlternativeNames) {
            Object obj = list.get(1);
            if (obj instanceof String) {
                arrayList.add(((String) obj).toLowerCase());
            }
        }
        String trim = x509Certificate.getSubjectDN().getName().trim();
        int indexOf = trim.indexOf("CN=");
        String str = "";
        if (indexOf >= 0) {
            str = trim.substring(indexOf + 3);
            indexOf = str.indexOf(",");
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
            }
        }
        ab.i(TAG, "certificate dn %s cn %s", trim, str);
        if (str.length() > 0) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private static boolean isHostMatched(List<String> list, String str) {
        if (list.contains(str)) {
            return true;
        }
        int indexOf = str.indexOf(".");
        int lastIndexOf = str.lastIndexOf(".");
        while (indexOf > 0 && indexOf < lastIndexOf) {
            String str2 = "*" + str.substring(indexOf);
            ab.i(TAG, "try match nhost ".concat(String.valueOf(str2)));
            if (list.contains(str2)) {
                return true;
            }
            indexOf = str.indexOf(".", indexOf + 1);
        }
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        return verifyServerCertificates(bArr, str, str2, 0, null);
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2, X509TrustManager x509TrustManager) {
        return verifyServerCertificates(bArr, str, str2, 0, x509TrustManager);
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2, int i, X509TrustManager x509TrustManager) {
        int i2 = 1;
        boolean z = false;
        ab.i(TAG, "verifyServerCertificates %s type %s", str2, str);
        if (bArr == null || bArr.length == 0 || bArr[0] == null) {
            throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(bArr));
        }
        try {
            ensureInitialized();
            ArrayList arrayList = new ArrayList();
            try {
                boolean z2;
                arrayList.add(createCertificateFromBytes(bArr[0]));
                try {
                    boolean z3;
                    ab.i(TAG, "check host %s in altnames %s", str2, getSubjectAlternativeNames((X509Certificate) arrayList.get(0)).toString());
                    if (isHostMatched(getSubjectAlternativeNames((X509Certificate) arrayList.get(0)), str2)) {
                        z3 = true;
                    } else {
                        ab.e(TAG, "hostname mismatch");
                        if (i != 1) {
                            return new AndroidCertVerifyResult(-1);
                        }
                        z3 = false;
                    }
                    z2 = z3;
                } catch (Exception e) {
                    ab.e(TAG, "hostname verify failed " + e.getLocalizedMessage());
                    if (i != 1) {
                        return new AndroidCertVerifyResult(-1);
                    }
                    z2 = false;
                }
                while (i2 < bArr.length) {
                    try {
                        arrayList.add(createCertificateFromBytes(bArr[i2]));
                    } catch (CertificateException e2) {
                        ab.w(TAG, "intermediate " + i2 + " failed parsing");
                    }
                    i2++;
                }
                X509Certificate[] x509CertificateArr = (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
                try {
                    x509CertificateArr[0].checkValidity();
                    if (!verifyKeyUsage(x509CertificateArr[0])) {
                        return new AndroidCertVerifyResult(-6);
                    }
                    synchronized (sLock) {
                        AndroidCertVerifyResult androidCertVerifyResult;
                        if (sDefaultTrustManager == null && x509TrustManager == null) {
                            androidCertVerifyResult = new AndroidCertVerifyResult(-1);
                            return androidCertVerifyResult;
                        } else if (x509TrustManager != null) {
                            try {
                                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                                androidCertVerifyResult = new AndroidCertVerifyResult(0, true, new ArrayList(), z2);
                                return androidCertVerifyResult;
                            } catch (CertificateException e3) {
                                ab.i(TAG, "Failed to validate the certificate chain use self trustmanager, error: " + e3.getMessage());
                                return new AndroidCertVerifyResult(-2);
                            }
                        } else {
                            List checkServerTrusted;
                            try {
                                checkServerTrusted = sDefaultTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                            } catch (CertificateException e4) {
                                try {
                                    checkServerTrusted = sTestTrustManager.checkServerTrusted(x509CertificateArr, str, str2);
                                } catch (CertificateException e5) {
                                    ab.i(TAG, "Failed to validate the certificate chain, error: " + e4.getMessage());
                                    return new AndroidCertVerifyResult(-2);
                                }
                            }
                            if (checkServerTrusted.size() > 0) {
                                z = isKnownRoot((X509Certificate) checkServerTrusted.get(checkServerTrusted.size() - 1));
                            }
                            androidCertVerifyResult = new AndroidCertVerifyResult(0, z, checkServerTrusted, z2);
                            return androidCertVerifyResult;
                        }
                    }
                } catch (CertificateExpiredException e6) {
                    return new AndroidCertVerifyResult(-3);
                } catch (CertificateNotYetValidException e7) {
                    return new AndroidCertVerifyResult(-4);
                } catch (CertificateException e8) {
                    return new AndroidCertVerifyResult(-1);
                }
            } catch (CertificateException e9) {
                return new AndroidCertVerifyResult(-5);
            }
        } catch (CertificateException e10) {
            return new AndroidCertVerifyResult(-1);
        }
    }
}
