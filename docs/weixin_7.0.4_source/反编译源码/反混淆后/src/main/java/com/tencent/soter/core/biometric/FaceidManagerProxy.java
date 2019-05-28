package com.tencent.soter.core.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C44476d;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
final class FaceidManagerProxy {
    public static final String FACEMANAGER_FACTORY_CLASS_NAME = "com.tencent.soter.core.biometric.SoterFaceManagerFactory";
    private static final String TAG = "Soter.FaceidManagerProxy";

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

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }

        public void onAuthenticationFailed() {
        }
    }

    public static final class AuthenticationResult {
        private CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public final CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    FaceidManagerProxy() {
    }

    static /* synthetic */ CryptoObject access$000(com.tencent.soter.core.biometric.FaceManager.CryptoObject cryptoObject) {
        AppMethodBeat.m2504i(72947);
        CryptoObject unwrapCryptoObject = unwrapCryptoObject(cryptoObject);
        AppMethodBeat.m2505o(72947);
        return unwrapCryptoObject;
    }

    private static FaceManager getFaceManager(Context context) {
        FaceManager faceManager;
        AppMethodBeat.m2504i(72939);
        try {
            faceManager = (FaceManager) Class.forName(FACEMANAGER_FACTORY_CLASS_NAME).getDeclaredMethod("getFaceManager", new Class[]{Context.class}).invoke(null, new Object[]{context});
        } catch (Exception e) {
            C44476d.m80483e(TAG, "soter: FaceManager init failed, maybe not support." + e.toString(), new Object[0]);
            faceManager = null;
        }
        AppMethodBeat.m2505o(72939);
        return faceManager;
    }

    public static boolean hasEnrolledFaceids(Context context) {
        boolean z = false;
        AppMethodBeat.m2504i(72940);
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                z = faceManager.hasEnrolledFaces();
                AppMethodBeat.m2505o(72940);
            } else {
                C44476d.m80483e(TAG, "soter: facemanager is null in hasEnrolledBiometric! Should never happen", new Object[0]);
                AppMethodBeat.m2505o(72940);
            }
        } catch (Exception e) {
            C44476d.m80483e(TAG, "soter: triggered SecurityException in hasEnrolledBiometric! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.m2505o(72940);
        }
        return z;
    }

    public static boolean isHardwareDetected(Context context) {
        boolean z = false;
        AppMethodBeat.m2504i(72941);
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                z = faceManager.isHardwareDetected();
                AppMethodBeat.m2505o(72941);
            } else {
                C44476d.m80483e(TAG, "soter: facemanager is null in isHardwareDetected! Should never happen", new Object[0]);
                AppMethodBeat.m2505o(72941);
            }
        } catch (Exception e) {
            C44476d.m80483e(TAG, "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.m2505o(72941);
        }
        return z;
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        AppMethodBeat.m2504i(72942);
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                faceManager.authenticate(wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i, wrapCallback(authenticationCallback), handler);
                AppMethodBeat.m2505o(72942);
                return;
            }
            C44476d.m80483e(TAG, "soter: facemanager is null in authenticate! Should never happen", new Object[0]);
            AppMethodBeat.m2505o(72942);
        } catch (Exception e) {
            C44476d.m80483e(TAG, "soter: triggered SecurityException in authenticate! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.m2505o(72942);
        }
    }

    private static com.tencent.soter.core.biometric.FaceManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        AppMethodBeat.m2504i(72943);
        com.tencent.soter.core.biometric.FaceManager.CryptoObject cryptoObject2;
        if (cryptoObject == null) {
            AppMethodBeat.m2505o(72943);
            return null;
        } else if (cryptoObject.getCipher() != null) {
            cryptoObject2 = new com.tencent.soter.core.biometric.FaceManager.CryptoObject(cryptoObject.getCipher());
            AppMethodBeat.m2505o(72943);
            return cryptoObject2;
        } else if (cryptoObject.getSignature() != null) {
            cryptoObject2 = new com.tencent.soter.core.biometric.FaceManager.CryptoObject(cryptoObject.getSignature());
            AppMethodBeat.m2505o(72943);
            return cryptoObject2;
        } else if (cryptoObject.getMac() != null) {
            cryptoObject2 = new com.tencent.soter.core.biometric.FaceManager.CryptoObject(cryptoObject.getMac());
            AppMethodBeat.m2505o(72943);
            return cryptoObject2;
        } else {
            AppMethodBeat.m2505o(72943);
            return null;
        }
    }

    private static CryptoObject unwrapCryptoObject(com.tencent.soter.core.biometric.FaceManager.CryptoObject cryptoObject) {
        AppMethodBeat.m2504i(72944);
        CryptoObject cryptoObject2;
        if (cryptoObject == null) {
            AppMethodBeat.m2505o(72944);
            return null;
        } else if (cryptoObject.getCipher() != null) {
            cryptoObject2 = new CryptoObject(cryptoObject.getCipher());
            AppMethodBeat.m2505o(72944);
            return cryptoObject2;
        } else if (cryptoObject.getSignature() != null) {
            cryptoObject2 = new CryptoObject(cryptoObject.getSignature());
            AppMethodBeat.m2505o(72944);
            return cryptoObject2;
        } else if (cryptoObject.getMac() != null) {
            cryptoObject2 = new CryptoObject(cryptoObject.getMac());
            AppMethodBeat.m2505o(72944);
            return cryptoObject2;
        } else {
            AppMethodBeat.m2505o(72944);
            return null;
        }
    }

    private static com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        AppMethodBeat.m2504i(72945);
        C309711 c309711 = new com.tencent.soter.core.biometric.FaceManager.AuthenticationCallback() {
            public final void onAuthenticationError(int i, CharSequence charSequence) {
                AppMethodBeat.m2504i(72935);
                C44476d.m80482d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationError", new Object[0]);
                authenticationCallback.onAuthenticationError(i, charSequence);
                AppMethodBeat.m2505o(72935);
            }

            public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                AppMethodBeat.m2504i(72936);
                C44476d.m80482d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationHelp", new Object[0]);
                authenticationCallback.onAuthenticationHelp(i, charSequence);
                AppMethodBeat.m2505o(72936);
            }

            public final void onAuthenticationSucceeded(com.tencent.soter.core.biometric.FaceManager.AuthenticationResult authenticationResult) {
                AppMethodBeat.m2504i(72937);
                C44476d.m80482d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
                authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(FaceidManagerProxy.access$000(authenticationResult.getCryptoObject())));
                AppMethodBeat.m2505o(72937);
            }

            public final void onAuthenticationFailed() {
                AppMethodBeat.m2504i(72938);
                C44476d.m80482d(FaceidManagerProxy.TAG, "hy: lowest level return onAuthenticationFailed", new Object[0]);
                authenticationCallback.onAuthenticationFailed();
                AppMethodBeat.m2505o(72938);
            }
        };
        AppMethodBeat.m2505o(72945);
        return c309711;
    }

    public static String getBiometricName(Context context) {
        String str = null;
        AppMethodBeat.m2504i(72946);
        try {
            FaceManager faceManager = getFaceManager(context);
            if (faceManager != null) {
                str = faceManager.getBiometricName(context);
                AppMethodBeat.m2505o(72946);
            } else {
                C44476d.m80483e(TAG, "soter: faceid manager is null! no biometric name returned.", new Object[0]);
                AppMethodBeat.m2505o(72946);
            }
        } catch (Exception e) {
            C44476d.m80483e(TAG, "soter: triggered SecurityException in getBiometricName! Make sure you declared USE_FACEID in AndroidManifest.xml", new Object[0]);
            AppMethodBeat.m2505o(72946);
        }
        return str;
    }
}
