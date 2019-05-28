package com.tencent.soter.core.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class a {
    static final e AuH;
    private Context mContext;

    public static abstract class b {
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

    static class a implements e {
        public final boolean hasEnrolledFingerprints(Context context) {
            AppMethodBeat.i(72978);
            boolean hasEnrolledFingerprints = b.hasEnrolledFingerprints(context);
            AppMethodBeat.o(72978);
            return hasEnrolledFingerprints;
        }

        public final boolean isHardwareDetected(Context context) {
            AppMethodBeat.i(72979);
            boolean isHardwareDetected = b.isHardwareDetected(context);
            AppMethodBeat.o(72979);
            return isHardwareDetected;
        }

        static void a(com.tencent.soter.core.a.b.a aVar) {
            AppMethodBeat.i(72981);
            com.tencent.soter.core.c.d.w("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            aVar.onAuthenticationError(10308, "Too many failed times");
            AppMethodBeat.o(72981);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A:{SYNTHETIC, Splitter:B:15:0x004f} */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(final Context context, d dVar, CancellationSignal cancellationSignal, final b bVar) {
            com.tencent.soter.core.a.b.c cVar;
            AnonymousClass1 anonymousClass1;
            AppMethodBeat.i(72980);
            if (dVar != null) {
                if (dVar.mCipher != null) {
                    cVar = new com.tencent.soter.core.a.b.c(dVar.mCipher);
                } else if (dVar.mSignature != null) {
                    cVar = new com.tencent.soter.core.a.b.c(dVar.mSignature);
                } else if (dVar.mMac != null) {
                    cVar = new com.tencent.soter.core.a.b.c(dVar.mMac);
                }
                anonymousClass1 = new com.tencent.soter.core.a.b.a() {
                    private boolean mMarkPermanentlyCallbacked = false;

                    public final void onAuthenticationError(int i, CharSequence charSequence) {
                        AppMethodBeat.i(72974);
                        while (true) {
                            com.tencent.soter.core.c.d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationError", new Object[0]);
                            if (this.mMarkPermanentlyCallbacked) {
                                AppMethodBeat.o(72974);
                                return;
                            }
                            this.mMarkPermanentlyCallbacked = true;
                            if (i == 5) {
                                com.tencent.soter.core.c.d.i("Soter.FingerprintManagerCompat", "soter: user cancelled fingerprint authen", new Object[0]);
                                bVar.onAuthenticationCancelled();
                                AppMethodBeat.o(72974);
                                return;
                            } else if (i == 7) {
                                com.tencent.soter.core.c.d.i("Soter.FingerprintManagerCompat", "soter: system call too many trial.", new Object[0]);
                                if (!(c.isCurrentFailTimeAvailable(context) || c.isCurrentTweenTimeAvailable(context) || c.isSystemHasAntiBruteForce())) {
                                    c.freeze(context);
                                }
                                this.mMarkPermanentlyCallbacked = false;
                                i = 10308;
                                charSequence = "Too many failed times";
                            } else {
                                bVar.onAuthenticationError(i, charSequence);
                                AppMethodBeat.o(72974);
                                return;
                            }
                        }
                    }

                    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                        AppMethodBeat.i(72975);
                        com.tencent.soter.core.c.d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationHelp", new Object[0]);
                        if (this.mMarkPermanentlyCallbacked) {
                            AppMethodBeat.o(72975);
                            return;
                        }
                        if (!a.a(this, context)) {
                            bVar.onAuthenticationHelp(i, charSequence);
                        }
                        AppMethodBeat.o(72975);
                    }

                    public final void a(com.tencent.soter.core.a.b.b bVar) {
                        AppMethodBeat.i(72976);
                        com.tencent.soter.core.c.d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationSucceeded", new Object[0]);
                        if (this.mMarkPermanentlyCallbacked) {
                            AppMethodBeat.o(72976);
                            return;
                        }
                        if (!a.a(this, context)) {
                            d dVar;
                            c cVar;
                            if (!c.isSystemHasAntiBruteForce()) {
                                c.unFreeze(context);
                            }
                            this.mMarkPermanentlyCallbacked = true;
                            b bVar2 = bVar;
                            com.tencent.soter.core.a.b.c cVar2 = bVar.AuL;
                            if (cVar2 != null) {
                                if (cVar2.mCipher != null) {
                                    dVar = new d(cVar2.mCipher);
                                } else if (cVar2.mSignature != null) {
                                    dVar = new d(cVar2.mSignature);
                                } else if (cVar2.mMac != null) {
                                    dVar = new d(cVar2.mMac);
                                }
                                cVar = new c(dVar);
                                bVar2.cvW();
                            }
                            dVar = null;
                            cVar = new c(dVar);
                            bVar2.cvW();
                        }
                        AppMethodBeat.o(72976);
                    }

                    public final void onAuthenticationFailed() {
                        AppMethodBeat.i(72977);
                        com.tencent.soter.core.c.d.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationFailed", new Object[0]);
                        if (this.mMarkPermanentlyCallbacked) {
                            AppMethodBeat.o(72977);
                            return;
                        }
                        if (!a.a(this, context)) {
                            if (!c.isSystemHasAntiBruteForce()) {
                                Context context = context;
                                c.setCurrentFailTime(context, Integer.valueOf(c.getCurrentFailTime(context)).intValue() + 1);
                                if (!c.isCurrentFailTimeAvailable(context)) {
                                    com.tencent.soter.core.c.d.w("Soter.FingerprintManagerCompat", "soter: too many fail trials", new Object[0]);
                                    c.freeze(context);
                                    a.a(this);
                                    AppMethodBeat.o(72977);
                                    return;
                                }
                            }
                            bVar.onAuthenticationFailed();
                        }
                        AppMethodBeat.o(72977);
                    }
                };
                if (b.checkSelfPermission(context, "android.permission.USE_FINGERPRINT") == 0) {
                    com.tencent.soter.core.c.d.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
                    AppMethodBeat.o(72980);
                    return;
                }
                try {
                    FingerprintManager fingerprintManager = b.getFingerprintManager(context);
                    if (fingerprintManager != null) {
                        CryptoObject cryptoObject;
                        if (cVar != null) {
                            if (cVar.mCipher != null) {
                                cryptoObject = new CryptoObject(cVar.mCipher);
                            } else if (cVar.mSignature != null) {
                                cryptoObject = new CryptoObject(cVar.mSignature);
                            } else if (cVar.mMac != null) {
                                cryptoObject = new CryptoObject(cVar.mMac);
                            }
                            fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.soter.core.a.b.AnonymousClass1(anonymousClass1), null);
                            AppMethodBeat.o(72980);
                            return;
                        }
                        cryptoObject = null;
                        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.soter.core.a.b.AnonymousClass1(anonymousClass1), null);
                        AppMethodBeat.o(72980);
                        return;
                    }
                    com.tencent.soter.core.c.d.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    AppMethodBeat.o(72980);
                    return;
                } catch (SecurityException e) {
                    com.tencent.soter.core.c.d.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                    AppMethodBeat.o(72980);
                    return;
                }
            }
            cVar = null;
            anonymousClass1 = /* anonymous class already generated */;
            if (b.checkSelfPermission(context, "android.permission.USE_FINGERPRINT") == 0) {
            }
        }

        static /* synthetic */ boolean a(com.tencent.soter.core.a.b.a aVar, Context context) {
            AppMethodBeat.i(72982);
            if (c.isSystemHasAntiBruteForce()) {
                com.tencent.soter.core.c.d.v("Soter.FingerprintManagerCompat", "soter: using system anti brute force strategy", new Object[0]);
                AppMethodBeat.o(72982);
                return false;
            } else if (c.isCurrentTweenTimeAvailable(context)) {
                if (!c.isCurrentFailTimeAvailable(context)) {
                    com.tencent.soter.core.c.d.v("Soter.FingerprintManagerCompat", "soter: unfreeze former frozen status", new Object[0]);
                    c.unFreeze(context);
                }
                AppMethodBeat.o(72982);
                return false;
            } else if (c.isCurrentFailTimeAvailable(context)) {
                com.tencent.soter.core.c.d.v("Soter.FingerprintManagerCompat", "soter: failure time available", new Object[0]);
                AppMethodBeat.o(72982);
                return false;
            } else {
                a(aVar);
                AppMethodBeat.o(72982);
                return true;
            }
        }
    }

    public static final class c {
        private d AuJ;

        public c(d dVar) {
            this.AuJ = dVar;
        }
    }

    public static class d {
        final Cipher mCipher;
        final Mac mMac;
        final Signature mSignature;

        public d(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public d(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public d(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    interface e {
        void a(Context context, d dVar, CancellationSignal cancellationSignal, b bVar);

        boolean hasEnrolledFingerprints(Context context);

        boolean isHardwareDetected(Context context);
    }

    static class f implements e {
        public final boolean hasEnrolledFingerprints(Context context) {
            return false;
        }

        public final boolean isHardwareDetected(Context context) {
            return false;
        }

        public final void a(Context context, d dVar, CancellationSignal cancellationSignal, b bVar) {
        }
    }

    public static a iU(Context context) {
        AppMethodBeat.i(72983);
        a aVar = new a(context);
        AppMethodBeat.o(72983);
        return aVar;
    }

    private a(Context context) {
        this.mContext = context;
    }

    static {
        AppMethodBeat.i(72987);
        if (com.tencent.soter.core.a.dQN()) {
            AuH = new a();
            AppMethodBeat.o(72987);
            return;
        }
        AuH = new f();
        AppMethodBeat.o(72987);
    }

    public final boolean hasEnrolledFingerprints() {
        AppMethodBeat.i(72984);
        boolean hasEnrolledFingerprints = AuH.hasEnrolledFingerprints(this.mContext);
        AppMethodBeat.o(72984);
        return hasEnrolledFingerprints;
    }

    public final boolean isHardwareDetected() {
        AppMethodBeat.i(72985);
        boolean isHardwareDetected = AuH.isHardwareDetected(this.mContext);
        AppMethodBeat.o(72985);
        return isHardwareDetected;
    }

    public final void a(d dVar, CancellationSignal cancellationSignal, b bVar) {
        AppMethodBeat.i(72986);
        AuH.a(this.mContext, dVar, cancellationSignal, bVar);
        AppMethodBeat.o(72986);
    }
}
