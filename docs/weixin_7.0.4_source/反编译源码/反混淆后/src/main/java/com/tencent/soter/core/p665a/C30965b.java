package com.tencent.soter.core.p665a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C24321g;
import com.tencent.soter.core.p1351c.C44476d;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
/* renamed from: com.tencent.soter.core.a.b */
final class C30965b {

    /* renamed from: com.tencent.soter.core.a.b$a */
    public static abstract class C30966a {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        /* renamed from: a */
        public void mo28999a(C30967b c30967b) {
        }

        public void onAuthenticationFailed() {
        }
    }

    /* renamed from: com.tencent.soter.core.a.b$b */
    public static final class C30967b {
        C30969c AuL;

        public C30967b(C30969c c30969c) {
            this.AuL = c30969c;
        }
    }

    /* renamed from: com.tencent.soter.core.a.b$1 */
    static class C309681 extends AuthenticationCallback {
        final /* synthetic */ C30966a AuK;

        C309681(C30966a c30966a) {
            this.AuK = c30966a;
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            AppMethodBeat.m2504i(72988);
            C44476d.m80482d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationError", new Object[0]);
            this.AuK.onAuthenticationError(i, charSequence);
            AppMethodBeat.m2505o(72988);
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            AppMethodBeat.m2504i(72989);
            C44476d.m80482d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationHelp", new Object[0]);
            this.AuK.onAuthenticationHelp(i, charSequence);
            AppMethodBeat.m2505o(72989);
        }

        public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
            C30969c c30969c;
            AppMethodBeat.m2504i(72990);
            C44476d.m80482d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
            C30966a c30966a = this.AuK;
            CryptoObject cryptoObject = authenticationResult.getCryptoObject();
            if (cryptoObject != null) {
                if (cryptoObject.getCipher() != null) {
                    c30969c = new C30969c(cryptoObject.getCipher());
                } else if (cryptoObject.getSignature() != null) {
                    c30969c = new C30969c(cryptoObject.getSignature());
                } else if (cryptoObject.getMac() != null) {
                    c30969c = new C30969c(cryptoObject.getMac());
                }
                c30966a.mo28999a(new C30967b(c30969c));
                AppMethodBeat.m2505o(72990);
            }
            c30969c = null;
            c30966a.mo28999a(new C30967b(c30969c));
            AppMethodBeat.m2505o(72990);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.m2504i(72991);
            C44476d.m80482d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationFailed", new Object[0]);
            this.AuK.onAuthenticationFailed();
            AppMethodBeat.m2505o(72991);
        }
    }

    /* renamed from: com.tencent.soter.core.a.b$c */
    public static class C30969c {
        final Cipher mCipher;
        final Mac mMac;
        final Signature mSignature;

        public C30969c(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public C30969c(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public C30969c(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    static FingerprintManager getFingerprintManager(Context context) {
        AppMethodBeat.m2504i(72992);
        FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManagerProxy.FINGERPRINT_SERVICE);
        AppMethodBeat.m2505o(72992);
        return fingerprintManager;
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        boolean z = false;
        AppMethodBeat.m2504i(72993);
        if (C30965b.checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
            AppMethodBeat.m2505o(72993);
        } else {
            try {
                FingerprintManager fingerprintManager = C30965b.getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.hasEnrolledFingerprints();
                    AppMethodBeat.m2505o(72993);
                } else {
                    C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
                    AppMethodBeat.m2505o(72993);
                }
            } catch (SecurityException e) {
                C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.m2505o(72993);
            }
        }
        return z;
    }

    static int checkSelfPermission(Context context, String str) {
        AppMethodBeat.m2504i(72994);
        if (context == null) {
            C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: check self permission: context is null", new Object[0]);
            AppMethodBeat.m2505o(72994);
            return -1;
        } else if (C24321g.isNullOrNil(str)) {
            C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: requested permission is null or nil", new Object[0]);
            AppMethodBeat.m2505o(72994);
            return -1;
        } else if (VERSION.SDK_INT < 23) {
            C44476d.m80482d("Soter.FingerprintManagerCompatApi23", "soter: below 23. directly return.", new Object[0]);
            AppMethodBeat.m2505o(72994);
            return 0;
        } else {
            int checkSelfPermission = context.checkSelfPermission(str);
            AppMethodBeat.m2505o(72994);
            return checkSelfPermission;
        }
    }

    public static boolean isHardwareDetected(Context context) {
        boolean z = false;
        AppMethodBeat.m2504i(72995);
        if (C30965b.checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: isHardwareDetected", new Object[0]);
            AppMethodBeat.m2505o(72995);
        } else {
            try {
                FingerprintManager fingerprintManager = C30965b.getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.isHardwareDetected();
                    AppMethodBeat.m2505o(72995);
                } else {
                    C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
                    AppMethodBeat.m2505o(72995);
                }
            } catch (SecurityException e) {
                C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.m2505o(72995);
            }
        }
        return z;
    }
}
