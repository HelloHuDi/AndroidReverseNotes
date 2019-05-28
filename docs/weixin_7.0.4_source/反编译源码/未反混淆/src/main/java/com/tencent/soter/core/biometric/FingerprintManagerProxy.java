package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
final class FingerprintManagerProxy {
    public static final String FINGERPRINT_SERVICE = "fingerprint";
    private static final String TAG = "Soter.FingerprintManagerProxy";

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Signature getSignature() {
            return this.mSignature;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }
    }

    public static final class AuthenticationResultInternal {
        private CryptoObject mCryptoObject;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public final CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
        }

        public void onAuthenticationFailed() {
        }
    }

    FingerprintManagerProxy() {
    }

    static /* synthetic */ CryptoObject access$000(android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject) {
        AppMethodBeat.i(72960);
        CryptoObject unwrapCryptoObject = unwrapCryptoObject(cryptoObject);
        AppMethodBeat.o(72960);
        return unwrapCryptoObject;
    }

    private static FingerprintManager getFingerprintManager(Context context) {
        AppMethodBeat.i(72952);
        FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService(FINGERPRINT_SERVICE);
        AppMethodBeat.o(72952);
        return fingerprintManager;
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        boolean z = false;
        AppMethodBeat.i(72953);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e(TAG, "soter: permission check failed: hasEnrolledBiometric", new Object[0]);
            AppMethodBeat.o(72953);
        } else {
            try {
                FingerprintManager fingerprintManager = getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.hasEnrolledFingerprints();
                    AppMethodBeat.o(72953);
                } else {
                    d.e(TAG, "soter: fingerprint manager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
                    AppMethodBeat.o(72953);
                }
            } catch (SecurityException e) {
                d.e(TAG, "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.o(72953);
            }
        }
        return z;
    }

    private static int checkSelfPermission(Context context, String str) {
        AppMethodBeat.i(72954);
        if (context == null) {
            d.e(TAG, "soter: check self permission: context is null", new Object[0]);
            AppMethodBeat.o(72954);
            return -1;
        } else if (g.isNullOrNil(str)) {
            d.e(TAG, "soter: requested permission is null or nil", new Object[0]);
            AppMethodBeat.o(72954);
            return -1;
        } else if (VERSION.SDK_INT < 23) {
            d.d(TAG, "soter: below 23. directly return.", new Object[0]);
            AppMethodBeat.o(72954);
            return 0;
        } else {
            int checkSelfPermission = context.checkSelfPermission(str);
            AppMethodBeat.o(72954);
            return checkSelfPermission;
        }
    }

    public static boolean isHardwareDetected(Context context) {
        boolean z = false;
        AppMethodBeat.i(72955);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e(TAG, "soter: permission check failed: isHardwareDetected", new Object[0]);
            AppMethodBeat.o(72955);
        } else {
            try {
                FingerprintManager fingerprintManager = getFingerprintManager(context);
                if (fingerprintManager != null) {
                    z = fingerprintManager.isHardwareDetected();
                    AppMethodBeat.o(72955);
                } else {
                    d.e(TAG, "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
                    AppMethodBeat.o(72955);
                }
            } catch (SecurityException e) {
                d.e(TAG, "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                AppMethodBeat.o(72955);
            }
        }
        return z;
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        AppMethodBeat.i(72956);
        if (checkSelfPermission(context, "android.permission.USE_FINGERPRINT") != 0) {
            d.e(TAG, "soter: permission check failed: authenticate", new Object[0]);
            AppMethodBeat.o(72956);
            return;
        }
        try {
            FingerprintManager fingerprintManager = getFingerprintManager(context);
            if (fingerprintManager != null) {
                fingerprintManager.authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i, wrapCallback(authenticationCallback), handler);
                AppMethodBeat.o(72956);
                return;
            }
            d.e(TAG, "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
            AppMethodBeat.o(72956);
        } catch (SecurityException e) {
            d.e(TAG, "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.o(72956);
        }
    }

    private static android.hardware.fingerprint.FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        AppMethodBeat.i(72957);
        android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject2;
        if (cryptoObject == null) {
            AppMethodBeat.o(72957);
            return null;
        } else if (cryptoObject.getCipher() != null) {
            cryptoObject2 = new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject.getCipher());
            AppMethodBeat.o(72957);
            return cryptoObject2;
        } else if (cryptoObject.getSignature() != null) {
            cryptoObject2 = new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject.getSignature());
            AppMethodBeat.o(72957);
            return cryptoObject2;
        } else if (cryptoObject.getMac() != null) {
            cryptoObject2 = new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject.getMac());
            AppMethodBeat.o(72957);
            return cryptoObject2;
        } else {
            AppMethodBeat.o(72957);
            return null;
        }
    }

    private static CryptoObject unwrapCryptoObject(android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject) {
        AppMethodBeat.i(72958);
        CryptoObject cryptoObject2;
        if (cryptoObject == null) {
            AppMethodBeat.o(72958);
            return null;
        } else if (cryptoObject.getCipher() != null) {
            cryptoObject2 = new CryptoObject(cryptoObject.getCipher());
            AppMethodBeat.o(72958);
            return cryptoObject2;
        } else if (cryptoObject.getSignature() != null) {
            cryptoObject2 = new CryptoObject(cryptoObject.getSignature());
            AppMethodBeat.o(72958);
            return cryptoObject2;
        } else if (cryptoObject.getMac() != null) {
            cryptoObject2 = new CryptoObject(cryptoObject.getMac());
            AppMethodBeat.o(72958);
            return cryptoObject2;
        } else {
            AppMethodBeat.o(72958);
            return null;
        }
    }

    private static android.hardware.fingerprint.FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        AppMethodBeat.i(72959);
        AnonymousClass1 anonymousClass1 = new android.hardware.fingerprint.FingerprintManager.AuthenticationCallback() {
            public final void onAuthenticationError(int i, CharSequence charSequence) {
                AppMethodBeat.i(72948);
                d.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationError", new Object[0]);
                authenticationCallback.onAuthenticationError(i, charSequence);
                AppMethodBeat.o(72948);
            }

            public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                AppMethodBeat.i(72949);
                d.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationHelp", new Object[0]);
                authenticationCallback.onAuthenticationHelp(i, charSequence);
                AppMethodBeat.o(72949);
            }

            public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
                AppMethodBeat.i(72950);
                d.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
                authenticationCallback.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerProxy.access$000(authenticationResult.getCryptoObject())));
                AppMethodBeat.o(72950);
            }

            public final void onAuthenticationFailed() {
                AppMethodBeat.i(72951);
                d.d(FingerprintManagerProxy.TAG, "hy: lowest level return onAuthenticationFailed", new Object[0]);
                authenticationCallback.onAuthenticationFailed();
                AppMethodBeat.o(72951);
            }
        };
        AppMethodBeat.o(72959);
        return anonymousClass1;
    }
}
