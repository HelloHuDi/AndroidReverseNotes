package com.tencent.soter.core.biometric;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationResultInternal;
import com.tencent.soter.core.p1351c.C44476d;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class BiometricManagerCompat {
    static final Map<Integer, IBiometricManager> IMPL_PROVIDER = new HashMap();
    private static final String TAG = "Soter.BiometricManagerCompat";
    private Integer mBiometricType;
    private Context mContext;

    static class FaceidManagerImpl implements IBiometricManager {
        private static final String TAG = "Soter.BiometricManagerCompat.Faceid";

        static /* synthetic */ boolean access$300(com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            AppMethodBeat.m2504i(72908);
            boolean shouldInformTooManyTrial = shouldInformTooManyTrial(authenticationCallback, context);
            AppMethodBeat.m2505o(72908);
            return shouldInformTooManyTrial;
        }

        static /* synthetic */ CryptoObject access$400(com.tencent.soter.core.biometric.FaceidManagerProxy.CryptoObject cryptoObject) {
            AppMethodBeat.m2504i(72909);
            CryptoObject unwrapCryptoObject = unwrapCryptoObject(cryptoObject);
            AppMethodBeat.m2505o(72909);
            return unwrapCryptoObject;
        }

        static /* synthetic */ void access$500(com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback authenticationCallback) {
            AppMethodBeat.m2504i(72910);
            informTooManyTrial(authenticationCallback);
            AppMethodBeat.m2505o(72910);
        }

        public boolean hasEnrolledBiometric(Context context) {
            AppMethodBeat.m2504i(72899);
            boolean hasEnrolledFaceids = FaceidManagerProxy.hasEnrolledFaceids(context);
            AppMethodBeat.m2505o(72899);
            return hasEnrolledFaceids;
        }

        public boolean isHardwareDetected(Context context) {
            AppMethodBeat.m2504i(72900);
            boolean isHardwareDetected = FaceidManagerProxy.isHardwareDetected(context);
            AppMethodBeat.m2505o(72900);
            return isHardwareDetected;
        }

        public String getBiometricName(Context context) {
            AppMethodBeat.m2504i(72901);
            String biometricName = FaceidManagerProxy.getBiometricName(context);
            AppMethodBeat.m2505o(72901);
            return biometricName;
        }

        public void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            AppMethodBeat.m2504i(72902);
            FaceidManagerProxy.authenticate(context, wrapCryptoObject(cryptoObject), i, cancellationSignal, wrapCallback(context, authenticationCallback), handler);
            AppMethodBeat.m2505o(72902);
        }

        private static com.tencent.soter.core.biometric.FaceidManagerProxy.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            AppMethodBeat.m2504i(72903);
            com.tencent.soter.core.biometric.FaceidManagerProxy.CryptoObject cryptoObject2;
            if (cryptoObject == null) {
                AppMethodBeat.m2505o(72903);
                return null;
            } else if (cryptoObject.getCipher() != null) {
                cryptoObject2 = new com.tencent.soter.core.biometric.FaceidManagerProxy.CryptoObject(cryptoObject.getCipher());
                AppMethodBeat.m2505o(72903);
                return cryptoObject2;
            } else if (cryptoObject.getSignature() != null) {
                cryptoObject2 = new com.tencent.soter.core.biometric.FaceidManagerProxy.CryptoObject(cryptoObject.getSignature());
                AppMethodBeat.m2505o(72903);
                return cryptoObject2;
            } else if (cryptoObject.getMac() != null) {
                cryptoObject2 = new com.tencent.soter.core.biometric.FaceidManagerProxy.CryptoObject(cryptoObject.getMac());
                AppMethodBeat.m2505o(72903);
                return cryptoObject2;
            } else {
                AppMethodBeat.m2505o(72903);
                return null;
            }
        }

        private static CryptoObject unwrapCryptoObject(com.tencent.soter.core.biometric.FaceidManagerProxy.CryptoObject cryptoObject) {
            AppMethodBeat.m2504i(72904);
            CryptoObject cryptoObject2;
            if (cryptoObject == null) {
                AppMethodBeat.m2505o(72904);
                return null;
            } else if (cryptoObject.getCipher() != null) {
                cryptoObject2 = new CryptoObject(cryptoObject.getCipher());
                AppMethodBeat.m2505o(72904);
                return cryptoObject2;
            } else if (cryptoObject.getSignature() != null) {
                cryptoObject2 = new CryptoObject(cryptoObject.getSignature());
                AppMethodBeat.m2505o(72904);
                return cryptoObject2;
            } else if (cryptoObject.getMac() != null) {
                cryptoObject2 = new CryptoObject(cryptoObject.getMac());
                AppMethodBeat.m2505o(72904);
                return cryptoObject2;
            } else {
                AppMethodBeat.m2505o(72904);
                return null;
            }
        }

        private static com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback wrapCallback(final Context context, final AuthenticationCallback authenticationCallback) {
            AppMethodBeat.m2504i(72905);
            C161741 c161741 = new com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback() {
                private boolean mMarkPermanentlyCallbacked = false;

                public final void onAuthenticationError(int i, CharSequence charSequence) {
                    AppMethodBeat.m2504i(72895);
                    C44476d.m80482d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] entered.", Integer.valueOf(i), charSequence);
                    if (this.mMarkPermanentlyCallbacked) {
                        C44476d.m80482d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] returned cause permanently callback.", Integer.valueOf(i), charSequence);
                        AppMethodBeat.m2505o(72895);
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (i == 5) {
                        C44476d.m80484i(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_CANCELED got.", Integer.valueOf(i), charSequence);
                        authenticationCallback.onAuthenticationCancelled();
                        AppMethodBeat.m2505o(72895);
                    } else if (i == 7) {
                        C44476d.m80484i(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned cause FACE_ERROR_LOCKOUT got.", Integer.valueOf(i), charSequence);
                        if (!(SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context) || SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context) || SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())) {
                            SoterBiometricAntiBruteForceStrategy.freeze(context);
                        }
                        authenticationCallback.onAuthenticationError(10308, "Too many failed times");
                        AppMethodBeat.m2505o(72895);
                    } else {
                        C44476d.m80482d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationError code[%d], msg[%s] callbacked and returned.", Integer.valueOf(i), charSequence);
                        authenticationCallback.onAuthenticationError(i, charSequence);
                        AppMethodBeat.m2505o(72895);
                    }
                }

                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                    AppMethodBeat.m2504i(72896);
                    C44476d.m80482d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationHelp helpMsgId[%d], helpString[%s]", Integer.valueOf(i), charSequence);
                    System.currentTimeMillis();
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.m2505o(72896);
                        return;
                    }
                    if (!FaceidManagerImpl.access$300(this, context)) {
                        authenticationCallback.onAuthenticationHelp(i, charSequence);
                    }
                    AppMethodBeat.m2505o(72896);
                }

                public final void onAuthenticationSucceeded(com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationResult authenticationResult) {
                    AppMethodBeat.m2504i(72897);
                    C44476d.m80482d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationSucceeded", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.m2505o(72897);
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (!FaceidManagerImpl.access$300(this, context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                        }
                        authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(FaceidManagerImpl.access$400(authenticationResult.getCryptoObject())));
                    }
                    AppMethodBeat.m2505o(72897);
                }

                public final void onAuthenticationFailed() {
                    AppMethodBeat.m2504i(72898);
                    C44476d.m80482d(FaceidManagerImpl.TAG, "soter: basic onAuthenticationFailed", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.m2505o(72898);
                        return;
                    }
                    this.mMarkPermanentlyCallbacked = true;
                    if (!(FaceidManagerImpl.access$300(this, context) || SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())) {
                        SoterBiometricAntiBruteForceStrategy.addFailTime(context);
                        if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                            C44476d.m80486w(FaceidManagerImpl.TAG, "soter: too many fail trials", new Object[0]);
                            SoterBiometricAntiBruteForceStrategy.freeze(context);
                            FaceidManagerImpl.access$500(this);
                            AppMethodBeat.m2505o(72898);
                            return;
                        }
                    }
                    authenticationCallback.onAuthenticationFailed();
                    AppMethodBeat.m2505o(72898);
                }
            };
            AppMethodBeat.m2505o(72905);
            return c161741;
        }

        private static boolean shouldInformTooManyTrial(com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            AppMethodBeat.m2504i(72906);
            if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                C44476d.m80485v(TAG, "soter: using system anti brute force strategy", new Object[0]);
                AppMethodBeat.m2505o(72906);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context)) {
                if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                    C44476d.m80485v(TAG, "soter: unfreeze former frozen status", new Object[0]);
                    SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                }
                AppMethodBeat.m2505o(72906);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                C44476d.m80485v(TAG, "soter: failure time available", new Object[0]);
                AppMethodBeat.m2505o(72906);
                return false;
            } else {
                informTooManyTrial(authenticationCallback);
                AppMethodBeat.m2505o(72906);
                return true;
            }
        }

        private static void informTooManyTrial(com.tencent.soter.core.biometric.FaceidManagerProxy.AuthenticationCallback authenticationCallback) {
            AppMethodBeat.m2504i(72907);
            C44476d.m80486w(TAG, "soter: too many fail callback. inform it.", new Object[0]);
            authenticationCallback.onAuthenticationError(10308, "Too many failed times");
            AppMethodBeat.m2505o(72907);
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

    interface IBiometricManager {
        void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler);

        String getBiometricName(Context context);

        boolean hasEnrolledBiometric(Context context);

        boolean isHardwareDetected(Context context);
    }

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

        public void onAuthenticationCancelled() {
        }
    }

    static class FingerprintManagerImpl implements IBiometricManager {
        private static final String TAG = "Soter.BiometricManagerCompat.Fingerprint";

        static /* synthetic */ boolean access$000(com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            AppMethodBeat.m2504i(72923);
            boolean shouldInformTooManyTrial = shouldInformTooManyTrial(authenticationCallback, context);
            AppMethodBeat.m2505o(72923);
            return shouldInformTooManyTrial;
        }

        static /* synthetic */ CryptoObject access$100(com.tencent.soter.core.biometric.FingerprintManagerProxy.CryptoObject cryptoObject) {
            AppMethodBeat.m2504i(72924);
            CryptoObject unwrapCryptoObject = unwrapCryptoObject(cryptoObject);
            AppMethodBeat.m2505o(72924);
            return unwrapCryptoObject;
        }

        static /* synthetic */ void access$200(com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback authenticationCallback) {
            AppMethodBeat.m2504i(72925);
            informTooManyTrial(authenticationCallback);
            AppMethodBeat.m2505o(72925);
        }

        public boolean hasEnrolledBiometric(Context context) {
            AppMethodBeat.m2504i(72915);
            boolean hasEnrolledFingerprints = FingerprintManagerProxy.hasEnrolledFingerprints(context);
            AppMethodBeat.m2505o(72915);
            return hasEnrolledFingerprints;
        }

        public boolean isHardwareDetected(Context context) {
            AppMethodBeat.m2504i(72916);
            boolean isHardwareDetected = FingerprintManagerProxy.isHardwareDetected(context);
            AppMethodBeat.m2505o(72916);
            return isHardwareDetected;
        }

        public String getBiometricName(Context context) {
            return FingerprintManagerProxy.FINGERPRINT_SERVICE;
        }

        public void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
            AppMethodBeat.m2504i(72917);
            FingerprintManagerProxy.authenticate(context, wrapCryptoObject(cryptoObject), i, cancellationSignal, wrapCallback(context, authenticationCallback), handler);
            AppMethodBeat.m2505o(72917);
        }

        private static com.tencent.soter.core.biometric.FingerprintManagerProxy.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            AppMethodBeat.m2504i(72918);
            com.tencent.soter.core.biometric.FingerprintManagerProxy.CryptoObject cryptoObject2;
            if (cryptoObject == null) {
                AppMethodBeat.m2505o(72918);
                return null;
            } else if (cryptoObject.getCipher() != null) {
                cryptoObject2 = new com.tencent.soter.core.biometric.FingerprintManagerProxy.CryptoObject(cryptoObject.getCipher());
                AppMethodBeat.m2505o(72918);
                return cryptoObject2;
            } else if (cryptoObject.getSignature() != null) {
                cryptoObject2 = new com.tencent.soter.core.biometric.FingerprintManagerProxy.CryptoObject(cryptoObject.getSignature());
                AppMethodBeat.m2505o(72918);
                return cryptoObject2;
            } else if (cryptoObject.getMac() != null) {
                cryptoObject2 = new com.tencent.soter.core.biometric.FingerprintManagerProxy.CryptoObject(cryptoObject.getMac());
                AppMethodBeat.m2505o(72918);
                return cryptoObject2;
            } else {
                AppMethodBeat.m2505o(72918);
                return null;
            }
        }

        private static CryptoObject unwrapCryptoObject(com.tencent.soter.core.biometric.FingerprintManagerProxy.CryptoObject cryptoObject) {
            AppMethodBeat.m2504i(72919);
            CryptoObject cryptoObject2;
            if (cryptoObject == null) {
                AppMethodBeat.m2505o(72919);
                return null;
            } else if (cryptoObject.getCipher() != null) {
                cryptoObject2 = new CryptoObject(cryptoObject.getCipher());
                AppMethodBeat.m2505o(72919);
                return cryptoObject2;
            } else if (cryptoObject.getSignature() != null) {
                cryptoObject2 = new CryptoObject(cryptoObject.getSignature());
                AppMethodBeat.m2505o(72919);
                return cryptoObject2;
            } else if (cryptoObject.getMac() != null) {
                cryptoObject2 = new CryptoObject(cryptoObject.getMac());
                AppMethodBeat.m2505o(72919);
                return cryptoObject2;
            } else {
                AppMethodBeat.m2505o(72919);
                return null;
            }
        }

        private static com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback wrapCallback(final Context context, final AuthenticationCallback authenticationCallback) {
            AppMethodBeat.m2504i(72920);
            C58261 c58261 = new com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback() {
                private boolean mMarkPermanentlyCallbacked = false;

                public final void onAuthenticationError(int i, CharSequence charSequence) {
                    AppMethodBeat.m2504i(72911);
                    while (true) {
                        C44476d.m80482d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationError", new Object[0]);
                        if (this.mMarkPermanentlyCallbacked) {
                            AppMethodBeat.m2505o(72911);
                            return;
                        }
                        this.mMarkPermanentlyCallbacked = true;
                        if (i == 5) {
                            C44476d.m80484i(FingerprintManagerImpl.TAG, "soter: user cancelled fingerprint authen", new Object[0]);
                            authenticationCallback.onAuthenticationCancelled();
                            AppMethodBeat.m2505o(72911);
                            return;
                        } else if (i == 7) {
                            C44476d.m80484i(FingerprintManagerImpl.TAG, "soter: system call too many trial.", new Object[0]);
                            if (!(SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context) || SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context) || SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce())) {
                                SoterBiometricAntiBruteForceStrategy.freeze(context);
                            }
                            this.mMarkPermanentlyCallbacked = false;
                            i = 10308;
                            charSequence = "Too many failed times";
                        } else {
                            authenticationCallback.onAuthenticationError(i, charSequence);
                            AppMethodBeat.m2505o(72911);
                            return;
                        }
                    }
                }

                public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                    AppMethodBeat.m2504i(72912);
                    C44476d.m80482d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationHelp", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.m2505o(72912);
                        return;
                    }
                    if (!FingerprintManagerImpl.access$000(this, context)) {
                        authenticationCallback.onAuthenticationHelp(i, charSequence);
                    }
                    AppMethodBeat.m2505o(72912);
                }

                public final void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
                    AppMethodBeat.m2504i(72913);
                    C44476d.m80482d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationSucceeded", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.m2505o(72913);
                        return;
                    }
                    if (!FingerprintManagerImpl.access$000(this, context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                        }
                        this.mMarkPermanentlyCallbacked = true;
                        authenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerImpl.access$100(authenticationResultInternal.getCryptoObject())));
                    }
                    AppMethodBeat.m2505o(72913);
                }

                public final void onAuthenticationFailed() {
                    AppMethodBeat.m2504i(72914);
                    C44476d.m80482d(FingerprintManagerImpl.TAG, "soter: basic onAuthenticationFailed", new Object[0]);
                    if (this.mMarkPermanentlyCallbacked) {
                        AppMethodBeat.m2505o(72914);
                        return;
                    }
                    if (!FingerprintManagerImpl.access$000(this, context)) {
                        if (!SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                            SoterBiometricAntiBruteForceStrategy.addFailTime(context);
                            if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                                C44476d.m80486w(FingerprintManagerImpl.TAG, "soter: too many fail trials", new Object[0]);
                                SoterBiometricAntiBruteForceStrategy.freeze(context);
                                FingerprintManagerImpl.access$200(this);
                                AppMethodBeat.m2505o(72914);
                                return;
                            }
                        }
                        authenticationCallback.onAuthenticationFailed();
                    }
                    AppMethodBeat.m2505o(72914);
                }
            };
            AppMethodBeat.m2505o(72920);
            return c58261;
        }

        private static boolean shouldInformTooManyTrial(com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback authenticationCallback, Context context) {
            AppMethodBeat.m2504i(72921);
            if (SoterBiometricAntiBruteForceStrategy.isSystemHasAntiBruteForce()) {
                C44476d.m80485v(TAG, "soter: using system anti brute force strategy", new Object[0]);
                AppMethodBeat.m2505o(72921);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(context)) {
                if (!SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                    C44476d.m80485v(TAG, "soter: unfreeze former frozen status", new Object[0]);
                    SoterBiometricAntiBruteForceStrategy.unFreeze(context);
                }
                AppMethodBeat.m2505o(72921);
                return false;
            } else if (SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(context)) {
                C44476d.m80485v(TAG, "soter: failure time available", new Object[0]);
                AppMethodBeat.m2505o(72921);
                return false;
            } else {
                informTooManyTrial(authenticationCallback);
                AppMethodBeat.m2505o(72921);
                return true;
            }
        }

        private static void informTooManyTrial(com.tencent.soter.core.biometric.FingerprintManagerProxy.AuthenticationCallback authenticationCallback) {
            AppMethodBeat.m2504i(72922);
            C44476d.m80486w(TAG, "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            authenticationCallback.onAuthenticationError(10308, "Too many failed times");
            AppMethodBeat.m2505o(72922);
        }
    }

    static class LegacyFingerprintManagerImpl implements IBiometricManager {
        public boolean hasEnrolledBiometric(Context context) {
            return false;
        }

        public boolean isHardwareDetected(Context context) {
            return false;
        }

        public String getBiometricName(Context context) {
            return null;
        }

        public void authenticate(Context context, CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        }
    }

    public static BiometricManagerCompat from(Context context, Integer num) {
        AppMethodBeat.m2504i(72926);
        BiometricManagerCompat biometricManagerCompat = new BiometricManagerCompat(context, num);
        AppMethodBeat.m2505o(72926);
        return biometricManagerCompat;
    }

    private BiometricManagerCompat(Context context, Integer num) {
        this.mContext = context;
        this.mBiometricType = num;
    }

    static {
        Object fingerprintManagerImpl;
        AppMethodBeat.m2504i(72934);
        if (C40997a.dQN()) {
            fingerprintManagerImpl = new FingerprintManagerImpl();
        } else {
            fingerprintManagerImpl = new LegacyFingerprintManagerImpl();
        }
        IMPL_PROVIDER.put(Integer.valueOf(1), fingerprintManagerImpl);
        if (C40997a.dQN() && isNativeSupportFaceid()) {
            IMPL_PROVIDER.put(Integer.valueOf(2), new FaceidManagerImpl());
        }
        AppMethodBeat.m2505o(72934);
    }

    public static boolean isNativeSupportFaceid() {
        AppMethodBeat.m2504i(72927);
        try {
            Class.forName(FaceidManagerProxy.FACEMANAGER_FACTORY_CLASS_NAME);
            AppMethodBeat.m2505o(72927);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(72927);
            return false;
        }
    }

    public boolean hasEnrolledBiometric() {
        AppMethodBeat.m2504i(72928);
        IBiometricManager iBiometricManager = (IBiometricManager) IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            C44476d.m80484i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            AppMethodBeat.m2505o(72928);
            return false;
        }
        boolean hasEnrolledBiometric = iBiometricManager.hasEnrolledBiometric(this.mContext);
        AppMethodBeat.m2505o(72928);
        return hasEnrolledBiometric;
    }

    public String getBiometricName() {
        AppMethodBeat.m2504i(72929);
        IBiometricManager iBiometricManager = (IBiometricManager) IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            C44476d.m80484i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            AppMethodBeat.m2505o(72929);
            return null;
        }
        String biometricName = iBiometricManager.getBiometricName(this.mContext);
        AppMethodBeat.m2505o(72929);
        return biometricName;
    }

    public boolean isHardwareDetected() {
        AppMethodBeat.m2504i(72930);
        IBiometricManager iBiometricManager = (IBiometricManager) IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            C44476d.m80484i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            AppMethodBeat.m2505o(72930);
            return false;
        }
        boolean isHardwareDetected = iBiometricManager.isHardwareDetected(this.mContext);
        AppMethodBeat.m2505o(72930);
        return isHardwareDetected;
    }

    public boolean isCurrentFailTimeAvailable() {
        AppMethodBeat.m2504i(72931);
        boolean isCurrentFailTimeAvailable = SoterBiometricAntiBruteForceStrategy.isCurrentFailTimeAvailable(this.mContext);
        AppMethodBeat.m2505o(72931);
        return isCurrentFailTimeAvailable;
    }

    public boolean isCurrentTweenTimeAvailable(Context context) {
        AppMethodBeat.m2504i(72932);
        boolean isCurrentTweenTimeAvailable = SoterBiometricAntiBruteForceStrategy.isCurrentTweenTimeAvailable(this.mContext);
        AppMethodBeat.m2505o(72932);
        return isCurrentTweenTimeAvailable;
    }

    public void authenticate(CryptoObject cryptoObject, int i, CancellationSignal cancellationSignal, AuthenticationCallback authenticationCallback, Handler handler) {
        AppMethodBeat.m2504i(72933);
        IBiometricManager iBiometricManager = (IBiometricManager) IMPL_PROVIDER.get(this.mBiometricType);
        if (iBiometricManager == null) {
            C44476d.m80484i(TAG, "soter: Biometric provider not initialized type[" + this.mBiometricType + "]", new Object[0]);
            authenticationCallback.onAuthenticationCancelled();
        }
        iBiometricManager.authenticate(this.mContext, cryptoObject, i, cancellationSignal, authenticationCallback, handler);
        AppMethodBeat.m2505o(72933);
    }
}
