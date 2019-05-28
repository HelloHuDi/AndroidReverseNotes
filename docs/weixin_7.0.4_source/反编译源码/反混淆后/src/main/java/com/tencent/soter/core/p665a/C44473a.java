package com.tencent.soter.core.p665a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p665a.C30965b.C30966a;
import com.tencent.soter.core.p665a.C30965b.C30967b;
import com.tencent.soter.core.p665a.C30965b.C309681;
import com.tencent.soter.core.p665a.C30965b.C30969c;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: com.tencent.soter.core.a.a */
public final class C44473a {
    static final C36453e AuH;
    private Context mContext;

    /* renamed from: com.tencent.soter.core.a.a$b */
    public static abstract class C5825b {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void cvW() {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationCancelled() {
        }
    }

    /* renamed from: com.tencent.soter.core.a.a$a */
    static class C16172a implements C36453e {
        public final boolean hasEnrolledFingerprints(Context context) {
            AppMethodBeat.m2504i(72978);
            boolean hasEnrolledFingerprints = C30965b.hasEnrolledFingerprints(context);
            AppMethodBeat.m2505o(72978);
            return hasEnrolledFingerprints;
        }

        public final boolean isHardwareDetected(Context context) {
            AppMethodBeat.m2504i(72979);
            boolean isHardwareDetected = C30965b.isHardwareDetected(context);
            AppMethodBeat.m2505o(72979);
            return isHardwareDetected;
        }

