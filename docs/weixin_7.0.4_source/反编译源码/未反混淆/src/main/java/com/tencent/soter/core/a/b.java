package com.tencent.soter.core.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
final class b {

    public static abstract class a {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void a(b bVar) {
        }

        public void onAuthenticationFailed() {
        }
    }

    public static final class b {
        c AuL;

        public b(c cVar) {
            this.AuL = cVar;
        }
    }

    /* renamed from: com.tencent.soter.core.a.b$1 */
    static class AnonymousClass1 extends AuthenticationCallback {
        final /* synthetic */ a AuK;

        AnonymousClass1(a aVar) {
            this.AuK = aVar;
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            AppMethodBeat.i(72988);
            d.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationError", new Object[0]);
            this.AuK.onAuthenticationError(i, charSequence);
            AppMethodBeat.o(72988);
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            AppMethodBeat.i(72989);
            d.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationHelp", new Object[0]);
            this.AuK.onAuthenticationHelp(i, charSequence);
            AppMethodBeat.o(72989);
        }

        public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
            c cVar;
            AppMethodBeat.i(72990);
            d.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
            a aVar = this.AuK;
            CryptoObject cryptoObject = authenticationResult.getCryptoObject();
            if (cryptoObject != null) {
                if (cryptoObject.getCipher() != null) {
                    cVar = new c(cryptoObject.getCipher());
                } else if (cryptoObject.getSignature() != null) {
                    cVar = new c(cryptoObject.getSignature());
                } else if (cryptoObject.getMac() != null) {
                    cVar = new c(cryptoObject.getMac());
                }
                aVar.a(new b(cVar));
                AppMethodBeat.o(72990);
            }
            cVar = null;
            aVar.a(new b(cVar));
            AppMethodBeat.o(72990);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.i(72991);
            d.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationFailed", new Object[0]);
            this.AuK.onAuthenticationFailed();
            AppMethodBeat.o(72991);
        }
    }

    public static class c {
        final Cipher mCipher;
        final Mac mMac;
        final Signature mSignature;

        public c(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public c(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public c(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    static FingerprintManager getFingerprintManager(Context context) {
        AppMethodBeat.i(72992);
        FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManagerProxy.FINGERPRINT_SERVICE);
        AppMethodBeat.o(72992);
        return fingerprintManager;
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        boolean z = false;
        AppMethodBeat.i(72993);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
            AppMethodBeat.o(72993);
        } else {
            try {
                FingerprintManager fingerprintManager = getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.hasEnrolledFingerprints();
                    AppMethodBeat.o(72993);
                } else {
                    d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
                    AppMethodBeat.o(72993);
                }
            } catch (SecurityException e) {
                d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.o(72993);
            }
        }
        return z;
    }

    static int checkSelfPermission(Context context, String str) {
        AppMethodBeat.i(72994);
        if (context == null) {
            d.e("Soter.FingerprintManagerCompatApi23", "soter: check self permission: context is null", new Object[0]);
            AppMethodBeat.o(72994);
            return -1;
        } else if (g.isNullOrNil(str)) {
            d.e("Soter.FingerprintManagerCompatApi23", "soter: requested permission is null or nil", new Object[0]);
            AppMethodBeat.o(72994);
            return -1;
        } else if (VERSION.SDK_INT < 23) {
            d.d("Soter.FingerprintManagerCompatApi23", "soter: below 23. directly return.", new Object[0]);
            AppMethodBeat.o(72994);
            return 0;
        } else {
            int checkSelfPermission = context.checkSelfPermission(str);
            AppMethodBeat.o(72994);
            return checkSelfPermission;
        }
    }

    public static boolean isHardwareDetected(Context context) {
        boolean z = false;
        AppMethodBeat.i(72995);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: isHardwareDetected", new Object[0]);
            AppMethodBeat.o(72995);
        } else {
            try {
                FingerprintManager fingerprintManager = getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.isHardwareDetected();
                    AppMethodBeat.o(72995);
                } else {
                    d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
                    AppMethodBeat.o(72995);
                }
            } catch (SecurityException e) {
                d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.o(72995);
            }
        }
        return z;
    }
}