        /* renamed from: a */
        static void m24527a(C30966a c30966a) {
            AppMethodBeat.m2504i(72981);
            C44476d.m80486w("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            c30966a.onAuthenticationError(10308, "Too many failed times");
            AppMethodBeat.m2505o(72981);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A:{SYNTHETIC, Splitter:B:15:0x004f} */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo28996a(final Context context, C36452d c36452d, CancellationSignal cancellationSignal, final C5825b c5825b) {
            C30969c c30969c;
            C161731 c161731;
            AppMethodBeat.m2504i(72980);
            if (c36452d != null) {
                if (c36452d.mCipher != null) {
                    c30969c = new C30969c(c36452d.mCipher);
                } else if (c36452d.mSignature != null) {
                    c30969c = new C30969c(c36452d.mSignature);
                } else if (c36452d.mMac != null) {
                    c30969c = new C30969c(c36452d.mMac);
                }
                c161731 = new C30966a() {
                    private boolean mMarkPermanentlyCallbacked = false;

                    public final void onAuthenticationError(int i, CharSequence charSequence) {
                        AppMethodBeat.m2504i(72974);
                        while (true) {
                            C44476d.m80482d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationError", new Object[0]);
                            if (this.mMarkPermanentlyCallbacked) {
                                AppMethodBeat.m2505o(72974);
                                return;
                            }
                            this.mMarkPermanentlyCallbacked = true;
                            if (i == 5) {
                                C44476d.m80484i("Soter.FingerprintManagerCompat", "soter: user cancelled fingerprint authen", new Object[0]);
                                c5825b.onAuthenticationCancelled();
                                AppMethodBeat.m2505o(72974);
                                return;
                            } else if (i == 7) {
                                C44476d.m80484i("Soter.FingerprintManagerCompat", "soter: system call too many trial.", new Object[0]);
                                if (!(C30970c.isCurrentFailTimeAvailable(context) || C30970c.isCurrentTweenTimeAvailable(context) || C30970c.isSystemHasAntiBruteForce())) {
                                    C30970c.freeze(context);
                                }
                                this.mMarkPermanentlyCallbacked = false;
                                i = 10308;
                                charSequence = "Too many failed times";
                            } else {
                                c5825b.onAuthenticationError(i, charSequence);
                                AppMethodBeat.m2505o(72974);
                                return;
                            }
                        }
                    }

                    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                        AppMethodBeat.m2504i(72975);
                        C44476d.m80482d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationHelp", new Object[0]);
                        if (this.mMarkPermanentlyCallbacked) {
                            AppMethodBeat.m2505o(72975);
                            return;
                        }
                        if (!C16172a.m24528a(this, context)) {
                            c5825b.onAuthenticationHelp(i, charSequence);
                        }
                        AppMethodBeat.m2505o(72975);
                    }

                    /* renamed from: a */
                    public final void mo28999a(C30967b c30967b) {
                        AppMethodBeat.m2504i(72976);
                        C44476d.m80482d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationSucceeded", new Object[0]);
                        if (this.mMarkPermanentlyCallbacked) {
                            AppMethodBeat.m2505o(72976);
                            return;
                        }
                        if (!C16172a.m24528a(this, context)) {
                            C36452d c36452d;
                            C36451c c36451c;
                            if (!C30970c.isSystemHasAntiBruteForce()) {
                                C30970c.unFreeze(context);
                            }
                            this.mMarkPermanentlyCallbacked = true;
                            C5825b c5825b = c5825b;
                            C30969c c30969c = c30967b.AuL;
                            if (c30969c != null) {
                                if (c30969c.mCipher != null) {
                                    c36452d = new C36452d(c30969c.mCipher);
                                } else if (c30969c.mSignature != null) {
                                    c36452d = new C36452d(c30969c.mSignature);
                                } else if (c30969c.mMac != null) {
                                    c36452d = new C36452d(c30969c.mMac);
                                }
                                c36451c = new C36451c(c36452d);
                                c5825b.cvW();
                            }
                            c36452d = null;
                            c36451c = new C36451c(c36452d);
                            c5825b.cvW();
                        }
                        AppMethodBeat.m2505o(72976);
                    }

                    public final void onAuthenticationFailed() {
                        AppMethodBeat.m2504i(72977);
                        C44476d.m80482d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationFailed", new Object[0]);
                        if (this.mMarkPermanentlyCallbacked) {
                            AppMethodBeat.m2505o(72977);
                            return;
                        }
                        if (!C16172a.m24528a(this, context)) {
                            if (!C30970c.isSystemHasAntiBruteForce()) {
                                Context context = context;
                                C30970c.setCurrentFailTime(context, Integer.valueOf(C30970c.getCurrentFailTime(context)).intValue() + 1);
                                if (!C30970c.isCurrentFailTimeAvailable(context)) {
                                    C44476d.m80486w("Soter.FingerprintManagerCompat", "soter: too many fail trials", new Object[0]);
                                    C30970c.freeze(context);
                                    C16172a.m24527a(this);
                                    AppMethodBeat.m2505o(72977);
                                    return;
                                }
                            }
                            c5825b.onAuthenticationFailed();
                        }
                        AppMethodBeat.m2505o(72977);
                    }
                };
                if (C30965b.checkSelfPermission(context, "android.permission.USE_FINGERPRINT") == 0) {
                    C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
                    AppMethodBeat.m2505o(72980);
                    return;
                }
                try {
                    FingerprintManager fingerprintManager = C30965b.getFingerprintManager(context);
                    if (fingerprintManager != null) {
                        CryptoObject cryptoObject;
                        if (c30969c != null) {
                            if (c30969c.mCipher != null) {
                                cryptoObject = new CryptoObject(c30969c.mCipher);
                            } else if (c30969c.mSignature != null) {
                                cryptoObject = new CryptoObject(c30969c.mSignature);
                            } else if (c30969c.mMac != null) {
                                cryptoObject = new CryptoObject(c30969c.mMac);
                            }
                            fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, new C309681(c161731), null);
                            AppMethodBeat.m2505o(72980);
                            return;
                        }
                        cryptoObject = null;
                        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, new C309681(c161731), null);
                        AppMethodBeat.m2505o(72980);
                        return;
                    }
                    C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    AppMethodBeat.m2505o(72980);
                    return;
                } catch (SecurityException e) {
                    C44476d.m80483e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                    AppMethodBeat.m2505o(72980);
                    return;
                }
            }
            c30969c = null;
            c161731 = /* anonymous class already generated */;
            if (C30965b.checkSelfPermission(context, "android.permission.USE_FINGERPRINT") == 0) {
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m24528a(C30966a c30966a, Context context) {
            AppMethodBeat.m2504i(72982);
            if (C30970c.isSystemHasAntiBruteForce()) {
                C44476d.m80485v("Soter.FingerprintManagerCompat", "soter: using system anti brute force strategy", new Object[0]);
                AppMethodBeat.m2505o(72982);
                return false;
            } else if (C30970c.isCurrentTweenTimeAvailable(context)) {
                if (!C30970c.isCurrentFailTimeAvailable(context)) {
                    C44476d.m80485v("Soter.FingerprintManagerCompat", "soter: unfreeze former frozen status", new Object[0]);
                    C30970c.unFreeze(context);
                }
                AppMethodBeat.m2505o(72982);
                return false;
            } else if (C30970c.isCurrentFailTimeAvailable(context)) {
                C44476d.m80485v("Soter.FingerprintManagerCompat", "soter: failure time available", new Object[0]);
                AppMethodBeat.m2505o(72982);
                return false;
            } else {
                C16172a.m24527a(c30966a);
                AppMethodBeat.m2505o(72982);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.soter.core.a.a$c */
    public static final class C36451c {
        private C36452d AuJ;

        public C36451c(C36452d c36452d) {
            this.AuJ = c36452d;
        }
    }

    /* renamed from: com.tencent.soter.core.a.a$d */
    public static class C36452d {
        final Cipher mCipher;
        final Mac mMac;
        final Signature mSignature;

        public C36452d(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public C36452d(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public C36452d(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    /* renamed from: com.tencent.soter.core.a.a$e */
    interface C36453e {
        /* renamed from: a */
        void mo28996a(Context context, C36452d c36452d, CancellationSignal cancellationSignal, C5825b c5825b);

        boolean hasEnrolledFingerprints(Context context);

        boolean isHardwareDetected(Context context);
    }

    /* renamed from: com.tencent.soter.core.a.a$f */
    static class C36891f implements C36453e {
        public final boolean hasEnrolledFingerprints(Context context) {
            return false;
        }

        public final boolean isHardwareDetected(Context context) {
            return false;
        }

        /* renamed from: a */
        public final void mo28996a(Context context, C36452d c36452d, CancellationSignal cancellationSignal, C5825b c5825b) {
        }
    }

    /* renamed from: iU */
    public static C44473a m80472iU(Context context) {
        AppMethodBeat.m2504i(72983);
        C44473a c44473a = new C44473a(context);
        AppMethodBeat.m2505o(72983);
        return c44473a;
    }

    private C44473a(Context context) {
        this.mContext = context;
    }

    static {
        AppMethodBeat.m2504i(72987);
        if (C40997a.dQN()) {
            AuH = new C16172a();
            AppMethodBeat.m2505o(72987);
            return;
        }
        AuH = new C36891f();
        AppMethodBeat.m2505o(72987);
    }

    public final boolean hasEnrolledFingerprints() {
        AppMethodBeat.m2504i(72984);
        boolean hasEnrolledFingerprints = AuH.hasEnrolledFingerprints(this.mContext);
        AppMethodBeat.m2505o(72984);
        return hasEnrolledFingerprints;
    }

    public final boolean isHardwareDetected() {
        AppMethodBeat.m2504i(72985);
        boolean isHardwareDetected = AuH.isHardwareDetected(this.mContext);
        AppMethodBeat.m2505o(72985);
        return isHardwareDetected;
    }

    /* renamed from: a */
    public final void mo70647a(C36452d c36452d, CancellationSignal cancellationSignal, C5825b c5825b) {
        AppMethodBeat.m2504i(72986);
        AuH.mo28996a(this.mContext, c36452d, cancellationSignal, c5825b);
        AppMethodBeat.m2505o(72986);
    }
}
